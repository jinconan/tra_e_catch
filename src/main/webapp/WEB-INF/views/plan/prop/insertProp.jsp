<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기획서 등록</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<nav class="col-sm-2 nav nav-pills nav-stacked nav-pills-stacked-example">
			<li role="presentation"><a href="<%=request.getContextPath()%>/plan/prop/view/propList/1">기획서 리스트</a></li>
			<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/plan/prop/view/insertProp">기획서 작성</a></li>
		</nav>

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

				<button type="submit" class="btn btn-primary">제출</button>
			</form>

		</div>


	</div>


</body>
</html>