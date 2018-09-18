<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>증명서 발급</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>

<script type="text/javascript">

	
	

function listoption(){
	var optnum = $("#optionnum").val();
	//alert(optnum);
	
	if(optnum=="1"){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/certform"
	        ,data:"",
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	$("#d_usepoint").text($("#useinput").val());
	        	listform();
	        	
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        });
	}
	else if(optnum==0){
		alert("증명서를 선택해 주세요");
		
		
	}
	/* 경력증명서 */
	else if(optnum==2){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/careercert"
	        ,data:"",
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	$("#d_usepoint").text($("#useinput").val());
	        	listform();
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        });
	}
	/* 사직서 양식 */
	else if(optnum==3){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/retireform"
	        ,data:"",
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	listform();
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        });
	}
	/* 시말서 양식 */
	else if(optnum==4){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/reasonform"
	        ,data:"",
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	listform();
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        });
	}



}

function listform(){
	$.ajax({
        method:"POST"
        ,url:"/tra_e_catch/per/cert/certprint"
        ,success : function(log){
        	$("#d_printlist").html(log);
          }
           });
}


</script>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<div class="col-sm-10">
			<!-- 메인화면 -->
			<div class="panel panel-primary col-xs-8">
				<table>
					<tr>
						<td>증명서 종류 :&nbsp;&nbsp;&nbsp;</td>
						<td>
						<select class="form-control" id="optionnum">
							<option value="0">증명서 선택</option>
							<option value="1">재직증명서</option>
							<option value="2">경력증명서</option>
							<option value="3">사직서</option>
							<option value="4">시말서</option>
						</select>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>사용 용도 : &nbsp;&nbsp;&nbsp;</td>

						<td><input type="text" id="useinput" class="form-control" placeholder="ex)은행제출용"></div></td>
						<td>&nbsp;&nbsp;
							<button type="button" class="btn btn-primary" onclick="listoption()">
								<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>OK
							</button>
						</td>
					</tr>
				</table>

			</div>
			<div class="col-xs-10">
				<div id="d_formprint"></div>
			</div>
			<!-- 메인화면 끝 -->

			<!-- 증명서.jsp파일(ajax, 팝업창으로 처리) -->

			<!-- 해당버튼 테이블(ajax처리) -->
			<div id="d_printlist"></div>
		</div>
	</div>
</body>
</html>