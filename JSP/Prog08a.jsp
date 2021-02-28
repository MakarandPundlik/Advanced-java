<%@ page language="java" info="To get user confirmation" %>

<h3>Terms and conditions</h3>
1.Payment must be done on receipt of goods<p>
2.If not satisfied with the product it should be returned within the period of 7 days<p>
...<p>
...<p>...<p>...<p>
<%
	String un = request.getParameter("un");
	String items = request.getParameter("items");
%>

<a href="Prog08b.jsp?un=<%=un%>&items=<%=items%>">I agree...</a>
<!--
	Here we can append using name value pairs without using spaces
	This is required because new request object gets created which doenst hold the state of previous request object
	Life of request object is limited to single page only 	
-->