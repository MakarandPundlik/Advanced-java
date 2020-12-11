//accept a citynamefrom user as a commandline argument and display the record 
import java.sql.*;

/*note : Loading class `com.mysql.jdbc.Driver'. This is deprecated. 
The new driver class is `com.mysql.cj.jdbc.Driver'. 
The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.*/
class Prog03
{
	public static void main(String[] args)
	{
		try
		{
			String cname = args[0];
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/company_info";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from emp_info where city = '"+cname+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			int cntr = 0;
			boolean flag =false;
			if(rs.next())
			{
				
				System.out.println("Empid\tName\tSurname\tCity\tSalary");
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5));
				cntr++;
				flag=true;
			}
			while(rs.next())
			{
				flag = true;
				
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5));
				cntr++;
			}
			if(!flag)
			System.out.println("no records found for "+cname+" city");
			else
			System.out.println(cntr+" records found for "+cname+" city");
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please enter city name ");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}