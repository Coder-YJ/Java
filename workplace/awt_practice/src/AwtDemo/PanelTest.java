package AwtDemo;

import java.awt.*;

public class PanelTest extends Frame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6832016704191895665L;
    Checkbox box;
    Panel panel;
	PanelTest()
	{
		box = new Checkbox("ÄÐ",true);
		panel = new Panel();
		panel.add(box);
		add(panel);
		setBounds(100, 100, 150, 150);
		setVisible(true);
		validate();
	}
}
