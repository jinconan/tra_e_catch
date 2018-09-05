package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/acc")
public class AccountingController {
	
	private static final Logger logger = Logger.getLogger(AccountingController.class);

	@RequestMapping(value = "/sal", method = RequestMethod.GET)
	public String sal_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("sal진입");
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/sales/sal_main";
	}
	
	
	@RequestMapping(value = "/slip", method = RequestMethod.GET)
	public String slip_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("slip진입");
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/slip/slip_main";
	}
	
	
	@RequestMapping(value = "/tax", method = RequestMethod.GET)
	public String tax_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("tax진입");
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/tax/tax_main";
	}
	
	
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("team진입");
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/teamexp/team_main";
	}
	
	
	@RequestMapping(value = "/wel", method = RequestMethod.GET)
	public String wel_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("wel진입");
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/welfare/wel_main";
	}

}
