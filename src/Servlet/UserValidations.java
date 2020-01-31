package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;

/**
 * Servlet implementation class UserValidations
 */
@WebServlet("/UserValidations")
public class UserValidations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidations() {
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
				try
				{
					if(method.equals("UserNameExists"))			
					{
						UserNameExists(request,response);
					}
					else if(method.equals("UserEmailExists"))
					{
						UserEmailExists(request,response);
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
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


