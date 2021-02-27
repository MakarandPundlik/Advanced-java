<%@ page language="java" info="An eg. to include directive to get current date dynamically" %>
<html>
<head>
	<title>Prog7</title>
</head>

<body>
	<b>
		<font size=6>
			<center>
				Databyte computers<br>
				<i>
					Karve Road,<br>
					Pune - 411004 <br>
				</i>
			</center>
		</font>
	</b>
	<%@ include file="Date.jsp" %>
	<p>These are the contents of the current jsp....
</body>
</html>