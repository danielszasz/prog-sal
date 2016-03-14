package ro.scoalainformala.pojo;

public class Company {

	private int id;
	private String name;
	private String cui;
	private String address;
	private String adminName;
	private int employeeNr;
	private String userId;
	private int currentYear;
	private int currentMonth;

	public Company() {
		super();
	}

	public Company(int id, String name, String cui, String address, String adminName, int employeeNr, String userId) {
		super();
		this.id = id;
		this.name = name;
		this.cui = cui;
		this.address = address;
		this.adminName = adminName;
		this.employeeNr = employeeNr;
		this.userId = userId;
	}

	public Company(String name, String cui, String address, String adminName, String userId) {
		this(0, name, cui, address, adminName, 0, userId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCui() {
		return cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getEmployeeNr() {
		return employeeNr;
	}

	public void setEmployeeNr(int employeeNr) {
		this.employeeNr = employeeNr;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}
}