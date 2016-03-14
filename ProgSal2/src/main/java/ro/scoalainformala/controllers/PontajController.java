package ro.scoalainformala.controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.scoalainformala.dao.ContractDAO;
import ro.scoalainformala.dao.EmployeeDAO;
import ro.scoalainformala.dao.PontajDAO;
import ro.scoalainformala.helper.ActiveUserHelper;
import ro.scoalainformala.pojo.Company;
import ro.scoalainformala.pojo.Contract;
import ro.scoalainformala.pojo.Employee;
import ro.scoalainformala.pojo.Pontaj;

@Controller
@RequestMapping(value = "/pontaj")
public class PontajController {

	@RequestMapping(value = "/generate")
	public void generatePontaj(ModelMap model, HttpServletResponse response, Principal principal) throws IOException {

		Company company = ActiveUserHelper.getActiveCompany(principal);
		try {
			List<Contract> contractList = ContractDAO.getContracts(company.getId(), company.getCurrentYear(),
					company.getCurrentMonth());
			List<Pontaj> pontajList = PontajDAO.getPontajList(company.getId(), company.getCurrentYear(),
					company.getCurrentMonth());
			for (Contract contract : contractList) {
				boolean isGenerated = false;
				for (Pontaj pontaj : pontajList) {
					if (contract.getId() == pontaj.getContractId()) {
						isGenerated = true;
					}
				}
				if (!isGenerated) {
					PontajDAO.createPontajEmpty(contract.getId(), contract.getCompanyId(), company.getCurrentYear(),
							company.getCurrentMonth());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("../pontaj/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView addPontaj(ModelMap model, Principal principal) {

		Company company = ActiveUserHelper.getActiveCompany(principal);

		try {
			List<Contract> contractList = ContractDAO.getContracts(company.getId(), company.getCurrentYear(),
					company.getCurrentMonth());
			List<Employee> employeeList = EmployeeDAO.getEmployeesWithContract(company.getId(), contractList);
			List<Pontaj> pontajList = PontajDAO.getPontajList(company.getId(), company.getCurrentYear(),
					company.getCurrentMonth());
			model.putAll(ActiveUserHelper.showUserCompany(principal));
			model.put("contractList", contractList);
			model.put("employeeList", employeeList);
			model.put("pontajList", pontajList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/pontaj/pontajlist", "model", model);

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView addPontajx(ModelMap model, Principal principal) {
		
		Company company = ActiveUserHelper.getActiveCompany(principal);
		Pontaj pontaj=new Pontaj();
		try {
			List<Contract> contractList = ContractDAO.getContracts(company.getId(), company.getCurrentYear(),
					company.getCurrentMonth());
			List<Employee> employeeList = EmployeeDAO.getEmployeesWithContract(company.getId(), contractList);
			List<Pontaj> pontajList = PontajDAO.getPontajList(company.getId(), company.getCurrentYear(),
					company.getCurrentMonth());
			model.putAll(ActiveUserHelper.showUserCompany(principal));
			model.put("contractList", contractList);
			model.put("employeeList", employeeList);
			model.put("pontajList", pontajList);
			model.put("pontaj", pontaj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/pontaj/pontajedit", "model", model);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void editPontaj(@ModelAttribute("pontaj")Pontaj pontaj,HttpServletResponse response, Principal principal) throws IOException {
		Pontaj pontajObj=new Pontaj();
		try {
			/*pontajObj = PontajDAO.get(employee.getId());
			pontajObj.setFirstName(employee.getFirstName());
			pontajObj.setLastName(employee.getLastName());
			pontajObj.setCnp(employee.getCnp());
			pontajObj.setAddress(employee.getAddress());*/
			pontajObj.setDays(pontaj.getDays());
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("../employee/list");	

		}
}
