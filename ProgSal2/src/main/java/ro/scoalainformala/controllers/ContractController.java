package ro.scoalainformala.controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.scoalainformala.dao.ContractDAO;
import ro.scoalainformala.dao.EmployeeDAO;
import ro.scoalainformala.helper.ActiveUserHelper;
import ro.scoalainformala.pojo.Company;
import ro.scoalainformala.pojo.Contract;
import ro.scoalainformala.pojo.Employee;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addContract(ModelMap model, Principal principal) {

		Company company = ActiveUserHelper.getActiveCompany(principal);
		model.putAll(ActiveUserHelper.showUserCompany(principal));
		try {
			ArrayList<Employee> employeeList = EmployeeDAO.getEmployees(company.getId());
			model.put("employeeList", employeeList);
			model.put("crtYear", company.getCurrentYear());
			model.put("crtMonth", company.getCurrentMonth());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.put("contractForm", new Contract());

		return new ModelAndView("/contract/contractadd", "model", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addContract(@ModelAttribute("contractForm") Contract contract, BindingResult result, ModelMap model,
			Principal principal, HttpServletResponse response) throws IOException {
		
		Company company = ActiveUserHelper.getActiveCompany(principal);
		Contract contractObj = new Contract();
		contractObj.setEmployeeId(contract.getEmployeeId());
		contractObj.setCompanyId(company.getId());
		contractObj.setNoContract(contract.getNoContract());
		contractObj.setTypeContr(contract.getTypeContr());
		contractObj.setDateContr(contract.getDateContr());
		contractObj.setBeginContr(contract.getBeginContr());
		contractObj.setEndContr(contract.getEndContr());
		contractObj.setCumulType(contract.getCumulType());
		contractObj.setSalaryType(contract.getSalaryType());
		contractObj.setSalary(contract.getSalary());
		contractObj.setCo(contract.getCo());
	
		try {
			ContractDAO.createContract(contractObj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("../company/main");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView displayContractList(ModelMap model, Principal principal) {
		Company company = ActiveUserHelper.getActiveCompany(principal);
		
		List<Contract> contractList;
		List<Employee> employeeList;
		try {
			contractList = ContractDAO.getContracts(company.getId(),company.getCurrentYear(),company.getCurrentMonth());
		
			employeeList= EmployeeDAO.getEmployeesWithContract(company.getId(), contractList);
			model = ActiveUserHelper.showUserCompany(principal);
			model.put("contractList", contractList);
			model.put("employeeList", employeeList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/contract/contractlist", "model", model);
	}
	
	
	
}
