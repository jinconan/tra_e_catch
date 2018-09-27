package com.team.tra_e_catch.REST;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.product.ProductLogic;

/*
 * Ŭ������ : 
 * �ۼ��� : 
 * ��¥ : 
 */


//������ �̵� ���� �������̽�
@RestController
@RequestMapping(value="/proR")
public class ProductREST {
	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private ProductLogic productLogic;
	
	
		
	/*
	 * init�޼��� : prodTran.jsp
	 * out������ : �ŷ����� ����Ʈ
	 * �뵵 : �ŷ����� ����Ʈ�� ����ϴ� �޼����� REST
	 * ��� : 
	 */
	@RequestMapping("/tran")
	private List<Map<String, Object>> team() {
		logger.info("����");
		List<Map<String, Object>> as = productLogic.teamR_Logic();
		return as;
	}
	
	
	@RequestMapping("slip/test")
	private Map<String, Object> team_test() {
		Map<String, Object> as = productLogic.chartsR_Logic();

		return as;
	}
}
