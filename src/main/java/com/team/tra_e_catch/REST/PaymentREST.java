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
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.payment.PaymentLogic;


/*
 * Ŭ������ : PaymentREST
 * �ۼ��� : ���߿�
 * ��¥ : 2018-10-04
 */


//������ �̵� ���� �������̽�
@RestController
@RequestMapping(value="/payR")
public class PaymentREST {

	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private PaymentLogic paymentLogic = null;
	
		
		/*
		 * init�޼��� : epay/draft.jsp
		 * out������ : ��� ���� ���
		 * �뵵 : ���� ��� ��¿�
		 * ��� : x
		 */
	
	// ����
	/*
	@RequestMapping("")
	private List<Map<String, Object>> team() {
		logger.info("����");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic();
		return as;
	}*/
	@RequestMapping("epay/{counts}")
	private List<Map<String, Object>> team(@PathVariable int counts,Model mod,HttpServletResponse res){
		logger.info(counts+"�� payR����");
		List<Map<String, Object>> paymentList = null;	
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("counts",counts);
		paymentList = paymentLogic.getPaymentList(pMap);
		//mod.addAttribute("paymentList", paymentList);
		return paymentList;
	}
}
