<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="java.sql.*" %>    
        <%@ page import="dao.*" %>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getParameter("q")!=null)
{
	 Datahelper.connection();
	  ResultSet res=Datahelper.dqlOpe("SELECT * FROM reg WHERE regid='"+request.getParameter("q")+"'");

	
	if(res.next())
	{
%>

<form action="EditRegSer" method="post">
<table border='1'>

<tr><td><p>Registration id</p><input type="number" name="txtregid" value="<%= res.getString(1) %>"/> </td></tr>

<tr><td><p>Course name</p><input type="text" name="txtcoursename" value="<%= res.getString(2) %>"/> </td></tr>

<tr><td><p>Registration date</p><input type="text" name="txtregdate" value="<%= res.getString(3) %>"/> </td></tr>

<tr><td><p>Total fees</p><input type="text" name="txttotalfees" value="<%= res.getString(4) %>"/> </td></tr>

<tr><td><p>Submitted fee</p><input type="text" name="txtsubmittedfee" value="<%= res.getString(5) %>"/> </td></tr>

<tr><td><p>remaining fee</p><input type="text" name="txtremainingfee" value="<%= res.getString(6) %>"/> </td></tr>

<tr><td><p>discount</p><input type="text" name="txtdiscount" value="<%= res.getString(7) %>"/> </td></tr>

<tr><td><p>enquiry id</p><input type="text" name="txtenqid" value="<%= res.getString(8) %>"/> </td></tr>

<tr><td colspan="2"><input type="submit" name="btnsubmit" value="update" />  </td></tr>


</table>

</form>
<%
}
}

%>

</body>
</html>