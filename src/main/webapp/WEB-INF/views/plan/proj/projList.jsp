<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> projList = (List<Map<String, Object>>)request.getAttribute("projList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 리스트</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
$(document).ready(function() {
	$(".tr_proj").click(function(event){
		var projNo = $(this).find("td")[0].innerText;
		location.href="<%=request.getContextPath()%>/plan/view/projDetail?projNo="+projNo;
	})
	
	//검색 폼 입력 여부 체크
	$("#form_search").submit(function() {
		if($("#searchValue").val().trim() == "") {
			alert("검색시 값을 입력해주세요");
			return false;
		}
		else {
			return true;
		}
			
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
					<%
						if(projList.size() == 0) {
					%>
							<tr><td colspan="5" align="center">프로젝트가 존재하지 않습니다</td></tr>
					<%		
						} else {
							for(Map<String, Object> proj : projList) {
					%>
								<tr class="tr_proj">
									<td><%=proj.get("proj_no")%></td>
									<td><%=proj.get("pstatus_name")%></td>
									<td><%=proj.get("proj_name")%></td>
									<td><%=proj.get("emp_name")%></td>
									<!-- 중단, 종료는 종료일자, 진행중은 예정일자 -->
					<%
								if(proj.get("pstatus_name").equals("진행중")) {
					%>
									<td><%=proj.get("start_date")%> ~ <%=proj.get("end_sched_date")%></td>
					<%
								} else {
					%>
									<td><%=proj.get("start_date")%> ~ <%=proj.get("end_date")%></td>
					<% 
								} 
					%>
								</tr>
					
					<%			
							}						
						}
					%>
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
				<form action="./all" method="post" class="form-inline text-center" id="form_search">
					<input type="hidden" name="pageNo" value="1"/>
					<div class="form-group">
						<select class="form-control" name="searchColumn">
							<option value="project_name">프로젝트명</option>
							<option value="leader_name">담당자</option>
						</select> 
						<label class="sr-only" for="searchValue">검색창</label> 
						<input type="text" class="form-control" name="searchValue" id="searchValue" placeholder="검색">
						<button class="btn btn-default">검색</button>
					</div>
				</form>
			</div>
		</div>

	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>