<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.cruds.demo.Department"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


 <script type="text/javascript">

var seldeptid,seldeptname;
function setData(deptid,deptname)
{
	//alert(deptid);
//document.deptform.hdnDeptId.value=deptid;
//document.deptform.hdnDeptId.value=deptname; 
seldeptid=deptid;
seldeptname=deptname;

}

function deldept()
{
	document.deptform.hdnDeptId.value=seldeptid;	
document.deptform.ACTION.value="DELETE";
document.deptform.submit();
}
function editdept()
{
	document.deptform.deptid.value=seldeptid;
	document.deptform.deptid.readOnly=true;
	document.deptform.deptname.value=seldeptname;
	
	document.deptform.btnsubmit.value="update";
	document.deptform.ACTION.value="UPDATE";
	
	}
</script> 
</head>
<body>

	 <form name="deptform" action="DepartmentServlet" method="post">
		<label> Deptid:</label> <input type="text" name="deptid" /> <br> 
		<label> Deptname:</label> <input type="text" name="deptname" /> <br>


		<input type="hidden" name="ACTION" value="CREATE" /> <input
			type="hidden" name="hdnDeptId" /> <input type="submit"
			name="btnsubmit" value="Create" />


	</form> 
	<%
		List<Department> dlist = (List<Department>)request.getAttribute("DEPT_LIST");
		String msg = (String) request.getAttribute("MESSAGE");
		if (msg != null) {
	%>
	<h1>
		<%=msg%></h1>

	<%
		} 
	%>



	<table border="1">
		<thead>
			<tr>
				<td>Dept ID</td>
				<td>Dept Name</td>
				<td></td>
			</tr>
		</thead>

		<tbody>
			<%
				if (dlist != null) {
					for (Department d : dlist) {
			%>
			<tr>
				<td><%=d.getId()%></td>
				<td><%=d.getName()%></td>
				 <td><input type="checkbox"
					onclick="setData(<%=d.getId()%>,'<%=d.getName()%>');"/>
					</td> 
 
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>
	<input type="button" value="Delete" onclick="deldept();"/>
	<input type="button" value="EDIT" onclick="editdept();"/>
</body>
</html>