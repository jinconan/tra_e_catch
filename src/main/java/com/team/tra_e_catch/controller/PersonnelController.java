package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Locale;
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
/*@RequestMapping(value="/per")*/
public class PersonnelController {

	private static final Logger logger = Logger.getLogger(PersonnelController.class);

	@RequestMapping(value="/per/salary/salaryList.tra", method = RequestMethod.GET)
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("salary호출");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/salary";
	}
	//사원명부
	@RequestMapping(value = "/per/empList", method = RequestMethod.GET)
	public String per(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/emplist";
	}
	//사원명부 검색 테이블 
	@RequestMapping(value = "/per/emptable", method = RequestMethod.GET)
	public String pertable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/emptable";
	}
	//근로계약서 관리
	@RequestMapping(value = "/per/labcont", method = RequestMethod.GET)
	public String labcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}
	//근로계약서  검색 테이블 
	@RequestMapping(value = "/per/labtable", method = RequestMethod.GET)
	public String labtable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/lablist";
	}
	//고용계약서 조회
	@RequestMapping(value = "/per/empcont", method = RequestMethod.GET)
	public String empcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}
	//근로계약서 조회 테이블
	@RequestMapping(value = "/per/empconttable", method = RequestMethod.GET)
	public String empconttable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/empconttable";
	}

}
