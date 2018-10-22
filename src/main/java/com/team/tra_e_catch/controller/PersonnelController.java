package com.team.tra_e_catch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.team.tra_e_catch.personnel.PersonnelLogic;

@Controller
@RequestMapping(value = "/per")
public class PersonnelController {

	@Autowired
	private PersonnelLogic personnelLogic = null;
	/*
	 * @Autowired�� ����ϸ� setter�޼ҵ忡 ���� �̸��� �ݵ�� Ŭ���� �̸��� ��ġ��ų��. ���� setter��ü ���Թ��� ����ϴ�
	 * ����� �����ڰ� �� �̸��� xml������ ����� �� ������
	 * 
	 * @Autowired�� ����� �� xml������ �߰� �����ü�� �ʿ���� ������.
	 */
	private static final Logger logger = Logger.getLogger(PersonnelController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/personnel-submenu.xml");

	//////////////////////////////// ������ �ۼ�///////////////////////////////////////
	/**
	 * ����ٰ���
	 * 
	 * @param pMap
	 * @param mod
	 * @param counts
	 * @return
	 */
	@RequestMapping(value = "/attd/{counts}")
	public String viewAttd(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("viewAttdȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// ���� ���� ����޴�
		mod.addAttribute("curSubMenu", "����ٰ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_attenList";

	}

	/**
	 * ��������
	 * 
	 * @param mod
	 * @param pMap
	 * @param count
	 * @return
	 */
	@RequestMapping(value = "/leave/{count}", method = RequestMethod.GET)
	public String attLeave(Model mod
			, @SessionAttribute("emp_no") int eno
			, @RequestParam Map<String, Object> pMap
			, @PathVariable("count") int count) {
		logger.info("attLeaveȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// ���� ���� ����޴�
																											// ȣ��
		mod.addAttribute("curSubMenu", "��������");
		mod.addAttribute("subMenuList", subMenuList);
		
		pMap = new HashMap<String, Object>();
		pMap.put("eno", eno);
		mod.addAttribute("remainLeave", personnelLogic.getRemainLeave(pMap));
		return "per/attd/attd_leaveList";

	}

	/**
	 * ���� ����
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/cert", method = RequestMethod.GET)
	public String certList(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("certListȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// ���� ����
																											// ����޴�
		mod.addAttribute("curSubMenu", "�����߱�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";

	}

	/**
	 * �������� ��� ������
	 * 
	 * @param pMap
	 * @param mod
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/cert/certform", method = RequestMethod.POST)
	public String serform(@RequestParam Map<String, Object> pMap, Model mod, @SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);
		logger.info("serformȣ�� :" + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/certform";
	}
	@RequestMapping(value = "/ratingstart")
	public String ratingstart(@RequestParam Map<String, Object> pMap, Model mod, @SessionAttribute("emp_no") int emp_no) {
		logger.info("ratingstartȣ�� :" + pMap);
		personnelLogic.ratingstart(pMap);
		return "home";
		
	}

	/**
	 * ������� ��� ������
	 * 
	 * @param pMap
	 * @param mod
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/cert/careercert", method = RequestMethod.POST)
	public String careercert(@RequestParam Map<String, Object> pMap, Model mod,
			@SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);
		logger.info("certPrintListȣ�� :" + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/careercert";
	}

	/**
	 * ������ ��� ������
	 * 
	 * @param pMap
	 * @param mod
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/cert/retireform", method = RequestMethod.POST)
	public String retirecert(@RequestParam Map<String, Object> pMap, Model mod,
			@SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);
		logger.info("certPrintListȣ�� : " + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/retireform";
	}

	/**
	 * �ø��� ��� ������
	 * 
	 * @param pMap
	 * @param mod
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/cert/reasonform", method = RequestMethod.POST)
	public String reasoncert(@RequestParam Map<String, Object> pMap, Model mod,
			@SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);
		logger.info("certPrintListȣ�� : " + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/reasonform";
	}

	/**
	 * ���� ��� ���� ���̺� ��û
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/cert/certprint", method = RequestMethod.POST)
	public String certPrint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("certListȣ�� : " + pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// ���� ����
		mod.addAttribute("curSubMenu", "�����߱�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_printList";

	}

	/**
	 * �޿����޳��� ������ ��û
	 * 
	 * @param pMap
	 * @param mod
	 * @param counts
	 * @return
	 */
	@RequestMapping(value = "/salary/{counts}", method = RequestMethod.GET)
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("salaryȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�޿����޳���");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		return "per/salary/salary";
	}

	/**
	 * �λ��� ����
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/rating/perrating", method = RequestMethod.GET)
	public String viewRating(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("viewRatingȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/rating/perrating";
	}

	/**
	 * ���� ������ �Է�
	 * 
	 * @param pMap
	 * @param mod
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/rating/servrating")
	public String sendRating(@RequestParam Map<String, Object> pMap, Model mod,
			@SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);
		logger.info("sendRatingȣ�� :" + pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ���");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.insertServrating(pMap);
		return "redirect:/per/rating/perrating";
	}

	/**
	 * ������
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empList")
	public String perEmpList(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("emplistȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��� ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/emplist";
	}

	/**
	 * ��� ���
	 * 
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empRegist", method = RequestMethod.GET)
	public String perRegist(Model mod) {
		logger.info("empRegist");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��� ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empRegist";
	}

	/**
	 * ��� ��� ���� ��û
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empInsert")
	public String empInsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("empInsertȣ�� :" + pMap);
		/* attdinfo = personnelLogic.setAttdInsert(pMap); */
		int result = personnelLogic.insertEmp(pMap);
		mod.addAttribute("result", result);
		return "redirect:/per/auth/empRegist";
	}

	/**
	 * �ٷΰ�༭ ����
	 * 
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/labcont")
	public String labcont(Model mod) {
		logger.info("labcontȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�ٷΰ�༭ ����");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}

	/**
	 * �ٷΰ�༭
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value = "/auth/labtable")
	public String labtable(@RequestParam Map<String, Object> pMap) {
		logger.info("labtableȣ�� :"+pMap);
		return "per/onlyauthper/lablist";
	}

	/**
	 * �ٷΰ�༭ ���
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/labcont/insert")
	public String labcontinsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("labcontinsertȣ�� :"+pMap);
		int result = personnelLogic.insertLab(pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}
	
	/**
	 * �ٷΰ�༭ ��
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/wordprint")
	public String wordprint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("wordprintȣ�� :" + pMap);
		List<Map<String, Object>> getEmpList = personnelLogic.getindivList(pMap);
		logger.info("�ٷΰ�༭ ���� : " + getEmpList);
		mod.addAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
		return "per/onlyauthper/printform";
	}
	//����༭ �� 
	@RequestMapping(value = "/auth/contprint")
	public String contprint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("contprintȣ�� :" + pMap);
		List<Map<String, Object>> getEmpList = personnelLogic.getindivlist(pMap);
		logger.info("����༭ ���� : " + getEmpList);
		mod.addAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
		return "per/onlyauthper/contform";
	}
	
	/**
	 * ����༭ ����ȭ��
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empcont")
	public String empcont(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("����༭ ��ȸ");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "����༭ ����");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}

	/**
	 * ����༭ ��ȸ ���̺�
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/auth/empconttable")
	public String empconttable(Model model) {
		return "per/onlyauthper/empconttable";
	}
	
	/**
	 * ����༭ ���
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/sourcing/insert")
	public String empsourcinginsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("empsourcinginsertȣ��" + pMap);
		int result = personnelLogic.insertEmpSourcing(pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}
	
	/**
	 * �μ����� ����
	 * @param pMap
	 * @param counts
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/deptupdatelist/{counts}")
	public String deptupdatelist(@RequestParam Map<String, Object> pMap, @PathVariable int counts, Model mod) {
		logger.info("deptupdatelistȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("counts", counts);
		mod.addAttribute("curSubMenu", "�μ�����");
		mod.addAttribute("subMenuList", subMenuList);

		return "per/onlyauthper/deptinsert";
	}
	
	/**
	 * �μ����� �μ�Ʈ
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/deptinsert")
	public String deptinsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("deptinsertȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�μ�����");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.insertDept(pMap);
		return "redirect:/per/auth/deptupdatelist/1";
	}
	
	/**
	 * �μ����� ��������
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/deptupdate")
	public String deptUpdate(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("deptUpdateȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�μ�����");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.updateDept(pMap);
		return "redirect:/per/auth/deptupdatelist/1";
	}
	
	/**
	 * �λ�߷� ����
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empupdate")
	public String empUpdate(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("empUpdateȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�λ����� ����");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empupdate";
	}

	/**
	 * �λ������������̺�
	 * @param mod
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value = "/auth/empupdatetable")
	public String empupdatetable(Model mod, @RequestParam Map<String, Object> pMap) {
		mod.addAttribute("emp_no", pMap.get("emp_no"));
		logger.info(pMap.get("emp_no"));
		return "per/onlyauthper/updatetable";
	}
	
	/**
	 * �λ�߷����� ����
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empupdateaccept")
	public String empupdateaccept(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("sendRatingȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�λ����� ����");
		mod.addAttribute("subMenuList", subMenuList);
		System.out.println("�λ�߷� �������� : " + pMap);
		int result = personnelLogic.updateEmployee(pMap);
		return "redirect:/per/auth/empupdate";
	}

	/**
	 * ������ �μ�Ʈ
	 * @param pMap
	 * @param mod
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/auth/teaminsert")
	public String teamInsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("deptinsertȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�μ�����");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.insertTeam(pMap);
		return "per/onlyauthper/deptinsert";
	}

	@RequestMapping(value = "/attdinsert")
	public String attdInsert(@RequestParam Map<String, Object> pMap, Model mod, @SessionAttribute("emp_no") int emp_no) {
		logger.info("attdInsertȣ��");
		List<Map<String, Object>> attdinfo = null;
		pMap.put("emp_no", emp_no);
		attdinfo = personnelLogic.setAttdInsert(pMap);

		return "redirect:/per/attd/1";
	}

////////////////////////////////������ �ۼ� �� ///////////////////////////////////////		

	////////////// �޿� ����////////////////
	/**
	 * �޿����� ������ ��û
	 * 
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empSal")
	public String viewEmpSal(Model mod, HttpServletRequest req) {
		logger.info("viewEmpSal ");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��� �޿�����");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);

		return "per/onlyauthper/empSal";

	}

	/**
	 * �޿� ���� ��û
	 * 
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value = "/auth/salaryInsert", method = RequestMethod.POST)
	public String salaryInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("salaryInsert " + pMap);
		personnelLogic.insertSalary(pMap);
		return "redirect:/per/auth/empSal";
	}

	@RequestMapping(value = "/auth/empSalUpdate", method = RequestMethod.POST)
	public String empSalaryUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("empSalaryUpdate " + pMap);
		personnelLogic.updateSalary(pMap);
		return "redirect:/per/auth/empSal";
	}
}
