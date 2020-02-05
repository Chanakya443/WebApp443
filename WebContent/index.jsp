<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
  body {
        background-color: #F3EBF6;
        font-family: 'Ubuntu', sans-serif;
    }    
    .main {
        background-color: #FFFFFF;
        width: 400px;
        height: 400px;
        margin: 7em auto;
        border-radius: 1.5em;
        box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
    }    
    .sign {
        padding-top: 40px;
        color: #8C55AA;
        font-family: 'Ubuntu', sans-serif;
        font-weight: bold;
        font-size: 23px;
    }    
    .un {
    width: 76%;
    color: rgb(38, 50, 56);
    font-weight: 700;
    font-size: 14px;
    letter-spacing: 1px;
    background: rgba(136, 126, 126, 0.04);
    padding: 10px 20px;
    border: none;
    border-radius: 20px;
    outline: none;
    box-sizing: border-box;
    border: 2px solid rgba(0, 0, 0, 0.02);
    margin-bottom: 50px;
    margin-left: 46px;
    text-align: center;
    margin-bottom: 27px;
    font-family: 'Ubuntu', sans-serif;
    }    
    form.form1 {
        padding-top: 40px;
    }    
    .pass {
    width: 76%;
    color: rgb(38, 50, 56);
    font-weight: 700;
    font-size: 14px;
    letter-spacing: 1px;
    background: rgba(136, 126, 126, 0.04);
    padding: 10px 20px;
    border: none;
    border-radius: 20px;
    outline: none;
    box-sizing: border-box;
    border: 2px solid rgba(0, 0, 0, 0.02);
    margin-bottom: 50px;
    margin-left: 46px;
    text-align: center;
    margin-bottom: 27px;
    font-family: 'Ubuntu', sans-serif;
    }     
    .un:focus, .pass:focus {
        border: 2px solid rgba(0, 0, 0, 0.18) !important;
        
    }    
      .submit {
        cursor: pointer;
        border-radius: 5em;
        color: #fff;
        background: linear-gradient(to right, #9C27B0, #E040FB);
        border: 0;
        padding-left: 40px;
        padding-right: 40px;
        padding-bottom: 10px;
        padding-top: 10px;
        font-family: 'Ubuntu', sans-serif;
        margin-left: 35%;
        font-size: 13px;
        box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
    }
     .submitt {
        cursor: pointer;
        border-radius: 5em;
        color: #fff;
        background: linear-gradient(to right, #9C27B0, #E040FB);
        border: 0;
        padding-left: 40px;
        padding-right: 40px;
        padding-bottom: 10px;
        padding-top: 10px;
        font-family: 'Ubuntu', sans-serif;
        margin-left: 26%;
        font-size: 13px;
        box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
    }    
    .forgot {
        text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
        color: #E1BEE7;
        padding-top: 15px;
    }    
    a {
        text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
        color: #E1BEE7;
        text-decoration: none
    }    
    @media (max-width: 600px) {
        .main {
            border-radius: 0px;
        }
  </style>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src=signUpValidations></script>
<script type="text/javascript"></script>
<script>
$(function() {
	$.validator.addMethod('userId',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && /[a-zA-Z]/i.test(value) &&/^\w+$/i.test(value) ||/[a-zA-Z0-9+_.-@]/i.test(value);
	},'<br><span style="color:red">Alphabets,Under scores,numbers and email Id are accepted</span>')
    
	$.validator.addMethod('strongPassword',function(value,element){
		return this.optional(element)
		||value.length>=8 && /\d/.test(value) && /[a-z]/i.test(value)&&/[A-Z]/i.test(value) && /([!,%,&,@,#,$,^,*,?,_,~])/i.test(value);
	},'<br><span style="color:red">Hint: min: 8 characters long,one Capital letter and Special Character are mandatory</span>')  
    
	
	$("#login-form").validate({
		rules:{
			username:{
				required:true,
				userId:true
			},		
			password:{
				required:true,	
				strongPassword:true
			},
		},
		messages:{
			username:{
				required:'<br><span style="color:red;margin-left:35%;padding-top:10px;" align="center">Please enter UserId</span>'
			},
			password:{
				required:'<br><span style="color:red;margin-left:35%;"align="center">Please enter password</span>'
			},
		}		
	});	
});
$(document).ready(function(){
	  $("#username").click(function(){
	    $("#errMessage").hide();
	  });
	  $("#password").click(function(){
		    $("#errMessage").hide();
		  });
	   
		$("#submit").click(function(){
		    $("#errMessage").hide();
		  });
});
</script>
</head>
 <body> 
  <div class="main">
     	  <p class="sign" align="center">Sign in</p>
	      <form id="login-form" action="Login" method="post">
	      <input class="un" type="text" id="username" name="username" align="center" placeholder="Username" required>
	      <input class="pass" type="password" id="password" name="password" align="center" placeholder="Password" required>
	      <input class="submit" id="submit" type="submit" value="Sign In" align="center"></input>     
	    </form>
	    <br> <br>
	     <a class="submitt" align="center" href="Register.jsp">New User? Sign Up</a>    
		 <span id="errMessage">${message}</span>
  </div>		
 </body>
</html>