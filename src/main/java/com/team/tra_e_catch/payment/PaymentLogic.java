package com.team.tra_e_catch.payment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PaymentLogic {
	private final Logger logger = Logger.getLogger(PaymentLogic.class);
	
	@Autowired
	private SqlPayDao sqlPayDao = null;
	
	//기안 문서 JSON데이터 요청
	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap, HttpServletResponse res) {
		logger.info("getPaymentList 호출");
		List<Map<String,Object>> paymentList = null;
		
		paymentList = sqlPayDao.getPaymentList(pMap);
		return paymentList;
	}

	public int epayInsert(PaymentVO pVO) {
		int result = 0;
		try {
			int doc_no = sqlPayDao.getDoc();
			pVO.setDoc_no(doc_no);
			int emp_no = sqlPayDao.getEmp();
			pVO.setEmp_no(emp_no);
			int pi = 0;
			pi = sqlPayDao.epayInsert(pVO);
			if(pi==1) {
				result = 1;
			}
			
		} catch (DataAccessException de) {
			throw de;
		}
		return result;
	}
}
