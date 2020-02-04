package Servlet;

import javax.servlet.http.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*; 
import Logger.LoggerProperties;

import DAO.RegisterDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String message="";
		LoggerProperties log=new LoggerProperties();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try
		{
		boolean res=RegisterDAO.LoginAuthentication(username,password);
		if(res)
			{
				message="<h3 align=\"center\" style=color:green>"+"Login successfull"+"</h3>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		else
			{
				message="<h3 align=\"center\" style=color:red>"+"Invalid Username/Passord"+"</h3>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}catch(Exception e) {
			log.logger.info(e.getMessage());;
		}
		
	}
	
}
