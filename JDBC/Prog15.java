//an example of RsultSetMetaData 
//accept a table name from user and display its name type and width i.e. display its structure

import java.sql.*;

class Prog15
{
	public static void main(String[] args)
	{
		try
		{
			String table_name = args[0];
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/company_info";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			//here we need to declare Statement object becase of select query
			
			Statement stmt = conn.createStatement();
			
			//define a query
			String sql = "select * from "+table_name;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			//base is always 1 in dB
			for(int i=1;i<=rsmd.getColumnCount();i++)
			System.out.println(rsmd.getColumnName(i)+"\t"+rsmd.getColumnTypeName(i)+"\t"+rsmd.getColumnDisplaySize(i));
			
			rs.close();//rsmd will automatically close
			stmt.close();
			conn.close();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please supply table name");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}