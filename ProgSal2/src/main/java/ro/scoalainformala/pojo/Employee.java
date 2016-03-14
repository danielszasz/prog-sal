package ro.scoalainformala.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private long cnp;
	private String address;
	private int childCare;
	private int companyId;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, long cnp, String address, int childCare, int companyId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cnp = cnp;
		this.address = address;
		this.childCare = childCare;
		this.companyId = companyId;
	}

	public Employee(String firstName, String lastName, long cnp, String address, int childCare, int companyId) {
		this(0, firstName, lastName, cnp, address, childCare, companyId);

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getCnp() {
		return cnp;
	}

	public void setCnp(long cnp) {
		this.cnp = cnp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getChildCare() {
		return childCare;
	}

	public void setChildCare(int childCare) {
		this.childCare = childCare;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
