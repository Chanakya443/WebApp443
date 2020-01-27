package DAO;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterDAO {
	static 
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}	 
	public static int LastId()
	{
		int k=0;
		String query="select * from Client_Registration_Details order by Id desc";
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			PreparedStatement ps=con.prepareStatement(query);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    k=rs.getInt(1);
		    }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return k;
	}
	public static boolean ValidUser(String username,String email)
	{
		boolean res=true;
		String query="select * from Client_Registration_Details where username in (?) or email in (?) ";
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			PreparedStatement cs=con.prepareStatement(query);
			cs.setString(1, username);
			cs.setString(2, email);
			ResultSet rs=cs.executeQuery();
			if(rs.next())
			{
				res=false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return res;
	}
	public static boolean LoginAuth(String username,String password)
	{	
		boolean res=false;
		String query="select * from client_registration_details where (username in (?) or email in (?)) and password in (?)";
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			PreparedStatement cs=con.prepareStatement(query);
			cs.setString(1,username);
			cs.setString(2,username);
			cs.setString(3,password);
			ResultSet rs=cs.executeQuery();
			if(rs.next())
			{
				res=true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return res;
	}
	public static int InsertRegistrationDetails(int id,String username, String email, String password, String confirmpassword, String fname,
			String lname, String adress, String pincode, int age)
		{
		int i=0;
		String query="insert into Client_Registration_Details values(?,?,?,?,?,?,?,?,?,?)";
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			PreparedStatement cs=con.prepareStatement(query);
			cs.setInt(1,id);
			cs.setString(2,username);			
			cs.setString(3,password );
			cs.setString(4,confirmpassword);
			cs.setString(5,fname);
			cs.setString(6,lname);
			cs.setString(7,adress);
			cs.setString(8,pincode);
			cs.setInt(9,age);
			cs.setString(10,email);
			i=cs.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return i;
	}

}
