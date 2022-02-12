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
<header style="background-color:blue; width:179%; ">
<h2><a href="AdminBranch.jsp">Branch</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminReg.jsp">Reg</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminFees.jsp">Fees</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminRecruit.jsp">Recruit</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="AdminLogout.jsp">Logout</a></h2>

</header>
<section >
<center>
<font size="10">This is Enquiry Table</font>
<table border="1" bgcolor="darkcyan">
<tr><td>Enquiryid</td><td>FullName</td><td>Mobile</td><td>email</td><td>dob</td><td>collegename</td><td>heigerqualification</td><td>enqdate</td><td>coursename</td><td>enquirysource</td><td>branchid</td><td>staffid</td></tr>
<%
Datahelper.connection();
ResultSet res=Datahelper.dqlOpe("select * from enquiry");

while(res.next())
{%>
<tr><td><%= res.getString(1) %></td><td><%= res.getString(2) %></td><td><%= res.getString(3) %></td><td><%= res.getString(4) %></td><td><%= res.getString(5) %></td><td><%= res.getString(6) %></td><td><%= res.getString(7) %></td><td><%= res.getString(8) %></td><td><%= res.getString(9) %></td><td><%= res.getString(10) %></td><td><%= res.getString(11) %></td><td><%= res.getString(12) %></td><td><a href="EditEnquiry.jsp?q=<%= res.getString(1)  %>">EDIT</a></td><td><a href="DeleteEnquiry.jsp?q=<%= res.getString(1)  %>">Delete</a></td>
</tr>
<%} %>

<form action="AdminEnquirySer" method="post">

<tr><td><input type="number" name="txtEnquiryid" /> </td>

<td><input type="text" name="txtFullName" /> </td>

<td><input type="number" name="txtMobile" /> </td>

<td><input type="text" name="txtemail" /> </td>

<td><input type="date" name="txtdob" /> </td>

<td><input type="text" name="txtcollegename" /> </td>

<td><input type="text" name="txtheigerqualification" /> </td>

<td><input type="date" name="txtenqdate" /> </td>

<td><input type="text" name="txtcoursename" /> </td>

<td><input type="text" name="txtenquirysource" /> </td>

<td><input type="number" name="txtbranchid" /> </td>

<td><input type="number" name="txtstaffid" /> </td>




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
<footer style="background-color:blue; width:179%;">
About us
</footer>
</body>
</html>