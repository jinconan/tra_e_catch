package com.team.tra_e_catch.payment;

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
	
	//��� ���� JSON������ ��û
	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList ȣ��");
		List<Map<String,Object>> paymentList = null;
		paymentList = sqlPayDao.getPaymentList(pMap);
		return paymentList;
	}
	
	public List<Map<String, Object>> getPaymentLogic(int counst,HttpServletRequest res) {
		logger.info("getPaymentLogic����");
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

	public int epayInsert(PaymentVO pVO) {
		int result = 0;
		try {
			int doc_no = sqlPayDao.getDoc();
			pVO.setDoc_no(doc_no);
			int emp_no = sqlPayDao.getEmp();
			pVO.setEmp_no(emp_no);
			String path = sqlPayDao.getPath();
			pVO.setPath(path);
			String title = sqlPayDao.getTitle();
			pVO.setTitle(title);
			String up_date = sqlPayDao.getUp_date();
			pVO.setUp_date(up_date);
			String content = sqlPayDao.getContent();
			pVO.setContent(content);
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

	public List<Map<String, Object>> getEpayWaitList(Map<String, Object> pMap) {
		logger.info("getEpayWaitList ȣ�⼺��");
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

}
