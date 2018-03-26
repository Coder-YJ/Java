import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class HandleEquality implements ActionListener {

	LinkedList<String> list;
	JTextField resultshow, showComputeProcess;
	JTextArea saveComputeProcess;
	public HandleEquality(LinkedList<String> list, JTextField t1, JTextField t2, JTextArea t3) {
		// TODO Auto-generated constructor stub
		this.list = list;
		resultshow = t1;
		showComputeProcess = t2;
		saveComputeProcess = t3;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (list.size() == 1) {
			String num = list.getFirst();
			resultshow.setText("" + num);
			showComputeProcess.setText(list.get(0));
		} 
        if (list.size() == 2) {
        	String num = list.getFirst();
        	String calculateSign = list.get(1);
        	try {
        		double n1 = Double.parseDouble(num);
        		double n2 = Double.parseDouble(num);
        		double result = 0;
        		if (calculateSign.equals("+")) {
        			result = n1 + n2;
        		} else if (calculateSign.equals("-")) {
        			result = n1 - n2;
        		} else if (calculateSign.equals("*")) {
        			result = n1 * n2;
        		} else if (calculateSign.equals("/")) {
        			result = n1 / n2;
        		}
        		
        		resultshow.setText(" + " + result);
        		String process = num + "" + calculateSign + num + "=" + result;
        		showComputeProcess.setText(process);
        		saveComputeProcess.append("" + process + "\n");
        		list.set(0, "" + result);
        	} catch (Exception ee) {}
		} else if (list.size() == 3) {
			String numOne = list.getFirst();
			String calculateSign = list.get(1);
			String numTwo = list.getLast();
			
			try {
				double n1 = Double.parseDouble(numOne);
				double n2 = Double.parseDouble(numTwo);
				double result = 0;
				
				if(calculateSign.equals("+")) {
					result = n1 + n2;
				} else if (calculateSign.equals("-")) {
					result = n1 - n2;
				} else if (calculateSign.equals("*")) {
					result = n1 * n2;
				} else if (calculateSign.equals("/")) {
					result = n1 / n2;
				}
				
				resultshow.setText("" + result);
				String process = numOne + "" + calculateSign + numTwo + "=" + result;
				showComputeProcess.setText(process);
				saveComputeProcess.append("" + process + "\n");
				list.set(0,  "" + result);
				list.removeLast();        // 移除第二个运算数
				list.removeLast();        // 移除运算符号
			} catch (Exception ee) {}
		}
	}

}
