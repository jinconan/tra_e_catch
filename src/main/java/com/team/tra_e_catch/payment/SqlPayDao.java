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

	
	////////��ȹ��� �ۼ�////////
	//��ȹ��� ���
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
	
	//������ ���� ������, ������ ���
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
	
	public List<Map<String, Object>> jobList(Map<String, Object> pMap) {
		List<Map<String, Object>> joblist = null;
		joblist = sqlSessionTemplate.selectList("jobList",pMap);
		return joblist;
	}
	//�۾����ü� �Է�
	public List<Map<String, Object>> SetJobInsert(Map<String, Object> pMap) {
		List<Map<String, Object>> setJobInsert = null;
		sqlSessionTemplate.insert("setJobInsert",pMap);
		return setJobInsert;
	}
	public List<Map<String, Object>> RestInsert(Map<String, Object> pMap) {
		System.out.println("���������� ���� �͵� : "+pMap);
		sqlSessionTemplate.insert("restinsert", pMap);
		return null;
	}
	public List<Map<String, Object>> getPaymentDao(Map<String, Object> map) {
		logger.info("getPaymentDao����");
		logger.info(map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("getPaymentList",map);
		return list;
	}
	//���� ��ȣ ä���� ��
	public int getDoc() {
		int doc_no = 0;//��ü ���ڵ� ���� ���� ����
		doc_no = sqlSessionTemplate.insert("getDoc",doc_no);
		return doc_no;
	}
	public int getEmp() {
		int emp_no = 0;//��ü ���ڵ� ���� ���� ����
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
	//��� ���� ������ ��û DB
	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList ȣ��");
		logger.info(pMap);
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlSessionTemplate.selectList("getPaymentList",pMap);
		return paymentList;
	}
	
	//��ȹ��� ��.
	public int getTotalPayment(Map<String, Object> pMap) {
		logger.info("getTotalPayment " + pMap);
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalPayment", pMap);
		return result;
	}

//���� ��� ���� 
	public List<Map<String, Object>> getEpayWaitList(Map<String, Object> pMap ) {
		logger.info("Dao EpaywaitList ȣ�⼺��");
		List<Map<String,Object>> EpayWaitList = null;
		EpayWaitList = sqlSessionTemplate.selectList("getEpayWaitList", pMap);
		System.out.println(EpayWaitList);
		return EpayWaitList;
	}
	//���� ��� ���� ���������̼�
	public int getTotalEpayWaitList(Map<String, Object> pMap) {
		logger.info("Dao EpaywaitList ȣ�⼺��");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getTotalEpayWaitList", pMap);
		return result;
	}
	
	
	//���� ��� ���� ���� �ΰ�
	public int getEpayupdate(Map<String, Object> pMap) {
		logger.info("Dao getEpayform ȣ�⼺��");
		int result = 0;
		result = sqlSessionTemplate.update("getEpayupdate", pMap);
		return result;
	}

// ���� �Ϸ� ����
	public List<Map<String, Object>> getEpayEnd(Map<String, Object> pMap) {
		logger.info("getEpayEnd ȣ�⼺��");
		List<Map<String,Object>> epayend = null;
		epayend = sqlSessionTemplate.selectList("getEpayEnd", pMap);
		System.out.println(epayend);
		return epayend;
		
	}
	
	
}
		
		
