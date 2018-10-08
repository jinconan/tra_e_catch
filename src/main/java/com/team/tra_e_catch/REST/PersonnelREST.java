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
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
				Map<String, Object> pMap = new HashMap<>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		salList = personnelLogic.getSalList(pMap);
	
		return salList;
	}
	
	@RequestMapping("only/loclist")//�ٹ��� ����Ʈ
	private List<Map<String, Object>> locList(@RequestParam Map<String, Object> pMap){
		logger.info("locList��û");
		List<Map<String, Object>>locList = null;
		System.out.println("locList�� ���� : "+pMap);
		locList = personnelLogic.getlocList(pMap);
		logger.info(locList);
		return locList;
	}
	
	@RequestMapping("only/deptlist/{counts}")//�μ� ����Ʈ
	private List<Map<String, Object>> deptList(@RequestParam Map<String, Object> pMap,@PathVariable int counts){
		logger.info("deptList��û");
		List<Map<String, Object>>deptList = null;
		pMap.put("counts", counts);
		deptList = personnelLogic.getdeptList(pMap);
		logger.info(deptList);
		return deptList;
	}
	@RequestMapping("only/teamlist")//�� ����Ʈ
	private List<Map<String, Object>> teamList(@RequestParam Map<String, Object> pMap){
		logger.info("deptList��û");
		List<Map<String, Object>>teamList = null;
		System.out.println("teamList�� ���� : "+pMap);
		teamList = personnelLogic.getTeamListView(pMap);
		logger.info(teamList);
		return teamList;
	}
	
	@RequestMapping("only/ctlev")//���� ����Ʈ
	private List<Map<String, Object>> levList(@RequestParam Map<String, Object> pMap){
		logger.info("levList��û");
		List<Map<String, Object>>levList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("levList�� ���� : "+pMap);
		levList = personnelLogic.getlevList(pMap);
		logger.info(levList);
		return levList;
	}
	
	
	@RequestMapping("only/emplist")//������ ������
	private List<Map<String, Object>> emplist(@RequestParam Map<String, Object> pMap){
		logger.info("emplist��û");
		List<Map<String, Object>>empList = null;
		/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		System.out.println("empList�� ���� : "+pMap);
		empList = personnelLogic.getEmpList(pMap);
		logger.info(empList);
		return empList;
	}
	@RequestMapping("attd/{counts}")
	private List<Map<String, Object>> viewAttdjson(@PathVariable int counts, HttpServletRequest req){
		logger.info("viewAttdjson��û");
		List<Map<String, Object>> attdList = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("counts", counts);
		pMap.put("emp_no", emp_no);
		attdList = personnelLogic.getAttdList(pMap);
		return attdList;
	}

	@RequestMapping("only/worklist")//�ٷΰ�༭ ������
	private List<Map<String, Object>> viewWorklist(@RequestParam Map<String, Object> pMap){
		logger.info("viewWorklist��û");
		List<Map<String, Object>> workList = null;
/*		pMap.put("emp_no", req.getParameter("emp_no").toString());*/
		
		pMap.put("in_emp_no", pMap.get("emp_no"));
		System.out.println("viewWorklist�� ���� : "+pMap);
		workList = personnelLogic.getWorkList(pMap);
		return workList;
	}
	@RequestMapping("only/sourcinglist")//����༭ ������
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
	
	@RequestMapping("rating/list")
	private List<Map<String, Object>> viewTeamjson(@RequestParam Map<String, Object> pMap, HttpServletRequest req){
		logger.info("viewTeamjson��û");
		List<Map<String, Object>> teamList = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
		getEmpList = personnelLogic.getEmpList(pMap);
		mod.addAttribute("getEmpList", getEmpList);
		return getEmpList;
	}
	
	//���νŻ�����
	@RequestMapping(value = "indivemp")
	public List<Map<String, Object>> indivEmpList(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		List<Map<String, Object>> indivList = null;
		System.out.println(pMap);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		indivList = personnelLogic.getindivList(pMap);
		
		return indivList;
	}
	//����༭���νŻ�����
	@RequestMapping(value = "indivemplist")
	public List<Map<String, Object>> indivEmplist2(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		List<Map<String, Object>> indivList = null;
		System.out.println("����༭�� ������ and �λ�߷ɿ� ������"+pMap);
		
		indivList = personnelLogic.getindivList(pMap);
		System.out.println("����༭�� ������"+indivList);
		return indivList;
	}
	
	@RequestMapping("rating/quar")//�ٹ����� �Ⱓ�з�
	private List<Map<String, Object>> quarList(@RequestParam Map<String, Object> pMap, HttpServletRequest req){
		logger.info("quarlist��û");
		List<Map<String, Object>>	quarlist = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		System.out.println("quarlist����� emp_no : "+pMap);
		quarlist = personnelLogic.getQuarList(pMap);
		
		return quarlist;
	}
	@RequestMapping("rating/leader")//�ٹ����� �Ⱓ�з�
	private List<Map<String, Object>> leaderView(@RequestParam Map<String, Object> pMap, HttpServletRequest req){
		logger.info("leaderView��û");
		List<Map<String, Object>>	leaderView = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		System.out.println("����ִ°� : "+pMap);
		leaderView = personnelLogic.getleaderView(pMap);
		
		return leaderView;
	}
	
	
	
	
	////////////////�޿� ���޿��� ���̴� �κ�/////////////
	
	
	/**
	 * �޿����� json ��û
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value="salhistory")
	public Map<String,Object> salHistory(@RequestParam Map<String, Object> pMap) {
		logger.info("salHistory " + pMap);
		
		return personnelLogic.getSalHistory(pMap);
	}
}
