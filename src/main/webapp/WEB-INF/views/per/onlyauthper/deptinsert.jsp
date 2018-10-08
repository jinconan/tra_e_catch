<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%
int addemp_no = Integer.parseInt(String.valueOf(session.getAttribute("emp_no"))); //사원정보 받는 곳
%>
</head>
<body>
	<script type="text/javascript">
	function deptinsertbutton(){
		$("#exampleModalInsert").modal('show'); 
		
	}
	//부서 추가
	function deptinsertnow(){
		/* alert("찍어볼까~?"); 정상작동 */
		$("#f_deptinsert").attr("action","./deptinsert");
		$("#f_deptinsert").submit(); 
		alert("정상적으로 처리 되었습니다.");
		
	}
	//부서 수정
	function deptupdatenow(){
		/* alert("찍어볼까~?"); 정상작동 */
		$("#f_deptupdate").attr("action","./deptupdate");
		$("#f_deptupdate").submit(); 
		alert("정상적으로 처리 되었습니다.");
		
	}
	 $(function() {
			$('#p_table').bootstrapTable({
				url:'<%=request.getContextPath()%>/perR/only/deptlist',
				onClickRow : function(row,$element, field) {
					console.log(row);
					
					 
                     
                     $("#up_dept_no").val(row.DEPT_NO);
					 $("#up_dept_name").val(row.NAME);
					 $("#up_dept_note").val(row.NOTE);
					$("#exampleModalupdate").modal('show'); 
				}
			});
			var emp_nochk = <%=addemp_no%>;

			if(emp_nochk>3){
				alert("인사권자 전용 페이지 입니다.");
				location.href='<%=request.getContextPath()%>/';
			}
		
	}); 
	</script>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<h3>
			<b>부서관리</b>
		</h3>
		
		<div class="col-sm-10">
		
			<div class="table-responsive col-xs-9" style="overflow:auto;">
		<button type="button" class="btn btn-primary" id="deptinsert" onclick="javascript:deptinsertbutton()">부서추가</button><br>
		<button type="button" class="btn btn-primary" id="deptinsert" >팀추가</button>
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
							<th data-field="DEPT_NO" data-width="15%">부서번호</th>
							<th data-field="NAME" data-width="20%">부서명</th>
							<th data-field="NOTE" data-width="20%">설명</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
			
			<!-- 업데이트 모달 -->
		<div class="modal fade" id="exampleModalupdate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		 <div id="login-overlay" class="modal-dialog">
      <div class="modal-content" aria-hidden="true">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel">부서정보 수정</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class=" col-xs-offset-3 col-xs-6">
 					<div class="well">
 					 <form id="f_deptupdate" method="POST">
                              <div class="form-group">
                                  <label for="up_dept_no" class="control-label">부서번호</label>
                                  <input type="text" class="form-control" id="up_dept_no" name="up_dept_no" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                                 <div class="form-group">
                                  <label for="up_dept_name" class="control-label">부서명</label>
                                  <input type="text" class="form-control" id="up_dept_name" name="up_dept_name" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                              <label for="up_dept_name" class="control-label">부서설명</label>
                                  <input type="text" class="form-control" id="up_dept_note" name="up_dept_note" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                                 </form>
 						</div>
                  </div>
              </div>
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="printinp" onclick="javascript:deptupdatenow()">수정</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        
      </div>
      </div>
  </div>

  </div>
		<!-- 업데이트 모달끝 -->	
		
		
		
		
		
		
		
		<!-- 추가 모달 -->
		<div class="modal fade" id="exampleModalInsert" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		 <div id="login-overlay" class="modal-dialog">
      <div class="modal-content" aria-hidden="true">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel">부서정보 추가</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class=" col-xs-offset-3 col-xs-6">
 					<div class="well">
 					 <form id="f_deptinsert" method="POST">
                              <div class="form-group">
                                  <label for="new_dept_no" class="control-label">부서번호</label>
                                  <input type="text" class="form-control" id="new_dept_no" name="new_dept_no" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                                 <div class="form-group">
                                  <label for="new_dept_name" class="control-label">부서이름</label>
                                  <input type="text" class="form-control" id="new_dept_name" name="new_dept_name" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="new_dept_note" class="control-label">부서설명</label>
                                <input type="text" class="form-control" id="new_dept_note" name="new_dept_note" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                                 </form>
 						</div>
                  </div>
              </div>
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="printinp" onclick="javascript:deptinsertnow()">추가</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        
      </div>
      </div>
  </div>

  </div>
		<!-- 추가 모달끝 -->	
		</div>
		<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
	</div>


</body>
</html>