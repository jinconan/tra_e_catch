<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	<%-- 
	form정보
	action : 미정
	method : post
	-------------
	[필드명, 이름, 아이디(이름과 아이디가 다를 경우에 명시)]
	아이디		: emp_id
	패스워드		: emp_pw
	아이디기억	: cb_remember_id
 --%>
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
			<div class="well">
				<h2><strong>로그인</strong></h2>
				<form action="" class="form-horizontal" method="post">
					<div class="form-group">
						<label for="emp_id" class="col-sm-3 control-label">ID</label>
						<div class="col-sm-3">
							<input type="text" id="emp_id" name="emp_id" class="form-control" placeholder="ID" required="required" autofocus="autofocus"> 
						</div> 
					</div>
					<div class="form-group">
						<label for="emp_pw" class="col-sm-3 control-label">Password</label> 
						<div class="col-sm-3">
							<input type="password" id="emp_pw" name="emp_pw" class="form-control" placeholder="Password" required="required">
						</div> 
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-3">
							<div class="checkbox">
								<input type="checkbox" id="cb_remember_id" name="cb_remember_id" value="1">아이디 기억
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-3">
							<button class="btn btn-primary btn-block" type="submit">로그인</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>
