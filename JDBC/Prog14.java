//an example on DetabaseMetaData object

import java.sql.*;
class Prog14 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/company_info?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Database used in backend is : "+dbmd.getDatabaseProductName());
			System.out.println("Database version used in backend is : "+dbmd.getDatabaseProductVersion());
			System.out.println("Database username is : "+dbmd.getUserName());
			System.out.println("Database driver used in backend is : "+dbmd.getDriverName());
			
			//create a srting array to accomodate all types of tables
			String[] tablenames = {"TABLE","VIEW","ALIAS","SYNONYM"};
		
			ResultSet rs = dbmd.getTables(null,null,null,tablenames);
			
			/*getTables() method of DatabaseMetaData returns status , type of different tables 
				The first 3 parameters are not applicable to MYSQL but normally used in ORACLE dBs
			*/
			System.out.println("Table Name\t\t\tTable Type");
			while(rs.next())
			System.out.println(rs.getString("TABLE_NAME")+"\t\t\t"+rs.getString("TABLE_TYPE"));
			
			rs.close();
			conn.close();// dbmd will close automatically
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}