<%@ page language="java" info="an example of shopping cart in beans and JSP" import="java.util.Enumeration" 	%>


[<a href="ToysQty.jsp">Shop for games</a>]
<form action="CDsQty.jsp" method="POST">
	<table cellspacing=20 >
	<%
		String[] title = {"Expandables","Mission Impossible 5","Ocean's Eleven","Collateral","Forest Gump"};
		int[] rate = {150,200,300,120,400};
		
		out.print("<tr>");
		out.print("<th>Movie");
		out.print("<th>Rate");
		out.print("<th>Qty");
		out.print("<th>Add");
		out.print("</tr>");
		
		
		
			
		for(int i=0;i<title.length;i++)
		{
			//during the round trip to the server, qty resets to the 1 and doesnt show the 
			//actual qty select by the user so to get the qty selected by the server and while 
			//sending it back to the user show the selected qty
		
			String str = request.getParameter("qty"+i); //get selected qty 1,2,3
			char q;
			if(str!=null)
				q = str.charAt(0);
			else //while first visit str is null 
				q = '1';
				
			out.print("<tr>");
			out.print("<td>"+title[i]);
			out.print("<td>"+rate[i]);
			out.print("<td><select name='qty" +i+ "'>");
			out.print("<option value='1'"+ (q=='1'?"selected":"") +">1");
			out.print("<option value='2'"+ (q=='2'?"selected":"") +">2");
			out.print("<option value='3'"+ (q=='3'?"selected":"") +">3");
			out.print("</select>");
			out.print("<td><input type='submit' value='Add' name='Add"+i+"'>");
			out.println("</tr>");
		}
	%>
	
	</table>
	</form>
	<hr><p>
	
	<table cellspacing=20>
	<%
		//to identify which button is clicked by the user
		for(int i=0;i<title.length;i++)
		{
			//get the pressed button
			String btnadd = request.getParameter("Add"+i);
			
			if(btnadd!=null)
			{
				//create an object of bean class and store the data into it
				// Conventional java code not jsp tags
				
				beans.Items ib = new beans.Items();
				//now store the data fieldwise
				ib.setName(title[i]);
				ib.setRate(rate[i]);
				int q = Integer.parseInt(request.getParameter("qty"+i));
				ib.setQty(q);
				ib.setTotal(q*rate[i]);
				session.setAttribute("cd"+i,ib);
				break; //at a time only one button is clicked
			}
			
		}
		//to clculate total
		int billtotal = 0;
		//now display the selected items
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements())
		{
			//get the object name
			String name = e.nextElement();
			beans.Items ib = (beans.Items)session.getAttribute(name);// we need to typecast Object type to required type
			out.print("<tr>");
			out.print("<td>"+ib.getName());
			out.print("<td>"+ib.getRate());
			out.print("<td>"+ib.getQty());
			out.print("<td>"+ib.getTotal());
			out.print("</tr>");
			billtotal+=ib.getTotal();
		}
		out.println("<h3>Total amount of bill is "+billtotal+"</h3>");
	%>
</table>