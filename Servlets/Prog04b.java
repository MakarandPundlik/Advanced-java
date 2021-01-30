//a servlet which will accept cost of items selected by user from previous page
//calculate the total ,diaply grand total

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Prog04b extends HttpServlet
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
			//get session 
			HttpSession s = req.getSession(false); //false means session already exist
			
			int page1_ttl = Integer.parseInt(s.getAttribute("page1_ttl").toString());
			
			pw.println("<html><body>");
			pw.println("<h3>Total of Page 1 is Rs " + page1_ttl +" </h3>");
			pw.println("<h3>Total of Page 2 is Rs " + sum +" </h3>");
			pw.println("<h3>Grand tTotal  is Rs " + (page1_ttl+sum) +" </h3>");
			pw.println("</form></body></html>");
		pw.close();
	
	}
}
