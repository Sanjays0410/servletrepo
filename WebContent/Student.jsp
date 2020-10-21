<%@page import="com.cruds.demo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="StudentServlet" method="post">
		<label> Student USN:</label> <input type="text" name="studusn" /> <br>
		<label> Student Name:</label> <input type="text" name="studname" /> <br>

		<input type="submit" name="Click" value="Create" />


	</form>
	<%
	List<Student> slist=(List<Student>) request.getAttribute("STUD_LIST");
	
		String msg = (String) request.getAttribute("MESSAGE");
		if (msg != null) {
	%>
	<h1>
		<%=msg%></h1>

	<%
		}
	%>

<table>
		<thead>
			<tr>
				<td>Student USN</td>
				
				<td>Student Name</td>
			</tr>
		</thead>

		<tbody>
			<%
				if (slist != null) {
					for (Student s : slist) {
			%>
			<tr>
				<td><%=s.getUsn()%></td>
				
				<td><%=s.getName()%></td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>

</body>
</html>