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
	
	
		/*
		 * init�޼��� : 
		 * out������ : 
		 * �뵵 : 
		 * ��� : 
		 */
	
	// ����
	/*
	@RequestMapping("")
	private List<Map<String, Object>> team() {
		logger.info("����");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic();
		return as;
	}*/
	//���������̼� ó�� ���������� ����(���� > emp_no ���)
	//(���� > �α��ο� ���� ���� ��=emp_no�� ����)
	@RequestMapping("salary/{counts}")
	private List<Map<String, Object>> viewSalaryjson(@PathVariable int counts, HttpServletRequest req){
		logger.info("viewSalary��û");
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
		logger.info("viewAttdjson��û");
		List<Map<String, Object>> attdList = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		attdList = personnelLogic.getAttdList(pMap);
		return attdList;
	}
	
	@RequestMapping("rating/list")
	private List<Map<String, Object>> viewTeamjson(@RequestParam Map<String, Object> pMap, HttpServletRequest req){
		logger.info("viewTeamjson��û");
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
		logger.info("viewLevList��û");
		List<Map<String, Object>> levList = null;
		levList = personnelLogic.getlevlist(pMap);
	
		return levList;
	}
	@RequestMapping("loc/list")
	private List<Map<String, Object>> viewLocList(@RequestParam Map<String, Object> pMap){
		logger.info("viewLocList��û");
		List<Map<String, Object>> locList = null;
		locList = personnelLogic.getLocList(pMap);
	
		return locList;
	}
	@RequestMapping("dept/list")
	private List<Map<String, Object>> viewDeptList(@RequestParam Map<String, Object> pMap){
		logger.info("viewDeptList��û");
		List<Map<String, Object>> deptList = null;
		deptList = personnelLogic.getDeptList(pMap);
	
		return deptList;
	}
	
	
	//���� �߱� ����
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
	@RequestMapping(value = "empList")
	public List<Map<String, Object>> per(@RequestParam Map<String, Object> pMap, Model mod, HttpServletResponse res) {
		logger.info("Welcome home! The client locale is1");
		logger.info(pMap);
		logger.info(pMap.get("name")+"\t"+pMap.get("lev_no")+"\t"+pMap.get("dept_no"));
		List<Map<String, Object>> getEmpList = null;
		getEmpList = personnelLogic.getEmpList(pMap,res);
		mod.addAttribute("getEmpList", getEmpList);
		return getEmpList;
	}
	
	//���νŻ�����
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
