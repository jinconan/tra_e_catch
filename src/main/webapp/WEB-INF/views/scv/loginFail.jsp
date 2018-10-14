<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("로그인에 실패하였습니다");
	location.href="<%=request.getContextPath()%>/scv/view/login";
</script>