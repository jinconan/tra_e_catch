<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<%
String emp_no = request.getParameter("in_emp_no").toString();
System.out.println("뾰롱"+emp_no);
%>
<body>
	<script type="text/javascript">
	function accept(){
		$("#f_empupdatelist").attr("action","<%=request.getContextPath()%>/per/auth/empupdateaccept");
		$("#f_empupdatelist").submit(); 
		
	}
$(function() {
	/* 직급리스트 */
	$.ajax({
		url:'<%=request.getContextPath()%>/perR/auth/ctlev',
		type: "json",
		success: function(data){
			for(i in data){
				$("#af_ctlev").append("<option val="+data[i].LEV_NO+">"+data[i].NAME+"</option>");
			}
		}
	})
	/* 근무지리스트 */
	$.ajax({
		url:'<%=request.getContextPath()%>/perR/auth/loclist',
		type: "json",
		success: function(data){
			for(i in data){
				$("#af_loc").append("<option val="+data[i].LOC_NO+">"+data[i].NAME+"</option>");
			}
		}
	})
	/* 부서리스트 */
		$.ajax({
		url:'<%=request.getContextPath()%>/perR/dept/list',
		type: "json",
		success: function(data){
			for(i in data){
				$("#af_dept").append("<option val="+data[i].DEPT_NO+">"+data[i].NAME+"</option>");
			}
		}
	})
	/* 팀리스트리스트 */
		$.ajax({
		url:'<%=request.getContextPath()%>/perR/auth/teamlist',
		type: "json",
		success: function(data){
			for(i in data){
				$("#af_team").append("<option val="+data[i].TEAM_NO+">"+data[i].NAME+"</option>");
			}
		}
	})
	$('#p_table').bootstrapTable({
		url:'<%=request.getContextPath()%>/perR/auth/indivemplist',
		queryParams: function(p){
            return{
            	emp_no : '<%=emp_no%>'
            }
		
		},
		onClickRow : function(row,$element, field) {
			console.log(row.EMP_NO);
			console.log(row.ENAME);
			$("#be_emp_no").val(row.EMP_NO);
			$("#af_emp_no").val(row.EMP_NO);
			$("#be_emp_name").val(row.ENAME);
			$("#af_emp_name").val(row.ENAME);
			$("#be_dept").val(row.DNAME);
			$("#be_ctlev").val(row.CLEV);
			$("#be_loc").val(row.LNAME);
			$("#be_team").val(row.TNAME);
			$("#exampleModal").modal('show');
			/*  test메소드에 아작스 처리하면 됨 쀼쀼 */ 
			
		}
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
						<th width="15%" data-field="ENAME">사원이름</th>
						<th width="15%" data-field="TNAME">팀명</th>
						<th width="15%" data-field="CLEV">직급</th>
						<th width="15%" data-field="HDAY">입사일자</th>

					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<nav>
				<div class="text-center"></div>
			</nav>
			<!-- 업데이트 모달 -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div id="login-overlay" class="modal-dialog">
					<div class="modal-content" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">인사정보 수정</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-6">
									<div class="well">
										<div class="form-group">
											<label for="emp_no" class="control-label">사원번호</label> <input type="text" class="form-control" id="be_emp_no" name="be_emp_no" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
										</div>
										<div class="form-group">
											<label for="emp_name" class="control-label">사원이름</label> <input type="text" class="form-control" id="be_emp_name" name="be_emp_name" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
										</div>
										<div class="form-group">
											<label for="dept" class="control-label">부서</label> <input type="text" class="form-control" id="be_dept" name="be_dept" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
										</div>
										<div class="form-group">
											<label for="team" class="control-label">소속팀</label> <input type="text" class="form-control" id="be_team" name="be_team" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
										</div>
										<div class="form-group">
											<label for="ctlv" class="control-label">직급</label> <input type="text" class="form-control" id="be_ctlev" name="be_ctlev" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
										</div>
										<div class="form-group">
											<label for="loc" class="control-label">근무지</label> <input type="text" class="form-control" id="be_loc" name="be_loc" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="well">
										<form id="f_empupdatelist" method="POST">
											<div class="form-group">
												<label for="emp_no" class="control-label">사원번호</label> <input type="text" class="form-control" id="af_emp_no" name="emp_no" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
											</div>
											<div class="form-group">
												<label for="emp_name" class="control-label">사원이름</label> <input type="text" class="form-control" id="af_emp_name" name="emp_name" value="" readonly="" title="Please enter you username"> <span class="help-block"></span>
											</div>
											<div class="form-group">
												<label for="dept" class="control-label">부서</label> <select class="form-control" id="af_dept" name="af_dept">
												</select> <span class="help-block"></span>
											</div>
											<div class="form-group">
												<label for="af_team" class="control-label">소속팀</label> <select class="form-control" id="af_team" name="af_team">
												</select> <span class="help-block"></span>
											</div>
											<div class="form-group">
												<label for="ctlv" class="control-label">직급</label> <select class="form-control" id="af_ctlev" name="af_ctlev">
												</select> <span class="help-block"></span>
											</div>
											<div class="form-group">
												<label for="loc" class="control-label">근무지</label> <select class="form-control" id="af_loc" name="af_loc">
												</select> <span class="help-block"></span>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="printinp" onclick="javascript:accept()">수정</button>
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>

						</div>
					</div>
				</div>

			</div>
			<!-- 업데이트 모달끝 -->
		</div>
	</div>
	<%-- 	<jsp:include page="/WEB-INF/views/_common/footer.jsp" /> --%>
</body>
</html>