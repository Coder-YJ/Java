import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * ManageWindow 主类
 * 本项目实现了一个基于数据结构的学籍管理系统
 * @author CoderYJ
 */

public class ManageWindow extends JFrame implements ActionListener{

	InputStudent infoInput;
	Inquest infoInquest;
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem input, modify, inquest, delete, welcome;
	HashMap<String, Student> basicInfo = null;
	File file = null;
	CardLayout card = null;
	JLabel label = null;
	JPanel pCenter;
	
	
	public ManageWindow() {
		// TODO Auto-generated constructor stub
		input = new JMenuItem("录入学生基本信息");
		modify = new JMenuItem("修改学生信息");
		inquest = new JMenuItem("查询与打印学生基本信息");
		delete = new JMenuItem("删除学生基本信息");
		welcome = new JMenuItem("欢迎界面");
		
		bar = new JMenuBar();
		fileMenu = new JMenu("菜单选项");
		fileMenu.add(input);
		fileMenu.add(modify);
		fileMenu.add(inquest);
		fileMenu.add(delete);
		fileMenu.add(welcome);
		
		bar.add(fileMenu);
		setJMenuBar(bar);
		
		input.addActionListener(this);
		modify.addActionListener(this);
		inquest.addActionListener(this);
		delete.addActionListener(this);
		welcome.addActionListener(this);
		
		label = new JLabel("学籍管理系统", JLabel.CENTER);
		label.setIcon(new ImageIcon("welcome.jpg"));
		label.setFont(new Font("隶书", Font.BOLD, 36));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		
		basicInfo = new HashMap<String, Student>();
		
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		file = new File("基本信息.txt");
		
		if (!file.exists()) {
			try {
				FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream objectOut = new ObjectOutputStream(out);
			    objectOut.writeObject(basicInfo);
			    objectOut.close();
			    out.close();
			} catch (Exception e) {}
		}
		
		infoInput = new InputStudent(file);
		infoInquest = new Inquest(file);
		pCenter.add("欢迎界面", label);
		pCenter.add("录入界面", infoInput);
		
		add(pCenter, BorderLayout.CENTER);
		validate();
		setVisible(true);
		setBounds(100, 50, 460, 280);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "确认退出吗", "确认对话框", JOptionPane.YES_NO_OPTION);
				
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		validate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == input) {
			infoInput.clearMess();
			card.show(pCenter, "录入界面");
		} else if (e.getSource() == inquest) {
		    infoInquest.clearMess();
		    infoInquest.setLocation(getBounds().x + getBounds().width, getBounds().y);
		    infoInquest.setVisible(true);
		} else if(e.getSource() == welcome) {
			card.show(pCenter, "欢迎界面");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManageWindow();
	}


}
