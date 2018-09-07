package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
/*@RequestMapping(value="/per")*/
public class PersonnelController {

	private static final Logger logger = Logger.getLogger(PersonnelController.class);

	@RequestMapping(value="/per/salary/salaryList.tra", method = RequestMethod.GET)
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("salaryȣ��");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�޿�����");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/salary";
	}

	
	@RequestMapping(value="/per/rating/perrating.tra", method = RequestMethod.GET)
	public String viewRating(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("viewRatingȣ��");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/rating/perrating";
	}
	//��ȼ��� �ӽ�����
	@RequestMapping(value="/per/rating/testform.tra", method = RequestMethod.GET)
	public String formTest(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("viewRatingȣ��");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "�λ�޴�");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/testform";
		
	}
	
	//����ٰ��� 
	@RequestMapping(value="/per/attd/attlist.tra", method = RequestMethod.GET)
	public String attWork(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("attWorkȣ��");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//���� ���� ����޴� ȣ��
		mod.addAttribute("curSubMenu", "����ٰ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_attenList";
		
	}
	//��������
	@RequestMapping(value="/per/attd/leave.tra", method = RequestMethod.GET)
	public String attLeave(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("attLeaveȣ��");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//���� ���� ����޴� ȣ��
		mod.addAttribute("curSubMenu", "��������");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_leaveList";
		
	}
	
	//��������
	@RequestMapping(value="/per/cert/cert.tra", method = RequestMethod.GET)
	public String certList(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("certListȣ��");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("per-attsub");//���� ���� ����޴� ȣ��
		mod.addAttribute("curSubMenu", "��������");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";
		
	}
	//���� ��±�� ������
	@RequestMapping(value="/per/cert/certprint.tra", method = RequestMethod.POST)
	public String certPrintList(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("certPrintListȣ��");
		return "per/cert/cert_printList";
	}
	//���� ��� ������
	@RequestMapping(value="/per/cert/certform.tra", method = RequestMethod.POST)
	public String certform(@RequestParam Map<String, Object> pMap, Model mod) {
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		logger.info("certPrintListȣ��");
		return "per/cert/certform";
	}

	//������
	@RequestMapping(value = "/per/empList", method = RequestMethod.GET)
	public String per(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
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
	//�ٷΰ�༭ ����
	@RequestMapping(value = "/per/labcont", method = RequestMethod.GET)
	public String labcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
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
		ApplicationContext context = new ClassPathXmlApplicationContext("personnel-submenu.xml");
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
