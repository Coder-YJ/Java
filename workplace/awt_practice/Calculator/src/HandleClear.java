import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HandleClear implements	ActionListener {

	LinkedList<String> list;
	JTextField resultShow, showComputeProcess;
	public HandleClear(LinkedList<String> list, JTextField t1, JTextField t2) {
		// TODO Auto-generated constructor stub
		this.list = list;
		resultShow = t1;
		showComputeProcess  = t2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resultShow.setText("0");
		list.clear();
		showComputeProcess.setText(null);
	}
}
