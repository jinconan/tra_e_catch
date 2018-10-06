<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안문서 작성</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%
	
	 
%>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		});
		$('#datetimepicker2').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		});
	});
	
	



	/*  function listoption(){
		var optnum = $("#optionnum").val();
		//alert(optnum);
		if(optnum=="0"){
			$.ajax({
		        method:"POST"
		        ,url:"/tra_e_catch/epay/jobInst"
		        ,data:"",
		        success : function(log){
		        	
		        	console.log(log);
		        	
		        }
				,error : function(xhr) {
					console.log("땡");
				}
	        });
		}
	
	} */
	
	
	</script>
</head>
<body>
<script type="text/javascript">
	 $(document).ready(function(){
		$("#btn_Inst").click(function(){
			$("#f_jobInst").attr("method","post");
			$("#f_jobInst").attr("action","jobInst.jsp");
			$("#f_jobInst").sumbit();
			$("#f_jobInst").attr("method","post");
			$("#f_jobInst").attr("action","restForm.jsp");
			$("#f_jobInst").sumbit();
		});
	}); 
	 
	 function insert() {
		 $("#f_insert").attr("method","post");
		 $("#f_insert").attr("action","draft.jsp");
		 $("#f_insert").submit();
		 
	 }
	 
	
		
	 
</script>	
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
			<form class="form-horizontal" id="f_insert">
				<div class="col-md-10">
				
				<!-- 분류 버튼 -->
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false">
						분류 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" id="optionum" >
						<li><a href="#" id="" onClick="">기획서</a></li>
						<li><a href="#" id="" onClick="">계약서</a></li>
						<li><a href="#" id="" onClick="">근로계약서</a></li>
						<li><a href="#" id="" onClick="">고용계약서</a></li>
						<li><a href="<%=request.getContextPath()%>/pay/epay/jobInst" id="btn_Inst" >작업지시서</a></li>
						<li><a href="#" id="" onClick="">사직서</a></li>
						<li><a href="<%=request.getContextPath()%>/pay/epay/restForm" id="btn_Inst" >휴가</a></li>
						<li><a href="#" id="" onClick="">외근</a></li>
						<li><a href="#" id="" onClick="">프로젝트보고서</a></li>
						<li><a href="#" id="" onClick="">협찬보고서</a></li>
						<li><a href="#" id="" onClick="">협업승인서</a></li>
						<li><a href="#" id="" onClick="">공간대여</a></li>
						<li><a href="#" id="" onClick="">공용장비대여</a></li>
						<li><a href="#" id="" onClick="">주말근무보고서</a></li>
						<li><a href="#" id="" onClick="">회식보고서</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</div>
				
				<center>
				<div class="page-header">
					<h1></h1>
				</div>
				</center>
				
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">담당부서</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="담당부서">
					</div>
					<div class="btn-group">

						<!-- 버튼태그 -->

						<button class="btn btn-default dropdown-toggle" type="button"
							data-toggle="dropdown">
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">경영팀</a></li>
							<li><a href="#">관리팀</a></li>
							<li><a href="#">cs팀</a></li>
							<li><a href="#">인사팀</a></li>
							<li><a href="#">외부지원팀</a></li>
							<li><a href="#">개발팀</a></li>
							<li><a href="#">사운드팀</a></li>
						</ul>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc_name">제목</label>
					<div class="col-sm-6">
						<input class="form-control" id="doc_name" type="name"
							placeholder="제목">

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc-start-date">시행일자</label>
					<div class="col-sm-2" style="padding-right: 0px;">

						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>



					<label class="col-sm-2 control-label" for="doc-end-date">종료일자</label>
					<div class="col-sm-2" style="padding-left: 0px;">

						<div class='input-group date' id='datetimepicker2'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>


				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc-data">내용</label>
					<div class="col-sm-6">
						<textarea class="form-control" rows="20"></textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc-emp">공람자</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="공람자">
					</div>
				</div>
		</div>
	
		<div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_pay" class="btn btn-primary" onclick="insert()">
					입력<i class="fa fa-check spaceLeft"></i>
				</button>
				<button id="btn_pay" class="btn btn-primary">
					취소<i class="fa fa-check spaceLeft"></i>
				</button>
			</div>
		</div>
	
		<div class="form-group" id=""></div>
		</form>
		<hr>
	</div>


	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>