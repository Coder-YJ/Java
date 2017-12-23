import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPoint extends JButton{

	int red, green, blue;
	public ColorPoint(ColorPad colorPad,int red, int green, int blue) {
		// TODO Auto-generated constructor stub
		this.red = red;
		this.green =green;
		this.blue = blue;
		setPreferredSize(new Dimension(4, 4));
//		setSize(10, 10);
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
