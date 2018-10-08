package com.team.tra_e_catch.REST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.payment.PaymentLogic;


/*
 * 클래스명 : 
 * 작성자 : 
 * 날짜 : 
 */


//데이터 이동 전용 인터페이스
@RestController
@RequestMapping(value="/payR")
public class PaymentREST {

	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private PaymentLogic paymentLogic;
	
	
		/*
		 * init메서드 : 
		 * out데이터 : 
		 * 용도 : 
		 * 비고 : 
		 */
	
	// 예제
	/*
	@RequestMapping("")
	private List<Map<String, Object>> team() {
		logger.info("진입");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic();
		return as;
	}*/
	//결제 대기 문서 
	@RequestMapping("epay/epaywait")
	private Map<String,Object> epaywaitlist(@RequestParam Map<String,Object>pMap,HttpServletRequest req){
		logger.info("epaywaitlist 호출 성공");
		System.out.println("epaywaitList에 들어가는 : " +pMap);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("eno", emp_no);
		Map<String,Object> rMap = paymentLogic.getEpayWaitList(pMap);
		logger.info("REST emp_no :" +emp_no);
		logger.info(rMap);
		return rMap;
	}
	//결제 문서 폼
		@RequestMapping(value = "epay/epayform")
		public List<Map<String, Object>> empform(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
			List<Map<String, Object>> empform = null;
			System.out.println("기안문서에 들어오는"+pMap);
			empform = paymentLogic.getEpayform(pMap);
			System.out.println("결제기안문서에 들어오는"+empform);
			return empform;
		}
	
	@RequestMapping("epay/{counts}")
	private List<Map<String, Object>> team(@PathVariable int counts,Model mod,HttpServletResponse res){
		logger.info(counts+"번 payR진입");
		List<Map<String, Object>> paymentList = null;	
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("counts",counts);
		paymentList = paymentLogic.getPaymentList(pMap);
		//mod.addAttribute("paymentList", paymentList);
		return paymentList;
	}
}
