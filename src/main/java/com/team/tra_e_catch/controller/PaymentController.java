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
@RequestMapping(value="/pay")
public class PaymentController {
	
	private static final Logger logger = Logger.getLogger(PaymentController.class);
	//���� ���� �ۼ�
	@RequestMapping(value = "/epay", method = RequestMethod.GET)
	public String epay(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("payment-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epayview";
	}
	//��� ����
	@RequestMapping(value = "/epay/drift", method = RequestMethod.GET)
	public String draft(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("payment-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/draft";
	}
	//���� ��� ����
	@RequestMapping(value = "/epay/epaywait", method = RequestMethod.GET)
	public String epaywait(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("payment-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epaywait";
	}
	//���� �Ϸ� ����
	@RequestMapping(value = "/epay/epayend", method = RequestMethod.GET)
	public String epayend(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("payment-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epayend";
	}
	//�ΰ���
	@RequestMapping(value = "/epay/backdrift", method = RequestMethod.GET)
	public String backdrift(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("payment-submenu.xml");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/backdrift";
	}
}
