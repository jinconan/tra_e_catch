package com.team.tra_e_catch.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Prod_VO {

	
	public void initDate(HttpServletRequest res,Map<String, Object> map) {
		if (res.getParameter("std") != null) {
			map.put("std",res.getParameter("std"));	
		}
		if (res.getParameter("dtd") != null) {
			map.put("dtd",res.getParameter("dtd"));	
		}	
		if (res.getParameter("incode") != null) {
			map.put("incode",res.getParameter("incode"));
		}
		if (res.getParameter("opt") != null) {
			map.put("opt",res.getParameter("opt").substring(0, 1));
		} 
		if (res.getParameter("cata") != null) {
			map.put("cata",res.getParameter("cata"));
		}
		if (res.getParameter("sums") != null) {
			map.put("sums",res.getParameter("sums"));
		}
		System.err.println(map);
	}
	
	public String outDate(HttpServletRequest res) {
		String s = "?y=0";
		if (res.getParameter("std") != null) {
			s += "&std="+res.getParameter("std");
		}
		if (res.getParameter("dtd") != null) {
			s += "&dtd=" + res.getParameter("dtd");	
		}	
		if (res.getParameter("incode") != null) {
			s += "&incode=" + res.getParameter("incode");
		}
		if (res.getParameter("cata") != null) {
			s += "&cata=" + res.getParameter("cata");
		} 
		if (res.getParameter("opt") != null) {
			s += "&opt=" + res.getParameter("opt");
		} 
		if (res.getParameter("sums") != null) {
			s += "&sums=" + res.getParameter("sums");
		}		
		s = s.replaceAll(" ", "");
		return s;
	}
	
}
