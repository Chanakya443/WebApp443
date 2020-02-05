package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.RegisterDAO;
import Logger.LoggerProperties;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Registration register;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoggerProperties log=new LoggerProperties();
		String validInput="";
		String errorMessage="";
		String message="";
		try
		{
			String username=request.getParameter("username");	
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String confirmpassword=request.getParameter("confirmpassword");
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String adress=request.getParameter("adress");
			String pincode=request.getParameter("pcode");
			String age=request.getParameter("age");
			if(!username.matches("[A-Za-z0-9_]+"))
			{
				errorMessage+="UserId ";
			}
		   if(!email.matches("[A-Za-z0-9!,%,&,@,#,$,^,*,_,~]+[@][a-zA-Z0-9.-]+"))
			{
				errorMessage+="email ";
			}
		   if(!password.matches("[A-Za-z0-9!,%,&,@,#,$,^,*,?,_,~]+") || password.length()<=8 || password.length()>=25 )
			{
				errorMessage+="password ";
			}
		   if(!password.equals(confirmpassword))
			{
				errorMessage+="Password/Confirm Password are not same";
			}
		   if(!fname.matches("[A-Za-z ]+") || fname.length()>=25)
			{
				errorMessage+="First Name ";
			}
		   if(!lname.matches("[A-Za-z]*") || lname.length()>=25)
			{
				errorMessage+="Last Name ";
			}
		    if(!age.matches("[0-9]{0,2}|100")) 
		    {  
		     errorMessage+="age "; 		   
		    }			 
		   if(!pincode.matches("[0-9A-Za-z]*") || pincode.length()>=25)
			{
				errorMessage+="pincode ";
			}
		   if(!adress.matches("[A-Za-z0-9\"#$'*,-.;_` ]*") )
			{
				errorMessage+="address ";
			}
		   if(!errorMessage.isEmpty())
		   {
			    message="<h3 align=\"center\" style=color:red>"+"Please enter Valid "+errorMessage+"</h3>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
		   }
			boolean res=RegisterDAO.ValidUser(username,email);			
			if(res && errorMessage.isEmpty())
			{
				int row=RegisterDAO.InsertRegistrationDetails(username.trim(), email.trim(), password.trim(), confirmpassword.trim(), fname.trim(), lname.trim(), adress.trim(), pincode.trim(), age.trim());
				if(row>0)
				{
					message="<h3 align=\"center\" style=color:green>"+"Signup successfull"+"</h3>";
					request.setAttribute("message", message);
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				}
				else
				{
					message="<h3 align=\"center\" style=color:red>"+"Signup Failed..!!!"+"</h3>";
					request.setAttribute("message", message);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else
			{
				message="<h3 align=\"center\" style=color:red>"+"User Already Exists..!!!"+"</h3>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}			
		
		}
		catch(Exception e)
		{
			log.logger.info(e.getMessage());
		}
		
	  }
	
	
}
