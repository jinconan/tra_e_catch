package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import com.team.tra_e_catch.scv.ScvLogic;

@Controller
public class ScvController {

	private static final Logger logger = Logger.getLogger(ScvController.class);
	private final int MAX_INACTIVE_INTERVAL = -1;
	@Autowired
	private ScvLogic scvLogic;
	
	/**
	 * 로그인 처리 요청 메소드
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/login", method = RequestMethod.POST)
	public String login(Model mod
			, HttpSession session
			, HttpServletResponse res
			, @RequestParam("emp_id") String emp_id
			, @RequestParam("emp_pw") String emp_pw
			, @RequestParam(name="remember_id",required=false) boolean remember_id) 
	   {
		logger.info("login");
		logger.info("emp_id:"+emp_id+", emp_pw:"+emp_pw+", remember_id:"+remember_id);
		
		if(session != null && session.getAttribute("emp_no") != null)
			return "redirect:/";
		
		//아이디 기억 체크박스 선택시 쿠키에 입력한 아이디 저장.
		if(remember_id == true) {
			Cookie cookie = new Cookie("emp_id", emp_id);
			res.addCookie(cookie);
		}
		
		Map<String,Object> result = scvLogic.login(emp_id, emp_pw);
		if(result == null)
			return "redirect:/scv/view/login";
		else {
			session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
			session.setAttribute("emp_no", result.get("EMP_NO"));
			session.setAttribute("emp_name", result.get("EMP_NAME"));
			session.setAttribute("emp_level", result.get("EMP_LEVEL"));
			session.setAttribute("emp_dept", result.get("EMP_DEPT"));
			return "redirect:/";
		}
	}

	/**
	 * 로그인 페이지 요청 메소드
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/view/login", method = RequestMethod.GET)
	public String viewLogin(Model mod, HttpSession session
			,@CookieValue(value="emp_id", required=false)Cookie cookie) {
		logger.info("viewLogin");
		logger.info("cookie : " + cookie);
		
		if(session != null && session.getAttribute("emp_no") != null)
			return "redirect:/";
		if(cookie != null)
			mod.addAttribute("emp_id",cookie.getValue());
		else
			mod.addAttribute("emp_id","");
		return "scv/login";
	}

	/**
	 * 로그아웃 처리 요청 메소드
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/logout", method = RequestMethod.GET)
	public String logout(Model mod, HttpSession session) { 
		logger.info("logout");
		session.invalidate();
		return "redirect:/";
	}

	/**
	 * 정보 수정 처리 요청 메소드
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/modify", method = RequestMethod.POST)
	public String modify(Model mod
			, @RequestParam Map<String,Object> pMap
			, @SessionAttribute("emp_no") int emp_no)
	{
		logger.info("modify");
		logger.info(pMap);
		pMap.put("emp_no", emp_no);
		
	    scvLogic.modify(pMap);
		 
		
		
		return "redirect:/scv/view/modify";
		
	}

	/**
	 * 정보 수정 페이지 요청 메소드
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/view/modify", method = RequestMethod.GET)
	public String viewModify(Model mod
			,@SessionAttribute("emp_no") int emp_no) 
	{
		logger.info(emp_no);
		
		List<Map<String,Object>> getScvList = scvLogic.getScvList(emp_no);	
		logger.info(getScvList);
		
		mod.addAttribute("getScvList", getScvList);
	
		return "scv/modify";
	}

}
