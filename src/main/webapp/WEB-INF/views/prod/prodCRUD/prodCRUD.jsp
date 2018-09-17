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
					<h1>작업지시서</h1>
				</div>
<!--------------------- 작업 지시서 폼 -----------------------> 				
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">분류</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputgubun" type="email"
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
					<label class="col-sm-3 control-label" for="inputEmail">거래처</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputDeal" type="email"
							placeholder="거래처">
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
					<label class="col-sm-3 control-label" for="inputNumber">등록일자</label>
					<div class="col-sm-2" style="padding-right: 0px;">

						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>



					<label class="col-sm-2 control-label" for="inputNumber">납기일자</label>
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
					<label class="col-sm-3 control-label" for="inputEmail">담당자</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="담당자">
					</div>
				</div>

				 <table class="table table-bordered responsive-table bordered">
				
				  	<tbody>
				  		<tr>
				  		 	<td>상품코드</td>
				  			<td>상품명</td>
				  			<td>수량</td>
				  			<td>비고</td>
				  		</tr>
				  		<tr>	
				  			<td>p-3456</td>
				  			<td>The witcher</td>
				  			<td>4</td>
				  	    	<td>잔고량 :3 </td>
				  	    </tr>
				  	    <tr>	
				  			<td>p-3456</td>
				  			<td>The witcher</td>
				  			<td>4</td>
				  	    	<td>잔고량 :3 </td>
				  	    </tr>
				  	    <tr>	
				  			<td>p-3456</td>
				  			<td>The witcher</td>
				  			<td>4</td>
				  	    	<td>잔고량 :3 </td>
				  	    </tr>
				  	    <tr>	
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  	    	<td><input type="text" class="form-control " placeholder="Text input"></td>
				  	    </tr>
				  	</tbody>		
				  </table>
				<button class="btn btn-default btn-xs" type="submit">조회</button>
				<button class="btn btn-default btn-xs" type="submit">저장</button>
				<button class="btn btn-default btn-xs" type="submit">수정</button>
				<button class="btn btn-default btn-xs" type="submit">삭제</button>

		</div>
		<!-- <div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_pay" class="btn btn-primary">
					저장<i class="fa fa-check spaceLeft"></i>
				</button>
				<button id="btn_pay" class="btn btn-primary">
					취소<i class="fa fa-check spaceLeft"></i>
				</button>

			</div>
		</div> -->
		<div class="form-group" id="emptable"></div>
		</form>
		<hr>
	</div>
</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
</body>
</html>