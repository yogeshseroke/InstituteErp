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

<header>
<h2><a href="AccountantEnquiry.jsp">Enquiry</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AccountantReg.jsp">Registration</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AccountantLogout.jsp">Logout</a></h2>

</header>
<section>
<center>
<h1><font color="white">This is Accountant page</font></h1>
<font size="10" color="white">Fees Table</font>
<table border="1" bgcolor="darkcyan">
<tr><td>Fees id</td><td>Registration id</td><td>Course id</td><td>Installment</td><td>Amount</td><td>Remaining Amount</td></tr>
<%
Datahelper.connection();
ResultSet res=Datahelper.dqlOpe("select * from fees");

while(res.next())
{%>
<tr><td><%= res.getString(1) %></td><td><%= res.getString(2) %></td><td><%= res.getString(3) %></td><td><%= res.getString(4) %></td><td><%= res.getString(5) %></td><td><%= res.getString(6) %></td><td><a href="EditBranch.jsp?q=<%= res.getString(1)  %>">EDIT</a></td>
</tr>
<%} %>

<form action="AdminFeesSer" method="post">

<tr><td><input type="number" name="txtfeesid" /> </td>


<td><input type="number" name="txtregid" /> </td>

<td><input type="number" name="txtcourseid" /> </td>

<td><input type="number" name="txtinstallment" /> </td>

<td><input type="number" name="txtamount" /> </td>

<td><input type="number" name="remainingamount" /> </td>

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
About us
</footer>
</body>
</html>