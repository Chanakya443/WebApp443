package DAO;
import java.util.*;
import java.sql.*;

public class RegisterDAO {
	static 
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");		
		System.out.println("Driver loaded");
		}
		catch(Exception ex)
		{
			System.out.println("Driver not loaded");
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
		    System.out.println(k);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	public static boolean ValidUser(String username,String email)
	{
		boolean res=false;
		String query="select * from Client_Registration_Details where username in (?) and email in (?)";
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			PreparedStatement cs=con.prepareStatement(query);
			ResultSet rs=cs.executeQuery();
			System.out.println(rs);
			if(rs.next())
			{
				res=false;
			}
			else
			{
				res=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
	public static boolean LoginAuth(String username,String email,String password)
	{
		boolean res=false;
		String query="select * from Client_Registration_Details";
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			PreparedStatement cs=con.prepareStatement(query);
			ResultSet rs=cs.executeQuery();
			while(rs.next())
			{
				if((rs.getString(2).equals(username) || rs.getString(10).equals(email)) && (rs.getString(3).equals(password)))
				{
					res=true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return i;
	}

}
