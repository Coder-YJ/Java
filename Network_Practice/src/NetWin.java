import java.awt.*;
import java.awt.event.*;
import java.net.*;

import java.io.*;

public class NetWin extends Frame implements ActionListener,Runnable
{
	Button button;
	URL url;
	TextField text;
	TextArea  area;
	byte b[] = new byte[118];
	Thread thread;
	
	public NetWin() 
	{
		text = new TextField(20);
		area = new TextArea(12, 12);
		button = new Button("确定");
		button.addActionListener(this);
		thread = new Thread(this);
		Panel p = new Panel();
		p.add(new Label("输入网址："));
		p.add(text);
		p.add(button);
		add(area, BorderLayout.CENTER);
		add(p ,BorderLayout.NORTH);
		setBounds(160, 60, 360, 300);
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
			String line = new String();
			area.setText(null);
			url = new URL(text.getText().trim());
			InputStream in = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			while((line=br.readLine()) != null)
			{
//				String s = new String(b, 0, n);
				area.append(line);
				area.append("\n");
			}
		}
		catch (MalformedURLException e1) 
		{
			area.setText(""+e1);
			return;
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
