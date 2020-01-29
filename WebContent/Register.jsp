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
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src=signUpValidations></script>
<script type="text/javascript">
$(function () {
        $("#formSubmit").click(function () {
            var password = $("#password").val();
            var confirmPassword = $("#confirmpassword").val();
            if (password != confirmPassword) {
                $("#errPassword").text("Password/Confirm Password are not same");
                return false;
            }
            else{
            	$("#errPassword").hide();
            }
            return true;
        });
    });
    
    
$(function() {
	$.validator.addMethod('strongPassword',function(value,element){
		return this.optional(element)
		||value.length>=8 && /\d/.test(value) && /[a-z]/i.test(value);
	},'Password must consists of 8 characters long and contain atleast one upper case and one number')
	
	$.validator.addMethod('userId',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && /[a-zA-Z]/i.test(value);
	},'Username should consists of Alphabets and numbers')
	
	$.validator.addMethod('age',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && (value.length>=0 && value.length<=3);
	},'age should be less than 3 digits')
	
	$.validator.addMethod('ageGreater',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && (value.length>=0 && value.length<=3);
	},'age shuold be greater than zero' )
	
	$.validator.addMethod('firstname',function(value,element){
		return this.option(element)
		|| /[a-zA-Z ]/i.test(value) && value.length<=25;		
	},'firstname should consists of Alphabets and less than 25 characters long')
	
	$.validator.addMethod('pincode',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && (value.length>=0 && value.length<=10);
	},'pincode should be less than than 10 digits')
	
	$.validator.addMethod('pincodeNonnegative',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && (value<0);
	},'pincode should be non negative')
	
	$("#Register-form").validate({
		rules:{
			username:{
				required:true,
				userId:true
			},
			email:{
				required:true,
				email:true          
			},
			password:{
				required:true,	
				strongPassword:true
			},
			confirmpassword:{
				required:true,
				equalTo:"#password"
			},
			fname:{
				required:true,
				firstname:true
			},	
			age:{
				required:false,
				age:true,
				ageGreater:true
			}
			
		},
		messages:{
			username:{
				required:'Please enter UserId'
			},
			email:{
				required:'Please enter an email adress',
				email: 'Please enter an email adress'
			},
			password:{
				required:'Please enter password'
			},
			confirmpassword:{
				required:'Please enter confirm password'
			},
			fname:{
				required:'Please enter firstname'
			}
		}
		
	});	
});
</script>
</head>
	<body>
	    <div id="login-box">
		  <div class="left">
		    <h1>Sign up</h1>
				 <form action="Register" id="Register-form" method="post">
					<input type="text" id="username" name="username" placeholder="Username"></input>			
					<input type="email" id="email" name="email" placeholder="E-mail"></input>		
					<input type="password" id="password" name="password" placeholder="Password"></input>			
					<input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm password"></input>
					<span class="errMessage" id="errPassword"></span>
					<input type="text" id="fname" name="fname" placeholder="First Name"></input>
					<input type="text" name="lname" placeholder="Last Name"></input>
					<input type="text" name="adress" placeholder="Address"></input>
					<input type="text" id="pincode" name="pincode" placeholder="Pincode"></input>
					<input type="text" name="age" placeholder="Age"></input>		
					<input type="submit" id="formSubmit" value="Sign Up"></input>							
				 </form>				 
		 	</div>
		</div>
		<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src=signUpValidations></script>
	</body>
</html>