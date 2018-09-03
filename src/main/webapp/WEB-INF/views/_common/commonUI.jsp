<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/resources");
%>
<link rel="stylesheet" href="<%=path.toString()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path.toString()%>/css/bootstrap-theme.min.css">
<script src="<%=path.toString()%>/js/jquery-2.2.4.min.js"></script>
<script src="<%=path.toString()%>/js/bootstrap.min.js"></script>