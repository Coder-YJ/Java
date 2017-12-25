import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.*;

public class Inquest extends JDialog implements ActionListener{

	StudentPicture pic;
	PrintJob print;
	Graphics g = null;
	HashMap<String, Student> basicInfoTable;
	
	JTextField number, name, grade, borth, major;
	JRadioButton male, female;
	JButton inquest,printTextAndPic, printText, printPic;
	ButtonGroup group = null;
	FileInputStream inOne = null;
	ObjectInputStream inTwo = null;
	File systemFile = null;
	
	JPanel messPanel;
	Student stu;
	
	public Inquest(File file) {
		// TODO Auto-generated constructor stub
		setTitle("��ѯ�Ի���");
		setModal(false);
		systemFile = file;
		pic = new StudentPicture();
		
	    number = new JTextField(5);
	    inquest = new JButton();
	    number.addActionListener(this);
	    inquest.addActionListener(this);
	    
	    printTextAndPic = new JButton("��ӡ�ı�����Ƭ");
	    printText = new JButton("��ӡ�ı�");
	    printPic = new JButton("��ӡ��Ƭ");
	    
	    printTextAndPic.addActionListener(this);
	    printText.addActionListener(this);
	    printPic.addActionListener(this);
	    
	    printTextAndPic.setEnabled(false);
	    printText.setEnabled(false);
	    printPic.setEnabled(false);
	    
	    name = new JTextField(5);
	    name.setEditable(false);
	    major = new JTextField(5);
	    major.setEditable(false);
	    grade = new JTextField(5);
	    grade.setEditable(false);
	    borth = new JTextField(5);
	    borth.setEditable(false);
	    male = new JRadioButton("��", true);
	    female = new JRadioButton("Ů", false);
	    group = new ButtonGroup();
	    group.add(male);
	    group.add(female);
	    
	    
	    Box box1 = Box.createHorizontalBox();
	    box1.add(new JLabel("ѧ�ţ�", JLabel.CENTER));
	    box1.add(number);
	    
	    Box box2 = Box.createHorizontalBox();
	    box2.add(new JLabel("������", JLabel.CENTER));
	    box2.add(name);
	    
	    Box box3 = Box.createHorizontalBox();
	    box3.add(new JLabel("�Ա�", JLabel.CENTER));
	    box3.add(male);
	    box3.add(female);
	    
	    Box box4 = Box.createHorizontalBox();
	    box4.add(new JLabel("רҵ��", JLabel.CENTER));
	    box4.add(major);
	    
	    Box box5 = Box.createHorizontalBox();
	    box5.add(new JLabel("�꼶��", JLabel.CENTER));
	    box5.add(grade);

	    Box box6 = Box.createHorizontalBox();
	    box6.add(new JLabel("������", JLabel.CENTER));
	    box6.add(borth);
	    
	    Box boxH = Box.createVerticalBox();
	    boxH.add(box1);
	    boxH.add(box2);
	    boxH.add(box3);
	    boxH.add(box4);
	    boxH.add(box5);
	    boxH.add(box6);
	    boxH.add(Box.createVerticalGlue());
	    
	    JPanel messPanel = new JPanel();
	    messPanel.add(boxH);
	    
	    JSplitPane splitH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, messPanel, pic);
	    add(splitH, BorderLayout.CENTER);
	    
	    JPanel pSouth = new JPanel();
	    pSouth.add(printTextAndPic);
	    pSouth.add(printText);
	    pSouth.add(printPic);
	    add(pSouth, BorderLayout.SOUTH);
	    
	    validate();
	    setSize(360, 230);

	    addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		setVisible(false);
	    	}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == inquest || e.getSource() == number) {
			String number = "";
			number = this.number.getText();
			if (number.length() > 0) {
				try {
					inOne = new FileInputStream(systemFile);
					inTwo = new ObjectInputStream(inOne);
					basicInfoTable = (HashMap<String, Student>)inTwo.readObject();
					inOne.close();
					inTwo.close();
				} catch (Exception e1) {}
				
				if (basicInfoTable.containsKey(number)) {
					stu = basicInfoTable.get(number);
					name.setText(stu.getName());
					major.setText(stu.getDiscipling());
					grade.setText(stu.getGrade());
					borth.setText(stu.getBorth());
					if (stu.getSex().equals("��")) {
						male.setSelected(true);
					} else {
						female.setSelected(true);
					}
					
					pic.setImage(stu.getImagePic());
					pic.repaint();
					
					printText.setEnabled(true);
					printPic.setEnabled(true);
					printTextAndPic.setEnabled(true);
				} else {
					printText.setEnabled(false);
					printPic.setEnabled(false);
					printTextAndPic.setEnabled(false);
					
					String warning = "��ѧ�Ų����ڣ�";
					JOptionPane.showMessageDialog(this, warning, "����", JOptionPane.WARNING_MESSAGE);
					
					clearMess();
				}
				
			} else {
				printText.setEnabled(false);
				printPic.setEnabled(false);
				printTextAndPic.setEnabled(false);
				String warning = "��������ѧ��";
				JOptionPane.showMessageDialog(this, warning, "����", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == printTextAndPic) {
			try {
				print = getToolkit().getPrintJob(new JFrame(), "��ӡ", new Properties());
				g = print.getGraphics();
				g.translate(120, 200);  // �ڴ�ӡҳ������ 120,200��ʼ��ӡ�ı�
				int w = messPanel.getBounds().width;
				messPanel.printAll(g);
				g.translate(w, 0);   // �ڴ�ӡҳ������ 120+w, 200����ӡ��Ƭ
				pic.printAll(g);
				name.setText(stu.getName());
				g.dispose();
				print.end();
			} catch (Exception exp) {}
		} else if (e.getSource() == printText) {
			try {
				print = getToolkit().getPrintJob(new JFrame(), "��ӡ", new Properties());
				g = print.getGraphics();
				g.translate(120, 200);  // �ڴ�ӡҳ������ 120,200��ʼ��ӡ�ı�
				messPanel.printAll(g);
				g.dispose();
				print.end();
			} catch (Exception exp) {}
		} else if (e.getSource() == printPic) {
			try {
				print = getToolkit().getPrintJob(new JFrame(), "��ӡ", new Properties());
				g = print.getGraphics();
				int w = messPanel.getBounds().width;
				g.translate(120 + w, 200);   // �ڴ�ӡҳ������ 120+w, 200����ӡ��Ƭ
				pic.printAll(g);
				g.dispose();
				print.end();
			} catch (Exception exp) {}
		} 
	}

	public void clearMess() {
		// TODO Auto-generated method stub
		number.setText(null);
		name.setText(null);
		grade.setText(null);
		borth.setText(null);
		major.setText(null);
		pic.setImage(null);
		pic.repaint();
	}
}
