package com.team.tra_e_catch.payment;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Arrrtd {
	public void initDate(HttpServletRequest res,Map<String, Object> map) {		
		if (res.getParameter("up_date") != null) {
			map.put("up_date",res.getParameter("up_date"));
		}
		
		if (res.getParameter("dtype_no") != null) {
			map.put("dtype_no",res.getParameter("dtype_no"));
		}
		if (res.getParameter("content") != null) {
			map.put("content",res.getParameter("content"));
		}
		if (res.getParameter("doc_no") != null) {
			map.put("doc_no",res.getParameter("doc_no").substring(0, 1));
			System.out.println(res.getParameter("doc_no"));
		} 
		if (res.getParameter("title") != null) {
			map.put("title",res.getParameter("title"));
		}
		if (res.getParameter("emp_no") != null) {
			map.put("emp_no",res.getParameter("emp_no"));
		}
	
	}
	public String outDate(HttpServletRequest res) {
		String paymentList = "?y=0";
		if (res.getParameter("up_date") != null) {
			paymentList += "&up_date="+res.getParameter("up_date");
		}
		if (res.getParameter("dtype_no") != null) {
			paymentList += "&dtype_no=" + res.getParameter("dtype_no");	
		}	
		if (res.getParameter("content") != null) {
			paymentList += "&content=" + res.getParameter("content");
		}
		if (res.getParameter("doc_no") != null) {
			paymentList += "&doc_no=" + res.getParameter("doc_no");
		} 
		if (res.getParameter("title") != null) {
			paymentList += "&title=" + res.getParameter("title");
		} 
		if (res.getParameter("emp_no") != null) {
			paymentList += "&emp_no=" + res.getParameter("emp_no");
		}		
		paymentList = paymentList.replaceAll(" ", "");
		
		return paymentList;
	}
}
