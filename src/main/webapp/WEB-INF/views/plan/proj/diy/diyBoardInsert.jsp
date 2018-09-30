<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int projNo = (Integer)request.getAttribute("projNo");
	int boardNo = (Integer)request.getAttribute("boardNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 - 프로젝트 - 게시글 작성</title>
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
				<form action="<%=request.getContextPath() %>/plan/articleInsert" method="post" enctype="multipart/form-data" class="form-horizontal">
					<input type="hidden" name="projNo" value="<%=projNo %>"/>
					<input type="hidden" name="boardNo" value="<%=boardNo %>"/>
					<div class="form-group">
						<label for="articleTitle" class="col-sm-2">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="articleTitle" name="articleTitle" placeholder="제목" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="articleFile" class="col-sm-2">파일</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" name="articleFile" id="articleFile" placeholder="파일">
						</div>
					</div>
					<div class="form-group">
						<label for="articleContent" class="col-sm-2">내용</label>
						<div class="col-sm-10">
							<textarea class="form-control" name="articleContent" id="articleContent" rows="3" required="required"></textarea>
						</div>
					</div>
					<div class="btn-group">
						<button class="btn btn-primary" >등록</button>
						<a class="btn btn-danger" href="<%=request.getContextPath()%>/plan/view/diyBoardList?projNo=<%=projNo %>&boardNo=<%=boardNo%>">취소</a>
					</div>
				</form>
			</div>

		</div>
	</div>
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>