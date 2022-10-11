package myLibs;

public class RegistrationLibs {
	
	int ID;
	String Name;
	String Email;
	String Mobile;
	String Address;
	String Username;
	String Password;
	String Role;
	String Account;
	String CVC;
	
public RegistrationLibs() {
		
		this.ID = 0;
		this.Name = "";
		this.Email = "";
		this.Mobile = "";
		this.Address = "";
		this.Username = "";
		this.Password = "";
		this.Role = "";
		this.Account = "";
		this.CVC = "";
	}
	
	public RegistrationLibs(int iD, String name, String email, String mobile, String address, String username,
			String password, String role, String account, String cVC) {
		
		this.ID = iD;
		this.Name = name;
		this.Email = email;
		this.Mobile = mobile;
		this.Address = address;
		this.Username = username;
		this.Password = password;
		this.Role = role;
		this.Account = account;
		this.CVC = cVC;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getCVC() {
		return CVC;
	}

	public void setCVC(String cVC) {
		CVC = cVC;
	}

	@Override
	public String toString() {
		return "RegistrationLibs [ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", Mobile=" + Mobile
				+ ", Address=" + Address + ", Username=" + Username + ", Password=" + Password + ", Role=" + Role
				+ ", Account=" + Account + ", CVC=" + CVC + "]";
	}
	
	
	

}
