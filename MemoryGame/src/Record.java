import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;

import javax.swing.*;

public class Record extends JDialog implements ActionListener
{

	int time; 
	JTextField yourName;
	JLabel label;
	JButton enter, cancel;
	File gradeFile = null;
	
	public Record()
	{
		time = 0;
		setBounds(100, 10, 330, 160);
		setResizable(false);
		setModal(true);
//		setModalityType();
		setVisible(false);
		
		enter = new JButton("确定");
		cancel = new JButton("取消");
		enter.addActionListener(this);
		cancel.addActionListener(this);
		yourName = new JTextField(8);
		yourName.setText("匿名");
		setLayout(new GridLayout(2, 1)); // 为啥设置为 GridLayout ??
		
		label = new JLabel();
		add(label);
		
		JPanel p = new JPanel();
		p.add(yourName);
		p.add(enter);
		p.add(cancel);
		add(p);
	}

	public void setGradeFile(File f)
	{
		gradeFile = f;
		setTitle("保存成绩到 " + gradeFile.getName());
		label.setText("保存成绩到 " + gradeFile.getName());
		validate();
	}
	
	public void setTime(int time)
	{
		this.time = time;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == enter)
		{
			LinkedList<People> list = new LinkedList<People>();  // 没有使用的地方 ？？
			try
			{
				RandomAccessFile out = new RandomAccessFile(gradeFile, "rw");
				out.seek(out.length());
				out.writeUTF(yourName.getText());
				out.writeInt(time);
				out.close();
			}
			catch (Exception e1) 
			{
				// TODO: handle exception
			}
			setVisible(false);
		}
		if(e.getSource() == cancel)
		{
			setVisible(false);
		}
		
	}

}
