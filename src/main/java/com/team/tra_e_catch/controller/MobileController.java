package com.team.tra_e_catch.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobile")
public class MobileController {
	Logger logger= Logger.getLogger(MobileController.class);
	
	@RequestMapping("/")
	private String home(Model model) {
		return "mobile/home";
	}
	
	@RequestMapping("/scv/view/login")
	private String viewLogin(Model model) {
		logger.info("모바일 로그인 페이지");
		return "mobile/login";
	}
	
	
}
