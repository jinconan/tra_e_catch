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
	 * @Autowired를 사용하면 setter메소드에 사용될 이름은 반드시 클래스 이름과 일치시킬것. 만일 setter객체 주입법을 사용하는
	 * 경우라면 개발자가 그 이름을 xml문서에 등록할 수 있지만
	 * 
	 * @Autowired를 사용할 땐 xml문서에 추가 등록자체가 필요없기 때문임.
	 */
	private static final Logger logger = Logger.getLogger(PersonnelController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/personnel-submenu.xml");

	//////////////////////////////// 김훈태 작성///////////////////////////////////////
	/**
	 * 출퇴근관리
	 * 
	 * @param pMap
	 * @param mod
	 * @param counts
	 * @return
	 */
	@RequestMapping(value = "/attd/{counts}")
	public String viewAttd(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("viewAttd호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// 근태 관련 서브메뉴
		mod.addAttribute("curSubMenu", "출퇴근관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_attenList";

	}

	/**
	 * 연차관리
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
		logger.info("attLeave호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// 근태 관련 서브메뉴
																											// 호출
		mod.addAttribute("curSubMenu", "연차관리");
		mod.addAttribute("subMenuList", subMenuList);
		
		pMap = new HashMap<String, Object>();
		pMap.put("eno", eno);
		mod.addAttribute("remainLeave", personnelLogic.getRemainLeave(pMap));
		return "per/attd/attd_leaveList";

	}

	/**
	 * 증명서 관리
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/cert", method = RequestMethod.GET)
	public String certList(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("certList호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// 증명서 관리
																											// 서브메뉴
		mod.addAttribute("curSubMenu", "증명서발급");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";

	}

	/**
	 * 재직증명서 양식 페이지
	 * 
	 * @param pMap
	 * @param mod
	 * @param emp_no
	 * @return
	 */
	@RequestMapping(value = "/cert/certform", method = RequestMethod.POST)
	public String serform(@RequestParam Map<String, Object> pMap, Model mod, @SessionAttribute("emp_no") int emp_no) {
		pMap.put("emp_no", emp_no);
		logger.info("serform호출 :" + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/certform";
	}
	@RequestMapping(value = "/ratingstart")
	public String ratingstart(@RequestParam Map<String, Object> pMap, Model mod, @SessionAttribute("emp_no") int emp_no) {
		logger.info("ratingstart호출 :" + pMap);
		personnelLogic.ratingstart(pMap);
		return "home";
		
	}

	/**
	 * 경력증명서 양식 페이지
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
		logger.info("certPrintList호출 :" + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/careercert";
	}

	/**
	 * 사직서 양식 페이지
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
		logger.info("certPrintList호출 : " + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/retireform";
	}

	/**
	 * 시말서 양식 페이지
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
		logger.info("certPrintList호출 : " + pMap);
		int result = personnelLogic.insertCert(pMap);
		return "per/cert/reasonform";
	}

	/**
	 * 증명서 출력 내역 테이블 요청
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/cert/certprint", method = RequestMethod.POST)
	public String certPrint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("certList호출 : " + pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// 증명서 관리
		mod.addAttribute("curSubMenu", "증명서발급");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_printList";

	}

	/**
	 * 급여지급내역 페이지 요청
	 * 
	 * @param pMap
	 * @param mod
	 * @param counts
	 * @return
	 */
	@RequestMapping(value = "/salary/{counts}", method = RequestMethod.GET)
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("salary호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "급여지급내역");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		return "per/salary/salary";
	}

	/**
	 * 인사고과 메인
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/rating/perrating", method = RequestMethod.GET)
	public String viewRating(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("viewRating호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사고과");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/rating/perrating";
	}

	/**
	 * 평정 데이터 입력
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
		logger.info("sendRating호출 :" + pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사고과");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.insertServrating(pMap);
		return "redirect:/per/rating/perrating";
	}

	/**
	 * 사원명부
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empList")
	public String perEmpList(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("emplist호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "사원 명부");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/emplist";
	}

	/**
	 * 사원 등록
	 * 
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empRegist", method = RequestMethod.GET)
	public String perRegist(Model mod) {
		logger.info("empRegist");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "사원 등록");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empRegist";
	}

	/**
	 * 사원 등록 수행 요청
	 * 
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empInsert")
	public String empInsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("empInsert호출 :" + pMap);
		/* attdinfo = personnelLogic.setAttdInsert(pMap); */
		int result = personnelLogic.insertEmp(pMap);
		mod.addAttribute("result", result);
		return "redirect:/per/auth/empRegist";
	}

	/**
	 * 근로계약서 관리
	 * 
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/labcont")
	public String labcont(Model mod) {
		logger.info("labcont호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "근로계약서 관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}

	/**
	 * 근로계약서
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value = "/auth/labtable")
	public String labtable(@RequestParam Map<String, Object> pMap) {
		logger.info("labtable호출 :"+pMap);
		return "per/onlyauthper/lablist";
	}

	/**
	 * 근로계약서 등록
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/labcont/insert")
	public String labcontinsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("labcontinsert호출 :"+pMap);
		int result = personnelLogic.insertLab(pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}
	
	/**
	 * 근로계약서 뷰
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/wordprint")
	public String wordprint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("wordprint호출 :" + pMap);
		List<Map<String, Object>> getEmpList = personnelLogic.getindivList(pMap);
		logger.info("근로계약서 인포 : " + getEmpList);
		mod.addAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
		return "per/onlyauthper/printform";
	}
	//고용계약서 뷰 
	@RequestMapping(value = "/auth/contprint")
	public String contprint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("contprint호출 :" + pMap);
		List<Map<String, Object>> getEmpList = personnelLogic.getindivlist(pMap);
		logger.info("고용계약서 인포 : " + getEmpList);
		mod.addAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
		return "per/onlyauthper/contform";
	}
	
	/**
	 * 고용계약서 관리화면
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empcont")
	public String empcont(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("고용계약서 조회");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "고용계약서 관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}

	/**
	 * 고용계약서 조회 테이블
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/auth/empconttable")
	public String empconttable(Model model) {
		return "per/onlyauthper/empconttable";
	}
	
	/**
	 * 고용계약서 등록
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/sourcing/insert")
	public String empsourcinginsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("empsourcinginsert호출" + pMap);
		int result = personnelLogic.insertEmpSourcing(pMap);
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}
	
	/**
	 * 부서정보 수정
	 * @param pMap
	 * @param counts
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/deptupdatelist/{counts}")
	public String deptupdatelist(@RequestParam Map<String, Object> pMap, @PathVariable int counts, Model mod) {
		logger.info("deptupdatelist호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("counts", counts);
		mod.addAttribute("curSubMenu", "부서관리");
		mod.addAttribute("subMenuList", subMenuList);

		return "per/onlyauthper/deptinsert";
	}
	
	/**
	 * 부서정보 인서트
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/deptinsert")
	public String deptinsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("deptinsert호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "부서관리");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.insertDept(pMap);
		return "redirect:/per/auth/deptupdatelist/1";
	}
	
	/**
	 * 부서정보 수정실행
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/deptupdate")
	public String deptUpdate(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("deptUpdate호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "부서관리");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.updateDept(pMap);
		return "redirect:/per/auth/deptupdatelist/1";
	}
	
	/**
	 * 인사발령 메인
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empupdate")
	public String empUpdate(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("empUpdate호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "인사정보 수정");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empupdate";
	}

	/**
	 * 인사정보수정테이블
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
	 * 인사발령정보 수정
	 * @param pMap
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empupdateaccept")
	public String empupdateaccept(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("sendRating호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "인사정보 수정");
		mod.addAttribute("subMenuList", subMenuList);
		System.out.println("인사발령 수정정보 : " + pMap);
		int result = personnelLogic.updateEmployee(pMap);
		return "redirect:/per/auth/empupdate";
	}

	/**
	 * 팀정보 인서트
	 * @param pMap
	 * @param mod
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/auth/teaminsert")
	public String teamInsert(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("deptinsert호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "부서관리");
		mod.addAttribute("subMenuList", subMenuList);
		int result = personnelLogic.insertTeam(pMap);
		return "per/onlyauthper/deptinsert";
	}

	@RequestMapping(value = "/attdinsert")
	public String attdInsert(@RequestParam Map<String, Object> pMap, Model mod, @SessionAttribute("emp_no") int emp_no) {
		logger.info("attdInsert호출");
		List<Map<String, Object>> attdinfo = null;
		pMap.put("emp_no", emp_no);
		attdinfo = personnelLogic.setAttdInsert(pMap);

		return "redirect:/per/attd/1";
	}

////////////////////////////////김훈태 작성 끝 ///////////////////////////////////////		

	////////////// 급여 지급////////////////
	/**
	 * 급여지급 페이지 요청
	 * 
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/auth/empSal")
	public String viewEmpSal(Model mod, HttpServletRequest req) {
		logger.info("viewEmpSal ");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "사원 급여관리");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);

		return "per/onlyauthper/empSal";

	}

	/**
	 * 급여 지급 요청
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
