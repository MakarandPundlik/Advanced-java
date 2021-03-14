<%@ page language="java" info="An example of beans in jsp which takes data from user, stores it and displays it in any page" %>

<jsp:useBean id="eb" class="beans.Emp" scope="session"/>

<h3>Details of employee are </h3><p>

Empname :- <jsp:getProperty name="eb" property="empname" /><p>
Empid :- <jsp:getProperty name="eb" property="empid" />



