import java.sql.*;

class Prog01
{
	public static void main(String[] args)
	{
		//every database program should start with try cluase because the program throws checked exceptions
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String connectionString = "jdbc:mysql://localhost:3306/company_info?autoReconnect=true&useSSL=false";
			String userName = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(connectionString,userName,password);
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from emp_info";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("Empid\t\tName\t\tSurname\t\tCity\t\tSalary");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getDouble(5));
				//close the objects in reverse order
				
			}
			rs.close();
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