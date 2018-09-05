<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" /> 
		<div class="col-sm-10">
			<div class="col-sm-offset-2 col-sm-4">
				<form class="form-signin">
					<h2 class="form-signin-heading">로그인</h2>
					<label for="emp_id" class="sr-only">ID</label> 
					<input type="text" id="emp_id" class="form-control" placeholder="ID" required="required" autofocus="autofocus"> 
					<label for="emp_pw" class="sr-only">Password</label> 
					<input type="password" id="emp_pw" class="form-control" placeholder="Password" required="required">
					<div class="checkbox">
						<label><input type="checkbox" value="remember-me">아이디 기억</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
				</form>
			</div>
		</div>
		
		
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>
