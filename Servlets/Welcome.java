//a servlet which shows link to different facilities of bank

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Welcome extends HttpServlet
{
	// when a servlet is invoked using res.sendRedirect(), it auto calls the doGet()
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html><head><title>Welcome Page</title></head>");
		pw.println("<body>");
		// direct visit/access to this page via history of URL should be prohibited
		// this can be achieved only by using sessions
		// here we will access the session object using getSession(false)
		// false means, if session is defined, access it
		// if session is not defined (if visit is direct i.e. not through the Process servlet) & we try access it,
		// the session object throws NullPointerException
		try{
			HttpSession s = req.getSession(false);
			//life of session object is by default 30 mins
			//so, to set user defined value we need to call setMaxInactiveInterval(secs)
			s.setMaxInactiveInterval(60); //in seconds, link will get disabled after 1 mins
			
			pw.println("<h3>Welcome "+s.getAttribute("un")+"<h3><p>");
			pw.println("<i>Facilities available:-<p>");
			pw.println("<a href='BB'> Check Balance.</a><p>");
			pw.println("Transfer Amount.<p>");
			pw.println("Pay Bills </i><p>");
		}
		catch(NullPointerException e)
		{
			res.sendRedirect("NoLogin.html");
		}
		pw.println("</body></html>");
		pw.close();
	}//end of doGet()
}//end of class	