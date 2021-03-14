
<%@ page language="java" info="a jsp which will instantite java beans and use it to store and disply the message" %>
 
<jsp:useBean id="mb" class="beans.Message"/>

<%
	/*
		Long cut method for <jsp:useBean
		
		Message mb = new Message();
		
	*/
%>
<jsp:setProperty name="mb" property="msg" value="Welcome to the world of JSP and Beans" />
<%
	/*
		Long cut method for <jsp:setProperty
		
		mb.setMsg("Welcome to the world of JSP and Beans");
		
	*/
%>
Message stored in bean object : <jsp:getProperty name="mb" property="msg" />
<%
	/*
		Long cut method for <jsp:getProperty
		
		out.println("Message stored in bean object "+mb.getMsg());
		
	*/
%>