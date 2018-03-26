import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.JEditorPane;

public class Win extends Frame implements ActionListener,Runnable
{
	Button button;
	URL url;
	TextField text;
	TextArea  area;
	JEditorPane editPane;
	byte b[] = new byte[118];
	Thread thread;
	
	public Win() 
	{
		text = new TextField(20);
		text.setText("http://");
		area = new TextArea(12, 12);
		button = new Button("确定");
		button.addActionListener(this);
		thread = new Thread(this);
		editPane  = new JEditorPane();
		editPane.setEditable(false);
		editPane.setBackground(Color.white);
		Panel p = new Panel();
		p.add(new Label("输入网址："));
		p.add(text);
		p.add(button);
		add(area, BorderLayout.CENTER);
		add(p ,BorderLayout.NORTH);
		
		ScrollPane scroll = new ScrollPane();
		scroll.add(editPane);
		add(scroll, BorderLayout.CENTER);
		add(p, BorderLayout.NORTH);
		
		setBounds(160, 60, 1500, 1200);
		setVisible(true);
		validate();
		
		
		
		addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				});
	}

	@Override
	public void run() 
	{
		try
		{
			editPane.setText(null);
			url = new URL(text.getText().trim());
			editPane.setPage(url);
		}
		catch (IOException e1)
		{
			area.setText(""+e1);
			return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(!thread.isAlive())
		{
			thread = new Thread(this);
		}
		try
		{
			thread.start();
		}
		catch (Exception ee) 
		{
			area.setText("正在读取：" + url);
		}
	}

}
