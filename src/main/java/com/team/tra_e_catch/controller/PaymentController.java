package com.team.tra_e_catch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.team.tra_e_catch.accounting.Acc_VO;
import com.team.tra_e_catch.payment.PaymentLogic;
import com.team.tra_e_catch.payment.PaymentVO;
import com.team.tra_e_catch.payment.SqlPayDao;

@Controller
@RequestMapping(value = "/pay")
public class PaymentController {
	
	@Autowired
	private PaymentLogic paymentLogic = null;

	private static final Logger logger = Logger.getLogger(PaymentController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/payment-submenu.xml");


	// ��ȹ������̺�URL(JSON)
	/*@RequestMapping("/epay/epayjson")
	public String getPaymentList(Model mod, @RequestParam Map<String, Object> pMap, HttpServletResponse res) {
		logger.info("getPaymentList ȣ��");
		List<Map<String, Object>> paymentList = null;
		paymentList = paymentLogic.getPaymentList(pMap, res);
		mod.addAttribute("getPaymentList", paymentList);
		return "pay/epay/epayjson";

	}*/
	//////////////////////////// ��� ///////////////////////////////
	// ���ȹ��� �Է�
	@RequestMapping(value = "/epay/epayInsert", method = RequestMethod.POST)
	public String epayInsert(@RequestParam Map<String, Object> pMap
				, @SessionAttribute("emp_no") int eno)
	{	
		logger.info("epayInsertȣ�� emp_no : "+eno+", " + pMap);
		pMap.put("eno", eno);
		int result = paymentLogic.insertEpay(pMap);
		return "redirect:/pay/epay/draft";
	}

	// ��� ���� ������
	@RequestMapping(value = "/epay", method = RequestMethod.GET)
	public String epay(Model mod) {
		logger.info("epayview ȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "��ȹ��� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epayview";
	}
	
	

	// �۾����ü� ������
	/*@RequestMapping(value = "/epay/jobInst", method = RequestMethod.POST)
	public String jobtable(@RequestParam Map<String, Object> pMap,Model mod) {
		logger.info("jobtableȣ��");
		System.out.println(pMap);
		// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		// curSubMenu : String
		List<Map<String,Object>> jobinsert = null;
		jobinsert = paymentLogic.setJobInsert(pMap);
		return "pay/epay/jobInst";

	}*/
	// �۾����ü� �Է�
	/*@RequestMapping(value = "/jobInst/insert", method = RequestMethod.POST)
	public String jobInsert(PaymentVO paymentList) 
	{	
		logger.info("jobInsertȣ��");
		System.out.println(pMap);
		List<Map<String,Object>> jobinsert = null;
		jobinsert = paymentLogic.setJobInsert(pMap);
		 
		return "pay/epay/draft";
	}*/
	
	//�ް� ������
	/*@RequestMapping(value = "/epay/restForm", method = RequestMethod.POST) 
		public String restcert(@RequestParam Map<String, Object> pMap, Model mod) {
			// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
			// subMenuList : List<Map<String, Object>>
			// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
			// curSubMenu : String
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
			mod.addAttribute("curSubMenu", "��ȹ��� �ۼ�");
			mod.addAttribute("subMenuList", subMenuList);
			List<Map<String, Object>> restinsert = null;
			System.out.println(pMap);
			restinsert = paymentLogic.restInsert(pMap);
			logger.info("restFormȣ��");
			return "pay/epay/restForm";
	}*/
	
	@RequestMapping(value = "/pay_list", method = RequestMethod.GET)
	public String pay_list(Model mod,@RequestParam Map<String, Object> pMap,@RequestParam Map<String,String> map) {
		logger.info("pay_list����");
		logger.info(map);
		String paymentList = "?y=0";
		if (map.get("up_date").length()>1) {
			paymentList += "&up_date="+map.get("up_date").substring(0, 11);
		}
		if (map.get("dtype_no").length()>1) {
			paymentList += "&dtype_no=" + map.get("dtype_no");
		}
		if (map.get("doc_no").length()>1) {
			paymentList += "&doc_no=" + map.get("doc_no");
		} 
		if (map.get("content").length()>1) {
			paymentList += "&content=" + map.get("content");
		} 
		if (map.get("title").length()>1) {
			paymentList += "&title=" + map.get("title");
		}		
		if (map.get("emp_no").length()>1) {
			paymentList += "&emp_no=" + map.get("emp_no");
		}		
		paymentList = paymentList.replaceAll(" ", "");
		/*mod.addAttribute("curSubMenu", "��� ���");
		mod.addAttribute("subMenuList", subMenuList);*/
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",paymentList);
		System.out.println(paymentList);
		return "pay/epay/draft";
	}
	

	// ��� ����
	@RequestMapping(value = "/epay/draft", method = RequestMethod.GET)
	public String draft(Model mod, @RequestParam Map<String,Object> pMap) 
	{	
		logger.info("draft ȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "��� ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/draft";
	}

	// �ΰ���
	@RequestMapping(value = "/epay/backdraft", method = RequestMethod.GET)
	public String backdrift(Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "�ΰ� ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/backdraft";
	}

	//////////////////////////// ���� //////////////////////////////////
	// ���� ��� ����
	@RequestMapping(value = "/epay/epaywait", method = RequestMethod.GET)
	public String epaywait(@RequestParam Map<String, Object> pMap, Model mod, HttpSession session) {
		logger.info("epaywait");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "���� ��� ����");
		mod.addAttribute("subMenuList", subMenuList);
		List<Map<String,Object>> epaywaitList = null;
		pMap.put("emp_no", session.getAttribute("emp_no"));
		pMap.put("ename", session.getAttribute("ename"));
		System.out.println("epaywaitList�� ���� : " +pMap);
		
		//epaywaitList = paymentLogic.getEpayWaitList(pMap);
		logger.info("epaywaitList :"+epaywaitList);
		mod.addAttribute("epaywaitList", epaywaitList);
		return "pay/epay/epaywait";
	}

	// ���� �Ϸ� ����
	@RequestMapping(value = "/epay/epayend", method = RequestMethod.GET)
	public String epayend(@RequestParam Map<String, Object> pMap,Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "���� �Ϸ� ����");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "pay/epay/epayend";
	}
	/*//��ȹ���  ��
		@RequestMapping(value = "/epay/epayform",method = RequestMethod.GET)
		public String epayfrom(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
			logger.info("epayfromȣ��");
			System.out.print("��ȹ��� ��"+pMap);
			List<Map<String, Object>> epayform = null;
			epayform = paymentLogic.getEpayform(pMap);
			System.out.println("����༭ ���� : "+getEmpList);
			req.setAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
			mod.addAttribute("epayform", epayform);
			req.setAttribute("ename", epayform.get(0).get("ENAME"));
			req.setAttribute("dno", epayform.get(0).get("DTYPE_NO"));
			req.setAttribute("udate", epayform.get(0).get("UDATE"));
			req.setAttribute("cdate", epayform.get(0).get("CDATE"));
			req.setAttribute("adate", epayform.get(0).get("ADATE"));
			req.setAttribute("title", epayform.get(0).get("TITLE"));
			return "pay/epay/epayform";
		}
*/
	
	@RequestMapping(value = "epay/epayupdate")
	public String epayupdate(@RequestParam Map<String, Object> pMap, @SessionAttribute("emp_no") int eno) {
		int result = 0;
		pMap.put("eno", eno);
		logger.info("epayupdate : " + pMap);
		result = paymentLogic.updateEpay(pMap);
		System.out.println("������ȹ����� ������"+result);
		return "redirect:/pay/epay/epaywait";
	}
}
