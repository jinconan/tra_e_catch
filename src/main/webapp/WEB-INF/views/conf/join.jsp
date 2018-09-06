<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원등록</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
$(document).ready(function() {
	$(".form_datetime").datetimepicker({
		format: 'yyyy-mm-dd'
		,minView:2
	});
})
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	
	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		
		<div class="col-sm-10">
				<form class="form-horizontal" role="form">
					<h2>직원등록</h2>
					<div class="form-group">
						<label for="id" class="col-sm-3 control-label">이름</label>
						<div class="col-sm-9">
							<input type="text" id="id" placeholder="이름" class="form-control" autofocus>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-3 control-label">이메일 </label>
						<div class="col-sm-9">
							<input type="email" id="email" placeholder="Email" class="form-control" name="email">
						</div>
					</div>
					<div class="form-group">
						<label for="birthDate" class="col-sm-3 control-label">생일</label>
						<div class="col-sm-9">
							<!-- <input type="date" id="birthDate" class="form-control"> -->
							<input type="text" readonly class="form-control form_datetime">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneNumber" class="col-sm-3 control-label">연락처 </label>
						<div class="col-sm-9">
							<input type="phoneNumber" id="phoneNumber" placeholder="Phone number" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">성별</label>
						<div class="col-sm-6">
							<div class="row">
								<div class="col-sm-4">
									<label class="radio-inline"> <input type="radio" id="maleRadio" value="Male">남
									</label>
								</div>
								<div class="col-sm-4">
									<label class="radio-inline"> <input type="radio" id="femaleRadio" value="Female">여
									</label>
								</div>
							</div>
						</div>
					</div>
					<!-- /.form-group -->
					<button type="submit" class="btn btn-primary btn-block">가입</button>
				</form>
				<!-- /form -->
		</div>


	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>
