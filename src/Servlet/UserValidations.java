package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logger.LoggerProperties;


import DAO.RegisterDAO;

/**
 * Servlet implementation class UserValidations
 */
@WebServlet("/UserValidations")
public class UserValidations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoggerProperties log=new LoggerProperties();
       
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
					log.logger.info(e.getMessage());
				}
				
		  }
	protected void UserNameExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		try
		{
			String username=request.getParameter("username");
			boolean res=RegisterDAO.ChkUserIdExists(username);			
			if(res)
			{
				response.setContentType("type/html");
				PrintWriter out=response.getWriter();
				out.print(username+" already available");
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
			log.logger.info(e.getMessage());
		}
	}
	protected void UserEmailExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		try
		{
			String email=request.getParameter("email");
			boolean res=RegisterDAO.ChkEmailExists(email);			
			if(res)
			{
				response.setContentType("type/html");
				PrintWriter out=response.getWriter();
				out.print(email+" already exists");
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
			log.logger.info(e.getMessage());
		}
	}
	  
	}


