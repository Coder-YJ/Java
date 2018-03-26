import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.*;

public class InputStudent extends JPanel implements ActionListener{

	Student student = null;
	StudentPicture pic;
	HashMap<String, Student> basicInfoTable = null;
	JTextField number, name, grade, borth;
	JButton buttonChoicePic;
	JComboBox<String> major;  // 熟悉  JComboBox 
	JRadioButton male, female;
	ButtonGroup group = null;
	JButton buttonInput, buttonReset;
	FileInputStream inOne = null;
	ObjectInputStream inTwo = null;
	FileOutputStream outOne = null;
	ObjectOutputStream outTwo = null;
	File systemFile, imagePic = null;
	
	public InputStudent(File file) {
		// TODO Auto-generated constructor stub
		systemFile = file;
		pic = new StudentPicture();
	    number = new JTextField(5);
	    name = new JTextField(5);
	    major = new JComboBox<String>();
	    
	    try {
	    	
	    	FileReader inOne = new FileReader("专业.txt");
	    	BufferedReader inTwo = new BufferedReader(inOne);
	    	String s = null;
	    	int i = 0;
	    	while((s = inTwo.readLine()) != null) {
	    		major.addItem(s);
	    	}
	    	
	    	inOne.close();
	    	inTwo.close();
	    } catch(IOException e) {
	    	major.addItem("数学");
	    	major.addItem("计算机科学与技术");
	    }
	    
	    grade = new JTextField(5);
	    borth = new JTextField(5);
	    buttonChoicePic = new JButton("选择");
	    group = new ButtonGroup();
	    male = new JRadioButton("男", true);
	    female = new JRadioButton("女", false);
	    group.add(male);
	    group.add(female);
	    
	    buttonInput = new JButton("录入");
	    buttonReset = new JButton("重置");
	    
	    buttonInput.addActionListener(this);
	    buttonChoicePic.addActionListener(this);
	    buttonReset.addActionListener(this);
	    
	    Box box1 = Box.createHorizontalBox();
	    box1.add(new JLabel("学号：", JLabel.CENTER));
	    box1.add(number);
	    
	    Box box2 = Box.createHorizontalBox();
	    box2.add(new JLabel("姓名：", JLabel.CENTER));
	    box2.add(name);
	    
	    Box box3 = Box.createHorizontalBox();
	    box3.add(new JLabel("性别：", JLabel.CENTER));
	    box3.add(male);
	    box3.add(female);
	    
	    Box box4 = Box.createHorizontalBox();
	    box4.add(new JLabel("专业：", JLabel.CENTER));
	    box4.add(major);
	    
	    Box box5 = Box.createHorizontalBox();
	    box5.add(new JLabel("年级：", JLabel.CENTER));
	    box5.add(grade);

	    Box box6 = Box.createHorizontalBox();
	    box6.add(new JLabel("出生：", JLabel.CENTER));
	    box6.add(borth);
	    
	    Box boxH = Box.createVerticalBox();
	    boxH.add(box1);
	    boxH.add(box2);
	    boxH.add(box3);
	    boxH.add(box4);
	    boxH.add(box5);
	    boxH.add(box6);
	    boxH.add(Box.createVerticalGlue());
	    
	    JPanel picPanel = new JPanel();
	    picPanel.setBackground(Color.green);
	    picPanel.add(new JLabel("选择照片：", JLabel.CENTER));
	    picPanel.add(buttonChoicePic);
	    JPanel putButton = new JPanel();
	    putButton.add(buttonInput);
	    putButton.add(buttonReset);
	    
	    JPanel messPanel = new JPanel();
	    messPanel.add(boxH);
	    messPanel.setBackground(Color.cyan);
	    putButton.setBackground(Color.red);
	    
	    setLayout(new BorderLayout());
	    JSplitPane splitV = new JSplitPane(JSplitPane.VERTICAL_SPLIT, picPanel, pic);
	    JSplitPane splitH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, messPanel, splitV);
	    
	    add(splitH, BorderLayout.CENTER);
	    add(putButton, BorderLayout.SOUTH);
	    
	    validate();
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonInput) {
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
					String warning = "该生基本信息已存在，请到修改 页面修改";
					JOptionPane.showMessageDialog(this,  warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {
					String m = "基本信息已录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if (ok == JOptionPane.YES_OPTION) {
						String name = this.name.getText();
						String discipling = (String)major.getSelectedItem();
						String grade = this.grade.getText();
						String borth = this.borth.getText();
						String sex = null;
						
						if (male.isSelected()) {
							sex = male.getText();
						} else {
							sex = female.getText();
						}
						
						student = new Student();
						student.setNumber(number);
						student.setName(name);
						student.setDisciping(discipling);
						student.setGrade(grade);
						student.setBorth(borth);
						student.setSex(sex);
						student.setImagePic(imagePic);
						
						try {
							outOne = new FileOutputStream(systemFile);
							outTwo = new ObjectOutputStream(outOne);
							basicInfoTable.put(number, student);
							outTwo.writeObject(basicInfoTable);
							outTwo.close();
							outOne.close();
							clearMess();
						} catch (Exception ee) {
							;
						}
					}
				}
				
			} else {
				String warning = "必须输入学！号";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource()== buttonChoicePic) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			
			chooser.setFileFilter(filter);
			int state = chooser.showOpenDialog(null);
			File choiceFile = chooser.getSelectedFile();
			if (choiceFile != null && state == JFileChooser.APPROVE_OPTION) {
				buttonChoicePic.setText(choiceFile.getName());
				imagePic = choiceFile;
				pic.setImage(imagePic);
				pic.repaint();
			}
		} else if (e.getSource() == buttonReset) {
			clearMess();
		}
	} 
	

	public void clearMess() {
		// TODO Auto-generated method stub
		number.setText(null);
		name.setText(null);
		grade.setText(null);
		borth.setText(null);
		buttonChoicePic.setText("选择");
		imagePic = null;
		pic.setImage(imagePic);
		pic.repaint();
	}
}
