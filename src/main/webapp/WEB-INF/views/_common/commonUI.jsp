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
<link rel="stylesheet" href="<%=path.toString()%>/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css">
<script src="<%=path.toString()%>/js/jquery-2.2.4.min.js"></script>
<script src="<%=path.toString()%>/js/bootstrap.min.js"></script>
<script src="<%=path.toString()%>/js/moment.js"></script>
<script src="<%=path.toString()%>/js/bootstrap-table.min.js"></script>
<script src="<%=path.toString()%>/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="<%=path.toString()%>/js/printThis.js"></script>
<!-- 프로젝트에서 직접 작성한 공통 자바스크립트 -->
<script src="<%=path.toString()%>/js/commonJS.js"></script>
<style>
	html,body { height:100%; }
	.panel-chatlist {
		min-height: 100%;
		position:fixed;
		width: 300px; top: 0px; right: 0px ; 
		padding-bottom: 52px; }
	.panel-chat {
		display:none;
		position: fixed; 
		width: 350px; 
		height: 600px; 
		bottom: 60px;
		right: 300px;}
	footer { position: absolute; bottom: 0; left: 0; right: 0; 
		background-color: #333333;
		color: #fffff0;}
</style>