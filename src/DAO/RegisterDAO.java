package DAO;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterDAO {
	public static Properties prop = new Properties();
	public static Connection con;
	public static String driverClass=null;
	public static String url=null;
	public static String dbuser=null;
	public static String dbpassword=null;
	public static Properties getDbProperties() throws IOException
	{
		try {
			InputStream input = new FileInputStream("C:\\Users\\cvs44\\eclipse-workspace\\WebApp01\\src\\Configurations\\config.properties");
	    	prop.load(input);	    	
	    	input.close();
		  }
		  catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
	    return prop;
	}
	static 
	{
		try
		{
			getDbProperties();
		    driverClass=prop.getProperty("driverClass");
		    url=prop.getProperty("url");
		    dbuser=prop.getProperty("dbuser");
		    dbpassword=prop.getProperty("dbpassword");
		    Class.forName(driverClass);	
		    con=DriverManager.getConnection(url,dbuser,dbpassword);
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
	public static boolean ValidUserId(String username)
	{
		boolean res=false;
		String query="select * from Client_Registration_Details where username in (?)";
		try
		{
			PreparedStatement cs=con.prepareStatement(query);
			cs.setString(1, username);
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
	public static boolean ValidEmailId(String email)
	{
		boolean res=false;
		String query="select * from Client_Registration_Details where email in (?)";
		try
		{
			PreparedStatement cs=con.prepareStatement(query);
			cs.setString(1, email);
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
	public static boolean LoginAuth(String username,String password)
	{	
		boolean res=false;
		String query="select * from client_registration_details where (username in (?) or email in (?)) and password = aes_encrypt(?,'key')";
		try
		{
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
		String query="insert into Client_Registration_Details values(?,?,aes_encrypt(?,'key'),aes_encrypt(?,'key'),?,?,?,?,?,?)";
		try{
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
