//to display logout status
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Logout extends HttpServlet
{
	//servlet invoked using doPost()
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html><head><title>Logout Page</title></head>");
		try
		{
			HttpSession s = req.getSession(true);
			s.invalidate();
			pw.println("<body><i>You have been successfully logged out</i>");
		}
		catch(NullPointerException e)
		{
			res.sendRedirect("NoLogin.html");
		}
		pw.println("</body></html>");
		pw.close();
	}//end of doPost()
}//end of class	