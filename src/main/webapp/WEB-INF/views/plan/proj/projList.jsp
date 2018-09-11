<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 리스트</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
$(document).ready(function() {
	$(".tr_proj").click(function(event){
		var proj_no = $(this).find("td")[0].innerText;
		location.href="<%=request.getContextPath()%>/plan/proj/view/detail/"+proj_no;
	})
})
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
		
		<!-- 중앙 게시판 -->
		<!-- 테이블 + 페이지네이션 + 검색창 -->
		<div class="col-sm-10">
			<div class="well">
				<h2><strong>프로젝트 리스트</strong></h2>
				<ul class="nav nav-pills">
				  <li role="presentation" class="active"><a href="#">전체</a></li>
				  <li role="presentation"><a href="#">진행중</a></li>
				  <li role="presentation"><a href="#">종료</a></li>
				  <li role="presentation"><a href="#">중단</a></li>
				</ul>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th width="10%">번호</th>
							<th width="10%">현황</th>
							<th width="50%">프로젝트명</th>
							<th width="10%">담당자</th>
							<th width="20%">기간</th>
						</tr>
					</thead>
					<tbody>
						<tr class="tr_proj">
							<td>1</td>
							<td>진행중</td>
							<td>엽문</td>
							<td>견자단</td>
							<td>2018-09-05 ~ 2018-09-06</td>
						</tr>
					</tbody>
				</table>
	
				<!-- 페이지네이션 -->
				<nav class="text-center">
					<ul class="pagination">
						<li class="disabled"><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
	
				<!-- 검색창 -->
				<form class="form-inline text-center">
					<div class="form-group">
						<select class="form-control" id="searchPropColumn">
							<option>프로젝트명</option>
							<option>담당자</option>
						</select> 
						<label class="sr-only" for="searchProp">검색창</label> 
						<input type="text" class="form-control" id="searchProp" placeholder="검색">
						<button type="submit" class="btn btn-default">검색</button>
					</div>
				</form>
			</div>
		</div>

	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>