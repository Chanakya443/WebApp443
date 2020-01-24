package DAO;
import Dao.CallableStatement;
import Dao.Connection;
import Dao.Exception;
import Dao.String;
import Model.Registration;

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
		int id=0;
		String query="select id from Client_Registration_Details order by id desc limit 1";
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			java.sql.CallableStatement cs=con.prepareCall(query);
			id=cs.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return id;
	}
	public static int InsertRegistrationDetails(int id,String username, String email, String password, String confirmpassword, String fname,
			String lname, String adress, String pincode, int age)
		{
		int i=0;
		String query="insert into Client_Registration_Details values(?,?,?,?,?,?,?,?,?,?)";
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","root");
			java.sql.CallableStatement cs=con.prepareCall(query);
			cs.setInt(1,id);
			cs.setString(2,username);
			cs.setString(3,email);
			cs.setString(4,password );
			cs.setString(5,confirmpassword);
			cs.setString(6,fname);
			cs.setString(7,lname);
			cs.setString(8,adress);
			cs.setString(9,pincode);
			cs.setInt(10,age);
			i=cs.executeUpdate();				
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return i;
	}

}
