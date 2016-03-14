package ro.scoalainformala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ro.scoalainformala.helper.DBHelper;
import ro.scoalainformala.pojo.SalSettings;

public class SalSettingsDAO {
	public static void createSettings(SalSettings salSettings) throws SQLException {
		final String sql = "INSERT INTO salary_settings (user_id) VALUES (?);";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, salSettings.getUserId());

		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createSettings(String userId) throws SQLException {
		SalSettings salSettings = new SalSettings(userId);
		SalSettingsDAO.createSettings(salSettings);
	}

	public static void updateSettings(int id, String userId, int minSal, int minSalEcon, float averageHour,
			int impSalar, float casAng, float casAsig, float fondAcc, float cassAng, float cassAsig, float concBoala,
			float somAng, float somAsig, float fondGar) throws SQLException {
		final String sql = "UPDATE salary_settings SET user_id=?, min_sal=?, min_sal_econ=?, average_hour=?, imp_salar=?, cas_ang=?, cas_asig=?, fond_accid=?, cass_ang=?, cass_asig=?, conc_boala=?,som_ang=?, som_asig=?, fond_gar=? WHERE id=?;";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setInt(2, minSal);
		pstmt.setInt(3, minSalEcon);
		pstmt.setFloat(4, averageHour);
		pstmt.setInt(5, impSalar);
		pstmt.setFloat(6, casAng);
		pstmt.setFloat(7, casAsig);
		pstmt.setFloat(8, fondAcc);
		pstmt.setFloat(9, cassAng);
		pstmt.setFloat(10, cassAsig);
		pstmt.setFloat(11, concBoala);
		pstmt.setFloat(12, somAng);
		pstmt.setFloat(13, somAsig);
		pstmt.setFloat(14, fondGar);
		pstmt.setInt(15, id);
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void updateSettings(SalSettings settings) throws SQLException {
		SalSettingsDAO.updateSettings(settings.getId(), settings.getUserId(), settings.getMinSal(),
				settings.getMinSalEcon(), settings.getAverageHour(), settings.getImpSalar(), settings.getCasAng(),
				settings.getCasAsig(), settings.getFondAcc(), settings.getCassAng(), settings.getCassAsig(),
				settings.getConcBoala(), settings.getSomAng(), settings.getSomAsig(), settings.getFondGar());
	}

	public static SalSettings getSettings(String userId) throws SQLException {
		final String sql = "SELECT * FROM salary_settings WHERE user_id=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		SalSettings settings = new SalSettings();

		if (rs.next()) {

			settings.setId(rs.getInt("id"));
			settings.setMinSal(rs.getInt("min_sal"));
			settings.setMinSalEcon(rs.getInt("min_sal_econ"));
			settings.setAverageHour(rs.getFloat("average_hour"));
			settings.setCasAng(rs.getFloat("cas_ang"));
			settings.setCasAsig(rs.getFloat("cas_asig"));
			settings.setFondAcc(rs.getFloat("fond_accid"));
			settings.setCassAng(rs.getFloat("cass_ang"));
			settings.setCassAsig(rs.getFloat("cass_asig"));
			settings.setConcBoala(rs.getFloat("conc_boala"));
			settings.setSomAng(rs.getFloat("som_ang"));
			settings.setSomAsig(rs.getFloat("som_asig"));
			settings.setFondGar(rs.getFloat("fond_gar"));
		}
		DBHelper.closeConnection(conn);
		return settings;
	}

}
