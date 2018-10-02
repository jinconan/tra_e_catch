package com.team.tra_e_catch.REST;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.product.ProductLogic;

/*
 * 클래스명 : 
 * 작성자 : 
 * 날짜 : 
 */


//데이터 이동 전용 인터페이스
@RestController
@RequestMapping(value="/proR")
public class ProductREST {
	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private ProductLogic productLogic;
	
	
		
	/*
	 * init메서드 : prodTran.jsp
	 * out데이터 : 거래내역 리스트
	 * 용도 : 거래내역 리스트를 출력하는 메서드의 REST
	 * 비고 : 
	 */
	@RequestMapping("/tran")
	private List<Map<String, Object>> team() {
		logger.info("진입");
		List<Map<String, Object>> as = productLogic.teamR_Logic();
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
	@RequestMapping("prodStat_ct/{counts}")
	private Map<String, Object> proStatR_ct(@PathVariable int counts) {
		Map<String, Object> as = productLogic.chartsR_moon_Logic(counts);
		return as;
	}
}
