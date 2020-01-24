<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	     <form action="Register" method="post">
	        <label>Username</label>:
			<input type="text" name="username"></input><br>
			<label>Email Id</label>:
			<input type="email" name="email"></input><br>
			<label>Password</label>:
			<input type="password" name="password"></input>
			<label>Confirm Password</label>:
			<input type="password" name="confirmpassword"></input><br>
			<label>First Name</label>
			<input type="text" name="fname"></input><br>
			<label>Last Name</label>
			<input type="text" name="lname"></input><br>
			<label>Address</label>
			<input type="text" name="adress"></input><br>
			<label>Pincode</label>
			<input type="text" name="pincode"></input><br>
			<label>Age</label>
			<input type="text" name="age"></input><br>		
			<input type="submit"></input>
	     </form>
	</body>
</html>