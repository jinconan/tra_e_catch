package com.team.tra_e_catch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.team.tra_e_catch.accounting.Acc_VO;
import com.team.tra_e_catch.payment.PaymentLogic;
import com.team.tra_e_catch.payment.PaymentVO;
import com.team.tra_e_catch.payment.SqlPayDao;

@Controller
@RequestMapping(value = "/pay")
public class PaymentController {
	
	@Autowired
	private PaymentLogic paymentLogic = null;

	private static final Logger logger = Logger.getLogger(PaymentController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/payment-submenu.xml");


	// 기안문서테이블URL(JSON)
	/*@RequestMapping("/epay/epayjson")
	public String getPaymentList(Model mod, @RequestParam Map<String, Object> pMap, HttpServletResponse res) {
		logger.info("getPaymentList 호출");
		List<Map<String, Object>> paymentList = null;
		paymentList = paymentLogic.getPaymentList(pMap, res);
		mod.addAttribute("getPaymentList", paymentList);
		return "pay/epay/epayjson";

	}*/
	//////////////////////////// 기안 ///////////////////////////////
	// 가안문서 입력
	@RequestMapping(value = "/epay/epayInsert", method = RequestMethod.POST)
	public String epayInsert(@RequestParam Map<String, Object> pMap
				, @SessionAttribute("emp_no") int eno)
	{	
		logger.info("epayInsert호출 emp_no : "+eno+", " + pMap);
		pMap.put("eno", eno);
		int result = paymentLogic.insertEpay(pMap);
		return "redirect:/pay/epay/draft";
	}

	// 기안 문서 페이지
	@RequestMapping(value = "/epay", method = RequestMethod.GET)
	public String epay(Model mod) {
		logger.info("epayview 호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "기안문서 작성");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/epayview";
	}
	
	

	// 작업지시서 페이지
	/*@RequestMapping(value = "/epay/jobInst", method = RequestMethod.POST)
	public String jobtable(@RequestParam Map<String, Object> pMap,Model mod) {
		logger.info("jobtable호출");
		System.out.println(pMap);
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		List<Map<String,Object>> jobinsert = null;
		jobinsert = paymentLogic.setJobInsert(pMap);
		return "pay/epay/jobInst";

	}*/
	// 작업지시서 입력
	/*@RequestMapping(value = "/jobInst/insert", method = RequestMethod.POST)
	public String jobInsert(PaymentVO paymentList) 
	{	
		logger.info("jobInsert호출");
		System.out.println(pMap);
		List<Map<String,Object>> jobinsert = null;
		jobinsert = paymentLogic.setJobInsert(pMap);
		 
		return "pay/epay/draft";
	}*/
	
	//휴가 페이지
	/*@RequestMapping(value = "/epay/restForm", method = RequestMethod.POST) 
		public String restcert(@RequestParam Map<String, Object> pMap, Model mod) {
			// 컨트롤러로 부터 넘겨받는 속성
			// subMenuList : List<Map<String, Object>>
			// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
			// curSubMenu : String
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
			mod.addAttribute("curSubMenu", "기안문서 작성");
			mod.addAttribute("subMenuList", subMenuList);
			List<Map<String, Object>> restinsert = null;
			System.out.println(pMap);
			restinsert = paymentLogic.restInsert(pMap);
			logger.info("restForm호출");
			return "pay/epay/restForm";
	}*/
	
	@RequestMapping(value = "/pay_list", method = RequestMethod.GET)
	public String pay_list(Model mod,@RequestParam Map<String, Object> pMap,@RequestParam Map<String,String> map) {
		logger.info("pay_list진입");
		logger.info(map);
		String paymentList = "?y=0";
		if (map.get("up_date").length()>1) {
			paymentList += "&up_date="+map.get("up_date").substring(0, 11);
		}
		if (map.get("dtype_no").length()>1) {
			paymentList += "&dtype_no=" + map.get("dtype_no");
		}
		if (map.get("doc_no").length()>1) {
			paymentList += "&doc_no=" + map.get("doc_no");
		} 
		if (map.get("content").length()>1) {
			paymentList += "&content=" + map.get("content");
		} 
		if (map.get("title").length()>1) {
			paymentList += "&title=" + map.get("title");
		}		
		if (map.get("emp_no").length()>1) {
			paymentList += "&emp_no=" + map.get("emp_no");
		}		
		paymentList = paymentList.replaceAll(" ", "");
		/*mod.addAttribute("curSubMenu", "기안 목록");
		mod.addAttribute("subMenuList", subMenuList);*/
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",paymentList);
		System.out.println(paymentList);
		return "pay/epay/draft";
	}
	

	// 기안 문서
	@RequestMapping(value = "/epay/draft", method = RequestMethod.GET)
	public String draft(Model mod, @RequestParam Map<String,Object> pMap) 
	{	
		logger.info("draft 호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "기안 목록");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/draft";
	}

	// 부결기안
	@RequestMapping(value = "/epay/backdraft", method = RequestMethod.GET)
	public String backdrift(Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-draft-submenu");
		mod.addAttribute("curSubMenu", "부결 기안");
		mod.addAttribute("subMenuList", subMenuList);
		return "pay/epay/backdraft";
	}

	//////////////////////////// 결재 //////////////////////////////////
	// 결재 대기 문서
	@RequestMapping(value = "/epay/epaywait", method = RequestMethod.GET)
	public String epaywait(@RequestParam Map<String, Object> pMap, Model mod, HttpSession session) {
		logger.info("epaywait");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "결재 대기 문서");
		mod.addAttribute("subMenuList", subMenuList);
		List<Map<String,Object>> epaywaitList = null;
		pMap.put("emp_no", session.getAttribute("emp_no"));
		pMap.put("ename", session.getAttribute("ename"));
		System.out.println("epaywaitList에 들어가는 : " +pMap);
		
		//epaywaitList = paymentLogic.getEpayWaitList(pMap);
		logger.info("epaywaitList :"+epaywaitList);
		mod.addAttribute("epaywaitList", epaywaitList);
		return "pay/epay/epaywait";
	}

	// 결재 완료 문서
	@RequestMapping(value = "/epay/epayend", method = RequestMethod.GET)
	public String epayend(@RequestParam Map<String, Object> pMap,Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("pay-submenu");
		mod.addAttribute("curSubMenu", "결재 완료 문서");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "pay/epay/epayend";
	}
	/*//기안문서  뷰
		@RequestMapping(value = "/epay/epayform",method = RequestMethod.GET)
		public String epayfrom(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
			logger.info("epayfrom호출");
			System.out.print("기안문서 뷰"+pMap);
			List<Map<String, Object>> epayform = null;
			epayform = paymentLogic.getEpayform(pMap);
			System.out.println("고용계약서 인포 : "+getEmpList);
			req.setAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
			mod.addAttribute("epayform", epayform);
			req.setAttribute("ename", epayform.get(0).get("ENAME"));
			req.setAttribute("dno", epayform.get(0).get("DTYPE_NO"));
			req.setAttribute("udate", epayform.get(0).get("UDATE"));
			req.setAttribute("cdate", epayform.get(0).get("CDATE"));
			req.setAttribute("adate", epayform.get(0).get("ADATE"));
			req.setAttribute("title", epayform.get(0).get("TITLE"));
			return "pay/epay/epayform";
		}
*/
	
	@RequestMapping(value = "epay/epayupdate")
	public String epayupdate(@RequestParam Map<String, Object> pMap, @SessionAttribute("emp_no") int eno) {
		int result = 0;
		pMap.put("eno", eno);
		logger.info("epayupdate : " + pMap);
		result = paymentLogic.updateEpay(pMap);
		System.out.println("결제기안문서에 들어오는"+result);
		return "redirect:/pay/epay/epaywait";
	}
}
