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
		 /* $('#datetimepicker1').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		});
		$('#datetimepicker2').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		}); */
	
	$('#fromDate').datetimepicker({
		language : 'ko', // 화면에 출력될 언어를 한국어로 설정한다.
		pickTime : false, // 사용자로부터 시간 선택을 허용하려면 true를 설정하거나 pickTime 옵션을 생략한다.
		defalutDate : new Date() // 기본값으로 오늘 날짜를 입력한다. 기본값을 해제하려면 defaultDate 옵션을 생략한다.
	});

	$('#toDate').datetimepicker({
		language : 'ko',
		pickTime : false,
		defalutDate : new Date()
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
		
		$.ajax({
			method:"POST"
			,url:""
		})
		
	}); 
	 
	 function listoption() {
		 var optnum = ("#optionnum").val();
		 if(optnum == "기획서"){
			 
		 }
		 else if(optnum==0){
			 alert("증명서를 선택해 주세요");
				
		}
		 else if(optnum == "계약서"){
			 
		 }
		 else if(optnum == "근로계약서"){
			 
		 }
		 else if(optnum == "고용계약서"){
			 
		 }
		 else if(optnum == "작업지시서"){
			 
		 }
		 else if(optnum == "사직서"){
			 
		 }
		 else if(optnum == "휴가"){
			 
		 }
		 else if(optnum == "외근"){
			 
		 }
		 else if(optnum == "프로젝트보고서"){
			 
		 }
		 else if(optnum == "협찬보고서"){
			 
		 }
		 else if(optnum == "협업승인서"){
			 
		 }
		 else if(optnum == "공간대여"){
			 
		 }
		 else if(optnum == "공용장비대여"){
			 
		 }
		 else if(optnum == "주말근무보고서"){
			 
		 }
		 else if(optnum == "회식보고서"){
			 
		 }
	 }
	 
	 function reset() {
		 
		 $.ajax({
			method:"POST"
			,url:"/tra_e_catch/pay/epay/epayview"
		 })
		 
	 }
	 
	 function insert() {
		
		 $("#f_insert").attr("action","./epayInsert");
		 $("#f_insert").submit();
		 alert("저장되었습니다.");
	 }
	 
	
		
	 
</script>	
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
			<form class="form-horizontal" id="f_insert" method="post">
				<div class="col-md-10">
				
				<!-- 분류 버튼 -->
				<table>
					<tr>
						<td>결재문서 분류 :&nbsp;&nbsp;&nbsp;</td>
						<td>
						<select class="form-control" id="optionnum" name="doc_no">
							<option val="0">결재문서 선택</option>
							<option val="1">기획서</option>
							<option val="2">계약서</option>
							<option val="3">근로계약서</option>
							<option val="4">고용계약서</option>
							<option val="5">작업지시서</option>
							<option val="6">사직서</option>
							<option val="7">휴가</option>
							<option val="8">외근</option>
							<option val="9">프로젝트보고서</option>
							<option val="10">협찬보고서</option>
							<option val="11">협업승인서</option>
							<option val="12">공간대여</option>
							<option val="13">공용장비대여</option>
							<option val="14">주말근무보고서</option>
							<option val="15">회식보고서</option>
						</select>
						</td>
				</tr>
				</table>	
				
				<center>
				<div class="page-header">
					<h1></h1>
				</div>
				</center>
				
				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc_emp_name">사원이름</label>
					<div class="col-sm-3">
						<input class="form-control" id="c_emp_name" name="emp_name" type="text"
							placeholder="사원이름">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc-emp_no">사원번호</label>
					<div class="col-sm-3">
						<input class="form-control" id="c_emp_no" name="emp_no" type="text"
							placeholder="사원번호">
					</div>
				</div>
			
				<!-- <div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">담당부서</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputEmail" type="text"
							placeholder="담당부서">
					</div>
					<div class="btn-group">

						버튼태그

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
				</div> -->
				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc_name">제목</label>
					<div class="col-sm-6">
						<input class="form-control" id="doc_title" name="title" type="text"
							placeholder="제목">

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc-start-date">시행일자</label>
					<div class="col-sm-2" style="padding-right: 0px;" >

						<div class='input-group date' id='fromDate' name="up_date">
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>



					<label class="col-sm-2 control-label" for="doc-end-date">종료일자</label>
					<div class="col-sm-2" style="padding-left: 0px;">

						<div class='input-group date' id='toDate' name="toDate">
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>


				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc-content">내용</label>
					<div class="col-sm-6">
						<textarea class="form-control" id="d_content" name="content" rows="20"></textarea>
					</div>
				</div>

		</div>
	
		<div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_pay" class="btn btn-primary" onclick="javascript:insert()">
					입력<i class="fa fa-check spaceLeft"></i>
				</button>
				<button id="btn_pay" class="btn btn-primary" onclick="javascript:reset()">
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