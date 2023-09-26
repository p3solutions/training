package JavaCode;

public class Users {
	private int User_Id;
    private String UserName;
    private String FirstName;
    private String LastName;
    private String Email;
    private String role;
    private String Password;
	public Users(int user_Id, String userName, String firstName, String lastName, String email, String role,
			String password) {
		super();
		User_Id = user_Id;
		UserName = userName;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		this.role = role;
		Password = password;
	}
	public Users(String userName, String firstName, String lastName, String email, String role, String password) {
		super();
		UserName = userName;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		this.role = role;
		Password = password;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}


}
