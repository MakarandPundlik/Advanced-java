//write a program to accept a city name from user and delete all the recordd from that city

import java.sql.*;
import java.util.Scanner;

class Prog05
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the cityname : " );
		String cname = sc.next();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			Statement stmt = conn.createStatement();
			
			String sql = "delete from emp_info where city = '"+cname+"'";
			
			int cntr = stmt.executeUpdate(sql);
			
			if(cntr!=0)
			System.out.println("Delete operation ws successful, "+cntr+" rows affected");
			
			else
			System.out.println("No record for "+cname + " city is registered");
			
			stmt.close();
			conn.close();
		}
		
		
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}