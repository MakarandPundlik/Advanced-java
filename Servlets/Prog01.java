//design a servlet to greet the user depending upon the time of the day
//Remember that the servlet code is not kept on the server. The developer writes the code on his/her machine , compiles it and 
//then uploads the .class file on server in the special folder "clsses" in "WEB-INF

import javax.servlet.*; /*servlet package is a art of extended java library & contains classes to create servlets or servlet APIs
is available in TOMCAT
eg, GenericServlet, ServletResponse, ServletRequest, ServletException etc
*/

import java.io.*; /*This package contains the PrintWriter which is used to deliver op stream to client through ServeletResponse object*/
import java.util.Date; //Date object

//all servlets are to be declared "public" as they are executed by external program on server
//This environment is called as J2EE and not JRE
//Java Enyterprise Edition

public class Prog01 extends GenericServlet
//servlets have to extend or inherit this class
{
		//GenericServlet is not an abstract class , hence no need to override all its methods
		//init() service() destroy()
		//however we have to override service() to ask the server to perform its task
		
		public void service(ServletRequest req,ServletResponse res) throws IOException , ServletException
		{
			//decide the type of content the servlt has to produce
			
			res.setContentType("text/html");
			
			//generate op stream
			PrintWriter pw = res.getWriter();
			
			//create a dat object
			Date d = new Date();
			int hrs = d.getHours(); //return hours in 24 hr format
			
			String wish = "Good ";
			if(hrs<12)
			wish+="Morning";
			
			else if(hrs<17)
			wish+="Afternoon";
			
			else 
			wish+="Evening";
			
			//deliver the html to client
			pw.println("<html><head><title>First Servlet</title></head>");
			pw.println("<body><h3>" + wish + "</h3></body></html>");
			pw.close();
		}
}