package com.team.tra_e_catch.controller;

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

import com.team.tra_e_catch.payment.PaymentLogic;
import com.team.tra_e_catch.payment.PaymentVO;

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
	
	/*@RequestMapping("epayInsert")
	public String epayInsert(@ModelAttribute PaymentVO pVO)
	{	
		//DB ���� ó��
		int result = 0;
		pVO.setEmp_no(pVO.getEmp_no());
		pVO.setDtype_no(pVO.getDtype_no());
		pVO.setPath(pVO.getPath());
		pVO.setContent(pVO.getContent());
		pVO.setDoc_no(pVO.getDoc_no());
		pVO.setUp_date(pVO.getUp_date());
		result = paymentLogic.epayInsert(pVO);
		return "forward:draft.jsp";
	}*/

	//////////////////////////// ��� ///////////////////////////////
	// ��� ���� �ۼ�
	@RequestMapping(value = "/epay", method = RequestMethod.GET)
	public String epay(Model mod) {
		logger.info("epayview ȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "��ȹ��� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epayview";
	}
	

	// �۾����ü� �ۼ�
	/*@RequestMapping(value = "/epay/jobInst", method = RequestMethod.GET)
	public String certList(Model mod) {
		// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		// curSubMenu : String
		logger.info("jobInstȣ��");
		return "pay/epay/jobInst";

	}*/

	// ��� ����
	@RequestMapping(value = "/epay/draft/{counts}", method = RequestMethod.GET)
	public String draft(@RequestParam Map<String,Object> pMap, Model mod, @PathVariable int counts) {
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
	//��ȹ���  ��
		@RequestMapping(value = "/epay/epayform",method = RequestMethod.GET)
		public String epayfrom(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
			logger.info("epayfromȣ��");
			System.out.print("��ȹ��� ��"+pMap);
			List<Map<String, Object>> epayform = null;
			epayform = paymentLogic.getEpayform(pMap);
			/*System.out.println("����༭ ���� : "+getEmpList);
			req.setAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));*/
			mod.addAttribute("epayform", epayform);
			req.setAttribute("ename", epayform.get(0).get("ENAME"));
			req.setAttribute("dno", epayform.get(0).get("DTYPE_NO"));
			req.setAttribute("udate", epayform.get(0).get("UDATE"));
			req.setAttribute("cdate", epayform.get(0).get("CDATE"));
			req.setAttribute("adate", epayform.get(0).get("ADATE"));
			req.setAttribute("title", epayform.get(0).get("TITLE"));
			return "pay/epay/epayform";
		}

}
