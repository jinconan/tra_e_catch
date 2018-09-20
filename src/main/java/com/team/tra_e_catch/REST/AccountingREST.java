package com.team.tra_e_catch.REST;

import java.util.*;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	private List<Map<String, Object>> team(@PathVariable int counts,Model mod) {
		logger.info(counts+"번 slieR진입");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic(counts);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
	
	
	
	@RequestMapping("slip/test")
	private Map<String,Object> team_test() {
		logger.info("test_slieR진입");
		Map<String,Object> list = new HashMap<String,Object>();	
		Map<String,Object> data = new HashMap<String,Object>();
		Map<String,Object> map1 = null;
		Map<String,Object> map = null;
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		Random rd = new Random();
		
		map1 = new HashMap<String,Object>();
		map1.put("caption","연도별 총 판매금액");                  
		map1.put("subcaption","2018~2018");                  
		map1.put("xaxisname,","년도");                              
		map1.put("yaxisname","금액");                       
		map1.put("showBorder","0");                                         
		map1.put("numberSuffix","억");                                     
		map1.put("theme","fusion");
		list.put("chart", map1);
		
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("label", 2008+i);
			list2.add(map);
		}	
		map = new HashMap<String, Object>();
		map.put("category", list2);
		list2 = new ArrayList<Map<String,Object>>(); 
		list2.add(map);
		list.put("categories", list2);
		
		
		list2 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("value", rd.nextInt(100)*100);
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "테스트1");
		map.put("data", list2);
		list1.add(map);
		
		list2 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("value", rd.nextInt(100)*100);
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "테스트2");
		map.put("data", list2);
		list1.add(map);
		
		list2 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("value", rd.nextInt(100)*100);
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "테스트3");
		map.put("data", list2);
		list1.add(map);
		
		list.put("dataset", list1);

		return list;
	}
	
	
}
