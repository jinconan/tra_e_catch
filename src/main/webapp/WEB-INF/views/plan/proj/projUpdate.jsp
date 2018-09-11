<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 변경</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	$(function() {
		var $a = $("#submenu>li>a");
		$a.each(function(i,data) {
			var href= $(this).attr("href");
			console.log("before : " + href);
			$(this).attr("href", href+"${projNo}" );
			var href= $(this).attr("href");
			console.log("after : " + href);
		});
		
		$(".form_datetime").datetimepicker({
			format : 'yyyy. mm. dd',
			minView : 2
		});

		$('#d_preview').scrollspy({
			target : '.navbar-example'
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

		<!-- 프로젝트 추가 폼 -->
		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong> 프로젝트 변경 </strong>
					</h2>
				</div>
				<form class="form-horizontal">
					<div class="form-group">
						<label for="projTitle" class="col-sm-2 control-label">프로젝트명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="projTitle" id="projTitle" placeholder="프로젝트명" required="required">
						</div>
						<!-- <div class="col-sm-2">
							<button type="button" id="btn_preview" class="btn btn-primary">미리보기</button>
						</div> -->
					</div>
					<div class="form-group">
						<label for="projLeader" class="col-sm-2 control-label">담당자</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="projTitle" id="projLeader" placeholder="담당자" readonly required="required">
						</div>
						<!-- <div class="col-sm-2">
							<button type="button" id="btn_preview" class="btn btn-primary">미리보기</button>
						</div> -->
					</div>
					<div class="form-group">
						<label for="projPeriod" class="col-sm-2 control-label">기간</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input type="text" class="form-control form_datetime" id="time_start" name="time_start" placeholder="시작일" readonly required />
								<div class="input-group-addon">~</div>
								<input type="text" class="form-control form_datetime" id="time_end" name="time_end" placeholder="종료일" readonly required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="projPlatform" class="col-sm-2 control-label">플랫폼</label>
						<div class="col-sm-10">

							<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
								<div class="panel panel-default">
									<div class="panel-heading" role="tab" id="headingOne">
										<input type="text" class="panel-title form-control" id="platforms" readonly data-toggle="collapse" data-parent="#accordion" href="#platform_list" aria-expanded="true" aria-controls="collapseOne" />
									</div>
									<div id="platform_list" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
										<div class="panel-body">
											<div class="input-group">
												<span class="input-group-addon"> 
													<input type="checkbox" aria-label="cb_platform1">
												</span><input type="text" class="form-control" aria-label="cb_platform1" value="PS4" readonly="readonly">
											</div>
											<div class="input-group">
												<span class="input-group-addon"> 
													<input type="checkbox" aria-label="cb_platform2">
												</span><input type="text" class="form-control" aria-label="cb_platform2" value="PC" readonly="readonly">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-2">
							<button class="btn btn-primary btn-block">변경</button>
						</div>
					</div>
				</form>
			</div>

		</div>


	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />

</body>
</html>