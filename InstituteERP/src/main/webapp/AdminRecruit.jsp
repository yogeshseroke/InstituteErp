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

<body bgcolor="gray" >
<header style="background-color:blue; width:105%;">
<h2><a href="AdminBranch.jsp">Branch</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminEnquiry.jsp">Enquiry</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminReg.jsp">Registration</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminFees.jsp">Fees</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminLogout.jsp">Logout</a></h2>

</header>
<section>
<center>
<h1><font color="white">This is Admin page</font></h1>
<font size="10" color="white">Recruitment Table</font>
<table border="1" bgcolor="darkcyan">
<tr><td>Recruit id</td><td>Email</td><td>Password</td><td>Staff Name</td><td>Joining Date</td><td>Designation</td><td>Experience</td></tr>
<%
Datahelper.connection();
ResultSet res=Datahelper.dqlOpe("select * from recruit");

while(res.next())
{%>
<tr><td><%= res.getString(1) %></td><td><%= res.getString(2) %></td><td><%= res.getString(3) %></td><td><%= res.getString(4) %></td><td><%= res.getString(5) %></td><td><%= res.getString(6) %></td><td><%= res.getString(7) %></td><td><a href="EditRecruit.jsp?q=<%= res.getString(1)  %>">EDIT</a></td><td><a href="DeleteRecruit.jsp?q=<%= res.getString(1)  %>">DELETE</a></td>
</tr>
<%} %>

<form action="AdminRecruitSer" method="post">


<tr><td><input type="number" name="txtrecruitid" /> </td>

<td><input type="text" name="txtemail" /> </td>

<td><input type="text" name="txtpassword" /> </td>

<td><input type="text" name="txtstaffname" /> </td>

<td><input type="date" name="txtjoiningdate" /> </td>

<td><input type="text" name="txtdesignation" /> </td>

<td><input type="text" name="txtexperience" /> </td>


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
<footer style="background-color:blue; width:105%;">
About us
</footer>
</body>
</html>