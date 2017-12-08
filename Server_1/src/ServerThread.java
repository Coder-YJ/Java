import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread
{
	Socket socket;
	DataOutputStream out = null;
	DataInputStream in = null;
	String s = null;
	boolean question = false;
	public ServerThread(Socket t) 
	{
		socket = t;
		try
		{
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		setName("ServerThread");
		
	}

	public void run()
	{
		while(true)
		{
			double a[] = new double[3];
			int i = 0;
			try 
			{
				
				System.out.println("Server run");
				s = in.readUTF();
				System.out.println("Server run");
				question = false;
				StringTokenizer st = new StringTokenizer(s, ", ");
				while(st.hasMoreTokens())
				{
					String temp = st.nextToken();
					try 
					{
						a[i] = Double.valueOf(temp).doubleValue();
						i ++;
					} 
					catch (NumberFormatException e) 
					{
						System.out.println("请输入数字");
						question = true;
					}
					if(question == false)
					{
						double p = (a[0] + a[1] + a[2])/2.0;
						out.writeUTF("" + Math.sqrt(p * (p-a[0]) * (p-a[1]) * (p-a[2])));
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println("客户离开");
				return ;
			}
		}
	}
}
