//accept an emp_id from user as a commandline argument and display the record 
import java.sql.*;

/*note : Loading class `com.mysql.jdbc.Driver'. This is deprecated. 
The new driver class is `com.mysql.cj.jdbc.Driver'. 
The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.*/
class Prog02
{
	public static void main(String[] args)
	{
		try
		{
			int id = Integer.parseInt(args[0]);
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/company_info";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from emp_info where emp_id = "+id;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				System.out.println("Record found");
				System.out.println("Empid\t\tName\t\tSurname\t\tCity\t\tSalary");
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getDouble(5));
			}
			else
			System.out.println("Record for emp_id = "+id+" not found");
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please enter id in number format only");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please enter id ");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}