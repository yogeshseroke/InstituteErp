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
	  ResultSet res=Datahelper.dqlOpe("SELECT * FROM fees WHERE feesid='"+request.getParameter("q")+"'");

	
	if(res.next())
	{
%>

<form action="EditFeesSer" method="post">
<table border='1'>

<tr><td><p>Fees ID</p><td><input type="number" name="txtfeesid" value="<%= res.getString(1) %>" /> </td></tr>

<tr><td><p>Registration ID</p><td><input type="number" name="txtregid" value="<%= res.getString(2) %>" /> </td></tr>

<tr><td><p>Course ID</p><td><input type="number" name="txtcourseid" value="<%= res.getString(3) %>" /> </td></tr>

<tr><td><p>Installment</p><td><input type="number" name="txtinstallment" value="<%= res.getString(4) %>" /> </td></tr>

<tr><td><p>Amount</p><td><input type="number" name="txtamount" value="<%= res.getString(5) %>" /> </td></tr>

<tr><td><p>Remaining Amount</p><td><input type="number" name="txtremainingamount" value="<%= res.getString(6) %>" /> </td></tr>
<tr><td colspan="2"><input type="submit" name="btnsubmit" value="update" />  </td></tr>

</table>

</form>
<%
}
}

%>

</body>
</html>