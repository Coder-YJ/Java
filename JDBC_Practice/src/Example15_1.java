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
			sql = con.createStatement();
			rs =  sql.executeQuery("SELECT * FROM chengjibiao");
			
			while(rs.next())
			{
				String number = rs.getString(1);
				String name = rs.getString(2);
				String date = rs.getString(3);
				int math = rs.getInt(4);
				int english = rs.getInt(5);
				
				System.err.print("学号：" + number);
				System.err.print("  姓名：" + name);
				System.err.print("  出生：" + date);
				System.err.print("  数学：" + math);
				System.err.println("  英语：" + english);
				
			}
			con.close();
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

}
