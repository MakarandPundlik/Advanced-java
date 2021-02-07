//write a java program to create a table in dB 

import java.sql.*;

class Prog11
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			Statement stmt = conn.createStatement();
			String sql = "create table student (roll_no int primary key, name varchar(15) not null)";
			
			stmt.executeUpdate(sql);
			
			System.out.println("Table created successfully.");
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}