<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Map<String,Object> articleDetail = (Map<String,Object>) request.getAttribute("articleDetail");
	
	int projNo = (Integer)request.getAttribute("projNo");
	int boardNo = (Integer)request.getAttribute("boardNo");
	int articleNo = (Integer)request.getAttribute("articleNo");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />

		<!-- 기획서 작성 폼 -->
		<div class="col-sm-10">
			<div class="well">
				<div class="row" style="margin-bottom: 10px;">
					<label class="col-sm-2">작성자</label>
					<div class="col-sm-4">
						<span><%=articleDetail.get("ARTICLE_WRITER") %></span>
					</div>
					<label class="col-sm-2">작성일</label>
					<div class="col-sm-4">
						<span><%=articleDetail.get("ARTICLE_DATE") %></span>
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<label class="col-sm-2">제목</label>
					<div class="col-sm-10">
						<span><%=articleDetail.get("ARTICLE_TITLE") %></span>
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<label class="col-sm-2">파일</label>
					<div class="col-sm-10">
					<%
					if(articleDetail.containsKey("ARTICLE_PATH")) {
					%>
						<form id="f_download" action="<%=request.getContextPath() %>/plan/articleDownload" method="post">
							<input type="hidden" name="articleNo" value="<%=articleNo%>">
							<a href="javascript:document.getElementById('f_download').submit()"><%=articleDetail.get("ARTICLE_PATH")  %></a>
						</form>
						
					<%	
					} 
					%>
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<label class="col-sm-2">내용</label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="12" style="resize: vertical;" readonly="readonly" ><%=articleDetail.get("ARTICLE_CONTENT")  %></textarea>
					</div>
				</div>	
				<form action="<%=request.getContextPath() %>/plan/articleDelete" method="post">
					<input type="hidden" name="articleNo" value="<%=articleNo %>"/>
					<input type="hidden" name="projNo" value="<%=projNo %>"/>
					<input type="hidden" name="boardNo" value="<%=boardNo %>"/>
					<div class="btn-group" style="margin-bottom: 10px;">
						<a class="btn btn-primary" href="diyBoardList?projNo=<%=projNo%>&boardNo=<%=boardNo%>">목록</a>
						<a class="btn btn-warning" href="diyBoardUpdate?projNo=<%=projNo%>&boardNo=<%=boardNo%>&articleNo=<%=articleNo%>">수정</a>
						<button class="btn btn-danger">삭제</button>
					</div>
				</form>
			</div>

		</div>
	</div>
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>