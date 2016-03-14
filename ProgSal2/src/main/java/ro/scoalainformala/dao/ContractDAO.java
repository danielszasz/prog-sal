package ro.scoalainformala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.LocalDate;

import ro.scoalainformala.helper.DBHelper;
import ro.scoalainformala.pojo.Contract;

public class ContractDAO {

	public static void createContract(Contract contract) throws SQLException {
		final String sql = "INSERT INTO contract(employee_id,company_id,no,type,date,begin_date,end_date,cumul,salary_type,salary,co) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, contract.getEmployeeId());
		pstmt.setInt(2, contract.getCompanyId());
		pstmt.setInt(3, contract.getNoContract());
		pstmt.setString(4, contract.getTypeContr());
		pstmt.setString(5, contract.getDateContr());
		pstmt.setString(6, contract.getBeginContr());
		pstmt.setString(7, contract.getEndContr());
		pstmt.setString(8, contract.getCumulType());
		pstmt.setString(9, contract.getSalaryType());
		pstmt.setInt(10, contract.getSalary());
		pstmt.setInt(11, contract.getCo());
		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void createConctract(int id, int employeeId, int companyId, int noContract, String typeContr,
			String dateContr, String beginContr, String endContr, String cumulType, String salaryType, int salary,
			int co) throws SQLException {

		Contract contract = new Contract(id, employeeId, companyId, noContract, typeContr, dateContr, beginContr,
				endContr, cumulType, salaryType, salary, co);
		ContractDAO.createContract(contract);
	}

	public static void updateContract(int id, String typeContr, String endContr, String cumulType, String salaryType,
			int salary, int co) throws SQLException {
		final String sql = "UPDATE contract SET type=?,end_date=?,cumul=?,salary_type=?,salary=?,co=?  WHERE id=?;";
		Connection conn = DBHelper.openConnection();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, typeContr);
		pstmt.setString(2, endContr.toString());
		pstmt.setString(3, cumulType);
		pstmt.setString(4, salaryType);
		pstmt.setInt(5, salary);
		pstmt.setInt(6, co);
		pstmt.setInt(7, id);

		pstmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void updateContract(Contract contract) throws SQLException {
		ContractDAO.updateContract(contract.getId(), contract.getTypeContr(), contract.getEndContr(),
				contract.getCumulType(), contract.getSalaryType(), contract.getSalary(), contract.getCo());
	}

	public static Contract getContract(int id) throws SQLException {
		final String sql = "SELECT * FROM contract WHERE id=?;";
		Connection conn = DBHelper.openConnection();
		Contract contract = new Contract();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			contract.setId(rs.getInt("id"));
			contract.setEmployeeId(rs.getInt("employee_id"));
			contract.setCompanyId(rs.getInt("company_id"));
			contract.setNoContract(rs.getInt("no"));
			contract.setTypeContr(rs.getString("type"));
			contract.setDateContr(rs.getString("date"));
			contract.setBeginContr(rs.getString("begin_date"));
			contract.setEndContr(rs.getString("end_date"));
			contract.setCumulType(rs.getString("cumul"));
			contract.setSalaryType(rs.getString("salary_type"));
			contract.setSalary(rs.getInt("salary"));
			contract.setCo(rs.getInt("co"));

		}
		DBHelper.closeConnection(conn);
		return contract;
	}

	public static ArrayList<Contract> getContracts(int companyId, int crtYear, int crtMonth) throws SQLException {
		ArrayList<Contract> contractList = new ArrayList<Contract>();
		final String sql = "SELECT * FROM contract WHERE company_id=?;";
		Connection conn = DBHelper.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, companyId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			LocalDate beginDate = new LocalDate(rs.getString("begin_date"));
			LocalDate endDate;
			if (rs.getString("end_date").isEmpty()) {

				endDate = new LocalDate("9999-12-31");
			} else {
				endDate = new LocalDate(rs.getString("end_date"));

			}
			if (beginDate.getYear() <= crtYear && beginDate.getMonthOfYear() <= crtMonth && endDate.getYear() >= crtYear
					&& endDate.getMonthOfYear() >= crtMonth) {
				Contract contract = new Contract(rs.getInt("id"), rs.getInt("employee_id"), rs.getInt("company_id"),
						rs.getInt("no"), rs.getString("type"), rs.getString("date"), rs.getString("begin_date"),
						rs.getString("end_date"), rs.getString("cumul"), rs.getString("salary_type"),
						rs.getInt("salary"), rs.getInt("co"));

				contractList.add(contract);
			}
		}
		DBHelper.closeConnection(conn);
		return contractList;

	}
}
