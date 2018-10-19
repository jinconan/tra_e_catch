<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>>	projList		= (List<Map<String, Object>>)request.getAttribute("projList");
	String						pstatus_name	= (String)request.getAttribute("pstatus_name");
	String 						searchColumn 	= (request.getAttribute("searchColumn") != null) ? (String)request.getAttribute("searchColumn") : null;
	String 						searchValue 	= (request.getAttribute("searchValue")!=null) ? (String)request.getAttribute("searchValue") : null;
	String 						searchParams 	= (searchColumn!=null) ? "&searchColumn="+searchColumn+"&searchValue="+searchValue : "";
	
	int							pageNo			= (Integer) request.getAttribute("pageNo");
	int							numOfProjPage	= (Integer)request.getAttribute("numOfProjPage");
	int 						pageGroup 		= (int)Math.ceil(pageNo/5.0);
	int 						maxPageGroup 	= (int)Math.ceil(numOfProjPage/5.0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 프로젝트 리스트</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	var pstatus_name = "<%=pstatus_name%>";
</script>
<script>
$(document).ready(function() {
	//프로젝트 리스트 상단 탭 active 속성 부여
	var $pstatus_list = $("#pstatus_list li");
	if(pstatus_name=="all")
		$pstatus_list.eq(0).addClass("active");
	else if(pstatus_name=="ing")
		$pstatus_list.eq(1).addClass("active");
	else if(pstatus_name=="end")
		$pstatus_list.eq(2).addClass("active");
	else if(pstatus_name=="stop")
		$pstatus_list.eq(3).addClass("active");
	
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
<style>
	table a:link { color: black; text-decoration: none;}
	table a:visited { color: black; text-decoration: none;}
	table a:hover { color: black; text-decoration: underline;}
</style>
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
				<div class="page-header">
					<h2><strong>프로젝트 리스트</strong></h2>
				</div>
				<ul id="pstatus_list" class="nav nav-pills">
				  <li role="presentation"><a href="./all?<%=searchParams%>">전체</a></li>
				  <li role="presentation"><a href="./ing?<%=searchParams%>">진행중</a></li>
				  <li role="presentation"><a href="./end?<%=searchParams%>">종료</a></li>
				  <li role="presentation"><a href="./stop?<%=searchParams%>">중단</a></li>
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
					<%if(projList.size() == 0) {%>
						<tr><td colspan="5" align="center">프로젝트가 존재하지 않습니다</td></tr>
					<%} else {%>
						<%for(Map<String, Object> proj : projList) {%>
						<tr>
							<td><%=proj.get("proj_no")%></td>
							<td><%=proj.get("pstatus_name")%></td>
							<td><a href="<%=request.getContextPath()%>/plan/view/projDetail?projNo=<%=proj.get("proj_no")%>"><%=proj.get("proj_name")%></a></td>
							<td><%=proj.get("emp_name")%></td>
							<!-- 중단, 종료는 종료일자, 진행중은 예정일자 -->
							<%if("진행중".equals(proj.get("pstatus_name"))) {%>
							<td><%=proj.get("start_date")%> ~ <%=proj.get("end_sched_date")%></td></tr>
							<%} else {%>
							<td><%=proj.get("start_date")%> ~ <%=proj.get("end_date")%></td></tr>
							<%}%> 
						<%}%>						
					<%}%>
					</tbody>
				</table>
	
				<!-- 페이지네이션 -->
				<nav class="text-center">
					<ul class="pagination">
						<%if(pageGroup <=1) {%>
						<li class="disabled">
							<a href='#' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a>
						</li>
						<%} else {%>
						<li>
							<a href="<%=pstatus_name %>?pageNo=<%=(pageGroup-1)*5 %><%=searchParams%>" aria-label="Previous"> 
							<span aria-hidden='true'>&laquo;</span></a>
						</li>
						<%}%>
							
						<%for(int i = (pageGroup-1)*5 + 1 ;i<=Math.min(pageGroup*5,numOfProjPage);i++) {%>	
							<%if(pageNo == i) {%>
							<li class="active">
							<%} else {%>
							<li>
							<%}%>
							<a href="<%=pstatus_name %>?pageNo=<%=i %><%=searchParams%>"><%=i %></a></li>
						<%}%>
												
						<%if(pageGroup >= maxPageGroup) {%>
						<li class="disabled">
							<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						<%} else {%>
						<li>
							<a href="<%=pstatus_name %>?pageNo=<%=pageGroup*5 +1%><%=searchParams%>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</li>
						<%}%>
					</ul>
				</nav>
	                    
				<!-- 검색창 -->
				<form action="<%=pstatus_name %>?pageNo=1" method="get" class="form-inline text-center" id="form_search">
					<div class="form-group">
						<select class="form-control" name="searchColumn" >
							<option value="project_name">프로젝트명</option>
							<option value="leader_name">담당자</option>
						</select> 
						<label class="sr-only" for="searchValue">검색창</label> 
						<input type="text" class="form-control" name="searchValue" id="searchValue" placeholder="검색">
						<button class="btn btn-info">검색</button>
					</div>
				</form>
		</div>

	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>