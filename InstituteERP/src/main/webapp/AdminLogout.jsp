<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
</header>
<section>
<form action="AdminLogoutSer" method="get">
<%
//session.removeAttribute("uid");
//session.invalidate();
//response.sendRedirect("index.jsp");
//HttpSession ses = request.getSession();

session.removeAttribute("uid");

session.invalidate();

//response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

//response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
//response.setDateHeader("Expires", 0); // Proxies.
response.setDateHeader("Expires",-1);

//response.sendRedirect("home.jsp");

response.sendRedirect("index.jsp");

%>
</form>
</section>
<footer>
</footer>
</body>
</html>