package com.team.tra_e_catch.accounting;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Acc_VO {

	
	public void initDate(HttpServletRequest res,Map<String, Object> map) {		
		if (res.getParameter("std") != null) {
			map.put("std",res.getParameter("std"));
		}
		if (res.getParameter("dtd") != null) {
			map.put("dtd",res.getParameter("dtd"));	
		}	
		if (res.getParameter("spay") != null) {
			map.put("spay",res.getParameter("spay"));
		}
		if (res.getParameter("dpay") != null) {
			map.put("dpay",res.getParameter("dpay"));
		}
		if (res.getParameter("opt") != null) {
			map.put("opt",res.getParameter("opt").substring(0, 1));
			System.out.println(res.getParameter("opt"));
		} 
		if (res.getParameter("intxt") != null) {
			map.put("intxt",res.getParameter("intxt"));
		}
	}
	
	public String outDate(HttpServletRequest res) {
		String s = "?y=0";
		if (res.getParameter("std") != null) {
			s += "&std="+res.getParameter("std");
		}
		if (res.getParameter("dtd") != null) {
			s += "&dtd=" + res.getParameter("dtd");	
		}	
		if (res.getParameter("spay") != null) {
			s += "&spay=" + res.getParameter("spay");
		}
		if (res.getParameter("dpay") != null) {
			s += "&dpay=" + res.getParameter("dpay");
		} 
		if (res.getParameter("opt") != null) {
			s += "&opt=" + res.getParameter("opt");
		} 
		if (res.getParameter("intxt") != null) {
			s += "&intxt=" + res.getParameter("intxt");
		}		
		s = s.replaceAll(" ", "");
		return s;
	}
	
	
}
