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
		super("���ļ��ĶԻ���Ĵ���");
		setSize(260, 270);
		setVisible(true);
		menubar = new MenuBar();
		menu = new Menu("�ļ�");
		itemOpen = new MenuItem("���ļ�");
		itemSave = new MenuItem("�����ļ�");
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
