package com.team.tra_e_catch.interceptor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team.tra_e_catch.personnel.PersonnelLogic;

public class CheckPerAuthInterceptor extends HandlerInterceptorAdapter{
	Logger logger = Logger.getLogger(CheckPerAuthInterceptor.class);
	
	private PersonnelLogic personnelLogic;
	public void setPersonnelLogic(PersonnelLogic personnelLogic) {
		this.personnelLogic = personnelLogic;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null) {
			int eno = ((BigDecimal)session.getAttribute("emp_no")).intValue();
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("eno",  eno);
			if(personnelLogic.isPerAuth(pMap)) {
				return true;
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/per/onlyauthper/authfail.jsp");
				dispatcher.forward(request, response);
				return false;
			}
		}
		else {
			response.sendRedirect(request.getContextPath()+"/scv/view/login");
			return false;
		}
	}
	
}
