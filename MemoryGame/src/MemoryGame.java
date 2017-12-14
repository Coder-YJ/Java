import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MemoryGame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar bar;                                           //菜单条
	JMenu menuGrade, menuResult, menuIcon;                  //等级选择菜单，排行榜菜单，图案选择菜单
	JMenuItem oneGradeItem, twoGradeItem, threeGradeItem;         //menuGrade菜单下的菜单项
	JMenuItem oneGradeResult, twoGradeResult, threeGradeResult;   //menuResult菜单下的菜单项
	JMenuItem carImageIcon, animalImageIcon;                      //menIcon菜单下的菜单项
	File fileOneGrade, fileTwoGrade, fileThreeGrade, gradeFile;   //初级排行榜记录文件，中级排行榜记录文件，高级排行榜记录文件，当前使用记录文件
	

	
	String imageName[];                 //图片名称
	MemoryTestArea memoryTestArea;      //测试区
	ShowRecordDialog showDialog = null; //测试结束弹出的对话框
	int m = 5, n = 6;
	final int imageNumber = 7;          //图片数量
	
	public MemoryGame() 
	{
		fileOneGrade = new File("初级记忆排行榜.txt");     //创建排行榜记录文件
		fileTwoGrade = new File("中级记忆排行榜.txt");
		fileThreeGrade = new File("高级记忆排行榜.txt");
		
		bar = new JMenuBar();                         //创建菜单条，菜单，菜单项
		menuGrade = new JMenu("级别");
		oneGradeItem = new JMenuItem("初级");
		twoGradeItem = new JMenuItem("中级");
		threeGradeItem = new JMenuItem("高级");
		menuGrade.setFont(new Font("宋体", Font.BOLD,15));   //设置菜单字体
		
		menuGrade.add(oneGradeItem);                  //添加菜单下对应菜单项
		menuGrade.add(twoGradeItem);
		menuGrade.add(threeGradeItem);
		
		menuResult = new JMenu("排行榜");                
		oneGradeResult = new JMenuItem("初级排行榜"	);
		twoGradeResult = new JMenuItem("中级排行榜");
		threeGradeResult = new JMenuItem("高级排行榜");
		menuResult.add(oneGradeResult);
		menuResult.add(twoGradeResult);
		menuResult.add(threeGradeResult);
		menuResult.setFont(new Font("宋体", Font.BOLD,15));
		
		menuIcon = new JMenu("选择图案");
		carImageIcon = new JMenuItem("汽车");
		animalImageIcon = new JMenuItem("动物");
		menuIcon.add(carImageIcon);
		menuIcon.add(animalImageIcon);
		menuIcon.setFont(new Font("宋体", Font.BOLD,15));
		carImageIcon.addActionListener(this);
		animalImageIcon.addActionListener(this);
		
		bar.add(menuGrade);
		bar.add(menuResult);
		bar.add(menuIcon);
		
		
		oneGradeItem.addActionListener(this);               //给菜单项绑定监听器
		twoGradeItem.addActionListener(this);
		threeGradeItem.addActionListener(this);  
		
		oneGradeResult.addActionListener(this);
		twoGradeResult.addActionListener(this);
		threeGradeResult.addActionListener(this);
		
		setJMenuBar(bar);                 //JFrame 的MenuBar 添加方式，与 Frame下直接使用 add有所区别
		
		if(!fileOneGrade.exists())        //文件若不存在则创建文件
		{
			try
			{
				fileOneGrade.createNewFile();
			}
			catch (IOException e) 
			{
			}
		}
		if(!fileTwoGrade.exists())
		{
			try
			{
				fileTwoGrade.createNewFile();
			}
			catch (IOException e) 
			{
			}
		}
		if(!fileThreeGrade.exists())
		{
			try
			{
				fileThreeGrade.createNewFile();
			}
			catch (IOException e) 
			{
			}
		}
		
		memoryTestArea = new MemoryTestArea();         //创建测试区
		imageName = new String[imageNumber];
		
		for(int i=0; i<imageNumber; i++)               //创建所需图片的路径及名称
		{
			imageName[i] = new String("images/car" + i + ".jpg");
		}
		
		m = 5;
		n = 6;
		
		gradeFile = fileOneGrade;
		///////////////////////
		memoryTestArea.initBlock(m, n, imageName, gradeFile); 
		add(memoryTestArea, BorderLayout.CENTER);
		showDialog = new ShowRecordDialog();
		///////////////////////
		
		setBounds(100, 100, 480, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	////////////MenuGrade菜单下对应菜单项监听操作///////////////
		if(e.getSource() == oneGradeItem)
		{
			m = 5;
			n = 6;
			gradeFile = fileOneGrade;
			memoryTestArea.initBlock(m, n, imageName, gradeFile);
		}    
		if(e.getSource() == twoGradeItem)
		{
			m = 6;
			n = 7;
			gradeFile = fileTwoGrade;
			memoryTestArea.initBlock(m, n, imageName, gradeFile);

		}
		if(e.getSource() == threeGradeItem)
		{
			m = 7;
			n = 8;
			gradeFile = fileThreeGrade;
			memoryTestArea.initBlock(m, n, imageName, gradeFile);
		}
		

		
     ////////////MenuIcon菜单下对应菜单项监听操作///////////////
		if(e.getSource() == carImageIcon)
		{
			for(int i=0; i<imageName.length; i++)
			{
				imageName[i] = new String("images/car" + i + ".jpg");
			}
			memoryTestArea.setImageName(imageName);
			memoryTestArea.initBlock(m, n, imageName, gradeFile);
		}
		if(e.getSource() == animalImageIcon)
		{
			for(int i=0; i<imageName.length; i++)
			{
				imageName[i] = new String("images/animal" + i + ".jpg");
			}
			memoryTestArea.setImageName(imageName);
			memoryTestArea.initBlock(m, n, imageName, gradeFile);
		}
		
     ////////////MenuResult菜单下对应菜单项监听操作///////////////
		if(e.getSource() == oneGradeResult)
		{
			showDialog.setGradeFile(fileOneGrade);
			showDialog.showRecord();
			showDialog.setVisible(true);
		}
		
		if(e.getSource() == twoGradeResult)
		{
			showDialog.setGradeFile(fileTwoGrade);
			showDialog.showRecord();
			showDialog.setVisible(true);
		}
		if(e.getSource() == threeGradeResult)
		{
			showDialog.setGradeFile(fileThreeGrade);
			showDialog.showRecord();
			showDialog.setVisible(true);
		}
	}
	
	public static void main(String args[])
	{
		new MemoryGame();
	}

}
