import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComputerClient extends Frame implements Runnable,ActionListener 
{

	Button connection, send;
	TextField inputText, showResult;
	Socket socket = null;
	DataInputStream in = null;
	DataOutputStream out = null;
	
	Thread thread;
	
	public ComputerClient()
	{
		socket = new Socket();
		setLayout(new FlowLayout());
		Box box = Box.createVerticalBox();
		connection = new Button("连接服务器");
		send = new Button("发送");
		send.setEnabled(false);
		inputText = new TextField(12);
		showResult = new TextField(12);
		box.add(connection);
		box.add(new Label("输入三角形三边的长度，用逗号或空格隔开"));
		box.add(inputText);
		box.add(send);
		box.add(new Label("收到的结果"));
		box.add(showResult);
		connection.addActionListener(this);
		send.addActionListener(this);
		thread = new Thread(this);
		add(box);
		setBounds(10, 30, 300, 400);
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
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == connection)
		{
			try 
			{
				if(socket.isConnected())
				{
					;
				}
				else
				{
					InetAddress address = InetAddress.getByName("127.0.0.1");
					InetSocketAddress socketAddress = new InetSocketAddress(address, 5004);
					socket.connect(socketAddress);
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
					send.setEnabled(true);
					thread.start();
				}
					
			}
			catch (IOException e2) 
			{
				System.out.println("e2:  " + e2);
			}
		}
		if(e.getSource() == send)
		{
			String s = inputText.getText();
			
			if(s != null)
			{
//				System.out.println(s);
				try 
				{
					out.writeUTF(s);
				}
				catch (Exception e2) 
				{
					System.out.println(e2);
				}
			}
		}
	}

	@Override
	public void run() 
	{
		String s =null;
		while(true)
		{
			try 
			{
				s = in.readUTF();
				showResult.setText(s);
			}
			catch (Exception e) 
			{
				showResult.setText("服务器已断开");
			}
		}
		
	}

}
