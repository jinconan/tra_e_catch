<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 등록</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	var memberList = null;
	$(function() {
		$(".form_datetime").datetimepicker({
			format : 'yyyy. mm. dd',
			minView : 2
		});
		
		$('#d_preview').scrollspy({ target: '.navbar-example' })
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

		<!-- 기획서 작성 폼 -->
		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong>
							프로젝트 추가
						</strong>
					</h2>
				</div>
				<form class="form-horizontal">
					<div class="form-group">
						<label for="propTitle" class="col-sm-1 control-label">파일</label>
						<div class="col-sm-8">
							<input type="file" class="form-control" id="propTitle" placeholder="파일" required="required">
						</div>
						<div class="col-sm-2">
							<button type="button" id="btn_preview" class="btn btn-primary">미리보기</button>
						</div>
					</div>
				</form>
			</div>
			<div class="embed-responsive embed-responsive-16by9">
		      <iframe id="if_frame" class="embed-responsive-item" src="">불러올 수 없습니다.</iframe>
		    </div>

		</div>


	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />

</body>
</html>