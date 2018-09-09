<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//프로젝트 번호
	int propNo = (Integer) request.getAttribute("propNo");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기획서 상세</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp"/>

		<!-- 기획서 작성 폼 -->
		<div class="col-sm-8">
			<div class="well">
				
				<form class="form-horizontal">
					<div class="form-group">
						<label for="propWriter" class="col-sm-2">작성자</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="propWriter" placeholder="작성자" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="propTitle" class="col-sm-2">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="propTitle" placeholder="제목" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="propFile" class="col-sm-2">파일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="propFile" placeholder="파일" readonly="readonly">
						</div>
					</div>
				</form>
				<div class="btn-group">
					<button type="button" class="btn btn-primary" 
						onclick="location.href='<%=request.getContextPath()%>/plan/prop/view/list/1'">
						목록
					</button>
					<button type="button" class="btn btn-warning"
						onclick="location.href='<%=request.getContextPath()%>/plan/prop/view/update/1'">
						수정
					</button>
					<button type="button" class="btn btn-danger"
						onclick="#">
						삭제
					</button>
				
				</div>
				<div class="row">
				</div>
			</div>

		</div>


	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />

</body>
</html>