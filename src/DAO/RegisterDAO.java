package DAO;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import Logger.LoggerProperties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import Logger.LoggerProperties;

public class RegisterDAO {
	public static Properties prop = new Properties();
	public static Connection con;
	public static String driverClass=null;
	public static String url=null;
	public static String dbuser=null;
	public static String dbpassword=null;
	public static LoggerProperties log;
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
		    log=new LoggerProperties();
		}
		catch(Exception ex)
		{
			log.logger.info(ex.getMessage());
		}
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
			log.logger.info(e.getMessage());
		}
		return res;
	}
	public static boolean ChkUserIdExists(String username)
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
			log.logger.info(e.getMessage());
		}
		return res;
	}
	public static boolean ChkEmailExists(String email)
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
			log.logger.info(e.getMessage());
		}
		return res;
	}
	public static boolean LoginAuthentication(String username,String password)
	{	
		boolean res=false;
		String userId="";
		String query="";
		if(username.matches("[A-Za-z0-9!,%,&,@,#,$,^,*,?,_,~]+[@][a-zA-Z0-9.-]+"))
		{
			userId=username;
			query="select * from client_registration_details where (email in (?)) and password = aes_encrypt(?,'key')";
		}
		else
		{
			userId=username;
		    query="select * from client_registration_details where (username in (?)) and password = aes_encrypt(?,'key')";
		}
		try
		{
			PreparedStatement cs=con.prepareStatement(query);
			cs.setString(1,userId);
			cs.setString(2,password);
			ResultSet rs=cs.executeQuery();
			if(rs.next())
			{
				res=true;
			}
		}
		catch(Exception e)
		{
			log.logger.info(e.getMessage());
		}
		return res;
	}
	public static int InsertRegistrationDetails(String username, String email, String password, String fname,
			String lname, String adress, String pincode, String age)
		{
		int i=0;
		String query="insert into Client_Registration_Details values(?,aes_encrypt(?,'key'),?,?,?,?,?,?)";
		try{
			PreparedStatement cs=con.prepareStatement(query);
			cs.setString(1,username);			
			cs.setString(2,password );
			cs.setString(3,fname);
			cs.setString(4,lname);
			cs.setString(5,adress);
			cs.setString(6,pincode);			
			cs.setString(7,email);
			cs.setString(8,age);
			i=cs.executeUpdate();		
		}
		catch(Exception e)
		{
			log.logger.info(e.getMessage());
		}
		return i;
	}

}
