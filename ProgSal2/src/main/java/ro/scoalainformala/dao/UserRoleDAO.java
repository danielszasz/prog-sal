package ro.scoalainformala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ro.scoalainformala.helper.DBHelper;
import ro.scoalainformala.pojo.UserRoles;

public class UserRoleDAO {
	public static void createUserRole(UserRoles userRole) throws SQLException {
		final String sql = "INSERT INTO user_roles (username,role) VALUES (?,?);";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userRole.getUsername());
		pstmt.setString(2, userRole.getRole());
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createUserRole(String username, String role) throws SQLException {
		UserRoles userRole = new UserRoles(username, role);
		UserRoleDAO.createUserRole(userRole);
	}

}
