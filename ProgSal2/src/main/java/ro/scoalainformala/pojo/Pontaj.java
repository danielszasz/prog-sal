package ro.scoalainformala.pojo;

public class Pontaj {

	private int id;
	private int contractId;
	private int companyId;
	private int year;
	private int month;
	private int[] days = new int[31];
	private int workedHours;
	private int coDays;

	public Pontaj(int id, int contractId, int companyId, int year, int month, int[] days, int workedHours, int coDays) {
		super();
		this.id = id;
		this.contractId = contractId;
		this.companyId = companyId;
		this.year = year;
		this.month = month;
		this.days = days;
		this.workedHours = workedHours;
		this.coDays = coDays;
	}

	public Pontaj(int id, int contractId, int companyId, int year, int month) {
		super();
		this.id = id;
		this.contractId = contractId;
		this.companyId = companyId;
		this.year = year;
		this.month = month;

	}

	public Pontaj() {
		super();
	}

	public Pontaj(int contractId, int companyId, int year, int month, int[] days, int workedHours, int coDays) {
		this(0, contractId, companyId, year, month, days, workedHours, coDays);
	}

	public Pontaj(int contractId, int companyId, int year, int month) {
		this(0, contractId, companyId, year, month);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public int getCoDays() {
		return coDays;
	}

	public void setCoDays(int coDays) {
		this.coDays = coDays;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}
