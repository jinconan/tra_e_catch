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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.team.tra_e_catch.payment.PaymentLogic;
import com.team.tra_e_catch.personnel.PersonnelLogic;

//������ �̵� ���� �������̽�
@RestController
@RequestMapping(value = "/payR")
public class PaymentREST {
	Logger logger = Logger.getLogger(PaymentREST.class);
	@Autowired
	private PaymentLogic paymentLogic;

	// ���� ��� ����
	@RequestMapping("/epaywait")
	private Map<String, Object> epaywaitlist(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		logger.info("epaywaitlist ȣ�� ����");
		System.out.println(" REST epaywaitList�� ���� : " + pMap);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("eno", emp_no);
		Map<String, Object> rMap = paymentLogic.getEpayWaitList(pMap);
		logger.info("REST emp_no :" + emp_no);
		logger.info("epay��Ʈ�ѷ� :" + rMap);
		return rMap;
	}

	// ���� �Ϸ� ����
	@RequestMapping("/epayend")
	private Map<String, Object> epayEnd(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		logger.info("epayend ȣ�� ����");
		System.out.println(" REST epayend�� ���� : " + pMap);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("eno", emp_no);
		Map<String, Object> rMap = paymentLogic.getEpayEnd(pMap);
		logger.info("REST emp_no :" + emp_no);
		logger.info("epay��Ʈ�ѷ� :" + rMap);
		return rMap;
	}

	///////////////////////////// ��� ���/////////////////////////
	@RequestMapping(value = "/draft", method = RequestMethod.GET)
	private Map<String, Object> getEpayList(@RequestParam Map<String, Object> pMap,
			@SessionAttribute("emp_no") int eno) {

		pMap.put("eno", eno);
		logger.info("getEpayList " + pMap);
		Map<String, Object> rMap = paymentLogic.getPaymentList(pMap);
		return rMap;
	}

}
