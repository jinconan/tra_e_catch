package com.team.tra_e_catch.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfController {
	
	private static final Logger logger = Logger.getLogger(ConfController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("로그인 페이지");
		return "conf/login";
	}
	
	@RequestMapping(value = "/pay/Teamsal", method = RequestMethod.GET)
	public String Teamsal(Locale locale, Model model) {
		logger.info("검색 페이지");
		return "pay/deciconf/Teamsal";
	}
	
}
