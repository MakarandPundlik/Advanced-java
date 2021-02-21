<%@ page language="java" info="A program to implement hit vounter for a website" %>

<html>
	<body>
		<%! 
			int cntr=0;
			int hitCounter()
			{
				return ++cntr;
			}
		%>
		<h3>
			Welcome visitor number <%= hitCounter() %>
		</h3>
	</body>
</html>