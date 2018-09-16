<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<style>
.los {
	padding-right: 5px;
	padding-left: 5px;
}

.table-striped {
	margin-top: 10px;
}

.sx-buttom {
	margin-top: 30px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
		<div class="container">
			<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<div class="col-sm-10">
			<form class="form-signin">
				<div class="row">
				<h2 class="form-signin-heading">세금 관리</h2>
				</div>
				<div class="row">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>번호</th>
								<th>일자</th>
								<th>분류</th>
								<th>구분</th>
								<th>계정과목</th>
								<th>거래처</th>
								<th>적요</th>
								<th>금액</th>
								<th>첨부자료</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>2018-08-01</td>
								<td>팀운영비</td>
								<td>입금</td>
								<td>당좌예금</td>
								<td>직원</td>
								<td>급여 지금</td>
								<td>3000000</td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-xs-10 .col-md-10">
						<nav>
							<ul class="pagination">
								<li class="disabled"><a href="#" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
								<li><a href="#">2 <span class="sr-only">(current)</span></a></li>
								<li><a href="#">3 <span class="sr-only">(current)</span></a></li>
								<li><a href="#">4 <span class="sr-only">(current)</span></a></li>
								<li class="disabled"><a href="#" aria-label="Previous"><span
										aria-hidden="true"> >> </span></a></li>
							</ul>
						</nav>
					</div>
					<div class="col-xs-2 col-md-2 sx-buttom">
						<input type="button" class="form-control" value="글작성" onclick="location.href='tax/in'">
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$('#fromDate').datetimepicker({
			language : 'ko', // 화면에 출력될 언어를 한국어로 설정한다.
			pickTime : false, // 사용자로부터 시간 선택을 허용하려면 true를 설정하거나 pickTime 옵션을 생략한다.
			defalutDate : new Date() // 기본값으로 오늘 날짜를 입력한다. 기본값을 해제하려면 defaultDate 옵션을 생략한다.
		});
	
		$('#toDate').datetimepicker({
			language : 'ko',
			pickTime : false,
			defalutDate : new Date()
		});
	</script>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>