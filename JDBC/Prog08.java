//accept a record from user and insert it into the datbase 
//use preparedstatement object

import java.sql.*;
import java.util.Scanner;

class Prog08
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the employee id : ");
		int id = sc.nextInt();
		System.out.print("Enter the employee name : ");
		String name = sc.next();
		System.out.print("Enter the employee surname : ");
		String surname = sc.next();
		System.out.print("Enter the employee city : ");
		String city = sc.next();
		System.out.print("Enter the employee salary : ");
		double sal = sc.nextDouble();
		
		//now open the connectivity to database
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info?autoReconnect=true&useSSL=false";
			String username = "root";
			String pass = "1234";
			Connection conn = DriverManager.getConnection(url,username,pass);
			
			//design query first
			String sql = "insert into emp_info values(?,?,?,?,?)";
			
			//prepare object
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//pass parameters to query
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,surname);
			ps.setString(4,city);
			ps.setDouble(5,sal);
			
			ps.executeUpdate();
			System.out.println("Record inserted successfully ");
			
			ps.close();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}
}	