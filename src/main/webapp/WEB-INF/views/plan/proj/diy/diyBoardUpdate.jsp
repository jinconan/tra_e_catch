<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
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
				<form class="form-horizontal">
					<div class="form-group">
						<label for="propWriter" class="col-sm-2">작성자</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="propWriter" placeholder="작성자" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="propTitle" class="col-sm-2">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="propTitle" placeholder="제목">
						</div>
					</div>
					<div class="form-group">
						<label for="propFile" class="col-sm-2">파일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="propFile" placeholder="파일" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="propContent" class="col-sm-2">내용</label>
						<div class="col-sm-10">
							<textarea class="form-control" name="propContent" id="propContent" rows="3"></textarea>
						</div>
					</div>
				</form>
				<div class="btn-group">
					<button type="button" class="btn btn-warning" onclick="location.href='alert(\'수정버튼 이벤트 구현하세요\')'">수정</button>
					<button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/plan/proj/board/view/${projNo}/${boardNo}'">취소</button>
				</div>
				<div class="row"></div>
			</div>

		</div>
	</div>
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>