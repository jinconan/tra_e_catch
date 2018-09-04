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
		<div class="col-md-4 col-md-offset-4">
			<form class="form-signin">
				<h2 class="form-signin-heading">로그인</h2>
				<label for="inputId" class="sr-only">ID</label> 
				<input type="text" id="inputId" class="form-control" placeholder="ID" required="" autofocus=""> 
				<label for="inputPassword" class="sr-only">Password</label> 
				<input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me"> Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form>
		</div>

	</div>
</body>
</html>
