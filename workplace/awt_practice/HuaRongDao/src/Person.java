import java.awt.*;
import java.awt.event.*;

class Person extends Button implements FocusListener 
{

	int number;
	Color c = new Color(255,245,170);
	public Person(int number,String s) 
	{
		super(s);
		setBackground(c);
		this.number = number;
		c = getBackground();
		addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		setBackground(Color.red);
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		setBackground(c);
	}

}
