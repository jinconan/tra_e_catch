package com.team.tra_e_catch.controller;

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
	private final int MAX_INACTIVE_INTERVAL = 60 * 60; //1시간
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
		
		int result = scvLogic.login(emp_id, emp_pw);
		if(result == 0)
			return "redirect:/scv/view/login";
		else {
			session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
			session.setAttribute("emp_no", result);
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
			, HttpServletRequest req
			, HttpServletResponse res
			, @RequestParam("emp_id") String emp_id
			, @RequestParam("emp_pw") String emp_pw
			, @RequestParam("emp_new_pw") String emp_new_pw
			, @RequestParam("emp_new_pw_check") String emp_new_pw_check
			, @RequestParam("emp_email") String emp_email
			, @RequestParam(name="remember_id",required=false) boolean remember_id)
	{
		logger.info("modify");
		logger.info("emp_id");
		
		if(remember_id == true) {
			Cookie cookie = new Cookie("emp_id", emp_id);
			res.addCookie(cookie);
		}
		int result = scvLogic.modify(emp_pw, emp_new_pw, emp_new_pw_check, emp_email);
		if(result == 0)
			return "scv/modify";
		else {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
			session.setAttribute("emp_no", result);
			return "home";
		}
		//return "scv/modify";
		
	}

	/**
	 * 정보 수정 페이지 요청 메소드
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/view/modify", method = RequestMethod.GET)
	public String viewModify(Model mod
			,@CookieValue(value="emp_id", required=false)Cookie cookie) 
	{
		logger.info("viewModify");
		if(cookie != null)
			mod.addAttribute("emp_id",cookie.getValue());
		return "scv/modify";
	}

}
