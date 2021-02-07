//this servlte represents the user account balance 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Balance extends HttpServlet
{
	// when a servlet is invoked using res.sendRedirect(), it auto calls the doGet()
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		// before dispatching the contents to the web page, we can request the browser of client not
		// to store the contents of this page into cache memory
		res.setHeader("pragma","no-cache");  // key/value pair
		// for cross browser support, use another header
		res.setHeader("cache-control","no-store");

		
		pw.println("<html><head><title>Balance Page</title></head>");
		pw.println("<body>");
		try
		{
			HttpSession s = req.getSession(false);
			pw.println("<h4><i>Dear "+s.getAttribute("username")+" your balance is "+s.getAttribute("balance")+" </h4><p>");
			pw.println("<form method='post' action='Lo'>");
			pw.println("<input type='submit' value='Logout'><p></form>");
			
		}
		catch(NullPointerException e)
		{
			res.sendRedirect("NoLogin.html");
		}
		pw.println("</body></head>");
		pw.close();
	}//end of doGet()
}//end of class	