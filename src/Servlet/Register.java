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
				
		PrintWriter out = response.getWriter();		
		String message="";
		try
		{
			int id=RegisterDAO.LastId()+1;
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String confirmpassword=request.getParameter("confirmpassword");
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String adress=request.getParameter("adress");
			String pincode=request.getParameter("pincode");
			int age=Integer.parseInt(request.getParameter("age"));
			int row=RegisterDAO.InsertRegistrationDetails(id,username, email, password, confirmpassword, fname, lname, adress, pincode, age);
			out.println(row);
			if(row>0)
			{
				message="Signup successfull";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else
			{
				message="Signup Failed..!!!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
