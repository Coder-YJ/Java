import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class HandleBack implements ActionListener{

	LinkedList<String> list;
	JTextField resultShow, showComputeProcess;
	
	public HandleBack(LinkedList<String> list, JTextField t1, JTextField t2) {
		// TODO Auto-generated constructor stub
		this.list = list;
		resultShow = t1;
		showComputeProcess = t2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (list.size() == 1) {
			String num = list.getFirst();
			if (num.length() >= 1) {
				num = num.substring(0, num.length() -1);
				list.set(0, num);
				resultShow.setText(num);
				showComputeProcess.setText("" + num);
			} else {
				list.removeLast();
				resultShow.setText("0");
				showComputeProcess.setText("0");
				
			}
		} else if (list.size() == 3) {
			String num = list.getLast();
			if (num.length() >= 1) {
				num = num.substring(0, num.length() -1);
				list.set(2,  num);
				resultShow.setText(num);
				showComputeProcess.setText(num);
			} else {
				list.removeLast();
				resultShow.setText("0");
				showComputeProcess.setText("0");
			}
		}
	}

}
