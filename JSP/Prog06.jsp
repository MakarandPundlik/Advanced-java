<%@ page language="java" info="A JSP to register users in dB" import="java.sql.*" %>

<%
	//start of scriplet
	String un = request.getParameter("un");
	String pwd = request.getParameter("pwd");
	Double bal = Double.parseDouble(request.getParameter("bal"));
	
	//no need to use try catch here 
	//as _jspService() is already in try catch
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_info?autoReconnect=true&useSSL=false","root","1234");
	
	String sql = "select * from users where username=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	
	ps.setString(1,un);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next())
	{
		out.println("<h3>Username "+un+" already exist, press Back button to try again</h3><p>");
		out.println("Balance = "+bal);
	}
		
	else 
		{
			sql = "insert into users values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,un);
			ps.setString(2,pwd);
			ps.setDouble(3,bal);
			
			 ps.executeUpdate();
			
			out.println("Congratulations! You have been successfully registered");
		}
	
		rs.close();
		ps.close();
		conn.close();
%>