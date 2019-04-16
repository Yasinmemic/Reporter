package com.reporter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reporter.entity.Users;
import com.reporter.service.UserService;

@Controller
public class UserController {
 
	@Autowired
	UserService userService;

	
	
	@RequestMapping("/login.html")
	public ModelAndView login()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addUser", "user", new Users());
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("user") Users user) {
		
		userService.insertUser(user);
		List<Users> users = userService.getAllUsers();
		ModelAndView model = new ModelAndView("getUsers");
		model.addObject("users", users);
		return model;
	}

	@RequestMapping("/getUsers")
	public ModelAndView getEmployees() {
		List<Users> users = userService.getAllUsers();
		ModelAndView model = new ModelAndView("getUsers");
		model.addObject("users", users);
		return model;
	}

}
