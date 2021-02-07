//write a program to accept a old and new  city name from user and replace it in the database

import java.sql.*;
import java.util.Scanner;

class Prog06
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the old cityname : " );
		String old_cname = sc.next();
		System.out.print("Enter the new cityname : " );
		String new_cname = sc.next();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			Statement stmt = conn.createStatement();
			
			String sql = "update emp_info set city = '"+new_cname+"' where city = '"+old_cname+"'";
			
			int cntr = stmt.executeUpdate(sql);
			
			if(cntr!=0)
			System.out.println("Update operation successful, "+cntr+" rows affected");
			
			else
			System.out.println("No record for "+ old_cname+ " city is registered");
			
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
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}