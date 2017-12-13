import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MemoryGame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar bar;
	JMenu menuGrade, menuResult, menuIcon;
	JMenuItem oneGradeItem, twoGradeItem, threeGradeItem;
	JMenuItem oneGradeResult, twoGradeResult, threeGradeResult; 
	JMenuItem carImageIcon, animalImageIcon;
	File fileOneGrade, fileTwoGrade, fileThreeGrade, gradeFile;
	
	String imageName[];
	MemoryTestArea memoryTestArea;
	ShowRecordDialog showDialog = null;
	int m = 5, n = 6;
	final int imageNumber = 7;
	
	public MemoryGame() 
	{
		fileOneGrade = new File("初级记忆排行榜.txt");
		fileTwoGrade = new File("中级记忆排行榜.txt");
		fileThreeGrade = new File("高级记忆排行榜.txt");
		
		bar = new JMenuBar();
		menuGrade = new JMenu("级别");
		oneGradeItem = new JMenuItem("初级");
		twoGradeItem = new JMenuItem("中级");
		threeGradeItem = new JMenuItem("高级");
		
		menuGrade.add(oneGradeItem);
		menuGrade.add(twoGradeItem);
		menuGrade.add(threeGradeItem);
		
		menuResult = new JMenu("排行榜");
		oneGradeResult = new JMenuItem("初级排行榜"	);
		twoGradeResult = new JMenuItem("中级排行榜");
		threeGradeResult = new JMenuItem("高级排行榜");
		menuResult.add(oneGradeResult);
		menuResult.add(twoGradeResult);
		menuResult.add(threeGradeResult);
		
		menuIcon = new JMenu("选择图案");
		carImageIcon = new JMenuItem("汽车");
		animalImageIcon = new JMenuItem("动物");
		menuIcon.add(carImageIcon);
		menuIcon.add(animalImageIcon);
		carImageIcon.addActionListener(this);
		animalImageIcon.addActionListener(this);
		
		bar.add(menuGrade);
		bar.add(menuResult);
		bar.add(menuIcon);
		
		oneGradeItem.addActionListener(this);
		twoGradeItem.addActionListener(this);
		threeGradeItem.addActionListener(this);
		
		oneGradeResult.addActionListener(this);
		twoGradeResult.addActionListener(this);
		threeGradeResult.addActionListener(this);
		
		setJMenuBar(bar);
		
		if(!fileOneGrade.exists())
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
		
		memoryTestArea = new MemoryTestArea();
		imageName = new String[imageNumber];
		
		for(int i=0; i<imageNumber; i++)
		{
			imageName[i] = new String("car" + i + ".jpg");
		}
		
		m = 5;
		n = 6;
		
		gradeFile = fileOneGrade;
		///////////////////////
		
		///////////////////////
		
		setBounds(100, 100, 400, 360);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		
	}
	
	public static void main(String args[])
	{
		new MemoryGame();
	}

}
