<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기획서 수정</title>
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
		<div class="col-sm-8">
			<form class="form-horizontal">
				<div class="form-group">
					<label for="propTitle" class="col-sm-2">작성자</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="propTitle" placeholder="작성자" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label for="propTitle" class="col-sm-2">제목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="propTitle" placeholder="제목" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="propTitle" class="col-sm-2">파일</label>
					<div class="col-sm-10">
						<input type="file" class="form-control" id="propTitle" placeholder="파일" required="required">
					</div>
				</div>

				<button type="submit" class="btn btn-primary">수정</button>
			</form>

		</div>


	</div>



</body>
</html>