package ro.scoalainformala.pojo;

public class UserRoles {
		
	private int id;
	private String username;
	private String role;
	
	
	
	public UserRoles(String username, String role) {
		this(0,username,role);
	}
	public UserRoles(int id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
