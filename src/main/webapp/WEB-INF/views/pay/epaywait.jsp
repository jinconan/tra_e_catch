<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    	  List<Map<String,Object>> epaywaitList = (List<Map<String,Object>>)request.getAttribute("epaywaitList"); 
         Object semp_no = session.getAttribute("emp_no");
         Object semp_name = session.getAttribute("emp_name");
         
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 대기 문서</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>

<script type="text/javascript">
var modal_row = null;

$(function(){
	$('#p_table').on('click-row.bs.table', function (e, row, $element, field) {
		modal_row = row;
		
		if(modal_row.CENO == ${sessionScope.emp_no}) {
	   		$("#btn_con").text("승인");
	    
		} else if(modal_row.AENO == ${sessionScope.emp_no}) {
			$("#btn_con").text("결재");
		}
		
		$("#exampleModal").modal('show');
		$("#dno").text(row.DNO);
		$("#udate").text(row.UDATE);
		$("#cdate").text(row.CDATE);
		$("#adate").text(row.ADATE);
		$("#name").text(row.ENAME);
		$("#content").text(row.CONTENT);
		$("#title").text(row.TITLE);
		
	})
	
	$("#btn_con").on('click',function(evt){
		$("#signDno").val(modal_row.DNO);
	   	if(modal_row.CENO == ${sessionScope.emp_no}) {
	   		//alert("승인자")
	   		$("#signVal").val("1");
	   		$("#isConfirm").val("true");
	   		//$("#cname").text(modal_row.CENAME);
	   		//$("#cdate").text(modal_row.CDATE);
	    
		} else if(modal_row.AENO == ${sessionScope.emp_no}) {
			//alert("결재자")
			//$("#aname").text(modal_row.AENAME);
			$("#isConfirm").val("false");
			$("#signVal").val("2");
		}
	
	   	$("#f_update").submit();
	});
	
	$("#btn_deny").click(function() {
		$("#signDno").val(modal_row.DNO);
		if(modal_row.CENO == ${sessionScope.emp_no}) {
	   		//alert("승인자")
	   		$("#signVal").val("-1");
	   		$("#isConfirm").val("true");
	   		//$("#cname").text(modal_row.CENAME);
	   		//$("#cdate").text(modal_row.CDATE);
	    
		} else if(modal_row.AENO == ${sessionScope.emp_no}) {
			//alert("결재자")
			//$("#aname").text(modal_row.AENAME);
			$("#signVal").val("-2");
			$("#isConfirm").val("false");
		}
	
	   	$("#f_update").submit();
	})
});
/* function test(row){
	
	
} */

</script>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">

			<div class="page-header">
				<h1>결재 대기 문서</h1>
			</div>
			<table class="table table-striped" id="p_table" 
				data-toggle="table"
				data-url="<%=request.getContextPath() %>/payR/epaywait"
				data-show-columns="true" data-toolbar="#table-toolbar"
				data-pagination="true" data-page-list="[10]"
				data-side-pagination="server">
				<!-- RNO, DNAME, TITLE, CONTENT, UDATE, CENAME, AENAME, SIGN_YN, SRESULT -->
				<thead>
					<tr>
						<th data-field="RNO" data-visible="false">#</th>
						<th data-field="DNAME">종류</th>
						<th data-field="TITLE">제목</th>
						<th data-field="UDATE">기안날짜</th>
						<th data-field="CENAME">승인자</th>
						<th data-field="AENAME">결재자</th>
						<th data-field="SRESULT">현황</th>
					</tr>
				</thead>
			</table>
		</div>
		
		
		<!-- 상세내역 모달 페이지 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">결재 대기 문서</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div id="d_viewwork">
							<form id="f_update" method="post" action="<%=request.getContextPath()%>/pay/epayupdate">
								<input type="hidden" name="signVal" id="signVal">
								<input type="hidden" name="signDno" id="signDno">
								<input type="hidden" name="isConfirm" id="isConfirm">
								<table border="1" class="center-block" style="width: 532px; text-align:center;">
									<tr>
										<td colspan="5">
											<h3>기 안 서</h3>
										</td>
									</tr>
									<tr>
										<td width="15%">문서번호</td>
										<td width="45%" id="dno"></td>
										<td rowspan="2" width="10%">결재</td>
										<td width="15%">승인</td>
										<td width="15%">결재</td>
									</tr>
									<tr>
										<td>기안일자</td>
										<td id="udate"></td>
										<td id="cname"></td>
										<td id="aname"></td>
									</tr>
									<tr>
										<td>승인일자</td>
										<td id="cdate"></td>
										<td colspan="3">기안자</td>
									</tr>
									<tr>
										<td>결재일자</td>
										<td id="adate"></td>
										<td colspan="3" id="name"></td>
									</tr>
									<tr>
										<td>제목</td>
										<td colspan="4" id="title"></td>
									</tr>
									<tr>
										<td colspan="5">내용</td>
									</tr>
									<tr>
										<td id="content" colspan="5" rowspan="10" width="532" height="420"></td>
									</tr>
								</table>
								</form>
						</div>
					</div>
					
					<div class="modal-footer" >
						<!-- <button type="button" class="btn btn-primary" id="printinp">Print</button> -->
						<button type="button" class="btn btn-secondary" id="btn_con"
							data-dismiss="modal">승인</button>
						<button type="button" class="btn btn-secondary" id="btn_deny"
							data-dismiss="modal">부결</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>

					</div>
				</div>
			</div>
		</div>
		<!-- 상세내역 모달 끝 -->
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>