package com.team.tra_e_catch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.tra_e_catch.personnel.PersonnelLogic;


@Controller
public class PersonnelController {
	@Autowired
	private PersonnelLogic personnelLogic = null;
	/*@Autowired�� ����ϸ� setter�޼ҵ忡 ���� �̸��� �ݵ�� Ŭ���� �̸��� ��ġ��ų��.
	 * ���� setter��ü ���Թ��� ����ϴ� ����� �����ڰ� �� �̸��� xml������ ����� �� ������
	 * @Autowired�� ����� �� xml������ �߰� �����ü�� �ʿ���� ������.
	 */
	private static final Logger logger = Logger.getLogger(PersonnelController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/personnel-submenu.xml");
////////////////////////////////������ �ۼ�///////////////////////////////////////
	//�޿�����
	@RequestMapping(value="/per/salary/salaryList", method = RequestMethod.GET)
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("salaryȣ��");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�޿�����");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/salary";
	}
	//�޿��������̺�URL(JSON)
	@RequestMapping(value="/per/salary/salaryjson", method = RequestMethod.GET)
	public String viewSalaryjson(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("salaryȣ��");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�޿�����");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/salaryjson";
	}

	//�λ��� ����
	@RequestMapping(value="/per/rating/perrating", method = RequestMethod.GET)
	public String viewRating(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("viewRatingȣ��");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/rating/perrating";
	}
	//��ȼ��� �ӽ�����
	@RequestMapping(value="/per/rating/testform", method = RequestMethod.GET)
	public String formTest(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("viewRatingȣ��");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ�޴�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/testform";
		
	}
	
	//����ٰ��� 
	@RequestMapping(value="/per/attd/attlist", method = RequestMethod.GET)
	public String attWork(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("attWorkȣ��");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//���� ���� ����޴� ȣ��
		mod.addAttribute("curSubMenu", "����ٰ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_attenList";
		
	}
	//����ٵ�����(JSON)
		@RequestMapping(value="/per/attd/attdjson")
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
		}
	//��������
	@RequestMapping(value="/per/attd/leave", method = RequestMethod.GET)
	public String attLeave(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("attLeaveȣ��");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//���� ���� ����޴� ȣ��
		mod.addAttribute("curSubMenu", "��������");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_leaveList";
		
	}
	
	//��������
	@RequestMapping(value="/per/cert/cert", method = RequestMethod.GET)
	public String certList(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("certListȣ��");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-certsub");//���� ���� ����޴�
		mod.addAttribute("curSubMenu", "�����߱�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";
		
	}
	//���� ��±�� ������
	@RequestMapping(value="/per/cert/certprint", method = RequestMethod.POST)
	public String certPrintList(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("certPrintListȣ��");
		return "per/cert/cert_printList";
	}
	//�������� ��� ������
	@RequestMapping(value="/per/cert/certform", method = RequestMethod.POST)
	public String serform(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("certPrintListȣ��");
		return "per/cert/certform";
	}
	//������� ��� ������
	@RequestMapping(value="/per/cert/careercert", method = RequestMethod.POST)
	public String careercert(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("certPrintListȣ��");
		return "per/cert/careercert";
	}
	//������ ��� ������
		@RequestMapping(value="/per/cert/retireform", method = RequestMethod.POST)
		public String retirecert(@RequestParam Map<String, Object> pMap, Model mod) {
			//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
			//subMenuList : List<Map<String, Object>>
			//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
			//curSubMenu : String
			logger.info("certPrintListȣ��");
			return "per/cert/retireform";
		}
		//�ø��� ��� ������
		@RequestMapping(value="/per/cert/reasonform", method = RequestMethod.POST)
		public String reasoncert(@RequestParam Map<String, Object> pMap, Model mod) {
			//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
			//subMenuList : List<Map<String, Object>>
			//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
			//curSubMenu : String
			logger.info("certPrintListȣ��");
			return "per/cert/reasonform";
		}
		
		
////////////////////////////////������ �ۼ� �� ///////////////////////////////////////		
		
	//������
	@RequestMapping(value = "/per/empList", method = RequestMethod.GET)
	public String per(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/emplist";
	}
	//������ �˻� ���̺� 
	@RequestMapping(value = "/per/emptable", method = RequestMethod.GET)
	public String pertable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/emptable";
	}
	@RequestMapping(value = "/per/empRegist", method = RequestMethod.GET)
	public String perRegist(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��� ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empRegist";
	}
	
	//�ٷΰ�༭ ����
	@RequestMapping(value = "/per/labcont", method = RequestMethod.GET)
	public String labcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}
	//�ٷΰ�༭  �˻� ���̺� 
	@RequestMapping(value = "/per/labtable", method = RequestMethod.GET)
	public String labtable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/lablist";
	}
	//����༭ ��ȸ
	@RequestMapping(value = "/per/empcont", method = RequestMethod.GET)
	public String empcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}
	//�ٷΰ�༭ ��ȸ ���̺�
	@RequestMapping(value = "/per/empconttable", method = RequestMethod.GET)
	public String empconttable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/empconttable";
	}

}
