<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= request.getAttribute("message") %>
<h1>Hello new User</h1>
<form action = "save" method = "post">
			User Name: <input type = "text" name = "uname" placeholder = "Enter user name"><br><br>
			Password: <input type = "password" name = "pwd1" placeholder = "Enter password"><br><br>
			Password: <input type = "password" name = "pwd2" placeholder = "Enter password"><br><br>
			<input type = "submit" value = "Signup"/>
	</form> <br>
</body>
</html>