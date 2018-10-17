<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> propList = (List<Map<String,Object>>)request.getAttribute("propList");
	int numOfPropPage = (Integer)request.getAttribute("numOfPropPage");
			
	int							pageNo			= (Integer) request.getAttribute("pageNo");
	int 						pageGroup 		= (int)Math.ceil(pageNo/5.0);
	int 						maxPageGroup 	= (int)Math.ceil(numOfPropPage/5.0);
	
	String 						searchColumn 	= (request.getAttribute("searchColumn") != null) ? (String)request.getAttribute("searchColumn") : null;
	String 						searchValue 	= (request.getAttribute("searchValue")!=null) ? (String)request.getAttribute("searchValue") : null;
	String 						searchParams 	= (searchColumn!=null) ? "&searchColumn="+searchColumn+"&searchValue="+searchValue : "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 기획서 리스트</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
$(function() {
	var $downloadIcon = $("i.propFile");
	var $formDownload = $("#f_req_download");
	//파일 아이콘 클릭시 파일 다운로드 처리할 부분.
	$downloadIcon.click(function(event) {
		var row = $(this).closest("tr");
		var propNo = row.find("td.propNo").eq(0).text();
		var propFile = row.find("td.propFile").eq(0).text();
		
		$formDownload[0].propNo.value = propNo;
		$formDownload[0].propFile.value = propFile;
		console.log(propNo+", " + propFile);
		
		$formDownload.submit();
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
		<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
		
		<!-- 중앙 게시판 -->
		<div class="col-sm-10">
				<div class="page-header">
					<h2><strong>기획서 리스트</strong></h2>
				</div>
				<!-- 파일 다운로드할 파라미터 폼 -->
				<form id="f_req_download" action="<%=request.getContextPath() %>/plan/propDownload" method="post">
					<input type="hidden" name="propNo">
					<input type="hidden" name="propFile">
				</form>
				
				<table class="table table-condensed">
					<thead>
						<tr>
							<th width="10%">번호</th>
							<th width="50%">제목</th>
							<th width="20%">작성자</th>
							<th width="15%">작성일자</th>
							<th style="display:none;">링크</th>
							<th width="5%">첨부</th>
						</tr>
					</thead>
					<tbody>
						<%if(propList == null || propList.size() == 0) {%>
						<tr>
							<td colspan="6" align="center">불러오는데 실패했습니다.</td>
						</tr>
						<%} else {%>
							<%for(Map<String,Object> prop:propList) {%>
							<tr>
								<td class="propNo"><%=prop.get("PROP_NO") %></td>
								<td class="propTitle"><%=prop.get("title") %></td>
								<td class="propWriter"><%=prop.get("emp_name") %></td>
								<td class="propDate"><%=prop.get("up_date") %></td>
								<%if(prop.get("path") != null){%>
									<td class="propFile" style="display:none;"><%=prop.get("path") %></td>
									<td><i class="propFile glyphicon glyphicon-download-alt"></i></td>	
								<%} else {%>
									<td style="display:none;"></td>
									<td></td>
								<%}%>
							</tr>
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
							<a href="propList?pageNo=<%=(pageGroup-1)*5 %><%=searchParams%>" aria-label="Previous"> 
							<span aria-hidden='true'>&laquo;</span></a>
						</li>
					<%}%>
					<%for(int i = (pageGroup-1)*5 + 1 ;i<=Math.min(pageGroup*5,numOfPropPage);i++) {%>
						<%if(pageNo == i) {%>
							<li class="active">
						<%} else {%>
							<li>
						<%}%>
						<a href="propList?pageNo=<%=i %><%=searchParams%>"><%=i %></a></li>
					<%}%>						
					<%if(pageGroup >= maxPageGroup) {%>
						<li class="disabled">
							<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
					<%} else {%>
						<li>
							<a href="propList?pageNo=<%=pageGroup*5 +1%><%=searchParams%>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					<%}%>
					</ul>
				</nav>
	
				<!-- 검색창 -->
				<form action="propList" class="form-inline text-center">
					<div class="form-group">
						<select class="form-control" id="searchColumn">
							<option value="propTitle">제목</option>
							<option value="propWriter">작성자</option>
						</select> 
						<label class="sr-only" for="searchValue">검색창</label> 
						<input type="text" class="form-control" id="searchValue" placeholder="검색">
						<button class="btn btn-default">검색</button>
					</div>
				</form>
		</div>

	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>