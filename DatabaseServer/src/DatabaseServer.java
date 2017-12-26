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
		
		System.out.println("我是服务器端，负责处理用户的连接请求");
	}
	
	public void startServer(int port) {
		while (true) {
			try {
				server = new ServerSocket(port);
			} catch (IOException e) {
				System.out.println("正在监听：");
			}
			
			try {
				System.out.println("等待用户呼叫.");
				you = server.accept();             // 此处会阻塞进程
				yourAddress = you.getInetAddress();
				System.out.println("客户IP:" + yourAddress);
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
