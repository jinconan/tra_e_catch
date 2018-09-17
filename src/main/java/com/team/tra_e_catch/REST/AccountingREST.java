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
 * 클래스명 : AccountingREST
 * 작성자 : 신철우
 * 날짜 : 2018-09-18
 */


//데이터 이동 전용 인터페이스
@RestController
@RequestMapping("/accR")
public class AccountingREST{
	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private AccountingLogic accountingLogic;
	
	
	// 예제
	/*
	 * init메서드 : slip/slip_main.jsp
	 * out데이터 : 전표 내역 
	 * 용도 : 전표내역 출력용
	 * 비고 : x
	 */
	@RequestMapping("slip/{counts}")
	private List<Map<String, Object>> team(@PathVariable int counts) {
		logger.info(counts+"번 slieR진입");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic(counts);
		return as;
	}
}
