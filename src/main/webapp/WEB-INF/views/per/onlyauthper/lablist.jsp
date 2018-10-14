<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근로계약서테이블</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<%
String emp_no = request.getParameter("in_emp_no").toString();
%>
<body>
	<script type="text/javascript">

	function test(){
		var inputdata = $("#f_modalselect").serialize();
	 	$.ajax({
	        method:"POST"
	        ,url:"<%=request.getContextPath()%>/per/auth/wordprint"
	        ,data:inputdata,
	        success : function(log){
	        	console.log(log);
	        	$("#d_viewwork").html(log);
	        }
			,error : function(xhr) {
				console.log("땡");
			}
        }); 
	}


$(function() {
	var selectword =null;
	
	$('#p_table').bootstrapTable({
		
		url:'<%=request.getContextPath()%>/perR/auth/worklist',
		queryParams: function(p){
            return{
            	emp_no : '<%=emp_no%>'
            };
		},
		onClickRow : function(row,$element, field) {
			console.log(row.UP_DATE);
			$("#selectdate").val(row.UP_DATE);
			alert($("#selectdate").val());
			
			$("#exampleModal").modal('show');
			test();/* test메소드에 아작스 처리하면 됨 쀼쀼 */
		}

	});

	$('#printinp').click(function(){
		$('#printtable').printThis(); <!-- print 할 부분에 설정 -->
	});

});

</script>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<table class="table table-striped" id="p_table">
				<thead>
					<tr>
						<!-- 김훈태 작업중  -->
						<th width="10%" data-field="EMP_NO">사원번호</th>
						<th width="20%" data-field="UP_DATE" id="testid">작성일자</th>
						<th width="15%" data-field="CONTENT">내용</th>
					</tr>
				</thead>
				<tbody id="p_tabledata">
				</tbody>
			</table>
			<nav>
				<div class="text-center">
	
				</div>
			</nav>
		</div>
		<form id="f_modalselect" method="post">
		<input type="hidden" id="selectdate" name="hday">
		<input type="hidden" id="selectemp_no" name="emp_no" value="<%=emp_no%>">
		</form>
		
		<!-- 상세내역 모달 페이지 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document" style="width: 635px">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">고용계약서 상세페이지</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div id="d_viewwork"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="printinp">Print</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div>
		<!-- 상세내역 모달 끝 -->
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>