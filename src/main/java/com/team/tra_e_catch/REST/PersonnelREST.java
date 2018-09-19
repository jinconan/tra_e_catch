package com.team.tra_e_catch.REST;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.personnel.PersonnelLogic;


/*
 * 클래스명 : 
 * 작성자 : 
 * 날짜 : 
 */


//데이터 이동 전용 인터페이스
@RestController
@RequestMapping(value="/perR")
public class PersonnelREST {

	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private PersonnelLogic personnelLogic = null;
	
	
		/*
		 * init메서드 : 
		 * out데이터 : 
		 * 용도 : 
		 * 비고 : 
		 */
	
	// 예제
	/*
	@RequestMapping("")
	private List<Map<String, Object>> team() {
		logger.info("진입");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic();
		return as;
	}*/
	
	@RequestMapping("salary/{counts}")
	private List<Map<String, Object>> viewSalaryjson(@PathVariable int counts){
		logger.info("viewSalary요청");
		List<Map<String, Object>> salList = null;
		salList = personnelLogic.getSalList(counts);
		return salList;
	}
	
	@RequestMapping("attd/{counts}")
	private List<Map<String, Object>> viewAttdjson(@PathVariable int counts){
		logger.info("viewAttdjson요청");
		List<Map<String, Object>> attdList = null;
		attdList = personnelLogic.getAttdList(counts);
		return attdList;
	}
	
	
}
