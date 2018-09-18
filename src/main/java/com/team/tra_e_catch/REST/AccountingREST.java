package com.team.tra_e_catch.REST;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.accounting.AccountingLogic;


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
	private List<Map<String, Object>> team(@PathVariable int counts) {
		logger.info(counts+"�� slieR����");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic(counts);
		return as;
	}
}
