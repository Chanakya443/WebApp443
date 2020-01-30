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
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		System.out.println("method is "+method);
		if(method.equals("UserNameExists"))			
		{
			UserNameExists(request,response);
		}
		else if(method.equals("UserEmailExists"))
		{
			UserEmailExists(request,response);
		}
		else if(method.equals("doPost")){
		String message="";
		try
		{
			int id=RegisterDAO.LastId()+1;
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String confirmpassword=request.getParameter("confirmpassword");
			if(!password.equals(confirmpassword))
			{
				message="Password/Confirm Password details not same";
				request.setAttribute("message", message);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else
		    {
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String adress=request.getParameter("adress");
			String pincode=request.getParameter("pcode");
			int age=Integer.parseInt(request.getParameter("age"));
			boolean res=RegisterDAO.ValidUser(username,email);			
			if(res)
			{
				int row=RegisterDAO.InsertRegistrationDetails(id,username, email, password, confirmpassword, fname, lname, adress, pincode, age);
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
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	  }
	}
	protected void UserNameExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		System.out.println("hitting this method");
		try
		{
			String username=request.getParameter("username");
			boolean res=RegisterDAO.ValidUserId(username);			
			if(res)
			{
				response.setContentType("type/html");
				PrintWriter out=response.getWriter();
				out.print("UserAlready Exists");
				System.out.println("UserAlready Exists");
			}
			else
			{
				response.setContentType("type/html");
				PrintWriter out=response.getWriter();
				out.print("");
				System.out.println("Not UserAlready Exists");
			
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	protected void UserEmailExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		System.out.println("hitting this method");
		try
		{
			String email=request.getParameter("email");
			boolean res=RegisterDAO.ValidEmailId(email);			
			if(res)
			{
				response.setContentType("type/html");
				PrintWriter out=response.getWriter();
				out.print("UserEmail Exists");
				System.out.println("UserEmail Exists");
			}
			else
			{
				response.setContentType("type/html");
				PrintWriter out=response.getWriter();
				out.print("");			
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
