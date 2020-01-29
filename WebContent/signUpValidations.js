$(function() {
	$.validator.addMethod('strongPassword',function(value,element){
		return this.optional(element)
		||value.length>=8 && /\d/.test(value) && /[a-z]/i.test(value);
	},'Password must consists of 8 characters long and contain atleast one upper case and one number')
	$("#Register-form").validate({
		rules:{
			username:{
				required:true
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
				required:true
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