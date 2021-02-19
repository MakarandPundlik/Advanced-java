<%@ page language="java" info="jsp with scriples and expressions" import="java.util.Date" %>
<html>
	<head><title>Example of scriplet and expression</title></head>
	<body>
		<%
			int prin = 1000,no_years = 2;
			double rate = 6.5,simp_int;
			simp_int = prin*no_years*rate/100;
		%>
		<h3>
			An investment of Rs <%= prin %> was made @<%= rate %> pcpa for period of <%= no_years %> years.
			Will fetch the interest of <%= simp_int %>.<p>
			
			Simple ineterst is Rs <%= prin*no_years*rate/100 %>.<p>
			3 + 5 = <%= 3+5 %>.<p>
			
			Todays date is <%= new Date()%>
		</h3>
	</body>
</html>
