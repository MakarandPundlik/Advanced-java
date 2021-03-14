<%@ page language="java" info="An example of beans in jsp which takes data from user, stores it and displays it in any page" %>

<jsp:useBean id="eb" class="beans.Emp" scope="session"/>
<jsp:setProperty name="eb" property="empname" param="ename"/>
<jsp:setProperty name="eb" property="empid" param="eid"/>

<%
	/*
		in jsp:setProperty fieldname in Emp class i.e. empid whereas eid is name of HTML form paramter 
		Using tag eliminates the need to use request.getParameter(parameter name);
	*/
%>

<h3>Data of employee stored successfully</h3><p>
<a href="Prog10b.jsp">Proceed to see details of employee</a>