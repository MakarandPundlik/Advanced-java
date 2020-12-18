//accept the empid from user as a commandline arg and display its record
//use PreparedStatement class

import java.sql.*;


class Prog07
{
	public static void main(String[] args)
	{
		try
		{
			int no = Integer.parseInt(args[0]);
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info";
			String username = "root";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url,username,password);
			
			//design the query first
			String sql = "select * from emp_info where emp_id = ?";
			//? represents the unknown value of paramter passed at runtime
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//here, PreparedStatement is a class and prepareStatement is a method
			//assign value to parameter created by calling prepareStatement 
			ps.setInt(1,no); //1st paramter is type of the int whose value is obtained from no
			
			//execute the query
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Record found : ");
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5));
			}
			else
			System.out.println("No record found for "+no);
			
			rs.close();
			ps.close();
			conn.close();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please enter the employee id");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}