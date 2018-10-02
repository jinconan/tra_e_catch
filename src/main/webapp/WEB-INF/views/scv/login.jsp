<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String emp_id = "";
	try {
		emp_id = (String)request.getAttribute("emp_id");
	}catch(Exception e) {
		emp_id = "";
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
//체크박스 체크
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
