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
	var certdata = $("#f_certinsert").serialize();
	if(optnum=="재직증명서"){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/certform"
	        ,data:certdata,
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	$("#d_usepoint").text($("#useinput").val());
	        	$("#d_userwork").text($("#workinfo").val());
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
	else if(optnum=="경력증명서"){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/careercert"
	        ,data:certdata,
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	$("#d_usepoint").text($("#useinput").val());
	        	$("#d_userwork").text($("#workinfo").val());
	        	listform();
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        });
	}
	/* 사직서 양식 */
	else if(optnum=="사직서"){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/retireform"
	        ,data:certdata,
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	$("#d_userwork").text($("#workinfo").val());
	        	listform();
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        });
	}
	/* 시말서 양식 */
	else if(optnum=="시말서"){
		$.ajax({
	        method:"POST"
	        ,url:"/tra_e_catch/per/cert/reasonform"
	        ,data:certdata,
	        success : function(log){
	        	
	        	console.log(log);
	        	$("#d_formprint").html(log);
	        	$("#d_userwork").text($("#workinfo").val());
	        	listform();
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        });
		
	}
	/* $("#f_certinsert").attr("action","./certlist");
	$("#f_certinsert").submit(); */
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
			<form id="f_certinsert" method="post">
			<div class="panel panel-primary col-xs-11">
				<table>
					<tr>
						<td>증명서 종류 :&nbsp;&nbsp;&nbsp;</td>
						<td>
						<select class="form-control" id="optionnum" name="p_c_name">
							<option val="0">증명서 선택</option>
							<option val="1">재직증명서</option>
							<option val="2">경력증명서</option>
							<option val="3">사직서</option>
							<option val="4">시말서</option>
						</select>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>사용 용도 : &nbsp;&nbsp;&nbsp;</td>

						<td><input type="text" id="useinput" class="form-control" placeholder="ex)은행제출용" name="p_c_type" style="width: 156px;"></td>
					<td>&nbsp;&nbsp;담당 업무 : &nbsp;&nbsp;&nbsp;</td>
						<td><input type="text" id="workinfo" class="form-control" placeholder="ex)캐릭터디자인" name="p_c_work" style="width: 156px;"></td>
						<td>&nbsp;&nbsp;
							<button type="button" class="btn btn-primary" onclick="listoption()">
								<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>OK
							</button>
						</td>
					</tr>
				</table>

			</div>
			</form>
			<div class="col-xs-10">
				<div id="d_formprint"></div>
			</div>
			<!-- 메인화면 끝 -->

			<!-- 증명서.jsp파일(ajax, 팝업창으로 처리) -->

			<!-- 해당버튼 테이블(ajax처리) -->
			<div id="d_printlist"></div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
</body>
</html>