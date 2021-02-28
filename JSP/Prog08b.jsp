<%@ page language="java" info="to give user the receipt of goods purchased" %>

<%
	String un = request.getParameter("un");
	String items = request.getParameter("items");
%>

<center>
	<h3>Thank you <%= un %> for purchasing <%= items %>  from our website </h3>
</center>