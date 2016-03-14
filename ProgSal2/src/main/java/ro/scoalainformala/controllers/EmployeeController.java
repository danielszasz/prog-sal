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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.scoalainformala.dao.EmployeeDAO;
import ro.scoalainformala.helper.ActiveUserHelper;
import ro.scoalainformala.pojo.Company;
import ro.scoalainformala.pojo.Employee;

@RequestMapping(value = "employee")
@Controller
public class EmployeeController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView displayEmployeeList(ModelMap model, Principal principal) {
		Company company = ActiveUserHelper.getActiveCompany(principal);
		List<Employee> employeeList;
		try {
			int id = company.getId();
			employeeList = EmployeeDAO.getEmployees(id);
			model = ActiveUserHelper.showUserCompany(principal);
			model.put("employeeList", employeeList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/employee/employeelist", "model", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployeeForm(@ModelAttribute("employeeForm") Employee employee, ModelMap model,
			BindingResult result, Principal principal) throws SQLException {

		model = ActiveUserHelper.showUserCompany(principal);
		return new ModelAndView("/employee/employeeadd", "model", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addEmployee(@ModelAttribute("employeeForm") Employee employee, ModelMap model, BindingResult result,
			Principal principal, HttpServletResponse response) throws IOException {
		Company company = ActiveUserHelper.getActiveCompany(principal);
		Employee employeeObj = new Employee();
		try {
			employeeObj.setFirstName(employee.getFirstName());
			employeeObj.setLastName(employee.getLastName());
			employeeObj.setCnp(employee.getCnp());
			employeeObj.setAddress(employee.getAddress());
			employeeObj.setChildCare(employee.getChildCare());
			employeeObj.setCompanyId(company.getId());
			EmployeeDAO.createEmployee(employeeObj);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployeeForm(@RequestParam("employeeid") String employeeId, ModelMap model,
			Principal principal) {

		model.putAll(ActiveUserHelper.showUserCompany(principal));
		try {
			Employee employee = EmployeeDAO.getEmployee(Integer.parseInt(employeeId));
			model.put("employeeForm", employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/employee/employeeedit", "model", model);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void editCompany(@ModelAttribute("employeeForm") Employee employee, BindingResult result,
			HttpServletResponse response, Principal principal) throws IOException {
		Employee employeeObj;
		try {
			employeeObj = EmployeeDAO.getEmployee(employee.getId());
			employeeObj.setFirstName(employee.getFirstName());
			employeeObj.setLastName(employee.getLastName());
			employeeObj.setCnp(employee.getCnp());
			employeeObj.setAddress(employee.getAddress());
			employeeObj.setChildCare(employee.getChildCare());
			EmployeeDAO.updateEmployee(employeeObj);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("../employee/list");
	}

}
