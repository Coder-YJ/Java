
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Dome_Frame {
	private JFrame mainFrame;

	private JFrame frame;
    private JLabel state1_Label = new JLabel("歌手：");
    private JLabel state2_Label = new JLabel("专辑：");
    private JLabel state3_Label = new JLabel("曲目数量：");
    private JLabel state4_Label = new JLabel("播放时间：");
    private JLabel state5_Label = new JLabel("是否拥有：");
    private JLabel state6_Label = new JLabel("说明：");
    private JTextField add1_text = new JTextField(16);
	private JTextField add2_text = new JTextField(16);
	private JTextField add3_text = new JTextField(16);
	private JTextField add4_text = new JTextField(16);
	private JTextField add5_text = new JTextField(16);
	private JTextField add6_text = new JTextField(16);
	private JButton add_button = new JButton("确认");
	private JButton add2_button = new JButton("取消");
	private Database db=new Database();
	private JPanel searchBar = new JPanel();
	private JTextField txtSearchId = new JTextField(10);
	
	public Dome_Frame(){
		db = new Database();
		
		mainFrame = new JFrame("多媒体资料管理");
		makeMenubar();
		mainFrame.pack();
		
//		ImageIcon img = new ImageIcon("main.jpg");
		ImageIcon img = new ImageIcon();
		JLabel jlb_pic = new JLabel(img);
		
		mainFrame.getLayeredPane().add(jlb_pic,new Integer(Integer.MIN_VALUE));
		jlb_pic.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		JPanel content = (JPanel)mainFrame.getContentPane();
		content.setOpaque(false);
		mainFrame.setSize(800, 600);
		mainFrame.setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(d.width/2-mainFrame.getWidth()/2,d.height/2-mainFrame.getHeight()/2);
		mainFrame.setVisible(true);
		//mainFrame.setSize(img.getIconWidth(), img.getIconHeight());
	}
		
	private void makeMenubar() {
		JMenuBar menubar = new JMenuBar();
		mainFrame.setJMenuBar(menubar);
		
		JMenu fileMenu = new JMenu("查看");
		menubar.add(fileMenu);
		
		JMenuItem openItem = new JMenuItem("CD");
		fileMenu.add(openItem);
		openItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new SearchCD(db);
					}
				}
				);
		
		JMenuItem quitItem = new JMenuItem("DVD");
		fileMenu.add(quitItem);
		quitItem.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						new SearchDVD(db);
					}
				}
				);
		
		
		JMenu addMenu = new JMenu("添加");
		menubar.add(addMenu);
		JMenuItem addcdItem = new JMenuItem("CD");
		addMenu.add(addcdItem);
		addcdItem.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						new AddCD1(db);
					}
				}
				);
		
		JMenuItem adddvdItem = new JMenuItem("DVD");
		addMenu.add(adddvdItem);
		adddvdItem.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						new AddDVD(db);
					}
				}
				);
		
		JMenu deletMenu = new JMenu("删除");
		menubar.add(deletMenu);
		
		
		JMenuItem cdItem = new JMenuItem("delet CD");
		deletMenu.add(cdItem);
		cdItem.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						new DeletCD(db);
					}
				}
				);
		
		JMenuItem dvdItem = new JMenuItem("delet DVD");
		deletMenu.add(dvdItem);
		dvdItem.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						new DeletDVD(db);
					}
				}
				);
		
		
		JMenu updateMenu = new JMenu("修改");
		menubar.add(updateMenu);
		
		JMenuItem upcdItem = new JMenuItem("update cd");
		updateMenu.add(upcdItem);
		upcdItem.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						new  UpdateCD(db);
					}
				}
				);
		
		JMenuItem updvdItem = new JMenuItem("update dvd");
		updateMenu.add(updvdItem);
		updvdItem.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						new DeletDVD(db);
					}
				}
				);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Dome_Frame();
	}

	}
