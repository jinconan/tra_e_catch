package com.team.tra_e_catch.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckSessionInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("!!@@##");
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("emp_no") == null) {
			response.sendRedirect(request.getContextPath()+"/scv/view/login");
			return false;
		} 
		return true;
	}
}
