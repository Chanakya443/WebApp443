<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <body>
 <form action="Login" method="post">
        <label>Username</label>:
		<input type="text" name="username"></input>
		<label>Password</label>:
		<input type="password" name="password"></input>
		<input type="submit">Login</input>
</form>
		<a href="Register.jsp">New User? Sign Up </a>    
		<h1 style=color:green>${message}</h1>
 </body>
</html>