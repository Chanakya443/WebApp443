<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
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
  height: 930px;
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
    font-size:15px;
    color:#ff0000;
    font-family:'red';
    display:inline;
}
}
</style>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places&key=AIzaSyBbFeageXicyf0z5L1BhE1v4LLv-W3Aooc"></script>
<script type="text/javascript">  
//$(document).ready(function () {
$(function() {
    $.validator.addMethod('userId',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && /[a-zA-Z]/i.test(value) &&/^\w+$/i.test(value);
	},'<span style="color:red">Accepted Alphabets,Under scores and numbers</span>')
    
	 $.validator.addMethod('strongPassword',function(value,element){
     return this.optional(element)||value.length>=8 && /^[A-Za-z0-9!,%,&,@,#,$,^,*,?,_,~]+$/i.test(value);
     },'<span style="color:red">Password must be 8 characters long and contain atleast one upper case, one lower case,one special Character(!,%,&,@,#,$,^,*,?,_,~) and one number</span>')    
    
    $.validator.addMethod('firstname',function(value,element){
		return this.optional(element)
		||/^[a-z ]+$/i.test(value) && value.length<=25;
	},'<span style="color:red">Accepted Alphabets and less than 25 characters long</span>')
    
    $.validator.addMethod('lastname',function(value,element){
		return this.optional(element)
		||/^[a-z]+$/i.test( value )&& value.length<=10;
	},'<span style="color:red">Accepted Alphabets and not more than 10 characters long</span>') 
    
    $.validator.addMethod('age',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && (value>=0 && value<=100);	
	},'<span style="color:red">Please enter valid age</span>')
		
    $.validator.addMethod('pincode',function(value,element){
		return this.optional(element)
		||/\d/.test(value) && (value>=0 && value.length<=10);
	},'<span style="color:red">Please enter valid pincode ex:600096</span>')  
	
	$.validator.addMethod('Address',function(value,element){
         return this.optional(element)||/^[A-Za-z0-9"#$'*,-.;_` ]+$/i.test(value);
     },'<span style="color:red">Please enter valid address</span>')  
	
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
				age:true
			},
            pcode:{
                pincode:true
            },
            lname:{
                lastname:true
            },
            adress:{
            	Address:true
            }			
		},
		messages:{
			username:{
				required:'<span style="color:red">Please enter UserId</span>'
			},
			email:{
				required:'<span style="color:red">Please enter an email adress</span>',
				email:'<span style="color:red">Please enter an email adress</span>'
			},
			password:{
				required:'<span style="color:red">Please enter password</span>'
			},
			confirmpassword:{
				required:'<span style="color:red">Please enter confirm password</span>',
				equalTo :'<span style="color:red">Password/Confirm Password are not same</span>'               
			},
			fname:{
				required:'<span style="color:red">Please enter firstname</span>'
			}
		}
		
	});	
});
var searchInput = 'adress';
$(document).ready(function () {
	$("#backendErrorMessage").hide();
	$('#username').change(function(){
		console.log("inside username validation function")
		var username=$('#username').val();
		console.log("searching for username "+username);
		$.ajax({
			type:'POST',
			data:{username:username},
			url:'UserValidations?method=UserNameExists',
			success:function(data){
				$('#usererr').html(data);	
			}			
		})		
	});   
	
	$('#email').change(function(){
		var email=$('#email').val();
		$.ajax({
			type:'POST',
			data:{email:email},
			url:'UserValidations?method=UserEmailExists',
			success:function(data){
				$('#userIderr').html(data);
			}			
		})		
	});
	
	//validations
	//$(document).on('change', '#'+searchInput, function () {
		$('#'+searchInput).keydown(function(){
	});
	 var autocomplete;
    autocomplete = new google.maps.places.Autocomplete((document.getElementById(searchInput)), {
        types: ['geocode'],
    });	
     google.maps.event.addListener(autocomplete,'place_changed',function () {
        var near_place = autocomplete.getPlace();
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
					<span class="errMessage" id="usererr"></span>		
					<input type="email" id="email" name="email" placeholder="E-mail"></input>
					<span class="errMessage" id="userIderr"></span>		
					<input type="password" id="password" name="password" placeholder="Password"></input>			
					<input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm password"></input>
					<span class="errMessage" id="errPassword"></span>
					<input type="text" id="fname" name="fname" placeholder="First Name"></input>
					<input type="text" id="lname" name="lname" placeholder="Last Name"></input>
					<input type="text" name="adress" id="adress" placeholder="Address"></input>
					<input type="text" id="pcode" name="pcode" placeholder="Pincode"></input>
					<input type="text" name="age" placeholder="Age"></input>		
					<input type="submit" id="formSubmit" value="Sign Up"></input>							
				 </form>		
				 	${message}	 
		 	</div>
		</div>		
	</body>
</html>