package com.team.tra_e_catch.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckSessionInterceptor extends HandlerInterceptorAdapter{
	Logger logger = Logger.getLogger(CheckSessionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle");
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("emp_no") == null) {
			if(DeviceUtils.getCurrentDevice(request).isMobile())
				response.sendRedirect(request.getContextPath()+"/mobile/scv/view/login");
			else
				response.sendRedirect(request.getContextPath()+"/scv/view/login");
			return false;
		} 
		return true;
	}
}
