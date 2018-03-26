import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.*;

public class Calculator extends JFrame implements ActionListener{

	NumberButton[] numberButton;
	OperationButton[] operationButton;
	JButton operateDot, operatePOrN, operateBack, operateEqual, operateClear, sin;
	JTextField resultShow;
	JTextField showComputeProcess;
	JTextArea saveComputeProcess;
	JButton saveButton, copyButton, clearButton;
	LinkedList<String> list;
	HandleDigit handleDigit;
	HandleOperation handleOperation;
	HandleBack handleBack;
	HandleClear handleClear;
	HandleEquality handleEquality;
	HandleDot handleDot;
	HandlePOrN handlePOrN;
	HandleSin handleSin;
	
	public Calculator() {
		// TODO Auto-generated constructor stub
		setTitle("计算器");
		JPanel panelLeft, panelRight;
		list = new LinkedList<String>();
		resultShow = new JTextField(10);
		resultShow.setHorizontalAlignment(JTextField.RIGHT);
		resultShow.setForeground(Color.blue);
		resultShow.setFont(new Font("Times Roman", Font.BOLD, 16));
		resultShow.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));         // 了解 SoftBevelBorder类
		resultShow.setEditable(false);
		resultShow.setBackground(Color.white);
		
		showComputeProcess = new JTextField();
		showComputeProcess.setHorizontalAlignment(JTextField.CENTER);
		showComputeProcess.setFont(new Font("Arial", Font.BOLD, 16));
		showComputeProcess.setBackground(Color.cyan);
		showComputeProcess.setEditable(false);
		
		saveComputeProcess = new JTextArea();    
		saveComputeProcess.setEditable(false);
		saveComputeProcess.setFont(new Font("宋体", Font.PLAIN, 16));
		
		numberButton = new NumberButton[10];
		handleDigit = new HandleDigit(list, resultShow, showComputeProcess);
		
		for(int i=0; i<10; i++) {
			numberButton[i] = new NumberButton(i);
			numberButton[i].setFont(new Font("Arial", Font.BOLD, 28));
			numberButton[i].addActionListener(handleDigit);
		}
		
		operationButton = new OperationButton[4];
		handleOperation = new HandleOperation(list, resultShow, showComputeProcess, saveComputeProcess);
		String[] calculateSign = {"+", "-", "*", "/"};
		for(int i=0; i<4; i++) {
			operationButton[i] = new OperationButton(calculateSign[i]);
			operationButton[i].setFont(new Font("Arial", Font.BOLD, 30));
			operationButton[i].addActionListener(handleOperation);
		}
		
		operateDot = new JButton(".");
		handleDot = new HandleDot(list, resultShow, showComputeProcess);
		operateDot.setFont(new Font("Arial", Font.BOLD, 20));
		operateDot.addActionListener(handleDot);
		
		operatePOrN = new JButton("+/-");
		handlePOrN = new HandlePOrN(list, resultShow, showComputeProcess);
		operatePOrN.setFont(new Font("Arial", Font.BOLD, 20));
		operatePOrN.addActionListener(handlePOrN);
		
		operateEqual = new JButton("=");
		handleEquality = new HandleEquality(list, resultShow, showComputeProcess, saveComputeProcess);
		operateEqual.setFont(new Font("Arial", Font.BOLD, 20));
		operateEqual.addActionListener(handleEquality);
		
		sin = new JButton("sin");
		handleSin = new HandleSin(list, resultShow, showComputeProcess, saveComputeProcess);
		sin.setFont(new Font("Arial", Font.BOLD, 20));
		sin.addActionListener(handleSin);
		
		operateBack = new JButton("Back");
		handleBack = new HandleBack(list, resultShow, showComputeProcess);
		operateBack.setFont(new Font("Arial", Font.BOLD, 15));
		operateBack.addActionListener(handleBack);
		
		operateClear = new JButton("C");
		handleClear = new HandleClear(list, resultShow, showComputeProcess);
		operateClear.setFont(new Font("Arial", Font.BOLD, 20));
		operateClear.addActionListener(handleClear);
		
		operateClear.setForeground(Color.red);
		operateBack.setForeground(Color.red);
		operateEqual.setForeground(Color.red);
		operateClear.setForeground(Color.blue); 
		operatePOrN.setForeground(Color.blue);
		operateDot.setForeground(Color.blue);
		
		panelLeft = new JPanel();
	    JPanel centerInLeft = new JPanel();
		panelLeft.setLayout(new BorderLayout());
		panelLeft.add(resultShow, BorderLayout.NORTH);
		panelLeft.add(centerInLeft, BorderLayout.CENTER);
		
		centerInLeft.setLayout(new GridLayout(4, 5));
		centerInLeft.add(numberButton[1]);
		centerInLeft.add(numberButton[2]);
		centerInLeft.add(numberButton[3]);
		centerInLeft.add(operationButton[0]);
		centerInLeft.add(operateClear);
		centerInLeft.add(numberButton[4]);
		centerInLeft.add(numberButton[5]);
		centerInLeft.add(numberButton[6]);
		centerInLeft.add(operationButton[1]);
		centerInLeft.add(operateBack);
		centerInLeft.add(numberButton[7]);
		centerInLeft.add(numberButton[8]);
		centerInLeft.add(numberButton[9]);
		centerInLeft.add(operationButton[2]);
		centerInLeft.add(sin);
		centerInLeft.add(operatePOrN);
		centerInLeft.add(numberButton[0]);
		centerInLeft.add(operateDot);
		centerInLeft.add(operationButton[3]);
		centerInLeft.add(operateEqual);
		
		panelRight = new JPanel();
		panelRight.setLayout(new BorderLayout());
		panelRight.add(showComputeProcess, BorderLayout.NORTH);
		
		saveButton = new JButton("保存");
		copyButton = new JButton("复制");
		clearButton = new JButton("清除");
		saveButton.setToolTipText("保存计算过程到文件");
		copyButton.setToolTipText("复制选中的计算过程");
		clearButton.setToolTipText("清除计算过程");
		saveButton.addActionListener(this);
		copyButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		panelRight.add(new JScrollPane(saveComputeProcess), BorderLayout.CENTER);
		JPanel southInPanelRight = new JPanel();
		southInPanelRight.add(saveButton);
		southInPanelRight.add(copyButton);
		southInPanelRight.add(clearButton);
		
		panelRight.add(southInPanelRight, BorderLayout.SOUTH);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
		add(split, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 50, 528, 350);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == copyButton) {
			saveComputeProcess.copy();
		}
		if (e.getSource() == clearButton) {
			saveComputeProcess.setText(null);
		}
		if (e.getSource() == saveButton) {
			JFileChooser chooser = new JFileChooser();
			int state = chooser.showSaveDialog(null);
			File file = chooser.getSelectedFile();
			if (file != null && state == JFileChooser.APPROVE_OPTION) {
				try {
					String content = saveComputeProcess.getText();
					StringReader read = new StringReader(content);
					BufferedReader in = new BufferedReader(read);
					FileWriter outOne = new FileWriter(file);
					BufferedWriter out = new BufferedWriter(outOne);
					String str = null;
					while ((str = in.readLine()) != null) {
						out.write(str);
						out.newLine();
					}
					
					in.close();
					out.close();
				} catch (IOException e1) {}
			
				
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();

	}



}
