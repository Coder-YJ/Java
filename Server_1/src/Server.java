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
				System.out.println("���ڼ���");
				
			}
			try
			{
				System.out.println("�ȴ��ͻ�����");
				you = server.accept();
				System.out.println("�ͻ�����ַ��" + you.getInetAddress());
			}
			catch (IOException e) 
			{
				System.out.println("���ڵȴ��ͻ�");
			}
			
			if(you == null)
			{
				new ServerThread(you).start();  //Ϊÿ���ͻ�����һ��ר�ŵ��߳�
			}
		}
	}

}
