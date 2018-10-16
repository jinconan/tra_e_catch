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
	
	////////��ȹ��� �ۼ�////////
	/**
	 * ��ȹ��� ��� 
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
	 * ������ ���� ������, ������ ���
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
	//////��ȹ��� �ۼ� ��///////
	/**
	 * ��� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList ȣ��");
		logger.info(pMap);
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlSessionTemplate.selectList("getPaymentList",pMap);
		return paymentList;
	}
	
	/**
	 * ��� ����� ��
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
	 * ���� ��� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEpayWaitList(Map<String, Object> pMap ) {
		logger.info("Dao EpaywaitList ȣ�⼺��");
		List<Map<String,Object>> EpayWaitList = null;
		EpayWaitList = sqlSessionTemplate.selectList("getEpayWaitList", pMap);
		System.out.println(EpayWaitList);
		return EpayWaitList;
	}
	/**
	 * ���� ����� ��
	 * @param pMap
	 * @return
	 */
	public int getTotalEpayWaitList(Map<String, Object> pMap) {
		logger.info("Dao EpaywaitList ȣ�⼺��");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalEpayWaitList", pMap);
		return result;
	}
	
	/**
	 * ��ȿ� ���� ���� �Ǵ� �ź�
	 * @param pMap
	 * @return
	 */
	public int updateEpay(Map<String, Object> pMap) {
		int result = 0;
		try {
			logger.info(pMap);
			result = sqlSessionTemplate.update("updateEpay", pMap);
			logger.info("������Ʈ ����");
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	/**
	 * ���� �Ϸ� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEpayEnd(Map<String, Object> pMap) {
		logger.info("getEpayEnd ȣ�⼺��");
		List<Map<String,Object>> epayend = null;
		epayend = sqlSessionTemplate.selectList("getEpayEnd", pMap);
		System.out.println(epayend);
		return epayend;
		
	}


	/**
	 * ���� �Ϸ��� ��
	 * @param pMap
	 * @return
	 */
	public int getTotalEpayEndList(Map<String, Object> pMap) {
		logger.info("getTotalEpayEndList ȣ�⼺��");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalEpayEndList", pMap);
		return result;
	}

	/**
	 * ���� �� ���� ��� ����Ʈ
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getUpperTeamMemberList(int eno) {
		logger.info("getUpperTeamMemberList " + eno);
		List<Map<String, Object>> result = sqlSessionTemplate.selectList("com.mybatis.mapper.paymentMapper.getUpperTeamMemberList", eno);
		return result;
	}
	
	/**
	 * ����� �˶� ��¥�� �����Ѵ�.
	 * @param pMap
	 * @return
	 */
	public int updateAlarmDate(Map<String, Object> pMap) {
		logger.info("updateAlarmDate ȣ�⼺��");
		int result = 0;
		result = sqlSessionTemplate.update("updateAlarmDate", pMap);
		return result;
	}
	
	/**
	 * ����� Ȯ������ ���� �˶��� ������ ���Ѵ�.
	 * @param pMap
	 * @return
	 */
	public int getTotalAlarmCount(Map<String, Object> pMap) {
		logger.info("getTotalAlarmCount ȣ�⼺��");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalAlarmCount", pMap);
		return result;
	}
}
		
		
