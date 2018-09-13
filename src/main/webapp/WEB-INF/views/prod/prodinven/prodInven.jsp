<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>

<!---------------- 헤더 --- ------------>
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
	
	<hr>
  	<div class="container">
<!-------------- 서브메뉴 ----------------->   
   	<jsp:include page="/WEB-INF/views/_common/submenu.jsp"/> 
   	<div class="col-sm-10">

<!---------------- 제목 ------------------->
  			<div class="page-header">
					<h1>재고 관리 대장</h1>
			</div>
<!------------ 재고 관리 폼 ------------------->  	
  	<form class="form-inline" id="f_search">
  	<div class="form-group">
	<tr>
		<td>
		  <select id="cb_type" class="form-control" name="cb_type" class="col-sm-3">
		    <option value="b_prodC">상품코드</option>
		    <option value="b_prodVC">상품종류코드</option>
		    <option value="b_name">상품명</option>
		    <option value="b_sal">판매여부</option>
		  </select>
		</td>
		<td>
		  <input type="email" id="sb_keyword" name="sb_keyword" class="form-control" class="col-sm-3"></input>
		</td>
		<td>
		  <button class="btn btn-default btn-m" id="btn_sea" type="submit">조회</button>
		</td>
	</tr>
	</div>
</form>	
<script type="text/javascript">



</script>
  <div class="row">
    <div class="col-sm-10">
	 <br>
	 <br>   
		<table id="prodtable" class="table table-bordered responsive-table bordered">
		      <thead class="thead-primary">
				  	    <tr>
				  	    	<th>상품코드</th>
				  			<th>상품종류코드</th>
				  			<th>상품명</th>
				  			<th>판매여부</th>
				  			<th>수량</th>
				  			<th>가격</th>
				 			<th>최근 거래일자</th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>CRD-12</td>
				  			<td>rp-12</td>
				  			<td>레지던트 이블</td>
				  			<td>판매중</td>
				  			<td>3</td>
				  			<td>19,000원</td>
				  			<td>2018-09-03</td>
				  			
				  		</tr>	
				  		
				  	</tbody>		
				  </table>
				  <button class="btn btn-default btn-xs" id="btn_add" type="submit">추가</button>
				  <button class="btn btn-default btn-xs" id="btn_upd" type="submit">수정</button>
				  <button class="btn btn-default btn-xs" id="btn_del" type="submit">삭제</button>
				  <button class="btn btn-default btn-xs" id="btn_all" type="submit">전체조회</button>
	<center>

<script>
  $('#btn_add').click(function() {
    var time = new Date().toLocaleTimeString();
    $('#prodtable > tbody:last').append('<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>');
  });
  $('#btn_del').click(function() {
    $('#prodtable > tbody:last > tr:last').remove();
  });
</script>
	
	<nav>
		<ul class="pagination">
			<li class="abled"><a href="#" aria-label="Previous"><span aria-hidden="true"> << </span></a></li>
			<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
			<li><a href="#">2 <span class="sr-only">(current)</span></a></li>
			<li><a href="#">3 <span class="sr-only">(current)</span></a></li>
			<li><a href="#">4 <span class="sr-only">(current)</span></a></li>
			<li class="abled"><a href="#" aria-label="Next"><span aria-hidden="true"> >> </span></a></li>
		</ul>
	</nav>
	</center>
			  
	
	</div>
</div>	
</div>
<!-------------------- 하단 메뉴 ------------------->
<jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
	
			   
</body>
</html>