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
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />

		<!-- 기획서 작성 폼 -->
		<div class="col-sm-10">
			<div class="well">
				<form action="<%=request.getContextPath() %>/plan/propInsert" method="post" enctype="multipart/form-data" class="form-horizontal">
					
					<div class="form-group">
						<label for="propTitle" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="propTitle" id="propTitle" placeholder="제목" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="propFile" class="col-sm-2 control-label">파일</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" name="propFile" id="propFile" placeholder="파일" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="pull-right" style="padding-right: 15px;">
							<button type="button" class="btn btn-primary" onclick="fileCheck( this.form.propFile )">등록</button>
						</div>
					</div>
				</form>

			</div>

		</div>


	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />

</body>
</html>