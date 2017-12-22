import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPoint extends JButton{

	int red, green, blue;
	public ColorPoint(ColorPad colorPad,int red, int green, int blue) {
		// TODO Auto-generated constructor stub
		this.red = red;
		this.green =green;
		this.blue = blue;
		setSize(5,5);
		setBackground(new Color(red ,green, blue));
		setEnabled(false);
		addMouseListener(colorPad);
	}
	public int getRed()
	{
		return red;
	}
	public int getGreeen()
	{
		return green;
	}
	public int getBlue()
	{
		return blue;
	}

}
