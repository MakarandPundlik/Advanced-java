//a servlet processes multiple values sent by html form for a single html element

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Prog03 extends HttpServlet
{
	//as data is sent via doPost() override the doPost()
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		//set res type
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		int cost=0;
		pw.println("<html><body>");
		
		//following method returns the array of String
		String[] arr_dests = req.getParameterValues("dests");
			
		//validation
		if(arr_dests==null)
		pw.println("<h3>Please select at least on destination</h3><p>");
		
		else
		{
			for(int i=0;i<arr_dests.length;i++)
			{
				if(arr_dests[i].equalsIgnoreCase("delhi"))
				{
					pw.println("<b>Delhi</b><p>");
					pw.println("<b>Stay :- </b><i>2 days @ <a href='http://www.hotelholidayinn.com'>Hotel Holiday Inn</a></i><p>");
					pw.println("<bPlaces to visit :- </b><i>Lal Fort,Qutub Minar,Sansad Bhavan...</i><p>");
					cost+=2000;
				}
				else if(arr_dests[i].equalsIgnoreCase("agra"))
				{
					pw.println("<b>Agra</b><p>");
					pw.println("<b>Stay :- </b><i>3 days @ <a href='http://www.hotelholidayfarm.com'>Hotel Holiday Farm</a></i><p>");
					pw.println("<bPlaces to visit :- </b><i>Taj Mahal, UP jail, Muslim Emporer Palace...</i><p>");
					cost+=3000;
				}
				else if(arr_dests[i].equalsIgnoreCase("jaipur"))
				{
					pw.println("<b>Jaipur</b><p>");
					pw.println("<b>Stay :- </b><i>3 days @ <a href='http://www.hotelpalace.com'>Hotel Palace</a></i><p>");
					pw.println("<bPlaces to visit :- </b><i>Hawa Mahal, King's Palace, Forts...</i><p>");
					cost+=5000;
				}
				else if(arr_dests[i].equalsIgnoreCase("nainital"))
				{
					pw.println("<b>Nainital</b><p>");
					pw.println("<b>Stay :- </b><i>2 days @ <a href='http://www.hotellakeview.com'>Hotel Lakeview</a></i><p>");
					pw.println("<bPlaces to visit :- </b><i>Boating,River rafting...</i><p>");
					cost+=4000;
				}
				else
				{
					pw.println("<b>Amritsar</b><p>");
					pw.println("<b>Stay :- </b><i>3 days @ <a href='http://www.hoteludtapunjab.com'>Hotel Udta Punjab</a></i><p>");
					pw.println("<bPlaces to visit :- </b><i>Jallianwala Baug,How farmers peacefully protest...</i><p>");
					cost+=5000;
				}
				
				
			}//end of loop
			pw.println("<h3>Total tour cost is Rs "+cost +" </h3><p>");
			
			
			
		}
		pw.println("</body></html>");
		pw.close();
	}
}