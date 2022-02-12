<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.sql.*" %>    
       <%@page import="dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Are you sure, you want to delete the record?</h1>
<%
if(request.getParameter("q")!=null)
{
	Datahelper.connection();
	  ResultSet res= Datahelper.dqlOpe("SELECT * FROM branch WHERE Branchid='"+request.getParameter("q")+"'");

	
	if(res.next())
	{
%>

<form action="DeleteBranchSer" method="post">
<table border='1'>
<tr><td><p>Enter Branch ID</p><td><input type="number" name="txtbranchid" value="<%= res.getString(1) %>" /> </td></tr>
<tr><td><p>Enter Branch Name</p><td><input type="text" name="txtbranchname" value="<%= res.getString(2) %>"/> </td></tr>
<tr><td colspan="2"><input type="submit" name="btnsubmit" value="delete" />  </td></tr>


</table>

</form>
<%
}
}

%>

</body>
</html>