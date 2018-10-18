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
 * Ŭ������ : 
 * �ۼ��� : 
 * ��¥ : 
 */


//������ �̵� ���� �������̽�
@RestController
@RequestMapping(value="/perR")
public class PersonnelREST {

	Logger logger = Logger.getLogger(PersonnelREST.class);
	@Autowired
	private PersonnelLogic personnelLogic = null;

	/**
	 * ��� ��Ȳ json ��û.
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
	 * ���� �߱� ����
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
	 * ���νŻ�����
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
	
	
	//���������̼� ó�� ���������� ����(���� > emp_no ���)
	// (���� > �α��ο� ���� ���� ��=emp_no�� ����)
	/**
	 * �޿� ���� json ��û
	 * @param counts
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("salary/{counts}")
	private List<Map<String, Object>> viewSalaryjson(@PathVariable int counts, @SessionAttribute("emp_no") int emp_no){
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		logger.info("viewSalaryjson��û : " + pMap);
		List<Map<String, Object>> salList = personnelLogic.getSalList(pMap);
		return salList;
	}
	
	/**
	 * ���� json ��û
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("rating/list")
	private List<Map<String, Object>> viewTeamjson(@RequestParam Map<String, Object> pMap
			, @SessionAttribute("emp_no") int emp_no){
		pMap.put("emp_no", emp_no);		
		logger.info("viewTeamjson��û : " + pMap);
		List<Map<String, Object>> teamList = personnelLogic.getTeamList(pMap);
		logger.info(teamList);
		return teamList;
	}
	
	/**
	 * �ٹ����� �Ⱓ�з�
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("rating/quar")
	private List<Map<String, Object>> quarList(@RequestParam Map<String, Object> pMap
			, @SessionAttribute("emp_no") int emp_no){
		pMap.put("emp_no", emp_no);
		logger.info("quarlist��û : " + pMap);
		List<Map<String, Object>> quarlist = personnelLogic.getQuarList(pMap);
		return quarlist;
	}
	
	/**
	 * �λ�����ǰ�
	 * @param pMap
	 * @param emp_no
	 * @return
	 */
	@RequestMapping("rating/leader")
	private List<Map<String, Object>> leaderView(@RequestParam Map<String, Object> pMap
			, @SessionAttribute("emp_no") int emp_no){
		pMap.put("emp_no", emp_no);
		logger.info("leaderView��û :" +pMap);
		List<Map<String, Object>>	leaderView = personnelLogic.getleaderView(pMap);
		return leaderView;
	}
	
	/**
	 * ������ ������
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/emplist")
	private List<Map<String, Object>> emplist(@RequestParam Map<String, Object> pMap){
		logger.info("emplist��û :" + pMap);
		List<Map<String, Object>> empList = personnelLogic.getEmpList(pMap);
		logger.info(empList);
		return empList;
	}	
	
	/**
	 * ���� ����Ʈ ������
	 * @param pMap
	 * @return
	 */
	@RequestMapping("lev/list")
	private List<Map<String, Object>> viewLevList(@RequestParam Map<String, Object> pMap){
		logger.info("viewLevList��û");
		List<Map<String, Object>> levList = null;
		levList = personnelLogic.getlevlist(pMap);
	
		return levList;
	}
	/**
	 * ���� ����Ʈ ������
	 * @param pMap
	 * @return
	 */
	@RequestMapping("loc/list")
	private List<Map<String, Object>> viewLocList(@RequestParam Map<String, Object> pMap){
		logger.info("viewLocList��û");
		List<Map<String, Object>> locList = null;
		locList = personnelLogic.getLocList(pMap);
		return locList;
	}
	
	/**
	 * �μ� ����Ʈ ������
	 * @param pMap
	 * @return
	 */
	@RequestMapping("dept/list")
	private List<Map<String, Object>> viewDeptList(@RequestParam Map<String, Object> pMap){
		logger.info("viewDeptList��û");
		List<Map<String, Object>> deptList = null;
		deptList = personnelLogic.getDeptList(pMap);
		return deptList;
	}
	
	/**
	 * ����༭���νŻ�����
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value = "/auth/indivemplist")
	public List<Map<String, Object>> indivEmplist2(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		logger.info("����༭�� ������ and �λ�߷ɿ� ������" + pMap);
		indivList = personnelLogic.getindivList(pMap);
		logger.info("����༭�� ������" + indivList);
		return indivList;
	}
	@RequestMapping(value = "/auth/contlist")
	public List<Map<String, Object>> contlist(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		logger.info("����༭�� ������ and �λ�߷ɿ� ������" + pMap);
		indivList = personnelLogic.getindivlist(pMap);
		logger.info("����༭�� ������" + indivList);
		return indivList;
	}
	
	/**
	 * �ٷΰ�༭ ������
	 * @param pMap
	 * @return
	 */
	@RequestMapping("/auth/worklist")
	private List<Map<String, Object>> viewWorklist(@RequestParam Map<String, Object> pMap){
		logger.info("viewWorklist��û");
		List<Map<String, Object>> workList = null;
/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		pMap.put("in_emp_no", pMap.get("emp_no"));
		logger.info("viewWorklist�� ���� : "+pMap);
		workList = personnelLogic.getWorkList(pMap);
		return workList;
	}
	
	/**
	 * ����༭ ������
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/sourcinglist")
	private List<Map<String, Object>> viewsourcinglist(@RequestParam Map<String, Object> pMap){
		logger.info("viewsourcinglist��û");
		List<Map<String, Object>> sourcingList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("viewsourcinglist�� ���� : "+pMap);
		pMap.put("in_emp_no", pMap.get("emp_no"));
		sourcingList = personnelLogic.getSourcingList(pMap);
		logger.info(sourcingList);
		return sourcingList;
	}
	
	/**
	 * �μ� ����Ʈ
	 * @param pMap
	 * @param counts
	 * @return
	 */
	@RequestMapping("auth/deptlist/{counts}")
	private List<Map<String, Object>> deptList(@RequestParam Map<String, Object> pMap,@PathVariable int counts){
		logger.info("deptList��û");
		List<Map<String, Object>>deptList = null;
		pMap.put("counts", counts);
		deptList = personnelLogic.getdeptList(pMap);
		logger.info(deptList);
		return deptList;
	}
	
	
	/**
	 * �ٹ��� ����Ʈ
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/loclist")
	private List<Map<String, Object>> locList(@RequestParam Map<String, Object> pMap){
		logger.info("locList��û");
		List<Map<String, Object>>locList = null;
		System.out.println("locList�� ���� : "+pMap);
		locList = personnelLogic.getlocList(pMap);
		logger.info(locList);
		return locList;
	}
	
	/**
	 * �� ����Ʈ
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/teamlist")
	private List<Map<String, Object>> teamList(@RequestParam Map<String, Object> pMap){
		logger.info("deptList��û");
		List<Map<String, Object>>teamList = null;
		System.out.println("teamList�� ���� : "+pMap);
		teamList = personnelLogic.getTeamListView(pMap);
		logger.info(teamList);
		return teamList;
	}
	
	/**
	 * ���� ����Ʈ
	 * @param pMap
	 * @return
	 */
	@RequestMapping("auth/ctlev")
	private List<Map<String, Object>> levList(@RequestParam Map<String, Object> pMap){
		logger.info("levList��û");
		List<Map<String, Object>>levList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("levList�� ���� : "+pMap);
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
	
	
	
	

	
	
	////////////////�޿� ���޿��� ���̴� �κ�/////////////
	
	
	/**
	 * �޿����� json ��û
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value="/auth/salhistory")
	public Map<String,Object> salHistory(@RequestParam Map<String, Object> pMap) {
		logger.info("salHistory " + pMap);
		
		return personnelLogic.getSalHistory(pMap);
	}
}
