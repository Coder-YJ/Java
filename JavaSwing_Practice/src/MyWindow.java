import java.awt.*;
import javax.swing.*;

public class MyWindow extends JFrame 
{
	JButton button;
	JTextArea text;
	

	public MyWindow() 
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setVisible(true);
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		button = new JButton("Ok");
		text = new JTextArea(10, 20);
		con.add(button);
		con.add(text);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String args[])
	{
		MyWindow win = new MyWindow();
	}

}
