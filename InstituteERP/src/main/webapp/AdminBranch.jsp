<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>    
        <%@ page import="dao.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" type="text/css" rel="stylesheet" />

</head>
<body bgcolor="gray">
<%
if(session.getAttribute("uid")==null)
{
    response.sendRedirect("AdminLogin.jsp");	
}
%>

<header>
<h2><a href="AdminEnquiry.jsp">Enquiry</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminReg.jsp">Registration</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminFees.jsp">Fees</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminRecruit.jsp">Recruitment</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminLogout.jsp">Logout</a></h2>

</header>
<section>
<center>
<h1><font color="white">This is Admin page</font><%session.getAttribute("uid"); %></h1>
<font size="10" color="white">Branch Table</font>
<table border="1" bgcolor="darkcyan">
<tr><td>Branchid</td><td>BranchName</td></tr>
<%
Datahelper.connection();
ResultSet res=Datahelper.dqlOpe("select * from branch");

while(res.next())
{%>
<tr><td><%= res.getString(1) %></td><td><%= res.getString(2) %></td><td><a href="EditBranch.jsp?q=<%= res.getString(1)  %>">EDIT</a></td><td><a href="DeleteBranch.jsp?q=<%= res.getString(1)  %>">DELETE</a></td>
</tr>
<%} %>

<form action="AdminBranchSer" method="post">

<tr><td><input type="number" name="txtbranchid" /> </td>

<td><input type="text" name="txtbranchname" /> </td>

<td><input type="submit" name="btnsubmit" />  </td></tr>



</form>

<%
if(request.getParameter("q")!=null)
{
	out.print(request.getParameter("q"));
}

%>
</table>
</center>
</section>
<br>
<br>
<footer>
about us
</footer>
</body>
</html>