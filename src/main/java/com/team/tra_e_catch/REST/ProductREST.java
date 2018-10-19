package com.team.tra_e_catch.REST;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/tran/{counts}")
	private List<Map<String, Object>> team(@PathVariable int counts,HttpServletRequest req) {
		logger.info("����");
		List<Map<String, Object>> as = productLogic.teamR_Logic(counts,req);
		logger.info(as);
		return as;
	}
	@RequestMapping("/Inven/{counts}")
	private List<Map<String, Object>> Inven(@PathVariable int counts,HttpServletRequest req) {
		logger.info("Inven ����");
		List<Map<String, Object>> as = productLogic.InvenR_Logic(counts,req);
		logger.info(as);
		return as;
	}
	@RequestMapping("/client/{counts}")
	private List<Map<String, Object>> client(@PathVariable int counts,HttpServletRequest req) {
		logger.info("client ����");
		List<Map<String, Object>> as = productLogic.clientR_Logic(counts,req);
		logger.info(as);
		return as;
	}
	@RequestMapping("/trancli")
	private List<Map<String, Object>> teamcli() {
		logger.info("teamcli ����");
		List<Map<String, Object>> as = productLogic.teancli_Logic();
		return as;
	}
	@RequestMapping("tran_goods/{counts}")
	private List<Map<String, Object>> tran_goods(@PathVariable int counts) {
		List<Map<String, Object>> as = productLogic.tran_goods_Logic(counts);
		return as;
	}
	
	@RequestMapping("prodStat")
	private Map<String, Object> proStatR() {
		Map<String, Object> as = productLogic.chartsR_Logic();
		return as;
	}
	
	@RequestMapping("prodStat_moon/{counts}")
	private Map<String, Object> proStatR_moon(@PathVariable int counts) {
		Map<String, Object> as = productLogic.chartsR_moon_Logic(counts);
		return as;
	}
	@RequestMapping("prodStat_ct/{counts}/{day}/{yn}")
	private Map<String, Object> proStatR_ct(@PathVariable int counts,@PathVariable int day,@PathVariable int yn) {
		Map<String, Object> as = productLogic.chartsR_ct_Logic(counts,day,yn);
		return as;
	}
}
