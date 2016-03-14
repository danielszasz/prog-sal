package ro.scoalainformala.controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.scoalainformala.dao.CompanyDAO;
import ro.scoalainformala.dao.SalSettingsDAO;
import ro.scoalainformala.dao.UsersDAO;
import ro.scoalainformala.helper.ActiveUserHelper;
import ro.scoalainformala.pojo.Company;
import ro.scoalainformala.pojo.SalSettings;
import ro.scoalainformala.pojo.Users;

@RequestMapping(value = "/company")
@Controller
public class CompanyController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView showMainMenu(ModelMap model, Principal principal) {

		model = ActiveUserHelper.showUserCompany(principal);

		return new ModelAndView("./mainmenu", "model", model);
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public ModelAndView displayCompanyList(@ModelAttribute("companySelect") Company company, ModelMap model,
			BindingResult result, Principal principal) {

		List<Company> companyList;

		try {
			Users user = ActiveUserHelper.getActiveUser(principal);

			companyList = CompanyDAO.getCompany(user.getUsername());
			model = ActiveUserHelper.showUserCompany(principal);
			model.put("companyList", companyList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/company/companyselect", "model", model);
	}

	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public void selectCompany(@ModelAttribute("companySelect") Company company, ModelMap model, BindingResult result,
			Principal principal, HttpServletResponse response) throws IOException {

		Users user = ActiveUserHelper.getActiveUser(principal);
		Company companyObj = new Company();
		try {
			companyObj.setId(company.getId());
			UsersDAO.addCurrentCompany(user, companyObj);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("selectM");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addCompany(ModelMap model, Principal principal) throws SQLException {

		model = ActiveUserHelper.showUserCompany(principal);
		return new ModelAndView("/company/companyadd", "model", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addCompany(@ModelAttribute("companyForm") Company company, ModelMap model, BindingResult result,
			Principal principal, HttpServletResponse response) throws IOException {
		Users user = ActiveUserHelper.getActiveUser(principal);
		Company companyObj = new Company();
		try {
			companyObj.setName(company.getName());
			companyObj.setCui(company.getCui());
			companyObj.setAddress(company.getAddress());
			companyObj.setAdminName(company.getAdminName());
			companyObj.setUserId(principal.getName());
			CompanyDAO.createCompany(companyObj);
			if (user.getCompanyId() == 0) {
				response.sendRedirect("../company/select");
			} else {
				response.sendRedirect("../company/main");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCompany(ModelMap model, Principal principal) {

		model.putAll(ActiveUserHelper.showUserCompany(principal));
		Company company = ActiveUserHelper.getActiveCompany(principal);
		model.put("companyForm", company);

		return new ModelAndView("/company/companyedit", "model", model);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void editCompany(@ModelAttribute("companyForm") Company company, BindingResult result,
			HttpServletResponse response, Principal principal) throws IOException {
		Company companyObj;
		try {
			companyObj = ActiveUserHelper.getActiveCompany(principal);
			companyObj.setName(company.getName());
			companyObj.setAddress(company.getAddress());
			companyObj.setCui(company.getCui());
			companyObj.setAdminName(company.getAdminName());
			CompanyDAO.updateCompany(companyObj);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("main");
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView displayCompany(ModelMap model, Principal principal) throws SQLException {

		Company company;
		model = ActiveUserHelper.showUserCompany(principal);

		{
			company = ActiveUserHelper.getActiveCompany(principal);
			model.put("company", company);
		}
		return new ModelAndView("/company/companydetail", "model", model);
	}

	@RequestMapping(value = "/selectM", method = RequestMethod.GET)
	public ModelAndView displayYearMonth(@ModelAttribute("yearMonth") Company company, ModelMap model,
			BindingResult result, Principal principal) {

		model = ActiveUserHelper.showUserCompany(principal);

		return new ModelAndView("/company/monthselect", "model", model);
	}

	@RequestMapping(value = "/selectM", method = RequestMethod.POST)
	public void selectYearMonth(@ModelAttribute("yearMonth") Company company, ModelMap model, BindingResult result,
			Principal principal, HttpServletResponse response) throws IOException {

		Company companyObj = ActiveUserHelper.getActiveCompany(principal);
		try {
			companyObj.setCurrentYear(company.getCurrentYear());
			companyObj.setCurrentMonth(company.getCurrentMonth());
			CompanyDAO.updateCompany(companyObj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("main");
	}

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView editSettings(ModelMap model, Principal principal) throws SQLException {
		String username;
		model.putAll(ActiveUserHelper.showUserCompany(principal));
		username = principal.getName();
		SalSettings settings = SalSettingsDAO.getSettings(username);
		model.put("settingsForm", settings);

		return new ModelAndView("/company/salsettings", "model", model);

	}

	@RequestMapping(value = "/settingsSave", method = RequestMethod.POST)
	public void editSettings(@ModelAttribute("settingsForm") SalSettings settings, BindingResult result,
			HttpServletResponse response, Principal principal) throws IOException {

		String username = principal.getName();
		SalSettings settingsObj;
		try {
			settingsObj = SalSettingsDAO.getSettings(username);
			settingsObj.setMinSal(settings.getMinSal());
			settingsObj.setMinSalEcon(settings.getMinSalEcon());
			settingsObj.setAverageHour(settings.getAverageHour());
			settingsObj.setCasAng(settings.getCasAng());
			settingsObj.setCasAsig(settings.getCasAsig());
			settingsObj.setFondAcc(settings.getFondAcc());
			settingsObj.setCassAng(settings.getCassAng());
			settingsObj.setCassAsig(settings.getCassAsig());
			settingsObj.setConcBoala(settings.getConcBoala());
			settingsObj.setSomAng(settings.getSomAng());
			settingsObj.setSomAsig(settings.getSomAsig());
			settingsObj.setFondGar(settings.getFondGar());
			SalSettingsDAO.updateSettings(settingsObj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("main");
	}

}
