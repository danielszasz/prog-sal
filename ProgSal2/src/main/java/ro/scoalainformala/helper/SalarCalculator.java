package ro.scoalainformala.helper;

import java.sql.SQLException;

import ro.scoalainformala.dao.ContractDAO;
import ro.scoalainformala.dao.EmployeeDAO;
import ro.scoalainformala.dao.SalSettingsDAO;
import ro.scoalainformala.pojo.Contract;
import ro.scoalainformala.pojo.Employee;
import ro.scoalainformala.pojo.SalSettings;
import ro.scoalainformala.pojo.Users;

public class SalarCalculator {

	public static int calcSalar(int contractId, Users user) {
		int childCare, dedPers, salarBrut, salarImp, impSalar, salarNet;
		Employee employee = new Employee();
		Contract contract = new Contract();
		SalSettings contributii = new SalSettings();
		SalSettings contributiiP = new SalSettings();

		// Deducere personala

		try {
			contract = ContractDAO.getContract(contractId);
			employee = EmployeeDAO.getEmployee(contract.getEmployeeId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		childCare = employee.getChildCare();

		if (contract.getCumulType().equals("cumul")) {
			dedPers = 0;
		} else {
			switch (childCare) {
			case 0:
				dedPers = 300;
				break;
			case 1:
				dedPers = 400;
				break;
			case 2:
				dedPers = 500;
				break;
			case 3:
				dedPers = 600;
				break;
			case 4:
				dedPers = 800;
				break;
			default:
				dedPers = 800;
			}
		}

		// Contributii

		try {
			contributii = SalSettingsDAO.getSettings(user.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salarBrut = contract.getSalary();
		contributiiP.setCasAng((contributii.getCasAng() * salarBrut) / 100);
		contributiiP.setCasAsig((contributii.getCasAsig() * salarBrut) / 100);
		contributiiP.setCassAng((contributii.getCasAsig() * salarBrut) / 100);
		contributiiP.setCassAsig((contributii.getCassAsig() * salarBrut) / 100);
		contributiiP.setConcBoala((contributii.getConcBoala() * salarBrut) / 100);
		contributiiP.setFondAcc((contributii.getFondAcc() * salarBrut) / 100);
		contributiiP.setFondGar((contributii.getFondGar() * salarBrut) / 100);
		contributiiP.setSomAng((contributii.getSomAng() * salarBrut) / 100);
		contributiiP.setSomAsig((contributii.getSomAsig() * salarBrut) / 100);

		// salar impozabil
		salarImp = contract.getSalary() - Math.round(contributiiP.getCasAsig()) - Math.round(contributiiP.getCassAsig())
				- Math.round(contributiiP.getSomAsig()) - dedPers;

		// impozit salar

		impSalar = Math.round((salarImp * 16) / 100);

		// salar net

		salarNet = salarImp - impSalar;
		return salarNet;

	}
}