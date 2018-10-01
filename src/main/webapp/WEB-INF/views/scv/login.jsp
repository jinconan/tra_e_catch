<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String emp_id = null;
	try {
		emp_id = (String)request.getAttribute("emp_id");
	}catch(Exception e) {
		emp_id = "";
	}
%>
<%--
	ERP 시스템은 무조건 로그인이 선행되어야 함.
	로그인이 안되어있을 경우에는 어떠한 링크를 타더라도 로그인페이지로 이동함.
	
	<form>
	로그인 양식
	-----------------------------------------------
	action = /scv/login(컨텍스트경로는 제외)
	method = post
	------------------------------------------------
	params[name,설명]
	
	[emp_id,아이디]
	[emp_pw,패스워드]
	[cb_remember_id,아이디 기억]
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
$(function() {
	$emp_id = $("#emp_id");
	$remember_id = $("#remember_id");
	
	if($emp_id.val() != "") {
		$remember_id.attr("checked","checked");
	}
})
	
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
		<%-- 로그인은 서브메뉴를 필요로 하지 않는다. --%>
		<%-- <jsp:include page="/WEB-INF/views/_common/submenu.jsp" /> --%>
		<div class="col-sm-12">
			<div class="well">
				<h2><strong>로그인</strong></h2>
				<form action="<%= request.getContextPath() %>/scv/login" class="form-horizontal" method="post">
					<div class="form-group">
						<label for="emp_id" class="sr-only control-label">ID</label>
						<div class="col-sm-offset-4 col-sm-4">
							<input type="text" id="emp_id" name="emp_id" class="form-control" placeholder="ID" value="<%= emp_id%>" required="required" autofocus="autofocus"> 
						</div> 
					</div>
					<div class="form-group">
						<label for="emp_pw" class="sr-only control-label">Password</label> 
						<div class="col-sm-offset-4 col-sm-4 ">
							<input type="password" id="emp_pw" name="emp_pw" class="form-control" placeholder="Password" required="required" c>
						</div> 
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<div class="checkbox">
								<input type="checkbox" id="remember_id" name="remember_id" value="true">아이디 기억
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<button class="btn btn-primary btn-block">로그인</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>
