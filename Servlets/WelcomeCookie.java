//a servlet 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeCookie extends HttpServlet
{
	//as servlet is invoked by form we need to override doPost()
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		pw.println("<html><head><title>Welcome Page</title></head><body>");
		
		//read the form data
		
		String un = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		String rem = req.getParameter("rem");	
		
		//it checkbox is not selected and we attempt to read its contents it throws NullPointerException
		
		if(rem!=null)
		{
			//create a cookie object to store user information
			Cookie c1 = new Cookie("un",un); //key vlue pair
			Cookie c2 = new Cookie("pwd",pwd);
			
			//important, set expiry dat for cookie
			//eg we want to cookie to expre after 1hr
			c1.setMaxAge(3600);
			c2.setMaxAge(3600); //time in seconds
			
			//write the cookie to use's machine
			res.addCookie(c1);
			res.addCookie(c2);
		}
		pw.println("Welcome "+un+" tp our website");
		pw.println("</body></html>");
		
		pw.close();
	}
}