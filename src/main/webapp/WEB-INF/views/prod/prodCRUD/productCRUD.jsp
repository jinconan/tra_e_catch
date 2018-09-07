<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap-theme.min.css">
<script src="/dev_jsp201809020/bootstrap/js/jquery-2.2.4.min.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/bootstrap.min.js"></script>
</head>

<body style="background-color: #f8f9fa;">
	<jsp:include page="/WEB-INF/views/_common/header.jsp">
   
   <div class="container">
	
	<jsp:include page="/WEB-INF/views/_common/submenu.jsp">
	
	<div class="row">
	  <div class="col-sm-10">
		<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">
		      <span class="glyphicon glyphicon-tags"></span>
				  &nbsp;&nbsp;작업 지시서
			</h3>
		   </div>
				  <table class="table table-bordered responsive-table bordered">
				  	<thead>
				  		<tr>
				  			<th>등록일자<input type="text" class="form-control " placeholder="Text input"></th>
				  			<th>담당자<input type="text" class="form-control" placeholder="Text input"></th>
				  			<th>거래처<input type="text" class="form-control " placeholder="Text input"></th>
				  			<th>납기일자<input type="text" class="form-control " placeholder="Text input"></th>
				  		</tr>
				  	</thead>
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
		</div>
	</div>
</div>	
	
	<jsp:include page="/WEB-INF/views/_common/footer.jsp">
</body>
</html>