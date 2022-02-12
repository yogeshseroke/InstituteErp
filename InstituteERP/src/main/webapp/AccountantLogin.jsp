<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" type="text/css" rel="stylesheet" />

</head>
<body bgcolor="gray">
<header>
<a href="index.jsp">Home</a>

</header>
<section>
<center>


<form action="AccountantLoginSer" method="post">

<h1>Accountant Login</h1>
   <br>
   <br>
  <input type="text" name="txtuid" placeholder="UserID"/>
  <br>
  <br>
  <input type="password" name="txtpass" placeholder="Password"/>
  <br>
  <br> 
   
  <input type="submit" name="btnsubmit" value="Login" />

</form>
</center>
</section>
<footer>
About us
</footer>
</body>
</html>