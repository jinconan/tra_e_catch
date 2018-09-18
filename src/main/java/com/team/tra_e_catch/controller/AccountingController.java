package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

import com.team.tra_e_catch.accounting.AccountingLogic;

<<<<<<< HEAD
=======

/*
 * Ŭ������ : AccountingController
 * �ۼ��� : ��ö��
 * ��¥ : 2018-08-31
 */


>>>>>>> refs/heads/cw_09181
@Controller
@RequestMapping(value="/acc")
public class AccountingController {
	
	private static final Logger logger = Logger.getLogger(AccountingController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/accounting-submenu.xml");
<<<<<<< HEAD
=======
	List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
>>>>>>> refs/heads/cw_09181
	
	@Autowired
	private AccountingLogic accountingLogic;
	/*
	@RequestMapping(value = "/sal", method = RequestMethod.GET)
	public String sal_main(Model mod, @RequestParam Map<String, Object> pMap) {
		logger.info("sal����");
		
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/sales/sal_main";
	}*/
	
	
	
	/*
	 * init�޼��� : slip/slip_main.jsp
	 * out�޼��� : acc/slip/slip_main
	 * �뵵 : ��ǥó�� ���� ȭ�� 
	 * ��� : x
	 */
	@RequestMapping(value = "/slip/{counts}", method = RequestMethod.GET)
	public String slip_main(Model mod,@RequestParam Map<String, Object> pMap,@PathVariable int counts) {
		logger.info(counts+"���� slip����");
		mod.addAttribute("curSubMenu", "��ǥó�� ����");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		return "acc/slip/slip_main";
	}

	
	/*
	 * init�޼��� : tax/tax_main.jsp
	 * out�޼��� : acc/tax/tax_main
	 * �뵵 : ���� ���� ������ 
	 * ��� : x
	 */
	@RequestMapping(value = "/tax", method = RequestMethod.GET)
	public String tax_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("tax����");
		mod.addAttribute("curSubMenu", "���� ����");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/tax/tax_main";
	}
	
	
	
	/*
	 * init�޼��� : team/team_main.jsp
	 * out�޼��� : acc/teamexp/team_main
	 * �뵵 : �� ��� ���� �������� �̵�
	 * ��� : x
	 */
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("team����");
		String acc = accountingLogic.team_Logic();
		mod.addAttribute("curSubMenu", "����� ����");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/teamexp/team_main";
	}
	
	
	
	/*
	 * init�޼��� : wel/wel_main.jsp
	 * out�޼��� : acc/welfare/wel_main
	 * �뵵 : ���� ������ ��ȸ�� �̵�
	 * ��� : x
	 */
	@RequestMapping(value = "/wel", method = RequestMethod.GET)
	public String wel_main(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("wel����");
		mod.addAttribute("curSubMenu", "���������� ��ȸ");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/welfare/wel_main";
	}
	
	
	
	/*
	 * init�޼��� : slip/slip_main.jsp
	 * out�޼��� : acc/slip/slip_init
	 * �뵵 : ��ȹ�� ����Ʈ ���� ���� �������� �̵�
	 * ��� : x
	 */
	@RequestMapping(value = "slip/in", method = RequestMethod.GET)
	public String slip_init(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("slip/in����");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/slip/slip_init";
	}
	
	
	/*
	 * init�޼��� : tax/tax_main
	 * out�޼��� : /acc/tax/tax_init
	 * �뵵 : ��ȹ�� ����Ʈ ���� ���� �������� �̵�
	 * ��� : x
	 */
	@RequestMapping(value = "/tax/in", method = RequestMethod.GET)
	public String tax_init(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("tax/in����");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "/acc/tax/tax_init";
	}

}
