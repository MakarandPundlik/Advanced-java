<%@ page language="java" info="an example of handling form data in jsp" %>

<%
	//scriplet is a part of jsp which has 2 parameters
	//request and resposne
	
	String fn = request.getParameter("fn");
	String gender = request.getParameter("gender");
	
	String status;
	if(gender.equalsIgnoreCase("male"))
		status="Mr. ";
	else status="Ms. ";
	
%>

<h3>Welcome <%= status %> <%= fn %> to our website</h3>
