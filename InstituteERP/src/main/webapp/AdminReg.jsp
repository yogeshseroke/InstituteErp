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
<h2><a href="AdminBranch.jsp">Branch</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminEnquiry.jsp">Enquiry</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminFees.jsp">Fees</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminRecruit.jsp">Recruitment</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminLogout.jsp">Logout</a></h2>
</header>
<section>
<center>
<h1><font color="white">This is Admin page</font></h1>
<br>
<br>
<table border="1" bgcolor="darkcyan">
<form action="AdminRegSer" method="post">

<tr><td>regid</td><td><input type="number" name="txtregid" /> </td></tr>

<tr><td>coursename</td><td><input type="text" name="txtcoursename" /> </td></tr>

<tr><td>regdate</td><td><input type="text" name="txtregdate" /> </td></tr>

<tr><td>totalfees</td><td><input type="text" name="txttotalfees" /> </td></tr>

<tr><td>submittedfee</td><td><input type="text" name="txtsubmittedfee" /> </td></tr>

<tr><td>remainingfee</td><td><input type="text" name="txtremainingfee" /> </td></tr>

<tr><td>discount</td><td><input type="text" name="txtdiscount" /> </td></tr>

<tr><td>enqid</td><td><input type="text" name="txtenqid" /> </td></tr>


<tr><td><input type="submit" name="btnsubmit" />  </td></tr>


</form>

<%
if(request.getParameter("q")!=null)
{
	out.print(request.getParameter("q"));
}

%>
</table>
<table border="1" bgcolor="darkcyan">
<font size="5" color="white">Registration Table</font>
<tr><td>regid</td><td>coursename</td><td>regdate</td><td>totalfees</td><td>submittedfee</td><td>remainingfee</td><td>discount</td><td>enqid</td></tr>

<%
Datahelper.connection();
ResultSet res=Datahelper.dqlOpe("select * from reg");

while(res.next())
{%>
<tr><td><%= res.getString(1) %></td><td><%= res.getString(2) %></td><td><%= res.getString(3) %></td><td><%= res.getString(4) %></td><td><%= res.getString(5) %></td><td><%= res.getString(6) %></td><td><%= res.getString(7) %></td><td><%= res.getString(8) %></td><td><a href="EditReg.jsp?q=<%= res.getString(1)  %>">EDIT</a></td></tr>
<%} %>

</table>

</center>
</section>
<footer>
About us
</footer>
</body>
</html>