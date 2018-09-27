package com.team.tra_e_catch.REST;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("salary/{counts}")
	private List<Map<String, Object>> viewSalaryjson(@PathVariable int counts){
		logger.info("viewSalary��û");
		List<Map<String, Object>> salList = null;
		salList = personnelLogic.getSalList(counts);
		return salList;
	}
	
	@RequestMapping("attd/{counts}")
	private List<Map<String, Object>> viewAttdjson(@PathVariable int counts){
		logger.info("viewAttdjson��û");
		List<Map<String, Object>> attdList = null;
		attdList = personnelLogic.getAttdList(counts);
		return attdList;
	}
	
	@RequestMapping("rating/list")
	private List<Map<String, Object>> viewTeamjson(@RequestParam Map<String, Object> pMap){
		logger.info("viewTeamjson��û");
		List<Map<String, Object>> teamList = null;
		teamList = personnelLogic.getTeamList(pMap);
		logger.info(teamList);
		return teamList;
	}
	//���� �߱� ����
	@RequestMapping(value = "certlist")
	public List<Map<String, Object>> certlist(@RequestParam Map<String, Object> pMap) {
		logger.info(pMap);
		List<Map<String, Object>> getCertlist = null;
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
	public List<Map<String, Object>> indivEmpList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		indivList = personnelLogic.getindivList(pMap);
		
		return indivList;
	}
}
