package AwtDemo;

import java.awt.*;

public class WindowText extends Frame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5973654417467039443L;
	TextField text1, text2;
	public WindowText(String s) 
	{
		super(s);
		setLayout(new FlowLayout());
		text1 = new  TextField("«Î ‰»Î√‹¬Î", 10);
		text1.setEditable(false);
		text2 = new TextField(10);
		text2.setEchoChar('*');
		add(text1);
		add(text2);
		setBounds(100, 100, 200, 150);
		setVisible(true);
		validate();

	}

}
