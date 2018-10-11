package com.team.tra_e_catch.payment;

import java.sql.SQLException;
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

	
	////////기안문서 작성////////
	//기안문서 등록
	public int insertEpay(Map<String, Object> pMap) {
		logger.info("insertEpay");
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("insertEpay", pMap);
		} catch(Exception e) {
			logger.error(e.toString());
			result = 0;	
		}
		return result;
	}
	
	//서류에 대한 승인자, 결재자 등록
	public int insertSign(Map<String,Object> pMap) {
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("insertSign",pMap);
		} catch (Exception e) {
			logger.error(e.toString());
			result = 0;	
		}
		return result;
	}
	//////기안문서 작성 끝///////
	
	public List<Map<String, Object>> jobList(Map<String, Object> pMap) {
		List<Map<String, Object>> joblist = null;
		joblist = sqlSessionTemplate.selectList("jobList",pMap);
		return joblist;
	}
	//작업지시서 입력
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
	public List<Map<String, Object>> getPaymentDao(Map<String, Object> map) {
		logger.info("getPaymentDao진입");
		logger.info(map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("getPaymentList",map);
		return list;
	}
	//문서 번호 채번할 때
	public int getDoc() {
		int doc_no = 0;//전체 레코드 수를 담을 변수
		doc_no = sqlSessionTemplate.insert("getDoc",doc_no);
		return doc_no;
	}
	public int getEmp() {
		int emp_no = 0;//전체 레코드 수를 담을 변수
		emp_no = sqlSessionTemplate.insert("getEmp",emp_no);
		return emp_no;
	}
	public String getEname() {
		String ename = "";
		ename = sqlSessionTemplate.selectOne("getEname",ename);
		return ename;
	}

	
	

	public String getPath() {
		String path = null;
		return path;
	}
	public String getTitle() {
		String title = null;
		return title;
	}
	public String getUp_date() {
		String up_date = null;
		return up_date;
	}
	public String getContent() {
		String content = null;
		
		return content;
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
	
	//기안문서 수.
	public int getTotalPayment(Map<String, Object> pMap) {
		logger.info("getTotalPayment " + pMap);
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalPayment", pMap);
		return result;
	}

//결제 대기 문서 
	public List<Map<String, Object>> getEpayWaitList(Map<String, Object> pMap ) {
		logger.info("Dao EpaywaitList 호출성공");
		List<Map<String,Object>> EpayWaitList = null;
		EpayWaitList = sqlSessionTemplate.selectList("getEpayWaitList", pMap);
		System.out.println(EpayWaitList);
		return EpayWaitList;
	}
	//결제 대기 문서 페이지네이션
	public int getTotalEpayWaitList(Map<String, Object> pMap) {
		logger.info("Dao EpaywaitList 호출성공");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalEpayWaitList", pMap);
		return result;
	}
	
	
	//결제 대기 문서 승인 부결
	public int getEpayupdate(Map<String, Object> pMap) {
		logger.info("Dao getEpayform 호출성공");
		int result = 0;
		result = sqlSessionTemplate.update("getEpayupdate", pMap);
		return result;
	}

// 결제 완료 문서
	public List<Map<String, Object>> getEpayEnd(Map<String, Object> pMap) {
		logger.info("getEpayEnd 호출성공");
		List<Map<String,Object>> epayend = null;
		epayend = sqlSessionTemplate.selectList("getEpayEnd", pMap);
		System.out.println(epayend);
		return epayend;
		
	}
	
	
}
		
		
