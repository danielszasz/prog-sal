package ro.scoalainformala.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.scoalainformala.helper.DBHelper;
import ro.scoalainformala.pojo.Contract;
import ro.scoalainformala.pojo.Employee;

public class EmployeeDAO {

	public static void createEmployee(Employee employee) throws SQLException {
		final String sql = "INSERT INTO employee (first_name, last_name, cnp, address,child_care,company_id) VALUES(?,?,?,?,?,?);";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, employee.getFirstName());
		pstmt.setString(2, employee.getLastName());
		pstmt.setLong(3, employee.getCnp());
		pstmt.setString(4, employee.getAddress());
		pstmt.setInt(5, employee.getChildCare());
		pstmt.setInt(6, employee.getCompanyId());
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createEmployee(int id, String firstName, String lastName, long cnp, String address,
			int childCare, int companyId) throws SQLException {
		Employee employee = new Employee(id, firstName, lastName, cnp, address, childCare, companyId);
		EmployeeDAO.createEmployee(employee);

	}

	public static void deleteEmployee(int id) throws SQLException {
		final String sql = "DELETE FROM employee WHERE id=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);

	}

	public static void deleteEmployee(Employee employee) throws SQLException {
		EmployeeDAO.deleteEmployee(employee.getId());
	}

	public static void updateEmployee(int id, String firstName, String lastName, long cnp, String address,
			int childCare) throws SQLException {
		final String sql = "UPDATE employee SET first_name=?, last_name=?, cnp=?, address=?, child_care=? WHERE id=?;";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setLong(3, cnp);
		pstmt.setString(4, address);
		pstmt.setInt(5, childCare);
		pstmt.setInt(6, id);
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void updateEmployee(Employee employee) throws SQLException {
		EmployeeDAO.updateEmployee(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getCnp(),
				employee.getAddress(), employee.getChildCare());
	}

	public static Employee getEmployee(int id) throws SQLException {
		final String sql = "SELECT * FROM employee WHERE id=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Employee employee = new Employee();

		if (rs.next()) {
			employee.setId(rs.getInt("id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setCnp(rs.getLong("cnp"));
			employee.setAddress(rs.getString("address"));
			employee.setChildCare(rs.getInt("child_care"));
		}
		DBHelper.closeConnection(conn);
		return employee;
	}

	public static ArrayList<Employee> getEmployees(int companyId) throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		final String sql = "SELECT * FROM employee WHERE company_id=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, companyId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Employee employee = new Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getLong("cnp"), rs.getString("address"), rs.getInt("child_care"), rs.getInt("company_id"));
			employeeList.add(employee);
		}
		DBHelper.closeConnection(conn);
		return employeeList;

	}

	public static ArrayList<Employee> getEmployeesWithContract(int companyId, List<Contract> activeContracts) throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		final String sql = "SELECT * FROM employee WHERE company_id=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, companyId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			for (Contract contract : activeContracts) {
				if (contract.getEmployeeId() == rs.getInt("id")) {
					Employee employee = new Employee(rs.getInt("id"), rs.getString("first_name"),
							rs.getString("last_name"), rs.getLong("cnp"), rs.getString("address"),
							rs.getInt("child_care"), rs.getInt("company_id"));
					employeeList.add(employee);
				}
			}
		}
		DBHelper.closeConnection(conn);
		return employeeList;

	}

}
