package com.team.tra_e_catch.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLogic {
	private final Logger logger = Logger.getLogger(ProductLogic.class);

	@Autowired
	private SqlProdDao sqlProdDao;
	
	
	/*
	 * init데이터 : 등록코드,거래처코드,결제방식,결제시작일 + 결제종료일,거래량
	 * out데이터 : List<Map<String, Object>> 출력테이블
	 * 용도 : 거래내역 전표 출력용 REST 
	 * 비고 : x
	 */
	public List<Map<String, Object>> teamR_Logic() {
		logger.info("TeamR_Logic진입");
		List<Map<String, Object>> s = sqlProdDao.tranR_Dao();
		return s;
	}
	
	public List<Map<String, Object>> chartsR_Logic() {
		logger.info("chartsR_Logic진입");
		List<Map<String, Object>> s = sqlProdDao.chartsR_Dao();
		
		Map<String,Object> map = null;
		Map<String,Object> list = new HashMap<String,Object>();	
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		map = new HashMap<String,Object>();
		map.put("caption","연도별 총 판매금액");                  
		map.put("subcaption","2018~2018");                  
		map.put("xaxisname,","년도");                              
		map.put("yaxisname","금액");                       
		map.put("showBorder","0");                                         
		map.put("numberSuffix","억");                                     
		map.put("theme","fusion");
		list.put("chart", map);
		
		
		for(Map<String,Object> maplist : s) {
			map = new HashMap<String, Object>();
			map.put("label", maplist.get("결제일자"));
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("category", list2);
		list2 = new ArrayList<Map<String,Object>>(); 
		list2.add(map);
		list.put("categories", list2);
		
		for(Map<String,Object> maplist : s) {
			map = new HashMap<String, Object>();
			map.put("value", maplist.get("금액"));
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "연도별 금액");
		map.put("allowDrag", "0");
		map.put("data", list2);
		list1.add(map);
		
		return s;
	}
	
}
