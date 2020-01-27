<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:400,300,500);
*:focus {
  outline: none;
}
body {
  margin: 0;
  padding: 0;
  background: #DDD;
  font-size: 16px;
  color: #222;
  font-family: 'Roboto', sans-serif;
  font-weight: 300;
}

#login-box {
  position: relative;
  margin: 5% auto;
  width: 600px;
  height: 730px;
  background: #FFF;
  border-radius: 2px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
}

.left {
  position: absolute;
  top: 0;
  left: 0;
  box-sizing: border-box;
  padding: 40px;
  width: 300px;
  height: 400px;
}

h1 {
  margin: 0 0 20px 0;
  font-weight: 300;
  font-size: 28px;
}

input[type="text"],input[type="email"],
input[type="password"] {
  display: block;
  box-sizing: border-box;
  margin-bottom: 20px;
  padding: 4px;
  width: 220px;
  height: 32px;
  border: none;
  border-bottom: 1px solid #AAA;
  font-family: 'Roboto', sans-serif;
  font-weight: 400;
  font-size: 15px;
  transition: 0.2s ease;
}

input[type="text"]:focus,
input[type="password"]:focus {
  border-bottom: 2px solid #16a085;
  color: #16a085;
  transition: 0.2s ease;
}

input[type="submit"] {
  margin-top: 28px;
  width: 120px;
  height: 32px;
  background: #16a085;
  border: none;
  border-radius: 2px;
  color: #FFF;
  font-family: 'Roboto', sans-serif;
  font-weight: 500;
  text-transform: uppercase;
  transition: 0.1s ease;
  cursor: pointer;
}

input[type="submit"]:hover,
input[type="submit"]:focus {
  opacity: 0.8;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
}

input[type="submit"]:active {
  opacity: 1;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
}

.or {
  position: absolute;
  top: 180px;
  left: 280px;
  width: 40px;
  height: 40px;
  background: #DDD;
  border-radius: 50%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  line-height: 40px;
  text-align: center;
}

.right {
  position: absolute;
  top: 0;
  right: 0;
  box-sizing: border-box;
  padding: 40px;
  width: 300px;
  height: 400px;
  background: url('https://goo.gl/YbktSj');
  background-size: cover;
  background-position: center;
  border-radius: 0 2px 2px 0;
}

.right .loginwith {
  display: block;
  margin-bottom: 40px;
  font-size: 28px;
  color: #FFF;
  text-align: center;
}
.errMessage{
    font-size: 13px;
    color: #ff0000;
    font-family: 'red';
}
</style>
<script type="text/javascript">
$(function () {
        $("#formSubmit").click(function () {
            var password = $("#password").val();
            var confirmPassword = $("#confirmpassword").val();
            if (password != confirmPassword) {
                $("#errPassword").text("Password/Confirm Password are not same");
                return false;
            }
            return true;
        });
    });
</script>
</head>
	<body>
	    <div id="login-box">
		  <div class="left">
		    <h1>Sign up</h1>
				 <form action="Register" method="post">
					<input type="text" name="username" placeholder="Username" pattern="[A-Za-z0-9]+" title="user name should contain Alphabets or Numbers" required></input>			
					<input type="email" name="email" placeholder="E-mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[A-Za-z]+" title="ex:username@domail.com" required></input>		
					<input type="password" id="password" name="password" placeholder="Password" required></input>			
					<input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm password" required></input>
					<span class="errMessage" id="errPassword"></span>
					<input type="text" name="fname" placeholder="First Name" required></input>
					<input type="text" name="lname" placeholder="Last Name"></input>
					<input type="text" name="adress" placeholder="Address"></input>
					<input type="text" name="pincode" placeholder="Pincode"></input>
					<input type="text" name="age" placeholder="Age"></input>		
					<input type="submit" id="formSubmit" value="Sign Up"></input>							
				 </form>				 
		 	</div>
		 	 <h3 style=color:red>${message}</h3>
		</div>
	</body>
</html>