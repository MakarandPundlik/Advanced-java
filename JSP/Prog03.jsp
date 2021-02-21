<!-- An example of Declaration,scripplet and expression-->

<html>
<head><title>An example of Declaration,scripplet and expression</title></head>

<body>
	<%! 
		//start of declaration
		int x = 10; //at class level
		
		String myMethod(String name)
		{
			//this method is used only for processing and accessing the
			//_jspService(), it cannot produce any output
			
			x++;
			
			//out.println("Hello "+name);
			//error, no such object found 
			//it is made use of scripplet only as this object of class
			//JspWriter is defined in _jspService()
			
			return "Hello "+name;
		}
	%>
	<h3>
		Before calling myMethod() x = <%= x %><p>
		Calling myMethod() <%= myMethod("Test name") %><p>
		After calling myMethod() x = <%= x %><p>
		
	</h3>
</body>
</html>