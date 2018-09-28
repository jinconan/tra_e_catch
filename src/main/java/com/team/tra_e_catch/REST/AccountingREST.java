package com.team.tra_e_catch.REST;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.team.tra_e_catch.accounting.AccountingLogic;
import com.team.tra_e_catch.accounting.Arrrtd;


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
	private List<Map<String, Object>> team(@PathVariable int counts,Model mod) {
		logger.info(counts+"번 slieR진입");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic(counts);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
	
	@RequestMapping("slip/t/{counts}")
	private List<Map<String, Object>> t_team(@PathVariable int counts,Model mod,HttpServletRequest res) {
		logger.info("slieR_t진입");
		List<Map<String, Object>> as = accountingLogic.t_teamR_Logic(counts,res);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
	
	@RequestMapping("slip/b/{counts}")
	private List<Map<String, Object>> b_team(@PathVariable int counts,Model mod,HttpServletRequest res) {
		logger.info("slieR_b진입");
		List<Map<String, Object>> as = accountingLogic.b_teamR_Logic(counts,res);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
}
