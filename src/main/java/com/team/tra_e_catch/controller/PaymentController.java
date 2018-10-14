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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.team.tra_e_catch.payment.PaymentLogic;

@Controller
@RequestMapping(value = "/pay")
public class PaymentController {
	
	@Autowired
	private PaymentLogic paymentLogic = null;

	private static final Logger logger = Logger.getLogger(PaymentController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/payment-submenu.xml");

	//////////////////////////// ��� ///////////////////////////////
	/**
	 * ��ȹ��� �Է�
	 * @param pMap
	 * @param eno
	 * @return
	 */
	@RequestMapping(value = "/draftInsert", method = RequestMethod.POST)
	public String draftInsert(@RequestParam Map<String, Object> pMap
				, @SessionAttribute("emp_no") int eno)
	{	
		pMap.put("eno", eno);
		logger.info("draftInsertȣ�� "+ pMap);
		int result = paymentLogic.insertEpay(pMap);
		return "redirect:/pay/draftList";
	}

	/**
	 * ��� ���� �Է� ������
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/draft", method = RequestMethod.GET)
	public String viewDraftInsert(Model mod
			, @SessionAttribute("emp_no") int eno) {
		logger.info("viewDraftInsert ȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "��ȹ��� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		
		List<Map<String,Object>> upperTeamMemberList = paymentLogic.getUpperTeamMemberList(eno);
		mod.addAttribute("upperTeamMemberList", upperTeamMemberList);
		return "pay/draftForm";
	}
	
	/**
	 * ��� ���� ��� ������
	 * @param mod
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value = "/draftList", method = RequestMethod.GET)
	public String draftList(Model mod, @RequestParam Map<String,Object> pMap) 
	{	
		logger.info("draft ȣ�� " + pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "��� ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/draft";
	}

	//////////////////////////// ���� //////////////////////////////////
	/**
	 * ���� ��� ����
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/epaywait", method = RequestMethod.GET)
	public String epaywait(Model mod) {
		logger.info("epaywait ");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "���� ��� ����");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epaywait";
	}

	/**
	 * ���� �Ϸ� ����
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/epayend", method = RequestMethod.GET)
	public String epayend(Model mod, @RequestParam Map<String, Object> pMap) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "���� �Ϸ� ����");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epayend";
	}
	
	/**
	 * ��ȼ� ���� or ����
	 * @param pMap
	 * @param eno
	 * @return
	 */
	@RequestMapping(value = "/epayupdate", method=RequestMethod.POST)
	public String epayupdate(@RequestParam Map<String, Object> pMap
			,@SessionAttribute("emp_no") int eno) {
		pMap.put("eno", eno);
		logger.info("epayupdate : " + pMap);
		int result = paymentLogic.updateEpay(pMap);
		return "redirect:/pay/epaywait";
	}
}
