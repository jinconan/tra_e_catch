<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안 문서</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>


</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	$("#dg_list").datagrid({
		url:'/epayjson.jsp'
		,columns:[[
			{field:'DOC_NO',title:'글번호',width:100, align:'center'},
	        {field:'DTYPE_NO',title:'글분류',width:400, align:'center'},
	        {field:'CONTENT',title:'내용',width:100, align:'center'},
	        {field:'UP_DATE',title:'작성일',width:150, align:'center'},
	        {field:'EMP_NO',title:'작성자',width:100, align:'center'}
			
		]]
	});

});
</script>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<form class="form-horizontal">
				<div class="page-header">
					<h1>기안 문서 목록</h1>
				</div>
				<!-- 분류 버튼 -->
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false">
						분류 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" id="optionum"
						onclick="listoption()">
						<li><a href="#f_jobInst">대기중</a></li>
						<li><a href="#">승인완료</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</div>
				
				<table class="table table-striped" id="dg_list">
				</table>
				
				<div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_pay" class="btn btn-primary">
					조회<i class="fa fa-check spaceLeft"></i>
				</button>
				
			</div>
		</div>
			
				<nav>
					<div class="text-center">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</div>
				</nav>
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>