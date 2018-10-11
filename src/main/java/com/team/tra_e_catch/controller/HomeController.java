package com.team.tra_e_catch.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Device device) {
		logger.info("home");
		return "home";
	}
/*	
	@RequestMapping("/mobile")
	public String homeVerMobile(Model model) {
		logger.info("mobile home");
		return "mobile/home";
	}
	
	@RequestMapping("/mobile/view/login")
	public String viewLoginVerMobile(Model model) {
		logger.info("mobile home");
		return "mobile/login";
	}*/
}
