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
	
	public Map<String, Object> chartsR_Logic() {
		logger.info("chartsR_Logic진입");
		Chart_Make cm = new Chart_Make();
		cm.C_Make(sqlProdDao.chartsR_Dao());

		return cm.map;
	}
	
}
