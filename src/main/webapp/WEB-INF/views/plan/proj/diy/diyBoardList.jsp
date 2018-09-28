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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 - 프로젝트 게시판 - </title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
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
			<%
					} else {
			%>
			<li role="presentation">		
			<%			
					}
			%>
			
				<a href="<%=request.getContextPath() %>/plan/view/diyBoardList?projNo=<%=projNo %>&boardNo=<%=bBoardNo%>&pageNo=1"><%=bName %></a>
			</li>
			<%	
				}
			}
			%>
		</nav>

		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong><%= boardName %></strong>
					</h2>
				</div>
				<div class="row">
					<table class="table">
						<thead>
							<tr>
								<th width="10%">#</th>
								<th width="50%">제목</th>
								<th width="10%">작성자</th>
								<th width="15%">날짜</th>
								<th width="10%">조회수</th>
								<th width="5%">첨부</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>1빠</td>
								<td>1빠</td>
								<td>1999-11-11</td>
								<td>1</td>
								<td></td>
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
							<select class="form-control" id="searchColumn">
								<option value="articleTitle">제목</option>
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