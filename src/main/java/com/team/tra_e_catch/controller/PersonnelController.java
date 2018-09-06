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
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "급여관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/salary";
	}
	
	@RequestMapping(value="/per/rating/perrating.tra", method = RequestMethod.GET)
	public String viewRating(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("viewRating호출");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사고과");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/rating/perrating";
	}
	@RequestMapping(value="/per/rating/testform.tra", method = RequestMethod.GET)
	public String formTest(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("viewRating호출");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사메뉴");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/testform";
		
	}
}
