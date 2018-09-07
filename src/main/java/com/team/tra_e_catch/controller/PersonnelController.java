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
	//기안서폼 임시저장
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
	
	//출퇴근관리 
	@RequestMapping(value="/per/attd/attlist.tra", method = RequestMethod.GET)
	public String attWork(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("attWork호출");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//근태 관련 서브메뉴 호출
		mod.addAttribute("curSubMenu", "출퇴근관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_attenList";
		
	}
	//연차관리
	@RequestMapping(value="/per/attd/leave.tra", method = RequestMethod.GET)
	public String attLeave(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("attLeave호출");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//근태 관련 서브메뉴 호출
		mod.addAttribute("curSubMenu", "연차관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_leaveList";
		
	}
	
	//증명서관리
	@RequestMapping(value="/per/cert/cert.tra", method = RequestMethod.GET)
	public String certList(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("certList호출");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//근태 관련 서브메뉴 호출
		mod.addAttribute("curSubMenu", "연차관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";
		
	}
	//증명서 출력기록 페이지
	@RequestMapping(value="/per/cert/certprint.tra", method = RequestMethod.POST)
	public String certPrintList(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("certPrintList호출");
		return "per/cert/cert_printList";
	}
	//증명서 양식 페이지
	@RequestMapping(value="/per/cert/certform.tra", method = RequestMethod.POST)
	public String certform(@RequestParam Map<String, Object> pMap, Model mod) {
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		logger.info("certPrintList호출");
		return "per/cert/certform";
	}

	//사원명부
	@RequestMapping(value = "/per/empList", method = RequestMethod.GET)
	public String per(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
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
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
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
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
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
