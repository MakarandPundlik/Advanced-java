//a servlet to receive data of a dropdown from html form and process it

import javax.servlet.*; //ServletException
import javax.servlet.http.*; //HttpServlet class 
//HttpServletRequest,HttpServletResponse 
//HttpServlet is a subclass of GenericServlet. It is more powerful & typically used when data is sent through frontend and 
//to be processed for advance features like sessions

import java.io.*;// PrintWriter 
public class Prog02 extends HttpServlet
{
	//override the doPost() of this class
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	
		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		
		// get/collect the value sent by html paramter select with name=collect
		
		String colname = req.getParameter("col");
		
		pw.println("<html><body>");
		pw.println("<h3><font color='" + colname + "'>It seems your favourite colour is " + colname + "</font></h3>");
		pw.println("</body></html>");
		
		pw.close();
	}
} 