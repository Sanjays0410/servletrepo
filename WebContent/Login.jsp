<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<label> UserName:</label> <input type="text" name="username" /> <br>
		<br> <label> Password:</label> <input type="password"
			name="password" /> <br> <br> <input type="submit"
			name="Click" value="Login" />
 
	</form>

	<%
		String msg = (String) request.getAttribute("MESSAGE");
		if (msg != null) {
	%>
	<h1 style="color: red">
		<%=msg%></h1>

	<%
		}
	%>

</body>
</html>