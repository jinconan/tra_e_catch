<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int projNo = (Integer)request.getAttribute("projNo");
	int boardNo = (Integer)request.getAttribute("boardNo");
	int articleNo = (Integer)request.getAttribute("articleNo");
	Map<String,Object> articleDetail = (Map<String,Object>) request.getAttribute("articleDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>

$(function() {
	var updateForm = document.forms[0];
	$("#collapseUpload").on("show.bs.collapse",function() {
		updateForm.isDelete.value = true;
	})
	$("#collapseUpload").on("hide.bs.collapse",function() {
		updateForm.isDelete.value = false;
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
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />

		<!-- 게시글 수정 폼 -->
		<div class="col-sm-10">
			<div class="well">
				<form action="<%=request.getContextPath() %>/plan/articleUpdate" method="post" enctype="multipart/form-data" class="form-horizontal">
					<input type="hidden" name="projNo" value="<%=projNo %>"/>
					<input type="hidden" name="boardNo" value="<%=boardNo %>"/>
					<input type="hidden" name="articleNo" value="<%=articleNo %>"/>
					
					<div class="form-group">
						<label for="articleTitle" class="col-sm-2">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="articleTitle" name="articleTitle" value="<%=articleDetail.get("ARTICLE_TITLE") %>" placeholder="제목" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="articleFile" class="col-sm-2">파일</label>
						<div class="col-sm-10">
							<% if(articleDetail.containsKey("ARTICLE_PATH")){%>
								<span><%= articleDetail.get("ARTICLE_PATH") %></span>
								<a href="#collapseUpload" data-toggle="collapse" class="btn btn-primary" aria-expanded="false" aria-controls="collapseUpload" >기존파일제거</a>
								<div class="collapse" id="collapseUpload">
									<input type="hidden" name="isDelete" value="false"/>
									<input type="file" class="form-control" name="articleFile" id="articleFile" placeholder="파일">
								</div>
							<%} else {%>
								<input type="hidden" name="isDelete" value="true"/>
								<input type="file" class="form-control" name="articleFile" id="articleFile" placeholder="파일">
							<%} %>
						</div>
					</div>
					<div class="form-group">
						<label for="articleContent" class="col-sm-2">내용</label>
						<div class="col-sm-10">
							<textarea class="form-control" name="articleContent" id="articleContent" rows="12"  required="required"><%=articleDetail.get("ARTICLE_CONTENT") %></textarea>
						</div>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-primary" onclick="fileCheck(this.form,this.form.articleFile)">수정</button>
						<a class="btn btn-danger" href="<%=request.getContextPath()%>/plan/view/diyBoardDetail?projNo=<%=projNo %>&boardNo=<%=boardNo%>&articleNo=<%=articleNo%>">취소</a>
					</div>
				</form>
			</div>

		</div>
	</div>
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>