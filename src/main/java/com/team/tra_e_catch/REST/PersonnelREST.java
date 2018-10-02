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

import com.team.tra_e_catch.personnel.PersonnelLogic;


/*
 * 클래스명 : 
 * 작성자 : 
 * 날짜 : 
 */


//데이터 이동 전용 인터페이스
@RestController
@RequestMapping(value="/perR")
public class PersonnelREST {

	Logger logger = Logger.getLogger(PersonnelREST.class);
	@Autowired
	private PersonnelLogic personnelLogic = null;
	
	
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
	//페이지네이션 처리 동적쿼리로 변경(기존 > emp_no 상수)
	//(변경 > 로그인에 따른 세션 값=emp_no로 변경)
	@RequestMapping("salary/{counts}")
	private List<Map<String, Object>> viewSalaryjson(@PathVariable int counts, HttpServletRequest req){
		logger.info("viewSalary요청");
		List<Map<String, Object>> salList = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		salList = personnelLogic.getSalList(pMap);
	
		return salList;
	}

	
	
	
	@RequestMapping("attd/{counts}")
	private List<Map<String, Object>> viewAttdjson(@PathVariable int counts, HttpServletRequest req){
		logger.info("viewAttdjson요청");
		List<Map<String, Object>> attdList = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		attdList = personnelLogic.getAttdList(pMap);
		return attdList;
	}

	@RequestMapping("only/worklist")//근로계약서 데이터
	private List<Map<String, Object>> viewWorklist(@RequestParam Map<String, Object> pMap){
		logger.info("viewWorklist요청");
		List<Map<String, Object>> workList = null;
/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("viewWorklist에 들어가는 : "+pMap);
		workList = personnelLogic.getWorkList(pMap);
		return workList;
	}
	@RequestMapping("only/sourcinglist")//고용계약서 데이터
	private List<Map<String, Object>> viewsourcinglist(@RequestParam Map<String, Object> pMap){
		logger.info("viewsourcinglist요청");
		List<Map<String, Object>> sourcingList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("viewsourcinglist에 들어가는 : "+pMap);
		sourcingList = personnelLogic.getSourcingList(pMap);
		logger.info(sourcingList);
		return sourcingList;
	}
	@RequestMapping("only/emplist")//사원명부 데이터
	private List<Map<String, Object>> emplist(@RequestParam Map<String, Object> pMap){
		logger.info("emplist요청");
		List<Map<String, Object>>empList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("empList에 들어가는 : "+pMap);
		empList = personnelLogic.getEmpList(pMap);
		logger.info(empList);
		return empList;
	}
	
	@RequestMapping("rating/list")
	private List<Map<String, Object>> viewTeamjson(@RequestParam Map<String, Object> pMap, HttpServletRequest req){
		logger.info("viewTeamjson요청");
		List<Map<String, Object>> teamList = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);		
		teamList = personnelLogic.getTeamList(pMap);
		logger.info(teamList);
		return teamList;
	}
	
	
	@RequestMapping("lev/list")
	private List<Map<String, Object>> viewLevList(@RequestParam Map<String, Object> pMap){
		logger.info("viewLevList요청");
		List<Map<String, Object>> levList = null;
		levList = personnelLogic.getlevlist(pMap);
	
		return levList;
	}
	@RequestMapping("loc/list")
	private List<Map<String, Object>> viewLocList(@RequestParam Map<String, Object> pMap){
		logger.info("viewLocList요청");
		List<Map<String, Object>> locList = null;
		locList = personnelLogic.getLocList(pMap);
	
		return locList;
	}
	@RequestMapping("dept/list")
	private List<Map<String, Object>> viewDeptList(@RequestParam Map<String, Object> pMap){
		logger.info("viewDeptList요청");
		List<Map<String, Object>> deptList = null;
		deptList = personnelLogic.getDeptList(pMap);
	
		return deptList;
	}
	
	
	//증명서 발급 내역
	@RequestMapping(value = "certlist")
	public List<Map<String, Object>> certlist(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		List<Map<String, Object>> getCertlist = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);		
		getCertlist = personnelLogic.getCertlist(pMap);
		logger.info(getCertlist);
		return getCertlist;
	}
	
	
	//개인신상정보
	@RequestMapping(value = "indivemp")
	public List<Map<String, Object>> indivEmpList(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		List<Map<String, Object>> indivList = null;
		System.out.println(pMap);
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);
		indivList = personnelLogic.getindivList(pMap);
		
		return indivList;
	}
}
