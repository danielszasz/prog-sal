package ro.scoalainformala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ro.scoalainformala.helper.DBHelper;
import ro.scoalainformala.pojo.Company;
import ro.scoalainformala.pojo.Users;

public class UsersDAO {

	public static void createUser(Users user) throws SQLException {
		final String sql = "INSERT INTO users (username,password,name,address,email,phone) VALUES (?,?,?,?,?,?);";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getAddress());
		pstmt.setString(5, user.getEmail());
		pstmt.setString(6, user.getPhone());
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createUser(String username, String password, String name, String address, String email,
			String phone) throws SQLException {
		Users user = new Users(username, password, name, address, email, phone);
		UsersDAO.createUser(user);
	}

	public static void updateUser(String username, String password, String name, String address, String email,
			String phone) throws SQLException {
		final String sql = "UPDATE users SET password=?, name=?, address=?, email=?, phone=? WHERE username=?;";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, name);
		pstmt.setString(3, address);
		pstmt.setString(4, email);
		pstmt.setString(5, phone);
		pstmt.setString(6, username);
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void updateUser(Users user) throws SQLException {
		UsersDAO.updateUser(user.getUsername(), user.getPassword(), user.getName(), user.getAddress(), user.getEmail(),
				user.getPhone());
	}

	public static Users getUser(String username) throws SQLException {
		final String sql = "SELECT * FROM users WHERE username=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		Users user = new Users();

		if (rs.next()) {

			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setCompanyId(rs.getInt("company_id"));
			user.setAddress(rs.getString("address"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
		}
		DBHelper.closeConnection(conn);
		return user;
	}

	public static void addCurrentCompany(String username, int companyId) throws SQLException {
		final String sql = "UPDATE users SET company_id=? WHERE username=?;";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, companyId);
		pstmt.setString(2, username);
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void addCurrentCompany(Users user, Company company) throws SQLException {
		UsersDAO.addCurrentCompany(user.getUsername(), company.getId());
	}

}