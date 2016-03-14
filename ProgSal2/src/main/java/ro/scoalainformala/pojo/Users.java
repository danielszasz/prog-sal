package ro.scoalainformala.pojo;

public class Users {
	private String username;
	private String password;
	private int companyId;
	private String name;
	private String address;
	private String email;
	private String phone;

	public Users() {
		super();
	}

	public Users(String username, String password, String name, String address, String email, String phone) {
				super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	/*public Users(String username, String password, String name, String address, String email, String phone) {
		this(0, username, password, name, address, email, phone);
	}*/

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
