import java.io.*;
import java.net.*;

public class Client 
{

	public static void main(String[] args) 
	{
		String s = null;
		Socket mySocket;
		DataInputStream in = null;
		DataOutputStream out =null;
		try
		{
			mySocket = new Socket("127.0.0.1", 4331);
			in = new DataInputStream(mySocket.getInputStream());
			out = new DataOutputStream(mySocket.getOutputStream());
			for(int k=1; k<100; k=k+2)
			{
				out.writeUTF("" + k);
				s= in.readUTF();
				System.out.println("客户收到： " + s);
				Thread.sleep(500);
			}
		}
		catch (Exception e)
		{
			System.out.println("服务器已断开");
		}
	}

}
