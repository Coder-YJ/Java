import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class ServerThread extends Thread{
	
	InetAddress yourAddress;
	Socket socket = null;
	DataOutputStream out = null;
	DataInputStream in = null;
	Connection con = null;
	Statement stmt = null; 
	ResultSet rs;
	int number;
	public ServerThread(Socket you) {
		// TODO Auto-generated constructor stub
		socket = you;
		try {
			con = DriverManager.getConnection("jdbc:odbc:myDataSource", "", "");
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {}
	}
	
	public void run() {
		String s = "";
		int N = 0;
		while (true) {
			try {
				s = in.readUTF();
				System.out.println(s);
				if (s.startsWith("�ֶθ�����")) {
					String number = s.substring(s.lastIndexOf(";") + 1);
					N = Integer.parseInt(number);
				} else {
					String sqlCondition = null;
					String tableName = "";
					String searchContent = "";
					String field = "";	
					String searchType = "";
					
					StringTokenizer fenxi = new StringTokenizer(s, ":");
					
					if (fenxi.hasMoreTokens()) {
						tableName = fenxi.nextToken();
					}
					if (fenxi.hasMoreTokens()) {
						searchContent = fenxi.nextToken();
					}
					if (fenxi.hasMoreTokens()) {
						field = fenxi.nextToken();
					}
					if (fenxi.hasMoreTokens()) {
						searchType = fenxi.nextToken();
					}
					
					if (searchType.equals("��ȫһ��")) {
						sqlCondition = "SELECT * FROM" + tableName + "WHERE" + field + "LIKE" + "'" + searchContent + "'";
					} else if (searchType.equals("ǰ��һ��")) {
						sqlCondition = "SELECT * FROM" + tableName + "WHERE" + field + "LIKE" + "'" + searchContent + "%";
					} else if (searchType.equals("��һ��")) {
						sqlCondition = "SELECT * FROM" + tableName + "WHERE" + field + "LIKE" + "%" + searchContent + "'";
					} else if (searchType.equals("�м����")) {
						sqlCondition = "SELECT * FROM" + tableName + "WHERE" + field + "LIKE" + "%" + searchContent + "%";
					}
					
					try {
						rs = stmt.executeQuery(sqlCondition);
						number = 0;
						while (rs.next()) {
							number ++;
							StringBuffer buff = new StringBuffer();
							for (int k = 1; k <= N; k++) {
								buff.append(rs.getString(k) + "");
							}
							out.writeUTF("\n" + new String(buff));
						}
						
						if (number == 0) {
							out.writeUTF("\n" + "δ���ҵ��κμ�¼");
						}
					} catch (SQLException e) {
						out.writeUTF("" + e);
					}
				}
			} catch (IOException e) {
				try {
					socket.close();
					con.close();
				} catch (Exception e1) {
					System.out.println("�ͻ����뿪");
					break;
				}
			}
		}
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
