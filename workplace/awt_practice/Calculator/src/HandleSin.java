import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class HandleSin implements ActionListener{

	LinkedList<String> list;
	JTextField resultShow, showComputeProcess;
	JTextArea saveComputeProcess;
	
	public HandleSin(LinkedList<String> list, JTextField t1, JTextField t2 ,JTextArea t3) {
		// TODO Auto-generated constructor stub
		this.list = list;
		resultShow = t1;
		showComputeProcess = t2;
		saveComputeProcess = t3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (list.size() == 1 || list.size() == 2) {
			String numOne = list.getFirst();
			try {
				double x= Double.parseDouble(numOne);
				double result = Math.sin(x);
				String str = String.valueOf(result);
				list.set(0, str);
				resultShow.setText(str);
				String process = "sin(" + numOne + ") = " + result; 
				showComputeProcess.setText(process);
				saveComputeProcess.append("" + process +"\n");
				
				if (list.size() == 2) {
					list.removeLast();
				}
			} catch (Exception ee) {}
		} else if(list.size() == 3) {
			String numTwo = list.getLast();
			try {
				double x = Double.parseDouble(numTwo);
				double result = Math.sin(x);
				String str = String.valueOf(x);
				list.set(0, str);
				resultShow.setText(str);
				String process = "sin(" + numTwo +") = " + result;
				showComputeProcess.setText(process);
				saveComputeProcess.append("" + process + "\n");
				list.removeLast();  //移除掉第二个运算符
				list.removeLast();  //移除运算符号
			} catch (Exception ee) {}
		}
	}
}
