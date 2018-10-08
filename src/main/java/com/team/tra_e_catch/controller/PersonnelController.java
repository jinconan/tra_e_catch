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
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
	//�λ�߷� ����
	@RequestMapping(value = "/onlyauthper/empupdate")
	public String empUpdate(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("empUpdateȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�λ����� ����");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		
		return "per/onlyauthper/empupdate";
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
		logger.info("serformȣ��");
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		servList = personnelLogic.setServrating(pMap);
		
		return "per/rating/perrating";
	}
	
	// �λ�߷����� ����
		@RequestMapping(value = "/onlyauthper/empupdateaccept")
		public String empupdateaccept(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
			logger.info("sendRatingȣ��");
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "�λ����� ����");
			mod.addAttribute("subMenuList", subMenuList);
			List<Map<String, Object>> empupdateList = null;
			System.out.println("�λ�߷� �������� : "+pMap);
			empupdateList = personnelLogic.updateEmployee(pMap);
			
			
			
			return "per/onlyauthper/empupdate";
		}
		
		// �μ����� ����
				@RequestMapping(value = "/onlyauthper/deptupdatelist/{counts}")
				public String deptupdatelist(@RequestParam Map<String, Object> pMap,@PathVariable int counts, Model mod, HttpServletRequest req) {
					logger.info("deptupdatelistȣ��");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					HttpSession session = req.getSession();
					String semp_no = String.valueOf(session.getAttribute("emp_no"));
					int emp_no = Integer.parseInt(semp_no);			
					mod.addAttribute("counts", counts);
					mod.addAttribute("curSubMenu", "�μ�����");
					mod.addAttribute("subMenuList", subMenuList);
				
					return "per/onlyauthper/deptinsert";
				}
				
				// �μ����� ��������
				@RequestMapping(value = "/onlyauthper/deptupdate")
				public String deptUpdate(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
					logger.info("deptUpdateȣ��");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					mod.addAttribute("curSubMenu", "�μ�����");
					mod.addAttribute("subMenuList", subMenuList);
					List<Map<String, Object>> deptupdateinfo = null;
					deptupdateinfo = personnelLogic.deptUpdate(pMap);
					return "per/onlyauthper/deptinsert";
				}
				
				
				// �μ����� �μ�Ʈ
				@RequestMapping(value = "/onlyauthper/deptinsert")
				public String deptinsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
					logger.info("deptinsertȣ��");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					mod.addAttribute("curSubMenu", "�μ�����");
					mod.addAttribute("subMenuList", subMenuList);
					List<Map<String, Object>> deptinsertinfo = null;
					deptinsertinfo = personnelLogic.deptInsert(pMap);
					return "per/onlyauthper/deptinsert";
				}
				// ������ �μ�Ʈ
				@RequestMapping(value = "/onlyauthper/teaminsert")
				public String teamInsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
					logger.info("deptinsertȣ��");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					mod.addAttribute("curSubMenu", "�μ�����");
					mod.addAttribute("subMenuList", subMenuList);
					List<Map<String, Object>> teaminsertinfo = null;
					teaminsertinfo = personnelLogic.teamInsert(pMap);
					return "per/onlyauthper/deptinsert";
				}
	
	@RequestMapping(value = "/attdinsert")
	public String attdInsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("attdInsertȣ��");
		List<Map<String, Object>> attdinfo = null;
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
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
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		empinsert = personnelLogic.EmpInsert(pMap);
		return "per/onlyauthper/empRegist";
	}
	// ������
		@RequestMapping(value = "/empList")
		public String perEmpList(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
			logger.info("emplistȣ��");
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "��� ���");
			mod.addAttribute("subMenuList", subMenuList);
			HttpSession session= req.getSession();
			String semp_no = String.valueOf(session.getAttribute("emp_no"));
			int emp_no = Integer.parseInt(semp_no);
			return "per/onlyauthper/emplist";
		}

		// ������ �˻� ���̺�
		@RequestMapping(value = "/emptable", method = RequestMethod.GET)
		public String pertable(@RequestParam Map<String, Object> pMap, Model mod) {
			logger.info("������ �˻� ���̺�");
			System.out.println(pMap);
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
	@RequestMapping(value = "/labcont")
	public String labcont(Locale locale, Model mod, HttpServletRequest req) {
		logger.info("labcontȣ��");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "�ٷΰ�༭ ����");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);		
		return "per/onlyauthper/labcont";
	}
	//����༭ ��
	@RequestMapping(value = "/onlyauthper/wordprint")
	public String wordprint(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		logger.info("wordprintȣ��");
		System.out.print("����� ��"+pMap);
		List<Map<String, Object>> getEmpList = null;
		getEmpList = personnelLogic.getindivList(pMap);
		System.out.println("����༭ ���� : "+getEmpList);
		req.setAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
		return "per/onlyauthper/printform";
	}
	//�ٷΰ�༭
	@RequestMapping(value = "/labtable")
	public String labtable(@RequestParam Map<String, Object> pMap) {
		logger.info("labtableȣ��");
		System.out.println(pMap);//���������� emp_no�� �������.
		return "per/onlyauthper/lablist";
	}
	//�ٷΰ�༭ ���
	@RequestMapping(value = "/labcont/insert")
	public String labcontinsert(@RequestParam Map<String, Object> pMap) {
		logger.info("labcontinsertȣ��");
		System.out.println(pMap);//���������� emp_no�� �������.
		List<Map<String, Object>> labinsert = null;
		System.out.println(pMap);
		labinsert = personnelLogic.labInsert(pMap);
		return "per/onlyauthper/labcont";
	}

	//����༭ ���
		@RequestMapping(value = "/sourcing/insert")
		public String empsourcinginsert(@RequestParam Map<String, Object> pMap,Model mod, HttpServletRequest req) {
			logger.info("empsourcinginsertȣ��");
			System.out.println(pMap);//���������� emp_no�� �������.
			List<Map<String, Object>> sourcinginsert = null;
			System.out.println(pMap);
			sourcinginsert = personnelLogic.empsourcingInsert(pMap);
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			
			HttpSession session= req.getSession();
			String semp_no = String.valueOf(session.getAttribute("emp_no"));
			int emp_no = Integer.parseInt(semp_no);		
			mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
			mod.addAttribute("subMenuList", subMenuList);
			return "per/onlyauthper/empcont";
		}

		// ����༭ ����ȭ��
		@RequestMapping(value = "/empcont")
		public String empcont(@RequestParam Map<String, Object> pMap, Model mod) {
			logger.info("����༭ ��ȸ");
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "����༭");
			mod.addAttribute("subMenuList", subMenuList);
			return "per/onlyauthper/empcont";
		}
		
	// �ٷΰ�༭ ��ȸ ���̺�
	@RequestMapping(value = "/empconttable")
	public String empconttable(Locale locale, Model model) {
		return "per/onlyauthper/empconttable";
	}
	
	// �λ������������̺�
	@RequestMapping(value = "/empupdatetable")
	public String empupdatetable(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		req.setAttribute("emp_no", pMap.get("emp_no"));
		System.out.println(pMap.get("emp_no"));
		return "per/onlyauthper/updatetable";
	}
		
	////////////// �޿� ����////////////////
	/**
	 * �޿����� ������ ��û
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/onlyauthper/empSal")
	public String viewEmpSal(Model mod, HttpServletRequest req) {
		logger.info("viewEmpSal ");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��� �޿�����");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);

		return "per/onlyauthper/empSal";

	}	
		
	/**
	 * �޿� ���� ��û
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value="/salaryInsert", method=RequestMethod.POST)
	public String salaryInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("salaryInsert "+pMap);
		personnelLogic.insertSalary(pMap);
		return "redirect:/per/onlyauthper/empSal";
	}
	
	@RequestMapping(value="/empSalUpdate", method=RequestMethod.POST)
	public String empSalaryUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("empSalaryUpdate "+pMap);
		personnelLogic.updateSalary(pMap);
		return "redirect:/per/onlyauthper/empSal";
	}
}
