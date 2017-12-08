import java.io.*;
import java.net.*;

public class Server 
{

	public static void main(String[] args) 
	{
		ServerSocket server = null;
		ServerThread thread ;
		Socket you = null;
		while(true)
		{
			try
			{
				server = new ServerSocket(5004);
			}
			catch (IOException e) 
			{
				System.out.println("正在监听");
				
			}
			try
			{
				System.out.println("等待客户呼叫");
				you = server.accept();
				System.out.println("客户机地址：" + you.getInetAddress());
			}
			catch (IOException e) 
			{
				System.out.println("正在等待客户");
			}
			
			if(you == null)
			{
				new ServerThread(you).start();  //为每个客户启动一个专门的线程
			}
		}
	}

}
