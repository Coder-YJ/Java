import java.sql.*;
public class Example15_1 
{
	public static void main(String[] args) 
	{
		Connection con;
		Statement sql;
		ResultSet rs;
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");     //JAVA7������ʹ�ô˷�ʽ
			Class.forName("com.hxtt.sql.access.AccessDriver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("" + e);
		}
		
		try
		{
			////////////////   "jdbc:Access:///"Ϊ�̶�������Ϊ���ݿ���Ե�ַ
			con = DriverManager.getConnection("jdbc:Access:///E:/Java/JavaDocuments/student.accdb", "", "");
//			con = DriverManager.getConnection("jdbc:odbc:JavaPractice", "", "");   //JAVA7������ʹ�ô˷�ʽ
			sql = con.createStatement();
			rs =  sql.executeQuery("SELECT * FROM chengjibiao");
			
			while(rs.next())
			{
				String number = rs.getString(1);  
				String name = rs.getString(2);
				String date = rs.getString(3);
				int math = rs.getInt(4);
				int english = rs.getInt(5);
				
				System.out.print("ѧ�ţ�" + number);
				System.out.print("  ������" + name);
				System.out.print("  ������" + date);
				System.out.print("  ��ѧ��" + math);
				System.out.println("  Ӣ�" + english);
				
			}
			con.close();
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

}
