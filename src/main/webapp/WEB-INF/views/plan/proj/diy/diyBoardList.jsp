<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> articleList = (List<Map<String,Object>>)request.getAttribute("articleList");
	List<Map<String,Object>> projBoardList = (List<Map<String,Object>>)request.getAttribute("projBoardList");
	int numOfArticlePage = (Integer)request.getAttribute("numOfArticlePage");
	int pageNo = (Integer)request.getAttribute("pageNo");
	int boardNo = (Integer)request.getAttribute("boardNo");
	int projNo = (Integer)request.getAttribute("projNo");
	String boardName = "알 수 없음.";
	String searchColumn 	= (request.getAttribute("searchColumn") != null) ? (String)request.getAttribute("searchColumn") : null;
	String searchValue 	= (request.getAttribute("searchValue")!=null) ? (String)request.getAttribute("searchValue") : null;
	String searchParams 	= (searchColumn!=null) ? "&searchColumn="+searchColumn+"&searchValue="+searchValue : "";
	int pageGroup 		= (int)Math.ceil(pageNo/5.0);
	int maxPageGroup 	= (int)Math.ceil(numOfArticlePage/5.0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 - 프로젝트 게시판 - </title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
$(function() {
	var $downloadIcon = $("i.articleFile");
	var $formDownload = $("#f_req_download");
	
	//파일 아이콘 클릭시 파일 다운로드 처리할 부분.
	$downloadIcon.click(function(event) {
		var row = $(this).closest("tr");
		var articleNo = row.find("td.articleNo").eq(0).text();
		
		$formDownload[0].articleNo.value = articleNo;
		$formDownload.submit();
	});
	
	
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
		<nav id="submenu" class="col-sm-2 nav nav-pills nav-stacked nav-pills-stacked-example">
			<li role="presentation">
				<a href="<%=request.getContextPath() %>/plan/view/projDetail?projNo=<%=projNo %>">프로젝트 정보</a>
			</li>
			<hr>
			<!-- 여기서부터 게시판 리스트 -->
			<%
			if(projBoardList != null) {
				for(int i=0;i<projBoardList.size();i++) {
					String bName = (String)projBoardList.get(i).get("board_name");
					BigDecimal bBoardNo = (BigDecimal)projBoardList.get(i).get("board_no");
					if(bBoardNo.intValue() == boardNo) {
						boardName = bName;
			%>
			<li role="presentation" class="active">
			<%} else {%>
			<li role="presentation">		
			<%}%>
			
				<a href="<%=request.getContextPath() %>/plan/view/diyBoardList?projNo=<%=projNo %>&boardNo=<%=bBoardNo%>&pageNo=1"><%=bName %></a>
			</li>
				<%}%>
			<%}%>
		</nav>

		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong><%= boardName %></strong>
					</h2>
					
					<a href="<%=request.getContextPath() %>/plan/view/diyBoardInsert?projNo=<%=projNo %>&boardNo=<%=boardNo %>" class="btn btn-primary">글 작성</a>
				</div>
				<div class="row">
					<form id="f_req_download" action="<%=request.getContextPath() %>/plan/articleDownload" method="post">
						<input type="hidden" name="articleNo">
					</form>
					<table class="table">
						<thead>
							<tr>
								<th width="10%">#</th>
								<th style="display:none;"></th>
								<th width="50%">제목</th>
								<th width="10%">작성자</th>
								<th width="15%">날짜</th>
								<th width="10%">조회수</th>
								<th style="display:none;"></th>
								<th width="5%">첨부</th>
							</tr>
						</thead>
						<tbody>
						<%
							if(articleList == null || articleList.size() == 0) {
								out.println("<tr><td colspan='6'>게시글을 불러올 수 없습니다.</tr></td>");
							} else {
								for(int i=0;i<articleList.size();i++) {
									BigDecimal articleNo = (BigDecimal)articleList.get(i).get("ARTICLE_NO");
						%>
							<tr>
								<td><%=articleList.get(i).get("ANO") %></td>
								<td class="articleNo" style="display:none;"><%=articleList.get(i).get("ARTICLE_NO") %></td>
								<td><a href="<%=request.getContextPath() %>/plan/view/diyBoardDetail?projNo=<%=projNo %>&boardNo=<%=boardNo %>&articleNo=<%=articleNo%>"><%=articleList.get(i).get("ARTICLE_TITLE") %></a></td>
								<td><%=articleList.get(i).get("ARTICLE_WRITER") %></td>
								<td><%=articleList.get(i).get("ARTICLE_DATE") %></td>
								<td><%=articleList.get(i).get("ARTICLE_HIT") %></td>
							<%if(articleList.get(i).containsKey("ARTICLE_PATH")) {%>
								<td style="display:none;"><%=articleList.get(i).get("ARTICLE_PATH") %></td>
								<td>
									<i class="articleFile glyphicon glyphicon-download-alt"></i>
								</td>
							<%							
							} else {
								out.println("<td style='display:none;'></td>");
								out.println("<td></td>");
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
						<%if(pageGroup <=1) {%>
							<li class="disabled">
								<a href='#' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a>
							</li>
						<%} else {%>
							<li>
								<a href="diyBoardList?pageNo=<%=(pageGroup-1)*5 %>" aria-label="Previous"> 
								<span aria-hidden='true'>&laquo;</span></a>
							</li>
						<%}%>
								
						<%for(int i = (pageGroup-1)*5 + 1 ;i<=Math.min(pageGroup*5,numOfArticlePage);i++) {%>
							<%if(pageNo == i) {%>
								<li class="active">
							<%} else {%>
								<li>
							<%}%>
							<a href="diyBoardList?pageNo=<%=i %>&projNo=<%=projNo %>&boardNo=<%=boardNo %><%=searchParams%>"><%=i %></a></li>
						<%}%>						
						<%if(pageGroup >= maxPageGroup) {%>
							<li class="disabled">
								<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
						<%} else {%>
							<li>
								<a href="diyBoardList?pageNo=<%=pageGroup*5 +1%>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						<%}%>
					</nav>

					<!-- 검색창 -->
					<form action="diyBoardList" class="form-inline text-center">
						<input type="hidden" name="projNo" value="<%=projNo %>"/>
						<input type="hidden" name="boardNo" value="<%=boardNo %>"/>
						<div class="form-group">
							<select class="form-control" id="searchColumn" name="searchColumn">
								<option value="articleTitle" selected="selected">제목</option>
								<option value="articleWriter">작성자</option>
							</select> 
							<label class="sr-only" for="searchValue">검색창</label> 
							<input type="text" class="form-control" name="searchValue" id="searchValue" placeholder="검색">
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