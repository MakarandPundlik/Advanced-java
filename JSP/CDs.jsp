<!-- 
	Shopping cart example
 -->
 
 <%@ page language="java" info="an example of shopping cart using links and session objects" import="java.util.Enumeration"%>
 
 <h4>[<a href="Toys.jsp">Shop for toys</a>]</h4><p>
 
 <!-- declare names of movies -->
 
 <table cellspacing=20>
 <%
	String[] items = {"Iron man 3","Lord of the rings return of the kings","PK","Mission Impossible","Massan","Cast Away","Foresr Gump"};
	
	for(int i=0;i<items.length;i++)
	{
 %>
 <tr>
 <td><%= items[i] %>
 <td><a href="CDs.jsp?aitem=<%= items[i] %>">Add to cart</a>

 </tr>
 <%
	}
 %>
 </table>
 <hr/>
 <h3>Contents of Shopping</h3>
 <table cellspacing=20>

	<%
		//accept the parameters sent dusing round trip to the server
		String aitem = request.getParameter("aitem");
		String ritem = request.getParameter("ritem");
		
		//during the first visit to the page aitem and ritem are both null
		//when user clicks on the link "Add to cart" ritem is null but aitem is not
		//same thing happens vice versa when user clicks on "remove from cart"
		
		//if we try to access value which is null, program throws NullPointerException
		//hence
		
		if(aitem!=null)
			session.setAttribute(aitem,aitem); //name of the movie is used as variable to store the value
		
		if(ritem!=null)
			session.removeAttribute(ritem); //movie will be removed from session object
			
		//display the contents of session object collection
		//unfortunately, session object does not have its own method to display all values of object collection
		
		//so here we will collect all attribute names of session object collection in an iterator Enumerator from util package

		Enumeration e = session.getAttributeNames();
		
			while(e.hasMoreElements())
			{
				String item=e.nextElement().toString();
				out.println("<tr><td>"+item+"<td><a href='CDs.jsp?ritem="+item+"'>Remove from cart</a></tr>");
			}
	%>

 </table>
 
 
 
 
 