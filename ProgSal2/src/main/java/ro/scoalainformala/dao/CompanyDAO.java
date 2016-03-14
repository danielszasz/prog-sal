package ro.scoalainformala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.scoalainformala.helper.DBHelper;
import ro.scoalainformala.pojo.Company;

public class CompanyDAO {

	public static void createCompany(Company company) throws SQLException {
		final String sql = "INSERT INTO company(name,cui,address,administrator,employee_nr,user_id) VALUES (?,?,?,?,?,?);";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, company.getName());
		pstmt.setString(2, company.getCui());
		pstmt.setString(3, company.getAddress());
		pstmt.setString(4, company.getAdminName());
		pstmt.setInt(5, company.getEmployeeNr());
		pstmt.setString(6, company.getUserId());
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createCompany(int id, String name, String cui, String address, String adminName, int employeeNr,
			String userId) throws SQLException {

		Company company = new Company(id, name, cui, address, adminName, employeeNr, userId);
		CompanyDAO.createCompany(company);
	}

	public static void updateCompany(int id, String name, String cui, String address, String adminName, int employeeNr,
			String userId, int currentYear, int currentMonth) throws SQLException {
		final String sql = "UPDATE company SET name=?, cui=?, address=?, administrator=?, employee_nr=?, user_id=?, current_year=?, current_month=?  WHERE id=?;";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, cui);
		pstmt.setString(3, address);
		pstmt.setString(4, adminName);
		pstmt.setInt(5, employeeNr);
		pstmt.setString(6, userId);
		pstmt.setInt(7, currentYear);
		pstmt.setInt(8, currentMonth);
		pstmt.setInt(9, id);

		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void updateCompany(Company company) throws SQLException {
		CompanyDAO.updateCompany(company.getId(), company.getName(), company.getCui(), company.getAddress(),
				company.getAdminName(), company.getEmployeeNr(), company.getUserId(), company.getCurrentYear(),
				company.getCurrentMonth());
	}

	public static Company getCompany(int id) throws SQLException {
		final String sql = "SELECT * FROM company WHERE id=?;";
		Connection conn = DBHelper.openConnection();
		Company company = new Company();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			company.setId(rs.getInt("id"));
			company.setName(rs.getString("name"));
			company.setCui(rs.getString("cui"));
			company.setAddress(rs.getString("address"));
			company.setAdminName(rs.getString("administrator"));
			company.setEmployeeNr(rs.getInt("employee_nr"));
			company.setUserId(rs.getString("user_id"));
			company.setCurrentYear(rs.getInt("current_year"));
			company.setCurrentMonth(rs.getInt("current_month"));
		}
		DBHelper.closeConnection(conn);
		return company;
	}

	public static Company getCompanyUsername(String username) throws SQLException {
		final String sql = "SELECT * FROM company WHERE user_id=?;";
		Connection conn = DBHelper.openConnection();
		Company company = new Company();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			company.setId(rs.getInt("id"));
			company.setName(rs.getString("name"));
			company.setCui(rs.getString("cui"));
			company.setAddress(rs.getString("address"));
			company.setAdminName(rs.getString("administrator"));
			company.setEmployeeNr(rs.getInt("employee_nr"));
			company.setUserId(rs.getString("user_id"));
		}
		DBHelper.closeConnection(conn);
		return company;
	}

	public static ArrayList<Company> getCompany(String username) throws SQLException {
		ArrayList<Company> companyList = new ArrayList<Company>();
		final String sql = "SELECT * FROM company WHERE user_id=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Company company = new Company(rs.getInt("id"), rs.getString("name"), rs.getString("cui"),
					rs.getString("address"), rs.getString("administrator"), rs.getInt("employee_nr"),
					rs.getString("user_id"));
			companyList.add(company);
		}
		DBHelper.closeConnection(conn);
		return companyList;

	}

}