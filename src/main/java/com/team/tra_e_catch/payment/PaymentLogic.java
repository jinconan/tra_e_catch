package com.team.tra_e_catch.payment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentLogic {
	private final Logger logger = Logger.getLogger(PaymentLogic.class);
	
	@Autowired
	private SqlPayDao sqlPayDao;

	public List<Map<String, Object>> getPaymentList(Map<String, Object> pMap, HttpServletResponse res) {
		logger.info("getPaymentList »£√‚");
		List<Map<String,Object>> paymentList = null;
		
		paymentList = sqlPayDao.getPaymentList(pMap);
		return paymentList;
	}
}
