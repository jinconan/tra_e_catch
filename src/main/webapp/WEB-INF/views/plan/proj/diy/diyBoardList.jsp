<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀 게시판</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />

		<div class="col-sm-8">
			<div class="well">
				<div class="row">
					<h2>
						<strong>게시판1</strong>
					</h2>
				</div>
				<div class="row">
					<table class="table">
						<thead>
							<tr>
								<th width="10%">#</th>
								<th width="90%">제목</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>1빠</td>
							</tr>
						</tbody>
					</table>
					<!-- 페이지네이션 -->
					<nav class="text-center">
						<ul class="pagination">
							<li class="disabled"><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="active"><a href="#">1</a></li>
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
								<option>제목</option>
								<option>작성자</option>
							</select> <label class="sr-only" for="searchProp">검색창</label> <input type="text" class="form-control" id="searchProp" placeholder="검색">
							<button type="submit" class="btn btn-default">검색</button>
						</div>
					</form>
				</div>

			</div>
		</div>
		<!-- 푸터 -->
		<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>