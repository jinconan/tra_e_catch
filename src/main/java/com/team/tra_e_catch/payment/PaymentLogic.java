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
	 * ��� ���
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
	 * ���� ��� ��� 
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayWaitList(Map<String, Object> pMap) {
		logger.info("getEpayWaitList ȣ�⼺��");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epaywaitList = null; 
		epaywaitList = sqlPayDao.getEpayWaitList(pMap);
		int total = sqlPayDao.getTotalEpayWaitList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epaywaitList);
		return rMap;
	}
	/**
	 * ��ȿ� ���� ���� �Ǵ� �ź�
	 * @param pMap
	 * @return
	 */
	public int updateEpay(Map<String, Object> pMap) {
		logger.info("getEpayupdate ȣ�⼺��");
		int result = 0;
		result = sqlPayDao.updateEpay(pMap);
		return result;
	}
	/**
	 * ���� �Ϸ� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayEnd(Map<String, Object> pMap) {
        logger.info("getEpayEnd ȣ�⼺��");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epayend = null; 
		epayend = sqlPayDao.getEpayEnd(pMap);
		int total = sqlPayDao.getTotalEpayEndList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epayend);
		return rMap;
	}

	/**
	 * ��� ��� ����Ʈ
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
	 * ���� �� ������ �����ȣ�� eno�� ������� �� ���� ������� ����Ʈ
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getUpperTeamMemberList(int eno) {
		logger.info("getUpperTeamMemberList " + eno);
		List<Map<String, Object>> upperTeamMemberList = sqlPayDao.getUpperTeamMemberList(eno);
		return upperTeamMemberList;
	}

	/**
	 * ����� �˶� ��¥�� �����Ѵ�.
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
	 * ��ȸ�� ��Ʈ ������
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getDraftChart(int eno) {
		logger.info("getDraftChart : " + eno);
		return sqlPayDao.getDraftChart(eno);
	}
	
}
