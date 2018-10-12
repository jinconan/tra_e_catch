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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.team.tra_e_catch.payment.PaymentLogic;
import com.team.tra_e_catch.personnel.PersonnelLogic;


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
	private PersonnelLogic personnelLogic;
	
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
		System.out.println(" REST epaywaitList에 들어가는 : " +pMap);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("eno", emp_no);
		Map<String,Object> rMap = paymentLogic.getEpayWaitList(pMap);
		logger.info("REST emp_no :" +emp_no);
		logger.info("epay컨트롤러 :"+rMap);
		return rMap;
	}
	//결제 문서 update
		
		//결제 완료 문서 
		@RequestMapping("epay/epayend")
		private Map<String,Object> epayEnd(@RequestParam Map<String,Object>pMap,HttpServletRequest req){
			logger.info("epayend 호출 성공");
			System.out.println(" REST epayend에 들어가는 : " +pMap);
			HttpSession session = req.getSession();
			String semp_no = String.valueOf(session.getAttribute("emp_no"));
			int emp_no = Integer.parseInt(semp_no);
			pMap.put("eno", emp_no);
			Map<String,Object> rMap = paymentLogic.getEpayEnd(pMap);
			logger.info("REST emp_no :" +emp_no);
			logger.info("epay컨트롤러 :"+rMap);
			return rMap;
		}
	@RequestMapping("epay/draft/t/{counts}")
	private List<Map<String, Object>> searchList(@PathVariable int counts,Model mod,HttpServletRequest req) {
		logger.info("payR_t진입");
		List<Map<String, Object>> paymentList = paymentLogic.getPaymentLogic(counts,req);	
		logger.info(paymentList.size());
		mod.addAttribute("paymentList",paymentList.size());
		return paymentList;
	}
	@RequestMapping("epay/jobInst/insert")
	private String jobinsert(@RequestParam Map<String, Object> pMap) {
		logger.info("jobInst호출");
		System.out.println(pMap);
		List<Map<String, Object>> jobinsert = null;
		System.out.println(pMap);
		jobinsert = paymentLogic.setJobInsert(pMap);
		return "pay/epay/draft";
		
	}
	/*@RequestMapping("only/emplist")//사원명부 데이터
	private List<Map<String, Object>> emplist(@RequestParam Map<String, Object> pMap){
		logger.info("emplist요청");
		List<Map<String, Object>>empList = null;
				pMap.put("emp_no", req.getParameter("emp_no").toString());
		System.out.println("empList에 들어가는 : "+pMap);
		empList = personnelLogic.getEmpList(pMap);
		logger.info(empList);
		return empList;
	}*/
	
	
	/////////////////////////////기안 목록/////////////////////////
	@RequestMapping(value="epay/draft", method=RequestMethod.GET) 
	private Map<String, Object> getEpayList(@RequestParam Map<String, Object> pMap
			, @SessionAttribute("emp_no") int eno) {
		
		pMap.put("eno", eno);
		logger.info("getEpayList " + pMap);
		Map<String, Object> rMap  = paymentLogic.getPaymentList(pMap);
		return rMap;
	}
		
	
}
