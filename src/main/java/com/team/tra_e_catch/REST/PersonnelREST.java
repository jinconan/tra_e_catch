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
	
	/*//�޿��������̺�URL(JSON)
		@RequestMapping(value="/salary/salaryjson")
		public String viewSalaryjson(@RequestParam Map<String, Object> pMap, Model mod, HttpServletResponse res) {
			//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
			//subMenuList : List<Map<String, Object>>
			//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
			//curSubMenu : String
			logger.info("viewSalaryjsonȣ��");
			List<Map<String, Object>> salList = null;
			salList = personnelLogic.getSalList(pMap,res);
			mod.addAttribute("getSalList", salList);
			return "per/salary/salaryjson";
		}
		//����ٵ�����(JSON)
		@RequestMapping(value="/attd/attdjson")
		public String viewAttdjson(@RequestParam Map<String, Object> pMap, Model mod, HttpServletResponse res) {
			//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
			//subMenuList : List<Map<String, Object>>
			//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
			//curSubMenu : String
			logger.info("viewAttdjsonȣ��");
			List<Map<String, Object>> attdList = null;
			attdList = personnelLogic.getAttdList(pMap,res);
			mod.addAttribute("getAttdList", attdList);
			return "per/attd/attdjson";
		}*/
	
}
