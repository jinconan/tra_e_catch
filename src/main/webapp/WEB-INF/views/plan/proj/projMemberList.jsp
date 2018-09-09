<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//프로젝트 번호
	int projNo = (Integer) request.getAttribute("projNo");
	List memberList = new ArrayList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>참여자 리스트</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
	$(document).ready(function() {
		var $a = $("#submenu>li>a");

		$a.each(function(i, data) {
			var href = $(this).attr("href");
			console.log("before : " + href);
			$(this).attr("href", href + "${projNo}");
			var href = $(this).attr("href");
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
						<strong>참여자 리스트</strong>
					</h2>
				</div>

				<div class="row">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>사원명</th>
									<th>역할</th>
									<th>직급</th>
									<th>부서</th>
								</tr>
							</thead>
							<tbody>
							<%
							if (memberList == null || memberList.size() == 0) {
								out.print("<tr><td colspan='5' style='text-align:center;'>리스트를 불러올 수 없습니다</td></tr>");
							} else {
								for(int i=0;i<memberList.size(); i++) {
							%>
								<tr class="rowMember">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							<%		
									}
								}
							%>
							</tbody>
						</table>
						<nav class="text-center">
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>