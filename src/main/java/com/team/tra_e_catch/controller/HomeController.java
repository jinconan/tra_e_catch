package com.team.tra_e_catch.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value= {"emp_id"})
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		if(model.containsAttribute("emp_id")) {
			return "home";
		}
		else {
			return "/scv/login";
		}
	}
	
}
