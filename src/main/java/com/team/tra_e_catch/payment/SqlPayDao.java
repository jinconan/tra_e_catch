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

	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList »£√‚");
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlSessionTemplate.selectList("getPaymentList",pMap);
		
		return paymentList;
	}
}
