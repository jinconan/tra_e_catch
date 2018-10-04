<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전표 작성</title>
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
			<form action="<%=request.getContextPath()%>/acc/slip/init" method="POST" enctype="multipart/form-data" class="form-horizontal">
				<div class="page-header">
					<h1>전표 작성</h1>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">분류/구분</label>
					<div class="col-xs-2">
						<select class="form-control" id = "TEAM_YN" name = "TEAM_YN">
							<option value="1">팀운영비</option>
							<option value="0">복지지원비</option>
						</select>
					</div>
					<div class="col-xs-2">
						<select class="form-control" id = "SLIP_TYPE_NO" name = "SLIP_TYPE_NO">
							<option value="2">출금</option>
							<option value="3">고정자산</option>
						</select>
					</div>
					<div class="col-xs-2">
						<select class="form-control" id = "ptype_no" name = "ptype_no">
							<option value="1">현금영수증</option>
							<option value="2">세금계산서</option>
							<option value="3">카드</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">적요</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" placeholder="적요" name="intxt" id="intxt">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">금액</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" placeholder="pay" name="inpay" id="inpay">
					</div>
				</div>
				<div class="form-group">
					<label for="accFile" class="col-sm-3 control-label">파일</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" name="accFile" id="accFile" placeholder="파일" required="required">
					</div>
				</div>
		</div>
		<div class="form-group">
						<div class="pull-right" style="padding-right: 15px;">
							<input type="submit" class="form-control" value="등록">
						</div>
					</div>
		<div class="form-group" id="emptable"></div>
		<div class="form-group">
		&nbsp;
		</div>
		<div class="form-group">
		&nbsp;
		</div>
		<div class="form-group">
		&nbsp;
		</div>
		<div class="form-group">
		&nbsp;
		</div>
		</form>
		<hr>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>