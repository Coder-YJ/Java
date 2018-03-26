import java.net.*;
import java.util.*;
import java.io.*;

public class DatabaseServer {
	ServerSocket server;
	Socket you;
	InetAddress yourAddress;
	
	public DatabaseServer() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("sun.jdc.odbd.JdbcOdbcDriver"); 
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		System.out.println("���Ƿ������ˣ��������û�����������");
	}
	
	public void startServer(int port) {
		while (true) {
			try {
				server = new ServerSocket(port);
			} catch (IOException e) {
				System.out.println("���ڼ�����");
			}
			
			try {
				System.out.println("�ȴ��û�����.");
				you = server.accept();             // �˴�����������
				yourAddress = you.getInetAddress();
				System.out.println("�ͻ�IP:" + yourAddress);
			} catch (IOException e) {}
			
			if (you != null) {
				new ServerThread(you).start();
			} else {
				continue;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseServer server = new DatabaseServer();
		server.startServer(6666);
	}

}
