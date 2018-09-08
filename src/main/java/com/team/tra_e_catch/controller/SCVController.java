package com.team.tra_e_catch.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SCVController {
	
	private static final Logger logger = Logger.getLogger(SCVController.class);

		@RequestMapping(value = "/scv/login", method = RequestMethod.POST)
	public String login(Model mod) {
		logger.info("login");
		return "home";
	}
	
	
	@RequestMapping(value = "/scv/view/login", method = RequestMethod.GET)
	public String viewLogin(Model mod) {
		logger.info("viewLogin");
		return "scv/login";
	}
	
	@RequestMapping(value = "/scv/view/join", method = RequestMethod.GET)
	public String viewJoin(Model mod) {
		logger.info("viewJoin");
		return "scv/join";
	}
	
	@RequestMapping(value = "/scv/logout", method = RequestMethod.GET)
	public String logout(Model mod) {
		logger.info("logout");
		return "home";
	}
	@RequestMapping(value = "/scv/modify", method = RequestMethod.POST)
	public String modify(Model mod) {
		logger.info("modify");
		return "scv/modify";
	}
	@RequestMapping(value = "/scv/view/modify", method = RequestMethod.GET)
	public String viewModify(Model mod) {
		logger.info("viewModify");
		return "scv/modify";
	}
	
	
}
