<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//프로젝트 번호
	int projNo = (Integer) request.getAttribute("projNo");
	//게시판 리스트 받아오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 관리</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
	$(document).ready(function() {
		var $a = $("#submenu>li>a");
		
		$a.each(function(i,data) {
			var href= $(this).attr("href");
			console.log("before : " + href);
			$(this).attr("href", href+"${projNo}" );
			var href= $(this).attr("href");
			console.log("after : " + href);
		});
	})
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>

		<!-- 작성할 부분 -->
		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong>게시판 관리</strong>
						<div class="btn-group">
							<button type="button" id="btn_add_timeline" class="btn btn-primary">추가</button>
						</div>
					</h2>
				</div>

				<div class="row">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th width="10%">#</th>
									<th width="90%">게시판명</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>게시판1</td>								
								</tr>
								<tr>
									<td>2</td>
									<td>게시판2</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>