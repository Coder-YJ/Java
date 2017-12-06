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
	FileReader file_reader;  //字符输入流
	BufferedWriter out;
	FileWriter tofile;       //字符输出流
	
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
		
		filedialog_save = new FileDialog(this, "保存文件对话框", FileDialog.SAVE);
		filedialog_load = new FileDialog(this, "打开文件对话框", FileDialog.LOAD);
		filedialog_save.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				filedialog_save.setVisible(false);
			}
		});
		filedialog_load.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				filedialog_load.setVisible(false);
			}
		});
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});;
		
		text = new TextArea(10, 10);
		add(text, BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == itemOpen)
		{
			filedialog_load.setVisible(true);
			text.setText(null);
			String s;
			if(filedialog_load.getFile() != null)
			{
				try 
				{
					File file = new File(filedialog_load.getDirectory(), filedialog_load.getFile());
					file_reader = new FileReader(file);
					in = new BufferedReader(file_reader);
					while((s = in.readLine()) != null)
					{
						text.append(s+ '\n');
					}
					in.close();
					file_reader.close();
				} catch (Exception e2) 
				{
					;
				}
			}
		}
		else if(e.getSource() == itemSave)
		{
			filedialog_save.setVisible(true);
			if(filedialog_save.getFile() != null)
			{
				try 
				{
					File file = new File(filedialog_save.getDirectory(), filedialog_save.getFile());
					tofile = new FileWriter(file);
					out = new BufferedWriter(tofile);
					out.write(text.getText(), 0, (text.getText()).length());
					out.close();
					tofile.close();
				} catch (Exception e2) 
				{
					;
				}
			}
		}
	}
	
}
