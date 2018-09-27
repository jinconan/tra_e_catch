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
	<script type="text/javascript">
		$(function() {
			$('#p_table').bootstrapTable({
				url:'<%=request.getContextPath()%>/accR/slip/t'				
			});
		});
	</script>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
			<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<div class="col-sm-10">
			<form class="form-signin">
				<h2 class="form-signin-heading">팀 운영비</h2>
				<div class="row" Style="margin-bottom: 5px">
					<div class="col-xs-1">
						<h5>날짜:</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" id="fromDate" type="text"
							placeholder="시작날짜">
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" id="toDate" type="text"
							placeholder="종료날짜">
					</div>
					<div class="col-xs-1">
						<h5>금액:</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" type="text" placeholder="시작금액">
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" type="text" placeholder="종료금액">
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<select class="form-control">
							<option>현영</option>
							<option>카드</option>
							<option>세계</option>
							<option>예산</option>
						</select>
					</div>
					<div class="col-xs-6">
						<input type="text" class="form-control" placeholder="Text input">
					</div>
					<div class="col-xs-2">
						<input type="button" class="form-control" value="검색">
					</div>
				</div>
				<div class="row">
					<table class="table table-striped" id="p_table">
						<thead>
							<tr>
								<th data-field="번호">번호</th>
								<th data-field="일자">날짜</th>
								<th data-field="거래처">거래처</th>
								<th data-field="수입">수입</th>
								<th data-field="비용">비용</th>
								<th data-field="고정자산">고정자산</th>
								<th data-field="증빙">증빙</th>
								<th data-field="첨부자료">첨부자료</th>
							</tr>   
						</thead>
						<tbody>
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