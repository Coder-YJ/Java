import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class HandleOperation implements ActionListener{

	LinkedList<String> list;
	JTextField resultShow, showComputeProcess;
	JTextArea saveComputeProcess;
	
	public HandleOperation(LinkedList<String> list, JTextField t1, JTextField t2, JTextArea t3) {
		// TODO Auto-generated constructor stub
		this.list = list;
		resultShow = t1;
		showComputeProcess = t2;
		saveComputeProcess = t3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		OperationButton operateButton = (OperationButton) e.getSource();
		if (list.size() == 1) {
			String sign = operateButton.getOperateSign();
			list.add(sign);
			showComputeProcess.setText("" + list.get(0) + "" + list.get(1));
		} else if(list.size() == 2) {
			String sign = operateButton.getOperateSign();
			list.set(1, sign);
			showComputeProcess.setText("" + list.get(0) + "" + list.get(1));
		} else if(list.size() == 3) {
			String numOne = list.getFirst();
			String numTwo = list.getLast();
			String calculateSign = list.get(1);
			String middleProcess = numOne + "" + calculateSign + numTwo;
			try {
				double n1 = Double.parseDouble(numOne);
				double n2 = Double.parseDouble(numTwo);
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
				
				String sign = operateButton.getOperateSign();
				list.clear();
				list.addFirst("" + result);
				list.add(sign);
				String pro = middleProcess + "=" + result + "" + list.get(1);
				showComputeProcess.setText(pro);
				saveComputeProcess.append("" + middleProcess + "=" + result + "\n");
			} catch (Exception ee) {}
		}
	}

}
