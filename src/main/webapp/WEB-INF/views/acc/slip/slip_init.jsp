<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		});
		$('#datetimepicker2').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		});
	});
</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<form class="form-horizontal">
				<div class="page-header">
					<h1>세금 관리서 작성</h1>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">분류/구분</label>
					<div class="col-xs-3">
						<select class="form-control">
							<option>월급</option>
							<option>팀운영비</option>
							<option>복지지원비</option>
						</select>
					</div>
					<div class="col-xs-3">
						<select class="form-control">
							<option>입금</option>
							<option>출금</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">계정과목</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="계정과목">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">거래처</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="거래처">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">적요</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="적요">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">제목</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="제목">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">금액</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="제목">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">내용</label>
					<div class="col-sm-6">
						<textarea class="form-control" rows="20"></textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">공람자</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="공람자">
					</div>
				</div>
				<div class="form-group">
					<label for="propTitle" class="col-sm-3 control-label">파일</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" id="propTitle"
							placeholder="파일" required="required">
					</div>
				</div>
		</div>
		<div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_pay" class="btn btn-primary">
					저장<i class="fa fa-check spaceLeft"></i>
				</button>
			</div>
		</div>
		<div class="form-group" id="emptable"></div>
		</form>
		<hr>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>