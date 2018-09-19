<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> getEmpjson = 
		(List<Map<String,Object>>)request.getAttribute("getEmpList");
	Gson gs = new Gson();
	String jsonemp = gs.toJson(getEmpjson);
	out.print(jsonemp);
%>