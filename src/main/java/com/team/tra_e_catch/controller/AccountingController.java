package com.team.tra_e_catch.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.tra_e_catch.accounting.AccountingLogic;
import com.team.tra_e_catch.accounting.Acc_VO;


/*
 * 클래스명 : AccountingController
 * 작성자 : 신철우
 * 날짜 : 2018-08-31
 */

@Controller
@RequestMapping(value="/acc")
public class AccountingController {
	
	private static final Logger logger = Logger.getLogger(AccountingController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/accounting-submenu.xml");
	List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
	
	@Autowired
	private AccountingLogic accountingLogic;
	/*
	@RequestMapping(value = "/sal", method = RequestMethod.GET)
	public String sal_main(Model mod, @RequestParam Map<String, Object> pMap) {
		logger.info("sal진입");
		
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("acc-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/sales/sal_main";
	}*/
	
	
	
	/*
	 * init메서드 : slip/slip_main.jsp
	 * out메서드 : acc/slip/slip_main
	 * 용도 : 전표처리 관리 화면 
	 * 비고 : x
	 */
	@RequestMapping(value = "/slip/{counts}", method = RequestMethod.GET)
	public String slip_main(Model mod,@RequestParam Map<String, Object> pMap,@PathVariable int counts) {
		logger.info(counts+"번 slip진입");
		mod.addAttribute("curSubMenu", "전표처리 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		return "acc/slip/slip_main";
	}

	
	
	
	/*
	 * init메서드 : team/team_main.jsp
	 * out메서드 : acc/teamexp/team_main
	 * 용도 : 팀 운영비 관리 페이지로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/team/{counts}", method = RequestMethod.GET)
	public String team_main(Model mod,@RequestParam Map<String, Object> pMap,@PathVariable int counts,HttpServletRequest res) {
		logger.info("team진입");
		mod.addAttribute("curSubMenu", "팀운영비 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);		
		Acc_VO arr = new Acc_VO();
		mod.addAttribute("datas",arr.outDate(res));
		return "acc/teamexp/team_main";
	}
	
	/*
	 * init메서드 : team/team_main.jsp
	 * out메서드 : acc/teamexp/team_main
	 * 용도 : 팀 운영비 관리 검색시 페이지 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/team_list", method = RequestMethod.POST)
	public String team_list(Model mod,@RequestParam Map<String, Object> pMap,@RequestParam Map<String,String> map) {
		logger.info("team_list진입");
		logger.info(map);
		String s = "?y=0";
		if (map.get("std").length()>1) {
			s += "&std="+map.get("std").substring(0, 11);
		}
		if (map.get("dtd").length()>1) {
			s += "&dtd=" + map.get("dtd").substring(0, 11);	
		}	
		if (map.get("spay").length()>1) {
			s += "&spay=" + map.get("spay");
		}
		if (map.get("dpay").length()>1) {
			s += "&dpay=" + map.get("dpay");
		} 
		if (map.get("opt").length()==2) {
			s += "&opt=" + map.get("opt");
		} 
		if (map.get("intxt").length()>1) {
			s += "&intxt=" + map.get("intxt");
		}		
		s = s.replaceAll(" ", "");
		mod.addAttribute("curSubMenu", "팀운영비 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",s);
		System.out.println(s);
		return "acc/teamexp/team_main";
	}
	
	
	/*
	 * init메서드 : team/team_main.jsp
	 * out메서드 : acc/teamexp/team_main
	 * 용도 : 팀 운영비 관리 검색시 페이지 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/wel_list", method = RequestMethod.POST)
	public String wel_list(Model mod,@RequestParam Map<String, Object> pMap,@RequestParam Map<String,String> map) {
		logger.info("wel_list진입");
		logger.info(map);
		String s = "?y=0";
		if (map.get("std").length()>1) {
			s += "&std="+map.get("std").substring(0, 11);
		}
		if (map.get("dtd").length()>1) {
			s += "&dtd=" + map.get("dtd").substring(0, 11);	
		}	
		if (map.get("spay").length()>1) {
			s += "&spay=" + map.get("spay");
		}
		if (map.get("dpay").length()>1) {
			s += "&dpay=" + map.get("dpay");
		} 
		if (map.get("opt").length()==2) {
			s += "&opt=" + map.get("opt");
		} 
		if (map.get("intxt").length()>1) {
			s += "&intxt=" + map.get("intxt");
		}		
		s = s.replaceAll(" ", "");
		mod.addAttribute("curSubMenu", "복지지원비 조회");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",s);
		System.out.println(s);
		return "acc/welfare/wel_main";
	}
	
	
	/*
	 * init메서드 : wel/wel_main.jsp
	 * out메서드 : acc/welfare/wel_main
	 * 용도 : 복지 지원비 조회로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/wel/{counts}", method = RequestMethod.GET)
	public String wel_main(Model mod,@RequestParam Map<String,String> map,@PathVariable int counts,HttpServletRequest res) {
		logger.info("wel진입");
		mod.addAttribute("curSubMenu", "복지지원비 조회");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);	
		Acc_VO arr = new Acc_VO();
		mod.addAttribute("datas",arr.outDate(res));
		return "acc/welfare/wel_main";
	}
	
	
	
	/*
	 * init메서드 : slip/slip_main.jsp
	 * out메서드 : acc/slip/slip_init
	 * 용도 : 기획서 리스트 생성 전용 페이지로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "slip/in", method = RequestMethod.GET)
	public String slip_init(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("slip/in진입");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "acc/slip/slip_init";
	}
	
	@RequestMapping(value = "slip/init", method=RequestMethod.POST )
	public String slip_init_date(Model mod
			,HttpServletRequest req
			,@RequestParam Map<String, Object> slipTitle) {
		logger.info("slip/init진입");
		HttpSession session = req.getSession();
		String emp_no = String.valueOf(session.getAttribute("emp_no"));
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)req;
	    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
	    MultipartFile multipartFile = null;
	    multipartFile = multipartHttpServletRequest.getFile(iterator.next());
        File file = new File("C:\\Users\\510\\Desktop\\새 폴더 (3)\\"+multipartFile.getOriginalFilename());
        file.mkdirs();
        if(multipartFile.isEmpty() == false){
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	    slipTitle.put("file",multipartFile.getOriginalFilename());
	    slipTitle.put("emp_no", emp_no);
	    accountingLogic.fileupdate(slipTitle);
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", 1);
		return "acc/slip/slip_main";
	}
	
	
	/*
	 * init메서드 : tax/tax_main
	 * out메서드 : /acc/tax/tax_init
	 * 용도 : 기획서 리스트 생성 전용 페이지로 이동
	 * 비고 : x
	 */
	@RequestMapping(value = "/tax/in", method = RequestMethod.GET)
	public String tax_init(Model mod,@RequestParam Map<String, Object> pMap) {
		logger.info("tax/in진입");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "/acc/tax/tax_init";
	}

	
	//사내전산 전표뷰
	@RequestMapping(value = "/slip/wordprint")
	public String slipprint(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		logger.info("slipprint호출");
		List<Map<String, Object>> getList = null;
		getList = accountingLogic.getSlipList(pMap);
		req.setAttribute("getList", getList.get(0));
		return "acc/slip/printform";
	}
}
