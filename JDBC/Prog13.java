//a java program which accepts customer id and displays shipped/cancelled status


import java.sql.*;
class Prog13
{
	public static void main(String[] args)
	{
		try
		{
			int cid = Integer.parseInt(args[0]);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info?autoReconnect=true&useSSL=false";
			String username="root";
			String password="1234";
			
			Connection conn = DriverManager.getConnection(url,username,password);
			
			CallableStatement cstmt = conn.prepareCall("call get_order_by_id(?,?,?,?,?)");
			
			cstmt.setInt(1,cid);
			cstmt.execute();
			
			int sh_cnt = cstmt.getInt(2),cn_cnt=cstmt.getInt(4);
			double sh_ttl = cstmt.getDouble(3),cn_ttl = cstmt.getDouble(5);
			System.out.println("Status of customer id "+cid+" is :- ");
			System.out.println("Items shipped "+sh_cnt);
			System.out.println("Shipped amount "+sh_ttl);
			System.out.println("Items cancelled "+cn_cnt);
			System.out.println("Cancelled amount "+cn_ttl);
			
			cstmt.close();
			conn.close();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please supply customer id");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}