package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.tra_e_catch.accounting.AccountingLogic;
import com.team.tra_e_catch.accounting.Arrrtd;


/*
 * 클래스명 : AccountingController
 * 작성자 : 신철우
 * 날짜 : 2018-08-31
 */

@Controller
@RequestMapping(value="/acc")
public class AccountingController {
	
	private static final Logger logger = Logger.getLogger(AccountingController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/accounting-submenu.xml");
	List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
	
	@Autowired
	private AccountingLogic accountingLogic;
	/*
	@RequestMapping(value = "/sal", method = RequestMethod.GET)
	public String sal_main(Model mod, @RequestParam Map<String, Object> pMap) {
		logger.info("sal진입");
		
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/sales/sal_main";
	}*/
	
	
	
	/*
	 * init메서드 : slip/slip_main.jsp
	 * out메서드 : acc/slip/slip_main
	 * 용도 : 전표처리 관리 화면 
	 * 비고 : x
	 */
	@RequestMapping(value = "/slip/{counts}", method = RequestMethod.GET)
	public String slip_main(Model mod,@RequestParam Map<String, Object> pMap,@PathVariable int counts) {
		logger.info(counts+"번쨰 slip진입");
		mod.addAttribute("curSubMenu", "전표처리 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		return "acc/slip/slip_main";
	}

	
	
	
	/*
	 * init메서드 : team/team_main.jsp
	 * out메서드 : acc/teamexp/team_main
	 * 용도 : 팀 운영비 관리 페이지로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/team/{counts}", method = RequestMethod.GET)
	public String team_main(Model mod,@RequestParam Map<String, Object> pMap,@PathVariable int counts,HttpServletRequest res) {
		logger.info("team진입");
		mod.addAttribute("curSubMenu", "팀운영비 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);		
		Arrrtd arr = new Arrrtd();
		mod.addAttribute("datas",arr.outDate(res));
		return "acc/teamexp/team_main";
	}
	
	/*
	 * init메서드 : team/team_main.jsp
	 * out메서드 : acc/teamexp/team_main
	 * 용도 : 팀 운영비 관리 검색시 페이지 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/team_list", method = RequestMethod.POST)
	public String team_list(Model mod,@RequestParam Map<String, Object> pMap,@RequestParam Map<String,String> map) {
		logger.info("team_list진입");
		logger.info(map);
		String s = "?y=0";
		if (map.get("std").length()>1) {
			s += "&std="+map.get("std").substring(0, 11);
		}
		if (map.get("dtd").length()>1) {
			s += "&dtd=" + map.get("dtd").substring(0, 11);	
		}	
		if (map.get("spay").length()>1) {
			s += "&spay=" + map.get("spay");
		}
		if (map.get("dpay").length()>1) {
			s += "&dpay=" + map.get("dpay");
		} 
		if (map.get("opt").length()==2) {
			s += "&opt=" + map.get("opt");
		} 
		if (map.get("intxt").length()>1) {
			s += "&intxt=" + map.get("intxt");
		}		
		s = s.replaceAll(" ", "");
		mod.addAttribute("curSubMenu", "팀운영비 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",s);
		System.out.println(s);
		return "acc/teamexp/team_main";
	}
	
	
	/*
	 * init메서드 : team/team_main.jsp
	 * out메서드 : acc/teamexp/team_main
	 * 용도 : 팀 운영비 관리 검색시 페이지 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/wel_list", method = RequestMethod.POST)
	public String wel_list(Model mod,@RequestParam Map<String, Object> pMap,@RequestParam Map<String,String> map) {
		logger.info("wel_list진입");
		logger.info(map);
		String s = "?y=0";
		if (map.get("std").length()>1) {
			s += "&std="+map.get("std").substring(0, 11);
		}
		if (map.get("dtd").length()>1) {
			s += "&dtd=" + map.get("dtd").substring(0, 11);	
		}	
		if (map.get("spay").length()>1) {
			s += "&spay=" + map.get("spay");
		}
		if (map.get("dpay").length()>1) {
			s += "&dpay=" + map.get("dpay");
		} 
		if (map.get("opt").length()==2) {
			s += "&opt=" + map.get("opt");
		} 
		if (map.get("intxt").length()>1) {
			s += "&intxt=" + map.get("intxt");
		}		
		s = s.replaceAll(" ", "");
		mod.addAttribute("curSubMenu", "복지지원비 조회");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",s);
		System.out.println(s);
		return "acc/welfare/wel_main";
	}
	
	
	/*
	 * init메서드 : wel/wel_main.jsp
	 * out메서드 : acc/welfare/wel_main
	 * 용도 : 복지 지원비 조회로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/wel/{counts}", method = RequestMethod.GET)
	public String wel_main(Model mod,@RequestParam Map<String,String> map,@PathVariable int counts,HttpServletRequest res) {
		logger.info("wel진입");
		mod.addAttribute("curSubMenu", "복지지원비 조회");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);	
		Arrrtd arr = new Arrrtd();
		mod.addAttribute("datas",arr.outDate(res));
		return "acc/welfare/wel_main";
	}
	
	
	
	/*
	 * init메서드 : slip/slip_main.jsp
	 * out메서드 : acc/slip/slip_init
	 * 용도 : 기획서 리스트 생성 전용 페이지로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "slip/in", method = RequestMethod.GET)
	public String slip_init(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("slip/in진입");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/slip/slip_init";
	}
	
	
	/*
	 * init메서드 : tax/tax_main
	 * out메서드 : /acc/tax/tax_init
	 * 용도 : 기획서 리스트 생성 전용 페이지로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/tax/in", method = RequestMethod.GET)
	public String tax_init(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("tax/in진입");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "/acc/tax/tax_init";
	}

}
