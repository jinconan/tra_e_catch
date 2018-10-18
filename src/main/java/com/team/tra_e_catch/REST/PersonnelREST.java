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
import org.springframework.web.bind.annotation.SessionAttribute;

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

	/**
	 * 출결 현황 json 요청.
	 * @param counts
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("/attd/{counts}")
	private List<Map<String, Object>> viewAttdjson(@PathVariable int counts, @SessionAttribute("emp_no") int emp_no){
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		logger.info("viewAttdjson :" + pMap);
		List<Map<String, Object>> attdList = personnelLogic.getAttdList(pMap);
		return attdList;
	}

	@RequestMapping("/leave")
	private Map<String, Object> viewLeavejson(@RequestParam Map<String, Object> pMap, @SessionAttribute("emp_no") int emp_no) {
		pMap.put("eno",emp_no);
		Map<String, Object> rMap = personnelLogic.getLeaveList(pMap); 
		return rMap;
	}
	
	
	/**
	 * 증명서 발급 내역
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/certlist")
	public List<Map<String, Object>> certlist(@RequestParam Map<String, Object> pMap, @SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);		
		logger.info("certlist : " + pMap);
		List<Map<String, Object>> getCertlist = personnelLogic.getCertlist(pMap);
		logger.info(getCertlist);
		return getCertlist;
	}
	
	/**
	 * 개인신상정보
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/indivemp")
	public List<Map<String, Object>> indivEmpList(@RequestParam Map<String, Object> pMap, @SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);
		logger.info("indivEmpList : " + pMap);
		return personnelLogic.getindivList(pMap);
	}
	
	
	//페이지네이션 처리 동적쿼리로 변경(기존 > emp_no 상수)
	// (변경 > 로그인에 따른 세션 값=emp_no로 변경)
	/**
	 * 급여 내역 json 요청
	 * @param counts
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("salary/{counts}")
	private List<Map<String, Object>> viewSalaryjson(@PathVariable int counts, @SessionAttribute("emp_no") int emp_no){
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		logger.info("viewSalaryjson요청 : " + pMap);
		List<Map<String, Object>> salList = personnelLogic.getSalList(pMap);
		return salList;
	}
	
	/**
	 * 팀원 json 요청
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("rating/list")
	private List<Map<String, Object>> viewTeamjson(@RequestParam Map<String, Object> pMap
			, @SessionAttribute("emp_no") int emp_no){
		pMap.put("emp_no", emp_no);		
		logger.info("viewTeamjson요청 : " + pMap);
		List<Map<String, Object>> teamList = personnelLogic.getTeamList(pMap);
		logger.info(teamList);
		return teamList;
	}
	
	/**
	 * 근무평정 기간분류
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("rating/quar")
	private List<Map<String, Object>> quarList(@RequestParam Map<String, Object> pMap
			, @SessionAttribute("emp_no") int emp_no){
		pMap.put("emp_no", emp_no);
		logger.info("quarlist요청 : " + pMap);
		List<Map<String, Object>> quarlist = personnelLogic.getQuarList(pMap);
		return quarlist;
	}
	
	/**
	 * 인사권자의견
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("rating/leader")
	private List<Map<String, Object>> leaderView(@RequestParam Map<String, Object> pMap
			, @SessionAttribute("emp_no") int emp_no){
		pMap.put("emp_no", emp_no);
		logger.info("leaderView요청 :" +pMap);
		List<Map<String, Object>>	leaderView = personnelLogic.getleaderView(pMap);
		return leaderView;
	}
	
	/**
	 * 사원명부 데이터
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/emplist")
	private List<Map<String, Object>> emplist(@RequestParam Map<String, Object> pMap){
		logger.info("emplist요청 :" + pMap);
		List<Map<String, Object>> empList = personnelLogic.getEmpList(pMap);
		logger.info(empList);
		return empList;
	}	
	
	/**
	 * 직급 리스트 데이터
	 * @param pMap
	 * @return
	 */
	@RequestMapping("lev/list")
	private List<Map<String, Object>> viewLevList(@RequestParam Map<String, Object> pMap){
		logger.info("viewLevList요청");
		List<Map<String, Object>> levList = null;
		levList = personnelLogic.getlevlist(pMap);
	
		return levList;
	}
	/**
	 * 지역 리스트 데이터
	 * @param pMap
	 * @return
	 */
	@RequestMapping("loc/list")
	private List<Map<String, Object>> viewLocList(@RequestParam Map<String, Object> pMap){
		logger.info("viewLocList요청");
		List<Map<String, Object>> locList = null;
		locList = personnelLogic.getLocList(pMap);
		return locList;
	}
	
	/**
	 * 부서 리스트 데이터
	 * @param pMap
	 * @return
	 */
	@RequestMapping("dept/list")
	private List<Map<String, Object>> viewDeptList(@RequestParam Map<String, Object> pMap){
		logger.info("viewDeptList요청");
		List<Map<String, Object>> deptList = null;
		deptList = personnelLogic.getDeptList(pMap);
		return deptList;
	}
	
	/**
	 * 고용계약서개인신상정보
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value = "/auth/indivemplist")
	public List<Map<String, Object>> indivEmplist2(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		logger.info("고용계약서에 들어오는 and 인사발령에 들어오는" + pMap);
		indivList = personnelLogic.getindivList(pMap);
		logger.info("고용계약서에 들어오는" + indivList);
		return indivList;
	}
	@RequestMapping(value = "/auth/contlist")
	public List<Map<String, Object>> contlist(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		logger.info("고용계약서에 들어오는 and 인사발령에 들어오는" + pMap);
		indivList = personnelLogic.getindivlist(pMap);
		logger.info("고용계약서에 들어오는" + indivList);
		return indivList;
	}
	
	/**
	 * 근로계약서 데이터
	 * @param pMap
	 * @return
	 */
	@RequestMapping("/auth/worklist")
	private List<Map<String, Object>> viewWorklist(@RequestParam Map<String, Object> pMap){
		logger.info("viewWorklist요청");
		List<Map<String, Object>> workList = null;
/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		pMap.put("in_emp_no", pMap.get("emp_no"));
		logger.info("viewWorklist에 들어가는 : "+pMap);
		workList = personnelLogic.getWorkList(pMap);
		return workList;
	}
	
	/**
	 * 고용계약서 데이터
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/sourcinglist")
	private List<Map<String, Object>> viewsourcinglist(@RequestParam Map<String, Object> pMap){
		logger.info("viewsourcinglist요청");
		List<Map<String, Object>> sourcingList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("viewsourcinglist에 들어가는 : "+pMap);
		pMap.put("in_emp_no", pMap.get("emp_no"));
		sourcingList = personnelLogic.getSourcingList(pMap);
		logger.info(sourcingList);
		return sourcingList;
	}
	
	/**
	 * 부서 리스트
	 * @param pMap
	 * @param counts
	 * @return
	 */
	@RequestMapping("auth/deptlist/{counts}")
	private List<Map<String, Object>> deptList(@RequestParam Map<String, Object> pMap,@PathVariable int counts){
		logger.info("deptList요청");
		List<Map<String, Object>>deptList = null;
		pMap.put("counts", counts);
		deptList = personnelLogic.getdeptList(pMap);
		logger.info(deptList);
		return deptList;
	}
	
	
	/**
	 * 근무지 리스트
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/loclist")
	private List<Map<String, Object>> locList(@RequestParam Map<String, Object> pMap){
		logger.info("locList요청");
		List<Map<String, Object>>locList = null;
		System.out.println("locList에 들어가는 : "+pMap);
		locList = personnelLogic.getlocList(pMap);
		logger.info(locList);
		return locList;
	}
	
	/**
	 * 팀 리스트
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/teamlist")
	private List<Map<String, Object>> teamList(@RequestParam Map<String, Object> pMap){
		logger.info("deptList요청");
		List<Map<String, Object>>teamList = null;
		System.out.println("teamList에 들어가는 : "+pMap);
		teamList = personnelLogic.getTeamListView(pMap);
		logger.info(teamList);
		return teamList;
	}
	
	/**
	 * 직급 리스트
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/ctlev")
	private List<Map<String, Object>> levList(@RequestParam Map<String, Object> pMap){
		logger.info("levList요청");
		List<Map<String, Object>>levList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("levList에 들어가는 : "+pMap);
		levList = personnelLogic.getlevList(pMap);
		logger.info(levList);
		return levList;
	}
	
	
	
	
	@RequestMapping(value = "empList")
	public List<Map<String, Object>> per(@RequestParam Map<String, Object> pMap, Model mod, HttpServletResponse res) {
		logger.info(pMap);
		logger.info(pMap.get("name")+"\t"+pMap.get("lev_no")+"\t"+pMap.get("dept_no"));
		List<Map<String, Object>> getEmpList = null;
		getEmpList = personnelLogic.getEmpList(pMap);
		mod.addAttribute("getEmpList", getEmpList);
		return getEmpList;
	}
	
	
	
	

	
	
	////////////////급여 지급에서 쓰이는 부분/////////////
	
	
	/**
	 * 급여내역 json 요청
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value="/auth/salhistory")
	public Map<String,Object> salHistory(@RequestParam Map<String, Object> pMap) {
		logger.info("salHistory " + pMap);
		
		return personnelLogic.getSalHistory(pMap);
	}
}
