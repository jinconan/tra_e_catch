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
	

	/* function listoption(){
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
	
	}
	function insertForm(){
		//$("#f_insert").attr("method","post");
		$("#f_insert").attr("action","./boardinsert.bo2");
		$("#f_insert").submit();
	} */
	
	</script>
</head>
<body>
<script type="text/javascript">
	 $(document).ready(function(){
		$("#btn_Inst").click(function(){
			$.ajax({
				url:'/try_e_catch/pay/epay/jobInst'
				,method:"POST"
				,data:""
				,success:function(data){
					alert("아작스 성공");
					$("#empjobtable").attr(data);
				}
				,error:function(Object){
					alert("error:"+Object.responseText);
				}
			});
			return false;
		});
	}); 
		
	/* function jobInstForm() {
		$("#f_jobInst").attr("method","post");
		$("#f_jobInst").attr("action","./jobInst");
		$("#f_jobInst").submit();
	} */	
	 
</script>	
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
			<form class="form-horizontal" id="f_insert" method="post">
				<div class="col-md-10">
			
				<div class="page-header">
					<h1>기안 문서작성</h1>
				</div>
				
				<!-- 분류 버튼 -->
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false">
						분류 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" id="optionum" onclick="listoption()">
						<li><a href="#" id="btn_Inst" onClick="jobInstForm()">작업지시서</a></li>
						<li><a href="#">기안 문서</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</div>
				
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
							<li><a href="#">부서명</a></li>
							<li><a href="#">부서명</a></li>
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
				<button id="btn_pay" class="btn btn-primary">
					저장<i class="fa fa-check spaceLeft"></i>
				</button>
				<button id="btn_pay" class="btn btn-primary">
					취소<i class="fa fa-check spaceLeft"></i>
				</button>
			</div>
		</div>
	
		<div class="form-group" id="empjobtable"></div>
		</form>
		<hr>
	</div>


	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>