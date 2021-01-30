//a servlet which will accept cost of items selected by user from previous page
//calculate the total ,diaply more items to shop

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Prog04a extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		//get the selected items values
		String[] arr_vals = req.getParameterValues("items");
		int sum=0;
		if(arr_vals!=null)
		{
			for(int i=0;i<arr_vals.length;i++)
			sum+=Integer.parseInt(arr_vals[i]);
			
			
			
		}
		//save this total in a session object
			HttpSession s = req.getSession(true); //create session object from user
			
			//store as key-value(object) pair
			s.setAttribute("page1_ttl",new Integer(sum));
			
			pw.println("<html><body>");
			pw.println("<h3>Total of Page 1 is Rs " + sum +" </h3>");
			pw.println("<form action='P4b' method='POST'");
			pw.println("<h3>Select some more items...</h3><p>");
			pw.println("<input type='checkbox' name='items' value='100'>Compass Box<p>");
			pw.println("<input type='checkbox' name='items' value='150'>Colour Box<p>");
			pw.println("<input type='submit' value='Next>>'>");
			pw.println("</form></body></html>");
		pw.close();
	
	}
}
