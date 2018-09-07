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
					<h1>결제 문서작성</h1>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">분류</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="분류">
					</div>
					<div class="btn-group">

						<!-- 버튼태그 -->

						<button class="btn btn-default dropdown-toggle" type="button"
							data-toggle="dropdown">
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">메뉴1</a></li>
							<li><a href="#">메뉴2</a></li>
						</ul>
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
					<label class="col-sm-3 control-label" for="inputNumber">시행일자</label>
					<div class="col-sm-2" style="padding-right: 0px;">

						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>



					<label class="col-sm-2 control-label" for="inputNumber">종료일자</label>
					<div class="col-sm-2" style="padding-left: 0px;">

						<div class='input-group date' id='datetimepicker2'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
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