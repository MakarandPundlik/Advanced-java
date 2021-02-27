<%@ page language="java" %>
<!-- Do not give info tag on included file-->

<center> 
	<b>
	<font size=6 color="red">
	
		Emerson Exports
	</font><p>
	<font size=4 color="green">
		<%= request.getParameter("dept") %><p>
		Shivajinagar Pune<p>
		Tel no:- <%= request.getParameter("tel") %><p>
	</font>
	</b>
</center>