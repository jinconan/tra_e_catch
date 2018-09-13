<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> getAttdjson = 
		(List<Map<String,Object>>)request.getAttribute("getAttdjson");
	Gson gs = new Gson();
	String jsonattd = gs.toJson(getAttdjson);
	out.print(jsonattd);
%>