package ro.scoalainformala.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	public static Connection openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "dani");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/program_salarizare", connectionProps);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
