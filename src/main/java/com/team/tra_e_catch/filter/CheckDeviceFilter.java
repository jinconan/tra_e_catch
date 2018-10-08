package com.team.tra_e_catch.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;

public class CheckDeviceFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Device device = DeviceUtils.getCurrentDevice(req);
		System.out.println(req.getRequestURI());
		if(device.isMobile() || device.isTablet()) {
			int contextPathLen = req.getContextPath().length();
			String uri = req.getRequestURI().substring(contextPathLen);
			Pattern patt = Pattern.compile("^/mobile.*$");
			Matcher mat = patt.matcher(uri);
			if(mat.matches() == false) {
				res.sendRedirect("/tra_e_catch/mobile");
			}
		} else if(device.isNormal()) {
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {}
}
