package myLibs;

public class LoginLibs {
	int ID;
	String Username;
	String Password;
	String Role;
	

	public LoginLibs() {

		this.ID = 0;
		this.Username = "";
		this.Password = "";
		this.Role = "";
	}

	public LoginLibs(int iD, String username, String password, String role) {

		this.ID = iD;
		this.Username = username;
		this.Password = password;
		this.Role = role;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "LoginLibs [ID=" + ID + ", Username=" + Username + ", Password=" + Password + ", Role=" + Role + "]";
	}

}
