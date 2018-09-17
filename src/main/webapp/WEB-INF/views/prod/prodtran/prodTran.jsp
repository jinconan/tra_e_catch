<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
<!---------------------- 헤더 --------------------------->
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>

	<div class="container">
<!---------------------- 서브메뉴 ------------------------>
	 	<jsp:include page="/WEB-INF/views/_common/submenu.jsp"/> 
	 
   	<div class="col-sm-10">
		
<!----------------------- 제목 -------------------------->		
		<div class="col-md-10">
			<form class="form-horizontal">
				<div class="page-header">
					<h1>거래내역서</h1>
				</div>
<!--------------------- 작업 지시서 폼 -----------------------> 				
				<div class="form-group">
					
					
					<label class="col-sm-3 control-label" for="inputEmail">등록코드</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputgubun" type="email"
							placeholder="등록코드">
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
					<label class="col-sm-3 control-label" for="inputEmail">거래처코드</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputDeal" type="email"
							placeholder="거래처코드">
					</div>
					</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">결제방식</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="결제방식">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputNumber">결제일자</label>
					<div class="col-sm-2" style="padding-right: 0px;">

						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>
				

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">결제코드</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="결제코드">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">거래량</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="거래량">
					</div>
				</div>
		</div>
				
		<div class="form-group" id="emptable"></div>
		</form>
		<hr>
		<table class="table table-striped">
						<thead>
							<tr>
								<th>번호</th>
								<th>날짜</th>
								<th>등록코드</th>
								<th>거래처코드</th>
								<th>결제방식</th>
								<th>결제일자</th>
								<th>결제코드</th>
								<th>거래량</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>2018-08-01</td>
								<td>2343</td>
								<td>st-21</td>
								<td>카드</td>
								<td>2018-07-31</td>
								<td>2351</td>
								<td>3</td>
							</tr>
						
						</tbody>
					</table>
				
				<button class="btn btn-default btn-xs" type="submit">조회</button>
				<button class="btn btn-default btn-xs" type="submit">저장</button>
				<button class="btn btn-default btn-xs" type="submit">수정</button>
				<button class="btn btn-default btn-xs" type="submit">삭제</button>
		<!-- <div class="form-group">
			<div class="col-sm-12 text-right">
				<button id="btn_pay" class="btn btn-primary">
					저장<i class="fa fa-check spaceLeft"></i>
				</button>
				<button id="btn_pay" class="btn btn-primary">
					취소<i class="fa fa-check spaceLeft"></i>
				</button>

			</div>
		</div> -->
	</div>
</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
</body>
</html>