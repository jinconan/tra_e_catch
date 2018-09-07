<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>


<!------------- 헤더 ------------>
<jsp:include page="/WEB-INF/views/_common/header.jsp">
	
<!------------- 본문 ------------>	
	<hr>
  <div class="container">
<!------------ 사이드 메뉴 ------------>  
		<nav class="col-sm-2 nav nav-pills nav-stacked nav-pills-stacked-example">
			<li role="presentation"><a href="<%=request.getContextPath()%>/prod/inven/view/prodInven/1">기획서 리스트</a></li>
			<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/plan/prop/view/insertProp">기획서 작성</a></li>
		</nav>
  <jsp:include page="/WEB-INF/views/_common/submenu.jsp">
	
<!------------ 중앙 게시판 ------------>	
	<div class="row">
	  <div class="col-sm-10">
		<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">
		      <span class="glyphicon glyphicon-tags"></span>
				  &nbsp;&nbsp;재고 관리 대장
			</h3>
		   </div>
			조회 : <input id="myInput" type="text" placeholder="Search.."><button class="btn btn-default btn-xs" type="submit">조회</button>
			
			 
			 <table class="table">
				  <thead>
				  	    <tr>
				  	    	<th>상품코드</th>
				  			<th>상품종류코드</th>
				  			<th>등록일자</th>
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
				  			<td>2018-09-04</td>
				  			<td>판매중</td>
				  			<td>3</td>
				  			<td>19,000원</td>
				  			<td>2018-09-03</td>
				  			
				  		</tr>	
				  	</tbody>		
				  </table>
				  <button class="btn btn-default btn-xs" type="submit">추가</button>
				  <button class="btn btn-default btn-xs" type="submit">전체 조회</button>
				  <button class="btn btn-default btn-xs" type="submit">수정</button>
				  <button class="btn btn-default btn-xs" type="submit">삭제</button>
			</div>	  
		</div>
	</div>
</div>	
<jsp:include page="/WEB-INF/views/_common/footer.jsp">
	
			   
</body>
</html>