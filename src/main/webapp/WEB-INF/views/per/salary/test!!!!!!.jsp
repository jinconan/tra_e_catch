<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> getSalaryjson = 
		(List<Map<String,Object>>)request.getAttribute("getSalList");
	Gson gs = new Gson();
	String jsonsalary = gs.toJson(getSalaryjson);
	out.print(jsonsalary);
%>