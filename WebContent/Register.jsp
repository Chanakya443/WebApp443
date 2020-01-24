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
			<input type="text" name="username"></input>
			<label>Email Id</label>:
			<input type="email" name="email"></input>
			<label>Password</label>:
			<input type="password" name="password"></input>
			<label>Confirm Password</label>:
			<input type="password" name="confirmpassword"></input>
			<label>First Name</label>
			<input type="text" name="fname"></input>
			<label>Last Name</label>
			<input type="text" name="lname"></input>
			<label>Address</label>
			<input type="text" name="adress"></input>
			<label>Pincode</label>
			<input type="text" name="pincode"></input>
			<label>Age</label>
			<input type="text" name="age"></input>		
			<input type="submit">Submit</input>
	     </form>
	</body>
</html>