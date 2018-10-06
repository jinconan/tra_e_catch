package com.team.tra_e_catch.payment;

import java.util.ArrayList;
import java.util.HashMap;
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
		logger.info(pMap);
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlSessionTemplate.selectList("getPaymentList",pMap);
		
		return paymentList;
	}
	//문서 번호 채번할 때
	public int getDoc() {
		int doc_no = 0;//전체 레코드 수를 담을 변수
		doc_no = sqlSessionTemplate.selectOne("getDoc");
		return doc_no;
	}
	public int getEmp() {
		int emp_no = 0;//전체 레코드 수를 담을 변수
		emp_no = sqlSessionTemplate.selectOne("getEmp");
		return emp_no;
	}
	public int epayInsert(PaymentVO pVO) {
		int result = 0;
		result = sqlSessionTemplate.insert("epayInsert", pVO);
		return result;
	}
//결재 대기 문서 
	public List<Map<String, Object>> getEpayWaitList(Map<String, Object> pMap ) {
		logger.info("Dao EpaywaitList 호출성공");
		List<Map<String,Object>> EpayWaitList = null;
		EpayWaitList = sqlSessionTemplate.selectList("getEpayWaitList", pMap);
		return EpayWaitList;
	}
	
	public List<Map<String, Object>> jobList(Map<String, Object> pMap) {
		List<Map<String, Object>> joblist = null;
		joblist = sqlSessionTemplate.selectList("jobList",pMap);
		return joblist;
	}
	public List<Map<String, Object>> SetJobInsert(Map<String, Object> pMap) {
		List<Map<String, Object>> setJobInsert = null;
		sqlSessionTemplate.insert("setJobInsert",pMap);
		return setJobInsert;
	}
	public List<Map<String, Object>> RestInsert(Map<String, Object> pMap) {
		System.out.println("최종적으로 들어가는 것들 : "+pMap);
		sqlSessionTemplate.insert("restinsert", pMap);
		return null;
	}
	
}
		
		
