package com.team.tra_e_catch.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlPayDao {
	Logger logger = Logger.getLogger(SqlPayDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	////////기안문서 작성////////
	/**
	 * 기안문서 등록 
	 * @param pMap
	 * @return
	 */
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
	
	/**
	 * 서류에 대한 승인자, 결재자 등록
	 * @param pMap
	 * @return
	 */
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
	/**
	 * 기안 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList 호출");
		logger.info(pMap);
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlSessionTemplate.selectList("getPaymentList",pMap);
		return paymentList;
	}
	
	/**
	 * 기안 목록의 수
	 * @param pMap
	 * @return
	 */
	public int getTotalPayment(Map<String, Object> pMap) {
		logger.info("getTotalPayment " + pMap);
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalPayment", pMap);
		return result;
	}

	/**
	 * 결재 대기 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEpayWaitList(Map<String, Object> pMap ) {
		logger.info("Dao EpaywaitList 호출성공");
		List<Map<String,Object>> EpayWaitList = null;
		EpayWaitList = sqlSessionTemplate.selectList("getEpayWaitList", pMap);
		System.out.println(EpayWaitList);
		return EpayWaitList;
	}
	/**
	 * 결재 대기의 수
	 * @param pMap
	 * @return
	 */
	public int getTotalEpayWaitList(Map<String, Object> pMap) {
		logger.info("Dao EpaywaitList 호출성공");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalEpayWaitList", pMap);
		return result;
	}
	
	/**
	 * 기안에 대한 승인 또는 거부
	 * @param pMap
	 * @return
	 */
	public int updateEpay(Map<String, Object> pMap) {
		int result = 0;
		try {
			logger.info(pMap);
			result = sqlSessionTemplate.update("updateEpay", pMap);
			logger.info("업데이트 성공");
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	/**
	 * 결재 완료 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEpayEnd(Map<String, Object> pMap) {
		logger.info("getEpayEnd 호출성공");
		List<Map<String,Object>> epayend = null;
		epayend = sqlSessionTemplate.selectList("getEpayEnd", pMap);
		System.out.println(epayend);
		return epayend;
		
	}


	/**
	 * 결재 완료의 수
	 * @param pMap
	 * @return
	 */
	public int getTotalEpayEndList(Map<String, Object> pMap) {
		logger.info("getTotalEpayEndList 호출성공");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalEpayEndList", pMap);
		return result;
	}

	/**
	 * 팀내 윗 선의 사원 리스트
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getUpperTeamMemberList(int eno) {
		logger.info("getUpperTeamMemberList " + eno);
		List<Map<String, Object>> result = sqlSessionTemplate.selectList("com.mybatis.mapper.paymentMapper.getUpperTeamMemberList", eno);
		return result;
	}
	
	/**
	 * 사원의 알람 날짜를 갱신한다.
	 * @param pMap
	 * @return
	 */
	public int updateAlarmDate(Map<String, Object> pMap) {
		logger.info("updateAlarmDate 호출성공");
		int result = 0;
		result = sqlSessionTemplate.update("updateAlarmDate", pMap);
		return result;
	}
	
	/**
	 * 사원이 확인하지 않은 알람의 갯수를 구한다.
	 * @param pMap
	 * @return
	 */
	public int getTotalAlarmCount(Map<String, Object> pMap) {
		logger.info("getTotalAlarmCount 호출성공");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalAlarmCount", pMap);
		return result;
	}
}
		
		
