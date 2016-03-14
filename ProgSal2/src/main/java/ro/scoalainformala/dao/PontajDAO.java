package ro.scoalainformala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.scoalainformala.helper.DBHelper;
import ro.scoalainformala.pojo.Pontaj;

public class PontajDAO {

	public static void createPontaj(Pontaj pontaj) throws SQLException {
		final String sql = "INSERT INTO pontaj(contract_id,company_id,year,month,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,ore_lucrate,ore_co) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pontaj.getContractId());
		pstmt.setInt(2, pontaj.getYear());
		pstmt.setInt(3, pontaj.getMonth());
		pstmt.setInt(4, pontaj.getCompanyId());

		int[] days = pontaj.getDays();
		int count = 0;
		for (int i = 5; i <= 35; i++) {
			pstmt.setInt(i, days[count]);
			count++;
		}
		pstmt.setInt(36, pontaj.getWorkedHours());
		pstmt.setInt(37, pontaj.getCoDays());
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createPontaj(int id, int contractId, int companyId, int year, int month, int[] days,
			int workedHours, int coDays) throws SQLException {

		Pontaj pontaj = new Pontaj(id, contractId, companyId, year, month, days, workedHours, coDays);
		PontajDAO.createPontaj(pontaj);
	}

	public static void createPontajEmpty(Pontaj pontaj) throws SQLException {
		final String sql = "INSERT INTO pontaj(contract_id,company_id,year,month) VALUES (?,?,?,?);";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pontaj.getContractId());
		pstmt.setInt(2, pontaj.getCompanyId());
		pstmt.setInt(3, pontaj.getYear());
		pstmt.setInt(4, pontaj.getMonth());
		
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createPontajEmpty(int contractId,int companyId, int year, int month) throws SQLException {

		Pontaj pontaj = new Pontaj(contractId,companyId, year, month);
		PontajDAO.createPontajEmpty(pontaj);
	}
	
	
	public static ArrayList<Pontaj> getPontajList(int companyId, int crtYear, int crtMonth) throws SQLException {
		ArrayList<Pontaj> pontajList = new ArrayList<Pontaj>();
		final String sql = "SELECT * FROM pontaj WHERE company_id=? AND year=? AND month=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, companyId);
		pstmt.setInt(2, crtYear);
		pstmt.setInt(3, crtMonth);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int[] days = new int[31];
			int j = 6;
			for (int i = 0; i < 31; i++) {
				days[i] = rs.getInt(j);
				j++;
			}
			Pontaj pontaj = new Pontaj(rs.getInt("id"), rs.getInt("contract_id"), rs.getInt("company_id"),
					rs.getInt("year"), rs.getInt("month"), days, rs.getInt("ore_lucrate"), rs.getInt("ore_co"));
			pontajList.add(pontaj);
		}
		DBHelper.closeConnection(conn);
		return pontajList;

	}

}
