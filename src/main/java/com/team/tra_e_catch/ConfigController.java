package com.team.tra_e_catch;

import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/conf")
public class ConfigController {
	
	private static final Logger logger = Logger.getLogger(ConfigController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> pMap) {
		logger.info("login");
		return "home";
	}
	@RequestMapping(value = "/view/login", method = RequestMethod.GET)
	public String viewLogin(@RequestParam Map<String, Object> pMap) {
		logger.info("viewLogin");
		return "conf/login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@RequestParam Map<String, Object> pMap) {
		logger.info("logout");
		return "home";
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@RequestParam Map<String, Object> pMap) {
		logger.info("modify");
		return "conf/modify";
	}
	@RequestMapping(value = "/view/modify", method = RequestMethod.POST)
	public String viewModify(@RequestParam Map<String, Object> pMap) {
		logger.info("viewModify");
		return "home";
	}
	
	
}
