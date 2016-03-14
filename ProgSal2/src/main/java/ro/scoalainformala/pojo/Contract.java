package ro.scoalainformala.pojo;

public class Contract {

	private int id;
	private int employeeId;
	private int companyId;
	private int noContract;
	private String typeContr;
	private String dateContr;
	private String beginContr;
	private String endContr;
	private String cumulType;
	private String salaryType;
	private int salary;
	private int co;

	public Contract(int id, int employeeId, int companyId, int noContract, String typeContr, String dateContr,
			String beginContr, String endContr, String cumulType, String salaryType, int salary, int co) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.companyId = companyId;
		this.noContract = noContract;
		this.typeContr = typeContr;
		this.dateContr = dateContr;
		this.beginContr = beginContr;
		this.endContr = endContr;
		this.cumulType = cumulType;
		this.salaryType = salaryType;
		this.salary = salary;
		this.co = co;
	}

	public Contract() {
		super();
	}

	public Contract(int employeeId, int companyId, int noContract, String typeContr, String dateContr,
			String beginContr, String endContr, String cumulType, String salaryType, int salary, int co) {
		this(0, employeeId, companyId, noContract, typeContr, dateContr, beginContr, endContr, cumulType, salaryType,
				salary, co);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoContract() {
		return noContract;
	}

	public void setNoContract(int noContract) {
		this.noContract = noContract;
	}

	public String getTypeContr() {
		return typeContr;
	}

	public void setTypeContr(String typeContr) {
		this.typeContr = typeContr;
	}

	public String getDateContr() {
		return dateContr;
	}

	public void setDateContr(String dateContr) {
		this.dateContr = dateContr;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getBeginContr() {
		return beginContr;
	}

	public void setBeginContr(String beginContr) {
		this.beginContr = beginContr;
	}

	public String getEndContr() {
		return endContr;
	}

	public void setEndContr(String endContr) {
		this.endContr = endContr;
	}

	public String getCumulType() {
		return cumulType;
	}

	public void setCumulType(String cumulType) {
		this.cumulType = cumulType;
	}

	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCo() {
		return co;
	}

	public void setCo(int co) {
		this.co = co;
	}

}
