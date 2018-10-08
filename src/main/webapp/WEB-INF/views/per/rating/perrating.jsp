<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사평정작성페이지</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%-- <%@ include file="../common/commonUI.jsp" %> --%>

</head>
<body>
<script type="text/javascript">
var optnum = $("#ranknum").val();
$(function() {
	/* DB에서 만들어진 뷰를 이용하여 인사팀장의 의견과 평점을 넣을예정. */
	/* $("#insateam").html("테스트 중입니다 평점 : A"); */
	if(optnum==1){
		$.ajax({
			method:"POST"
			,url:"/tra_e_catch/rating"
			,data:""
			,success : function(log){
				$("#insateam").html(log);
			}
			
		})
	}
	$.ajax({
		url:'<%=request.getContextPath()%>/perR/rating/list',
		type: "json",
		success: function(data){
			for(i in data){
				$("#e_list").append("<option val="+data[i].EMP_NO+">"+data[i].ENAME+"</option>");
				
			}
		}
	})
	
	//개인 평정 작성 분기
	 $.ajax({
		url:'<%=request.getContextPath()%>/perR/rating/quar',
		type: "json",
		success: function(data){
			for(i in data){
				$("#ranknum").append("<option val="+data[i].RNO+">"+data[i].QUARTER+"</option>");
				
			}
			
		}
	})

});
function isselect(){

	$("#i_quarter").val($("#ranknum option:selected").val());
	var testindex = $("#f_quarter").serialize();
	//인사권자의견 평정 작성 분기
$.ajax({
	url:'<%=request.getContextPath()%>/perR/rating/leader',
	method:"POST",
	type: "json",
	data: testindex,
	success: function(data){
		for(i in data){
			$("#insa").text(data[i].CONTENT);
	}
			
		}
		
	})
}

function isok(){
/* 	alert("저장되었습니다."); */
	
	alert($("#e_list option:selected").val());
	
	 $("#f_content").attr("action","./servrating");
	$("#f_content").submit(); 
}

</script>
<jsp:include page="/WEB-INF/views/_common/header.jsp" />
<br>
<div class="container">
<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
	<h3><b>근 무 평 정 작 성</b></h3>
	<table>
	<tr>
	<td width="900" height="550">
	<div class="panel panel-primary col-xs-10" style="
    margin-bottom: 10px;
    margin-top: 10px;
    padding-top: 10px;">
    
    <form id="f_content" method="post">

				<div class="col-xs-4 col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<br> 개인 평정 작성<br> <br>

						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<br> 인사 팀장 의견<br> <br>
							<br>
							<br>

						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-7">
						<textarea class="form-control" rows="4" placeholder="개인평가를 작성해 주세요" id="w_content"name="w_content"></textarea>
						<br>
						<div class="col-xs-12" style="padding-left: 0px; padding-right: 0px;">
						<select class="form-control col-xs-6" id="ranknum" style="width: 78%;">
						</select> 
						&nbsp; &nbsp;<button type="button" class="btn btn-primary" onclick="javascript:isselect()">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 검색</button>

						</div>
						<textarea class="form-control" id="insa" rows="3" readonly=""></textarea>
					</div>
					</div>
			<br>
				<div class="col-xs-4 col-sm-4">
				<div class="panel panel-primary">
						<div class="panel-heading">
				 <br> <br> 팀원 평정 작성 <br> <br> <br> <br>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-7">
						<select class="form-control" id="e_list" name="e_list">

						</select>
						<textarea class="form-control" rows="5" placeholder="" name="e_content"id="e_content"></textarea>
					</div>
					</div>

				<div class="col-xs-4 col-sm-4">
				<div class="panel panel-primary">
						<div class="panel-heading">
					<br> 팀장 평정 작성 <br>  <br> <br>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-7">
						<textarea class="form-control" rows="5" placeholder="팀장평가를 작성해 주세요"id="pm_content" name="pm_content"></textarea>

					</div>
					</div>
</form>
	</div>
	</td></tr>
</table>
	<div class="col-xs-offset-5">
	<button type="button" class="btn btn-primary" onclick=javascript:isok()>
		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> OK
	</button>

	<button type="button" class="btn btn-success">
		<span class="glyphicon glyphicon-save" aria-hidden="true"></span>SAVE
	</button>

	<button type="button" class="btn btn-danger">
		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Remove
	</button>
	</div>
							<form id="f_quarter" method="post">
						<input type="hidden" id="i_quarter" name="i_quarter">
						</form>
						
						
<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</div>
</body>
</html>