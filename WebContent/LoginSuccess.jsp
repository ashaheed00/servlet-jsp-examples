<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<body>
	<h2>
		Hi  <%=request.getAttribute("name")%>, Login Successful<br>
		Your username: <%=request.getAttribute("user") %>
	</h2>
	<a href="login.html">Login Page</a>
</body>
</html>
