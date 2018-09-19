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

	Logger logger = Logger.getLogger(AccountingREST.class);
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
	
	
}
