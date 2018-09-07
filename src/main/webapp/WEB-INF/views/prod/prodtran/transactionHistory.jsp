<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/sticky-footer.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css">
<script src="/dev_jsp201809020/bootstrap/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/google_chart_loader.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/jquery-2.2.4.min.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/bootstrap.min.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/moment.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	



</script>

</head>
<body style="background-color: #f8f9fa;">
	
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
<hr>
  <div class="container">
  
  	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
	<div class="row">
	  <div class="col-sm-10">
		<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">
		      <span class="glyphicon glyphicon-tags"></span>
				  &nbsp;&nbsp;거래 내역 
			</h3>
		   </div>
			  
				  <table class="table table-bordered responsive-table bordered">
				  	<thead>
				  		<tr>
				  			<th>결제일자</th>
				  			<th>상품코드</th>
				  			<th>거래처코드</th>
				  			<th>결제방식</th><!-- () -->
				  			<th>결제코드</th><!-- (게임,굿즈...) -->
				  			<th>거래량</th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>2018-09-03</td>
				  			<td>102394</td>
				  			<td>steam</td>
				  			<td>매입</td>
				  			<td>2367</td>
				  			<td>1</td>
				  		</tr>	
				  		<tr>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  		</tr>	
				  	</tbody>		
				  </table>
				  <button class="btn btn-default btn-xs" type="submit">조회</button>
				  <button class="btn btn-default btn-xs" type="submit">추가</button>
				  <button class="btn btn-default btn-xs" type="submit">전체 조회</button>
				  <button class="btn btn-default btn-xs" type="submit">수정</button>
				  <button class="btn btn-default btn-xs" type="submit">삭제</button>
			</div>	  
		</div>
	</div>
</div>	
	
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
	


</body>
</html>