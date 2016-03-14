package ro.scoalainformala.controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.scoalainformala.dao.SalSettingsDAO;
import ro.scoalainformala.dao.UserRoleDAO;
import ro.scoalainformala.dao.UsersDAO;
import ro.scoalainformala.helper.ActiveUserHelper;
import ro.scoalainformala.pojo.Users;

@RequestMapping(value = "/user")
@Controller
public class UserController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public ModelAndView addUserForm(ModelMap model) {
		Users user= new Users();
		model.put("userForm", user);
		return new ModelAndView("/user/useradd", "model", model);

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userForm") Users user, ModelMap model, BindingResult result) {

		Users userObj = new Users();
		try {
			userObj.setUsername(user.getUsername());
			userObj.setPassword(user.getPassword());
			userObj.setName(user.getName());
			userObj.setAddress(user.getAddress());
			userObj.setEmail(user.getEmail());
			userObj.setPhone(user.getPhone());
			UsersDAO.createUser(userObj);
			UserRoleDAO.createUserRole(user.getUsername(), "ROLE_USER");
			SalSettingsDAO.createSettings(user.getUsername());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("userLogin", new Users());
		return new ModelAndView("/user/login", "model", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUserForm(ModelMap model, Principal principal) {
		Users user;
		model.putAll(ActiveUserHelper.showUserCompany(principal));
		user = ActiveUserHelper.getActiveUser(principal);
		model.put("userForm", user);

		return new ModelAndView("/user/useredit", "model", model);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void editUser(@ModelAttribute("userForm") Users user, BindingResult result, HttpServletResponse response,
			Principal principal) throws IOException {
		Users userObj;
		try {
			userObj = ActiveUserHelper.getActiveUser(principal);
			userObj.setName(user.getName());
			userObj.setAddress(user.getAddress());
			userObj.setEmail(user.getEmail());
			userObj.setPhone(user.getPhone());
			UsersDAO.updateUser(userObj);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("../company/main");
	}

	@RequestMapping(value = "/passchange", method = RequestMethod.GET)
	public ModelAndView editPassForm(ModelMap model, Principal principal) {

		model.putAll(ActiveUserHelper.showUserCompany(principal));
		Users user = ActiveUserHelper.getActiveUser(principal);
		model.put("userForm", user);

		return new ModelAndView("/user/changepass", "model", model);

	}

	@RequestMapping(value = "/passchange", method = RequestMethod.POST)
	public void editPass(@ModelAttribute("userForm") Users user, BindingResult result, HttpServletResponse response,
			Principal principal) throws IOException {
		Users userObj;
		try {
			userObj = ActiveUserHelper.getActiveUser(principal);
			userObj.setPassword(user.getPassword());
			UsersDAO.updateUser(userObj);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("../company/main");
	}
}
