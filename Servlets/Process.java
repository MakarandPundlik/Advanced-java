//a pure processing servlet(which does not produce any output) 
//This servlet is used to authenticate the user and create session for him/her on server

import java.sql.*; //database driver
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Process extends HttpServlet
{
	//override reqd method
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		//do not user MIME type or PrintWriter object
		//as servlet is not going to return any output
		
		String un = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/company_info";
			String username = "root";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url,username,password);
			
			//create sql query
			String sql = "select * from users where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set parameters of the query
			ps.setString(1,un);
			ps.setString(2,pwd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) //only one resultset
			{
				//create session object for user and store the data from dB into it for further transactions
				HttpSession s = req.getSession(true);
				//key-object pair
				s.setAttribute("username",un);
				s.setAttribute("balance",new Double(rs.getDouble(2)));
				
				//got to welcome page
				res.sendRedirect("Wel"); //Wel is url pattern for welcome page
			}
			else
			res.sendRedirect("NoLogin.html");
			
			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			PrintWriter pw = res.getWriter();
			
			pw.println("<html><body>"+e.getMessage()+"</body></html>");
			pw.close();
		}
	}//end of doPost()
	
}//end of class