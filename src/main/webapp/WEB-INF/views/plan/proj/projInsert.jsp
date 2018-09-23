<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 등록</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	$(function() {
		$(".form_datetime").datetimepicker({
			format : 'yyyy-mm-dd',
			minView : 2
		});
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

		<!-- 프로젝트 추가 폼 -->
		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong> 프로젝트 등록 </strong>
					</h2>
				</div>
				<form action="<%=request.getContextPath() %>/plan/projInsert" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="projTitle" class="col-sm-2 control-label">프로젝트명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="projName" id="projName" placeholder="프로젝트명" required="required">
						</div>
					</div>
					<!-- <div class="form-group">
						<label for="projLeader" class="col-sm-2 control-label">담당자</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="projTitle" id="projLeader" placeholder="담당자" readonly required="required">
						</div>
					</div> -->
					<div class="form-group">
						<label for="projPeriod" class="col-sm-2 control-label">기간</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input type="text" class="form-control form_datetime" id="startDate" name="startDate" placeholder="시작일" readonly required />
								<div class="input-group-addon">~</div>
								<input type="text" class="form-control form_datetime" id="endSchedDate" name="endSchedDate" placeholder="종료일" readonly required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-2">
							<button class="btn btn-primary btn-block">등록</button>
						</div>
					</div>
				</form>
			</div>

		</div>


	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />

</body>
</html>