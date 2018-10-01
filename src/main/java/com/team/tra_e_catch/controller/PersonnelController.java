package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Locale;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	////////////////////////////////������ �ۼ�///////////////////////////////////////
	// �޿�����
	@RequestMapping(value = "/salary/{counts}", method = RequestMethod.GET)
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts, HttpServletRequest req) {
		logger.info("salaryȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�޿�����");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		HttpSession session= req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		System.out.println("������ ��� : "+emp_no);
		System.out.println("pMap�� ���°͵�?: "+pMap);
		System.out.println("counts?: "+counts);
		return "per/salary/salary";
	}

	// ����ٰ���
	@RequestMapping(value = "/attd/{counts}")
	public String viewAttd(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("viewAttdȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// ���� ���� ����޴�

		mod.addAttribute("curSubMenu", "����ٰ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_attenList";

	}

	// �λ��� ����
	@RequestMapping(value = "/rating/perrating", method = RequestMethod.GET)
	public String viewRating(@RequestParam Map<String, Object> pMap, Model mod) {
		// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		// curSubMenu : String
		logger.info("viewRatingȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/rating/perrating";
	}

	// ��ȼ��� �ӽ�����
	@RequestMapping(value = "/rating/testform", method = RequestMethod.GET)
	public String formTest(@RequestParam Map<String, Object> pMap, Model mod) {
		// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		// curSubMenu : String
		logger.info("viewRatingȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ�޴�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/testform";

	}

	// ��������
	@RequestMapping(value = "/attd/leave", method = RequestMethod.GET)
	public String attLeave(@RequestParam Map<String, Object> pMap, Model mod) {
		// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		// curSubMenu : String
		logger.info("attLeaveȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// ���� ���� ����޴�
																											// ȣ��
		mod.addAttribute("curSubMenu", "��������");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_leaveList";

	}

	// ��������
	@RequestMapping(value = "/cert/cert", method = RequestMethod.GET)
	public String certList(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("certListȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// ���� ����
																											// ����޴�
		mod.addAttribute("curSubMenu", "�����߱�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";

	}
	@RequestMapping(value = "/cert/certprint", method = RequestMethod.POST)
	public String certPrint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("certListȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// ���� ����
		mod.addAttribute("curSubMenu", "�����߱�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_printList";

	}


	// �������� ��� ������
	@RequestMapping(value = "/cert/certform", method = RequestMethod.POST)
	public String serform(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("certPrintListȣ��");
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		return "per/cert/certform";
	}

	// ������� ��� ������
	@RequestMapping(value = "/cert/careercert", method = RequestMethod.POST)
	public String careercert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("certPrintListȣ��");
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		return "per/cert/careercert";
	}

	// ������ ��� ������
	@RequestMapping(value = "/cert/retireform", method = RequestMethod.POST)
	public String retirecert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		// curSubMenu : String
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		logger.info("certPrintListȣ��");
		return "per/cert/retireform";
	}

	// �ø��� ��� ������
	@RequestMapping(value = "/cert/reasonform", method = RequestMethod.POST)
	public String reasoncert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		// ��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		// curSubMenu : String
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		logger.info("certPrintListȣ��");
		return "per/cert/reasonform";
	}

	// ���� ������ �Է�
	@RequestMapping(value = "/rating/servrating")
	public String sendRating(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {

		logger.info("sendRatingȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ���");
		mod.addAttribute("subMenuList", subMenuList);
		List<Map<String, Object>> servList = null;
		HttpSession session = req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);
		servList = personnelLogic.setServrating(pMap);
		
		return "per/rating/perrating";
	}

	
	@RequestMapping(value = "/attdinsert")
	public String attdInsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("attdInsertȣ��");
		List<Map<String, Object>> attdinfo = null;
		HttpSession session= req.getSession();
		int emp_no = (int)session.getAttribute("emp_no");
		pMap.put("emp_no", emp_no);
		attdinfo = personnelLogic.setAttdInsert(pMap);
		
		return "home";
	}

////////////////////////////////������ �ۼ� �� ///////////////////////////////////////		
	
	
	@RequestMapping(value = "/empinsert")
		public String empInsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("empInsertȣ��");
		List<Map<String, Object>> empinsert = null;
		System.out.println("������� : "+pMap);
		/*attdinfo = personnelLogic.setAttdInsert(pMap);*/
		empinsert = personnelLogic.EmpInsert(pMap);
		return "per/onlyauthper/empRegist";
	}
	// ������
	@RequestMapping(value = "/empList")
	public String per(@RequestParam Map<String, Object> pMap, Model mod, HttpServletResponse res) {
		logger.info("Welcome home! The client locale is1");

		logger.info(pMap);
		logger.info(pMap.get("name") + "\t" + pMap.get("lev-no") + "\t" + pMap.get("dept-no"));
		System.out.print(pMap.get("name"));
		String a = (String) pMap.get("lev-no");
		System.out.println(a);
		try {
			List<Map<String, Object>> getEmpList = null;
			getEmpList = personnelLogic.getEmpList(pMap, res);
			mod.addAttribute("getEmpList", getEmpList);
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
			mod.addAttribute("subMenuList", subMenuList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "per/onlyauthper/emplist";
	}

	// ������ �˻� ���̺�
	@RequestMapping(value = "/emptable", method = RequestMethod.GET)
	public String pertable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/emptable";
	}

	@RequestMapping(value = "/empRegist", method = RequestMethod.GET)
	public String perRegist(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��� ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empRegist";
	}

	// �ٷΰ�༭ ����
	@RequestMapping(value = "/labcont", method = RequestMethod.GET)
	public String labcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}

	// �ٷΰ�༭ �˻� ���̺�
	@RequestMapping(value = "/labtable", method = RequestMethod.POST)
	public String labtable(@RequestParam Map<String, Object> pMap) {
		logger.info("labtableȣ��");
		System.out.print(pMap);
		
		return "per/onlyauthper/lablist";
	}

	// ����༭ ��ȸ
	@RequestMapping(value = "/empcont", method = RequestMethod.GET)
	public String empcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}

	// �ٷΰ�༭ ��ȸ ���̺�
	@RequestMapping(value = "/empconttable", method = RequestMethod.GET)
	public String empconttable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/empconttable";
	}

}
