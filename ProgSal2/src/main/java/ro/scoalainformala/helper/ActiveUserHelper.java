package ro.scoalainformala.helper;

import java.security.Principal;
import java.sql.SQLException;

import org.springframework.ui.ModelMap;

import ro.scoalainformala.dao.CompanyDAO;
import ro.scoalainformala.dao.UsersDAO;
import ro.scoalainformala.pojo.Company;
import ro.scoalainformala.pojo.Users;

public class ActiveUserHelper {
	public static Users getActiveUser(Principal principal) {
		Users user = new Users();
		try {
			user = UsersDAO.getUser(principal.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public static Company getActiveCompany(Principal principal) {
		Users user = new Users();
		Company company = new Company();
		try {
			user = getActiveUser(principal);
			company = CompanyDAO.getCompany(user.getCompanyId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return company;
	}

	public static ModelMap showUserCompany(Principal principal) {
		ModelMap model = new ModelMap();
		Users user;
		Company company;

		user = getActiveUser(principal);
		company = getActiveCompany(principal);

		model.put("userName", user.getName());
		model.put("companyName", company.getName());
		model.put("year", company.getCurrentYear());
		model.put("month", company.getCurrentMonth());
		return model;
	}
}
