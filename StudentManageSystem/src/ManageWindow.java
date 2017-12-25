import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * ManageWindow ����
 * ����Ŀʵ����һ���������ݽṹ��ѧ������ϵͳ
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
		input = new JMenuItem("¼��ѧ��������Ϣ");
		modify = new JMenuItem("�޸�ѧ����Ϣ");
		inquest = new JMenuItem("��ѯ���ӡѧ��������Ϣ");
		delete = new JMenuItem("ɾ��ѧ��������Ϣ");
		welcome = new JMenuItem("��ӭ����");
		
		bar = new JMenuBar();
		fileMenu = new JMenu("�˵�ѡ��");
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
		
		label = new JLabel("ѧ������ϵͳ", JLabel.CENTER);
		label.setIcon(new ImageIcon("welcome.jpg"));
		label.setFont(new Font("����", Font.BOLD, 36));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		
		basicInfo = new HashMap<String, Student>();
		
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		file = new File("������Ϣ.txt");
		
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
		pCenter.add("��ӭ����", label);
		pCenter.add("¼�����", infoInput);
		
		add(pCenter, BorderLayout.CENTER);
		validate();
		setVisible(true);
		setBounds(100, 50, 460, 280);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "ȷ���˳���", "ȷ�϶Ի���", JOptionPane.YES_NO_OPTION);
				
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
			card.show(pCenter, "¼�����");
		} else if (e.getSource() == inquest) {
		    infoInquest.clearMess();
		    infoInquest.setLocation(getBounds().x + getBounds().width, getBounds().y);
		    infoInquest.setVisible(true);
		} else if(e.getSource() == welcome) {
			card.show(pCenter, "��ӭ����");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManageWindow();
	}


}
