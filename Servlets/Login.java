//an example of a login form whivh reads input from cookie if any &
//populates the textfields data from cookie

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet
{
	//as servlet is invoked by link we need to override doGet()
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		pw.println("<html><head><title>Login Page</title></head><body>");
		
		//declare 2 variables to read the data from cookies
		String un="",pwd="";
		
		//read the data from cookie which has automatically arrived from req object
		//however if cookie is not available and we attempt to read it , it throws NullPointerException
		
		//cookie id not available when user visits th website for the first time
		
		try
		{
			Cookie[] arr_cookie = req.getCookies();
			un = arr_cookie[0].getValue();
			pwd = arr_cookie[1].getValue();
			
		}
		//important
		catch(NullPointerException e)
		{
			pw.println(e.getMessage()); //time being this will appear as null on frontend as user visits website for the first time
		}
		//design the login page form
		pw.println("<form action='WC' method='POST'>");
		pw.println("Username:-");
		pw.println("<input type='textfield' name='un' value='"+ un +"'/><p>");
		
		pw.println("Password:-");
		pw.println("<input type='password' name='pwd'  value='"+ pwd +"'/><p>");
		
		pw.println("<input type='checkbox' value='on' name='rem'>Remember Me</input><p>");
		pw.println("<input type='submit' value='Login'/>");
		pw.println("</form></body></html>");
		
		pw.close();
	}
}