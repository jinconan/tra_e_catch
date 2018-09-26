package com.team.tra_e_catch.payment;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class SqlPayDao {
	Logger logger = Logger.getLogger(SqlPayDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
		
		
	}
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	//기안 문서 데이터 요청 DB
	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList 호출");
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlSessionTemplate.selectList("getPaymentList",pMap);
		
		return paymentList;
	}
}
