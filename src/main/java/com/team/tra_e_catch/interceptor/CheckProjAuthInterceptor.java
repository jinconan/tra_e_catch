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
import com.team.tra_e_catch.plan.PlanLogic;

public class CheckProjAuthInterceptor extends HandlerInterceptorAdapter{
	Logger logger = Logger.getLogger(CheckProjAuthInterceptor.class);
	
	private PlanLogic planLogic;
	public void setPersonnelLogic(PlanLogic planLogic) {
		this.planLogic = planLogic;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}
	
}
