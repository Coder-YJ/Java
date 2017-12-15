import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class HandleDigit implements ActionListener{
	
	LinkedList<String> list;
	JTextField resultShow;
	JTextField showComputeProcess;
	
	public HandleDigit(LinkedList<String> list, JTextField resultShow, JTextField processShow) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.resultShow = resultShow;
		showComputeProcess = processShow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		NumberButton numberButton = (NumberButton)e.getSource();
		if (list.size() == 0) {                       // 若还未按下任何按键
			int number = numberButton.getNumber();
			list.add("" + number);
			resultShow.setText("" + number);
			showComputeProcess.setText("" + list.get(0));
		} else if (list.size() == 1) {                //
			int number = numberButton.getNumber();
			String num = list.getFirst();
			String s = num.concat("" + number);
			list.set(0, s);
			resultShow.setText(s);
			showComputeProcess.setText("" + list.get(0));
		} else if (list.size() == 2) {
			int number = numberButton.getNumber();
			list.add("" + number);
			resultShow.setText("" + number);
			showComputeProcess.setText("" + list.get(0) + "" + list.get(1) + "" + list.get(2));
		} else if (list.size() == 3) {
			int number = numberButton.getNumber();
			String num = list.getLast();
			String s = num.concat("" + number);
			list.set(2, s);
			resultShow.setText(s);
			showComputeProcess.setText("" + list.get(0) + "" + list.get(1) + "" + list.get(2));
		}
		
	}
}
