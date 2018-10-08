package com.team.tra_e_catch.REST;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.team.tra_e_catch.accounting.AccountingLogic;
import com.team.tra_e_catch.accounting.Acc_VO;


/*
 * Ŭ������ : AccountingREST
 * �ۼ��� : ��ö��
 * ��¥ : 2018-09-18
 */


//������ �̵� ���� �������̽�
@RestController
@RequestMapping("/accR")
public class AccountingREST{
	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private AccountingLogic accountingLogic;
	
	// ����
	/*
	 * init�޼��� : slip/slip_main.jsp
	 * out������ : ��ǥ ���� 
	 * �뵵 : ��ǥ���� ��¿�
	 * ��� : x
	 */
	@RequestMapping("slip/{counts}")
	private List<Map<String, Object>> team(@PathVariable int counts,Model mod, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String emp_no = String.valueOf(session.getAttribute("emp_no"));
		logger.info(counts+"�� slieR����");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic(counts,emp_no);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
	
	@RequestMapping("slip/t/{counts}")
	private List<Map<String, Object>> t_team(@PathVariable int counts,Model mod,HttpServletRequest req) {
		logger.info("slieR_t����");
		List<Map<String, Object>> as = accountingLogic.t_teamR_Logic(counts,req);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
	
	@RequestMapping("slip/b/{counts}")
	private List<Map<String, Object>> b_team(@PathVariable int counts,Model mod,HttpServletRequest req) {
		logger.info("slieR_b����");
		List<Map<String, Object>> as = accountingLogic.b_teamR_Logic(counts,req);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
}
