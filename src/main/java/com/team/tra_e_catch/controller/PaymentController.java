package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.tra_e_catch.payment.PaymentLogic;

@Controller
@RequestMapping(value="/pay")
public class PaymentController {
	
	private static final Logger logger = Logger.getLogger(PaymentController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/payment-submenu.xml");
	
	@Autowired
	private PaymentLogic paymentLogic;
	
	//////////////////////////// 기안 ///////////////////////////////
	//기안 문서 작성
	@RequestMapping(value = "/epay", method = RequestMethod.GET)
	public String epay(Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "기안문서 작성");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epayview";
	}
	//기안 문서
	@RequestMapping(value = "/epay/draft", method = RequestMethod.GET)
	public String draft(Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "기안 목록");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/draft";
	}
	
	//부결기안
	@RequestMapping(value = "/epay/backdraft", method = RequestMethod.GET)
	public String backdrift(Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "부결 기안");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/backdraft";
	}
	
	//////////////////////////// 결재 //////////////////////////////////
	//결재 대기 문서
	@RequestMapping(value = "/epay/epaywait", method = RequestMethod.GET)
	public String epaywait(Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "결재 대기 문서");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epaywait";
	}
	//결재 완료 문서
	@RequestMapping(value = "/epay/epayend", method = RequestMethod.GET)
	public String epayend(Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "결재 완료 문서");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epayend";
	}
	
}
