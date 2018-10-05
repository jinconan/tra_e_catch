package com.team.tra_e_catch.REST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.payment.PaymentLogic;
import com.team.tra_e_catch.personnel.PersonnelLogic;


/*
 * Ŭ������ : 
 * �ۼ��� : 
 * ��¥ : 
 */


//������ �̵� ���� �������̽�
@RestController
@RequestMapping(value="/payR")
public class PaymentREST {

	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private PaymentLogic paymentLogic;
	private PersonnelLogic personnelLogic;
	
		/*
		 * init�޼��� : 
		 * out������ : 
		 * �뵵 : 
		 * ��� : 
		 */
	
	// ����
	/*
	@RequestMapping("")
	private List<Map<String, Object>> team() {
		logger.info("����");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic();
		return as;
	}*/
	@RequestMapping("epay/epaywait")
	private List<Map<String,Object>> epaywaitlist(@RequestParam Map<String,Object>pMap){
		logger.info("epaywaitlist ȣ�� ����");
		List<Map<String,Object>> epaywaitList = null;
		System.out.println("epaywaitList�� ���� : " +pMap);
		epaywaitList = paymentLogic.getEpayWaitList(pMap);
		logger.info(epaywaitList);
		return epaywaitList;
	}
		
	@RequestMapping("epay/draft/{counts}")
	private List<Map<String, Object>> getEpayList(@RequestParam Map<String,Object> pMap, @PathVariable int counts
			,Model mod,HttpServletResponse res)
	{
		logger.info(counts+"�� payR����");
		List<Map<String, Object>> paymentList = null;	
		pMap.put("counts",counts);
		paymentList = paymentLogic.getPaymentList(pMap);
		mod.addAttribute("paymentList", paymentList);
		return paymentList;
	}
	@RequestMapping("epay/jobInst/insert")
	private String jobinsert(@RequestParam Map<String, Object> pMap) {
		logger.info("jobInstȣ��");
		System.out.println(pMap);
		List<Map<String, Object>> jobinsert = null;
		System.out.println(pMap);
		jobinsert = paymentLogic.setJobInsert(pMap);
		return "pay/epay/draft";
		
	}
	@RequestMapping("only/emplist")//������ ������
	private List<Map<String, Object>> emplist(@RequestParam Map<String, Object> pMap){
		logger.info("emplist��û");
		List<Map<String, Object>>empList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("empList�� ���� : "+pMap);
		empList = personnelLogic.getEmpList(pMap);
		logger.info(empList);
		return empList;
	}
}
