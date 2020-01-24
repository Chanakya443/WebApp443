package Model;

public class Registration {
	private int id;
	private String username;
	private String email;
	private String password;
	private String confirmpassword;
	private String fname;
	private String lname;
	private String adress;
	private String pincode;
	private int age;
	public Registration() {
		super();
	}	
	public Registration(int id, String username, String email, String password, String confirmpassword, String fname,
			String lname, String adress, String pincode, int age) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.fname = fname;
		this.lname = lname;
		this.adress = adress;
		this.pincode = pincode;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getAdress() {
		return adress;
	}
	public String getPincode() {
		return pincode;
	}
	public int getAge() {
		return age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setAge(int age) {
		this.age = age;
	}	

}
