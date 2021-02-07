//write a program to call mysql procedure "changeadata()" with 2 ip and 1 op parameters
//accept customerid and full name from cmd
import java.sql.*;

class Prog12
{
	public static void main(String[] args)
	{
		try
		{
			int cid = Integer.parseInt(args[0]);
			String fn = args[1];
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url,username,password);
			
			CallableStatement cstmt = conn.prepareCall("call changedata(?,?,?)");
			
			//set values for parameters 
			cstmt.setInt(1,cid);
			cstmt.setString(2,fn);
			
			
			/*while working with mysql procedures we may have to execute different types*
			of queries like insert,updates,delete,select etc.
			All these queries can be executed by calling the execute method of callable statement object
			*/
			
			cstmt.execute();
			
			//now get the value of parameters for validation
			
			int nor = cstmt.getInt(3); //nor will contain the records affected by query 
			
			if(nor ==0)
			System.out.println("record with custid "+cid+" not found");
			
			else
			System.out.println("record with custid "+cid+" has been updated");
			
			
			
			
			//display the column headings first
			
			System.out.println("Cid\tFullname");
			ResultSet rs = cstmt.getResultSet();
			while(rs.next())
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			
			rs.close();
			cstmt.close();
			conn.close();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please supply customer id and full name");
			
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please supply customer id in integer format only");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}