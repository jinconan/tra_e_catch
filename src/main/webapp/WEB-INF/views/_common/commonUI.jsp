<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/resources");
	
%>
<%--
	<bootstrap-datetimepicker api 문서 링크>  
	https://www.malot.fr/bootstrap-datetimepicker/
--%>
<link rel="stylesheet" href="<%=path.toString()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path.toString()%>/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=path.toString()%>/css/sticky-footer.css">
<link rel="stylesheet" href="<%=path.toString()%>/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css">
<script src="<%=path.toString()%>/js/jquery-2.2.4.min.js"></script>
<script src="<%=path.toString()%>/js/bootstrap.min.js"></script>
<script src="<%=path.toString()%>/js/google_chart_loader.js"></script>
<script src="<%=path.toString()%>/js/moment.js"></script>
<script src="<%=path.toString()%>/js/bootstrap-table.min.js"></script>
<script src="<%=path.toString()%>/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>