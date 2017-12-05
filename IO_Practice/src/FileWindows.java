import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileWindows extends Frame implements ActionListener 
{
	FileDialog filedialog_save, filedialog_load;
	MenuBar menubar;
	Menu menu;
	MenuItem itemOpen, itemSave;
	TextArea text;
	BufferedReader in;
	FileReader file_reader;
	BufferedWriter out;
	FileWriter tofile;
	
	public FileWindows() 
	{
		super("带文件的对话框的窗口");
		setSize(260, 270);
		setVisible(true);
		menubar = new MenuBar();
		menu = new Menu("文件");
		itemOpen = new MenuItem("打开文件");
		itemSave = new MenuItem("保存文件");
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		
		menu.add(itemOpen);
		menu.add(itemSave);
		menubar.add(menu);
		setMenuBar(menubar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
