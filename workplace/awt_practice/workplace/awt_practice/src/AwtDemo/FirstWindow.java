package AwtDemo;

import java.awt.*;

public class FirstWindow extends Frame
{
	private static final long serialVersionUID = -4681854843997370827L;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem item1, item2;
	
	public FirstWindow(String s) 
	{
		// TODO Auto-generated constructor stubT
		setTitle(s);
		Toolkit tool = getToolkit();
		Dimension dim = tool.getScreenSize();
		setBounds(0, 0, dim.width, dim.height);
		menuBar = new MenuBar();
		menu = new Menu("file");
		item1 = new MenuItem("open");
		item2 = new MenuItem("save");
		menu.add(item1);
		menu.add(item2);
		menuBar.add(menu);
		setMenuBar(menuBar);
		setVisible(true);
	}
    
}
