import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class MemoryTestArea extends JPanel implements Runnable, ActionListener
{
	int row, col, usedTime, sucess;
	int scaleHeight, scaleWidth;
	File gradeFile;
	ArrayList<Block> allBlockList;
	String imageFileName[];
	LinkedList<ImageIcon> openIconList;
	LinkedList<Block> openBlockList;
	
	Thread hintThread;
	JButton hintButton;
	JTextField hintMessage, showUsedTime;
	javax.swing.Timer timer;         // 为何已导入 javax.swing.*后还需显式的用 javax.swing.Timer才行 ？？
	Record record;
	JPanel center, sourth;
	
	
	public MemoryTestArea() 
	{
		setLayout(new BorderLayout());
		allBlockList = new ArrayList<Block>();
		openIconList = new LinkedList<ImageIcon>();
		openBlockList = new LinkedList<Block>();
		
		hintThread = new Thread(this);
		hintMessage  = new JTextField();
		hintMessage.setHorizontalAlignment(JTextField.CENTER);
		hintMessage.setEditable(false);
		hintMessage.setFont(new Font("宋体", Font.BOLD, 18));  // 关于字体的部分需要复习一下
		center = new JPanel();
		sourth = new JPanel();
		hintButton = new JButton("提示");
		hintButton.addActionListener(this);
		showUsedTime = new JTextField(8);
		showUsedTime.setEditable(false);
		showUsedTime.setHorizontalAlignment(JTextField.CENTER);
		
		sourth.add(new JLabel("用时："));
		sourth.add(showUsedTime);
		sourth.add(new JLabel("提示图标位置（导致用时增加）："));
		sourth.add(hintButton);
		add(sourth, BorderLayout.SOUTH);
		add(hintMessage, BorderLayout.NORTH);
		timer = new javax.swing.Timer(1000, this); // 复习Timer的用法
		record = new Record();
	}

	public void initBlock(int m, int n, String name[], File f)
	{
		row = m;
		col = n;
		gradeFile = f;
		center.removeAll();
		imageFileName = name;
		ImageIcon icon[] = new ImageIcon[imageFileName.length];
		
		if(allBlockList.isEmpty())
		{
			for(int i=0; i<row*col; i++)
			{
				allBlockList.add(new Block());
			}
		}
		else
		{
			allBlockList.clear();
			for(int i=0; i<row*col; i++)
			{
				allBlockList.add(new Block());
			}
		}
	  scaleHeight = allBlockList.get(0).getHeight();
	  scaleWidth  = allBlockList.get(0).getWidth();
	  
	  System.out.println("");
		
		for(int i=0; i<icon.length; i++)
		{
			icon[i] = new ImageIcon(imageFileName[i]);
			icon[i].setImage(icon[i].getImage().getScaledInstance(scaleHeight, scaleWidth, Image.SCALE_DEFAULT));
		}
		
		
		for(int i=0; i<allBlockList.size(); i++)
		{
			allBlockList.get(i).addActionListener(this);
			allBlockList.get(i).setOpenStateIcon(icon[i%row]);
		}
		
		Collections.shuffle(allBlockList); //  随机排列 allBlockList中的节点
		                                   // 需了解一下 Collection 类  及其 shuffle 函数；
		
		center.setLayout(new GridLayout(row, col));
		for(int i=0; i<allBlockList.size(); i++)
		{
			center.add(allBlockList.get(i));
		}
		add(center, BorderLayout.CENTER);
		
		if(timer.isRunning())
		{
			timer.stop();
		}
		
		hintMessage.setText("请点击鼠标找出" + col + "个相同的方块");
		usedTime = 0;
		showUsedTime.setText(null);
		validate();
		
	}
	
	public void setImageName(String name[])
	{
		imageFileName = name;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() instanceof Block)   // instanceof 
		{
			if(!timer.isRunning())
			{
				timer.start();
			}
			
			Block block = (Block)e.getSource();
			ImageIcon openStateIcon = block.getOpenStateIcon();
			block.setIcon(openStateIcon);
			
			if(openIconList.size() == 0)
			{
				openIconList.add(openStateIcon);
				openBlockList.add(block);
				sucess = 1;
			}
			else 
			{
				ImageIcon temp = openIconList.getLast();
				if(temp == openStateIcon && !(openBlockList.contains(block)))
				{
					sucess = sucess + 1;
					openIconList.add(openStateIcon);
					openBlockList.add(block);
					
					if(sucess == col)
					{
						for(int i=0; i<allBlockList.size(); i++)
						{
							allBlockList.get(i).setEnabled(false);
						}
						
						for(int j=0; j<openBlockList.size(); j++)
						{
							Block b = openBlockList.get(j);
							b.setDisabledIcon(b.getOpenStateIcon());
						}
						timer.stop();
						record.setTime(usedTime);
						record.setGradeFile(gradeFile);
						record.setVisible(true);
					}
				}
				else if(temp != openStateIcon && (!(openBlockList.contains(block))))
				{
					openIconList.clear();
					openBlockList.clear();
					openIconList.add(openStateIcon);
					openBlockList.add(block);
					sucess = 1;
					
					for(int i=0; i<allBlockList.size(); i++)
					{
						if(allBlockList.get(i) != block)
						{
							allBlockList.get(i).setIcon(null);
						}
					}
				}
			}
		}
		
		if(e.getSource() == hintButton)
		{
			if(!hintThread.isAlive())
			{
				hintThread = new Thread(this);
			}
			
			for(int i=0; i<allBlockList.size(); i++)
			{
				allBlockList.get(i).remove(this);
			}
			usedTime = usedTime + 10;
			try
			{
				hintThread.start();
			}
			catch (IllegalThreadStateException threadEx)
			{
				;
			}
		}
		
		if(e.getSource() == timer)
		{
			usedTime ++;
			showUsedTime.setText("您已用时 " + usedTime + " 秒");
		}
	}

	@Override
	public void run() 
	{
		for(int i=0; i<allBlockList.size(); i++)
		{
			allBlockList.get(i).setIcon(allBlockList.get(i).getOpenStateIcon());
		}
		
		try
		{
			Thread.sleep(1200);
		}
		catch (InterruptedException exp)
		{
			;
		}
		
		for(int i=0; i<allBlockList.size(); i++)
		{
			allBlockList.get(i).addActionListener(this);
		}
		for(int i=0; i<allBlockList.size(); i++)
		{
			if(!openBlockList.contains(allBlockList.get(i)))
			{
				allBlockList.get(i).setIcon(null);
			}
		}
	}

}
