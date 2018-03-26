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
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");     //JAVA7及以下使用此方式
			Class.forName("com.hxtt.sql.access.AccessDriver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("" + e);
		}
		
		try
		{
			////////////////   "jdbc:Access:///"为固定，后面为数据库绝对地址
			con = DriverManager.getConnection("jdbc:Access:///E:/Java/JavaDocuments/student.accdb", "", "");
//			con = DriverManager.getConnection("jdbc:odbc:JavaPractice", "", "");   //JAVA7及以下使用此方式
			sql = con.createStatement();
			rs =  sql.executeQuery("SELECT * FROM chengjibiao");
			
			while(rs.next())
			{
				String number = rs.getString(1);  
				String name = rs.getString(2);
				String date = rs.getString(3);
				int math = rs.getInt(4);
				int english = rs.getInt(5);
				
				System.out.print("学号：" + number);
				System.out.print("  姓名：" + name);
				System.out.print("  出生：" + date);
				System.out.print("  数学：" + math);
				System.out.println("  英语：" + english);
				
			}
			con.close();
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

}
