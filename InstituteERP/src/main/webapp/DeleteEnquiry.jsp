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
	  ResultSet res= Datahelper.dqlOpe("SELECT * FROM enquiry WHERE enqid='"+request.getParameter("q")+"'");

	
	if(res.next())
	{
%>

<form action="DeleteEnquirySer" method="post">
<table border='1'>

<tr><td><p>Enquiryid</p><input type="number" name="txtEnquiryid" value="<%= res.getString(1) %>"/> </td></tr>

<tr><td><p>FullName</p><input type="text" name="txtFullName" value="<%= res.getString(2) %>"/> </td></tr>

<tr><td><p>Mobile</p><input type="number" name="txtMobile" value="<%= res.getString(3) %>"/> </td></tr>

<tr><td><p>email</p><input type="text" name="txtemail" value="<%= res.getString(4) %>"/> </td></tr>

<tr><td><p>dob</p><input type="date" name="txtdob" value="<%= res.getString(5) %>"/> </td></tr>

<tr><td><p>collegename</p><input type="text" name="txtcollegename" value="<%= res.getString(6) %>"/> </td></tr>

<tr><td><p>heigerqualification</p><input type="text" name="txtheigerqualification" value="<%= res.getString(7) %>"/> </td></tr>

<tr><td><p>enqdate</p><input type="date" name="txtenqdate" value="<%= res.getString(8) %>"/> </td></tr>

<tr><td><p>coursename</p><input type="text" name="txtcoursename" value="<%= res.getString(9) %>"/> </td></tr>

<tr><td><p>enquirysource</p><input type="text" name="txtenquirysource" value="<%= res.getString(10) %>"/> </td></tr>

<tr><td><p>branchid</p><input type="number" name="txtbranchid" value="<%= res.getString(11) %>"/> </td></tr>

<tr><td><p>staffid</p><input type="number" name="txtstaffid" value="<%= res.getString(12) %>"/> </td></tr>

<tr><td colspan="2"><input type="submit" name="btnsubmit" value="delete" />  </td></tr>

</table>

</form>
<%
}
}

%>

</body>
</html>