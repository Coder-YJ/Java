
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Dome_Frame {
	private JFrame mainFrame;

	private JFrame frame;
    private JLabel state1_Label = new JLabel("���֣�");
    private JLabel state2_Label = new JLabel("ר����");
    private JLabel state3_Label = new JLabel("��Ŀ������");
    private JLabel state4_Label = new JLabel("����ʱ�䣺");
    private JLabel state5_Label = new JLabel("�Ƿ�ӵ�У�");
    private JLabel state6_Label = new JLabel("˵����");
    private JTextField add1_text = new JTextField(16);
	private JTextField add2_text = new JTextField(16);
	private JTextField add3_text = new JTextField(16);
	private JTextField add4_text = new JTextField(16);
	private JTextField add5_text = new JTextField(16);
	private JTextField add6_text = new JTextField(16);
	private JButton add_button = new JButton("ȷ��");
	private JButton add2_button = new JButton("ȡ��");
	private Database db=new Database();
	private JPanel searchBar = new JPanel();
	private JTextField txtSearchId = new JTextField(10);
	
	public Dome_Frame(){
		db = new Database();
		
		mainFrame = new JFrame("��ý�����Ϲ���");
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
		
		JMenu fileMenu = new JMenu("�鿴");
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
		
		
		JMenu addMenu = new JMenu("���");
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
		
		JMenu deletMenu = new JMenu("ɾ��");
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
		
		
		JMenu updateMenu = new JMenu("�޸�");
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
