import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class HandleDot implements ActionListener{
	
	LinkedList<String> list;
	JTextField resultShow, showComputeProcess;
	
	public HandleDot(LinkedList<String> list, JTextField t1, JTextField t2 ) {
		// TODO Auto-generated constructor stub
		this.list = list;
		resultShow = t1;
		showComputeProcess  = t2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String dot = e.getActionCommand();   //  什么意思？？
		if (list.size() == 1) {
			String num = list.getFirst();
			String s = null;
			if (num.indexOf(dot) == -1) {
				s = num.concat(dot);
				list.set(0, s);
			} else {
				s = num;
			}
			
			list.set(0, s);
			resultShow.setText(s);
			showComputeProcess.setText("" + list.get(0));
		} else if (list.size() == 3) {
			String num = list.getLast();
			String s = null;
			if (num.indexOf(dot) == -1) {
				s = num.concat(dot);
				list.set(2, s);
			} else {
				s = num;
			}
			
			resultShow.setText(s);
			showComputeProcess.setText("" + list.get(0) + list.get(1) + "" + list.get(2));
		}
	}

}
