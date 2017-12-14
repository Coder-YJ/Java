import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class HandlePOrN implements ActionListener{

	LinkedList<String> list;
	JTextField resultShow, showComputeProcess;
	
	public HandlePOrN(LinkedList<String> list, JTextField t1, JTextField t2) {
		// TODO Auto-generated constructor stub
		this.list = list;
		resultShow = t1;
		showComputeProcess = t2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (list.size() == 1) {
			String number1 = list.getFirst();
			try {
				double d = Double.parseDouble(number1);
				d = -1 * d;
				String str = String.valueOf(d);
				list.set(0, str);
				resultShow.setText(str);
				showComputeProcess.setText("" + list.get(0));
			} catch (Exception ee) {}
		} else if(list.size() == 3) {
			String number2 = list.getLast();
			try {
				double d = Double.parseDouble(number2);
				d = -1 * d;
				String str = String.valueOf(d);
				list.set(2, str);
				resultShow.setText(str);
				showComputeProcess.setText("" + list.get(0) + "" + list.get(1) + "" +list.get(2));
			} catch (Exception ee) {}
		}
	}
}