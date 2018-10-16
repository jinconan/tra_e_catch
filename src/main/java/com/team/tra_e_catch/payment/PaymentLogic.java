package com.team.tra_e_catch.payment;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.team.tra_e_catch.accounting.Acc_VO;

@Service
public class PaymentLogic {
	private final Logger logger = Logger.getLogger(PaymentLogic.class);
	
	@Autowired
	private SqlPayDao sqlPayDao = null;
	
	/**
	 * 기안 등록
	 * @param pMap
	 * @return
	 */
	public int insertEpay(Map<String, Object> pMap) {
		logger.info("insertEpay() " + pMap);
		int result = 0;
		
		
		int resultOfEpay = sqlPayDao.insertEpay(pMap);
		if(resultOfEpay == 0)
			throw new RuntimeException();
		else {
			result = sqlPayDao.insertSign(pMap);
			if(result == 0)
				throw new RuntimeException();
		}
		return result;
	}
	/**
	 * 결재 대기 목록 
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayWaitList(Map<String, Object> pMap) {
		logger.info("getEpayWaitList 호출성공");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epaywaitList = null; 
		epaywaitList = sqlPayDao.getEpayWaitList(pMap);
		int total = sqlPayDao.getTotalEpayWaitList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epaywaitList);
		return rMap;
	}
	/**
	 * 기안에 대한 승인 또는 거부
	 * @param pMap
	 * @return
	 */
	public int updateEpay(Map<String, Object> pMap) {
		logger.info("getEpayupdate 호출성공");
		int result = 0;
		result = sqlPayDao.updateEpay(pMap);
		return result;
	}
	/**
	 * 결재 완료 리스트
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayEnd(Map<String, Object> pMap) {
        logger.info("getEpayEnd 호출성공");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epayend = null; 
		epayend = sqlPayDao.getEpayEnd(pMap);
		int total = sqlPayDao.getTotalEpayEndList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epayend);
		return rMap;
	}

	/**
	 * 기안 목록 리스트
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList " + pMap);
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> rows = sqlPayDao.getPaymentList(pMap);
		int total = sqlPayDao.getTotalPayment(pMap);
		
		rMap.put("total",  total);
		rMap.put("rows", rows);
		return rMap;
	}

	/**
	 * 같은 팀 내에서 사원번호가 eno인 사원보다 윗 선인 사원들의 리스트
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getUpperTeamMemberList(int eno) {
		logger.info("getUpperTeamMemberList " + eno);
		List<Map<String, Object>> upperTeamMemberList = sqlPayDao.getUpperTeamMemberList(eno);
		return upperTeamMemberList;
	}

	/**
	 * 사원의 알람 날짜를 갱신한다.
	 * @param eno
	 * @return
	 */
	public int updateAlarmDate(int eno) {
		logger.info("updateAlarmDate " + eno);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("eno",  eno);
		int result = sqlPayDao.updateAlarmDate(pMap);
		return result;
	}
	
	/**
	 * 기안목록 차트 데이터
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getDraftChart(int eno) {
		logger.info("getDraftChart : " + eno);
		return sqlPayDao.getDraftChart(eno);
	}
	
}
