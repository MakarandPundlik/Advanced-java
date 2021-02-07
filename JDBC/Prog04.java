//accept a record from a user and add to the database

import java.sql.*;
import java.util.Scanner;

class Prog04
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter eployee id:");
		int empid = sc.nextInt();
		
		System.out.print("Enter eployee name:");
		String name = sc.next();
		
		System.out.print("Enter eployee surname:");
		String surname = sc.next();
		
		System.out.print("Enter eployee city:");
		String city = sc.next();
		
		System.out.print("Enter eployee salary:");
		double sal = sc.nextDouble();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String db = "jdbc:mysql://localhost:3306/company_info";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(db,username,password);
			
			Statement stmt = conn.createStatement();
			
			/*if query is of type select use executeQuery() and return type of method is resultset object
				if query is type of insert,update,delete use executeUpdate() and return type of method is integer
			*/
			//String sql = insert into emp_info (1,"ramesh","powar","pune",121212);
'			
			String sql = " insert into emp_info values(" + empid + " , ' " + name + " ' , ' " + surname + " ' , ' " + city + " ' , " + sal + " ) ";
			int cntr = stmt.executeUpdate(sql);
			
			if(cntr!=0)
			System.out.println("Record inserted successfully");
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}