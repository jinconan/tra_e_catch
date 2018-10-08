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
	
	//기안 문서 JSON데이터 요청
	/*public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList 호출");
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlPayDao.getPaymentList(pMap);
		return paymentList;
	}*/
	
	public List<Map<String, Object>> getPaymentLogic(int counst,HttpServletRequest res) {
		logger.info("getPaymentLogic진입");
		HttpSession session = res.getSession();
		String emp_no = String.valueOf(session.getAttribute("emp_no"));
		List<Map<String, Object>> paymentList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counst", counst);
		map.put("emp_no", emp_no);
		Acc_VO arr = new Acc_VO();
		arr.initDate(res,map);
		paymentList = sqlPayDao.getPaymentDao(map);
		return paymentList;
	}

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

	public List<Map<String, Object>> getEpayWaitList(Map<String, Object> pMap) {
		logger.info("getEpayWaitList 호출성공");
		List<Map<String,Object>> epaywaitList = null; 
		epaywaitList = sqlPayDao.getEpayWaitList(pMap);
		return epaywaitList;
	}

	
	public List<Map<String, Object>> jobList(Map<String, Object> pMap) {
		List<Map<String, Object>> joblist = null;
		joblist = sqlPayDao.jobList(pMap);
		return joblist;
	}

	public List<Map<String, Object>> setJobInsert(Map<String, Object> pMap) {
		List<Map<String, Object>> setJobInsert = null;
		setJobInsert = sqlPayDao.SetJobInsert(pMap);
		return setJobInsert;
	}

	public List<Map<String, Object>> restInsert(Map<String, Object> pMap) {
		List<Map<String,Object>> restInsert = null;
		restInsert = sqlPayDao.RestInsert(pMap);
		return null;
	}

	public Map<String, Object> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList " + pMap);
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> rows = sqlPayDao.getPaymentList(pMap);
		int total = sqlPayDao.getTotalPayment(pMap);
		
		rMap.put("total",  total);
		rMap.put("rows", rows);
		return rMap;
	}

}
