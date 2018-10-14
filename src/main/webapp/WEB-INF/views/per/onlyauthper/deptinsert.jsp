<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%
int addemp_no = Integer.parseInt(String.valueOf(session.getAttribute("emp_no"))); //사원정보 받는 곳
int counts = (Integer)request.getAttribute("counts");
int list = (((counts-1)/10)*10)+1;
int num = (counts%10);
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
		$("#f_deptinsert").attr("action","<%=request.getContextPath()%>/per/auth/deptinsert");
		$("#f_deptinsert").submit(); 
		alert("정상적으로 처리 되었습니다.");
		
	}
	//팀추가
	function teaminsertnow(){
		/* alert("찍어볼까~?"); 정상작동 */
		$("#f_deptinsert").attr("action","<%=request.getContextPath()%>/per/auth/deptinsert");
		$("#f_deptinsert").submit(); 
		alert("정상적으로 처리 되었습니다.");
		
	}
	
	
	//부서 수정
	function deptupdatenow(){
		/* alert("찍어볼까~?"); 정상작동 */
		$("#f_deptupdate").attr("action","<%=request.getContextPath()%>/per/auth/deptupdate");
		$("#f_deptupdate").submit(); 
		alert("정상적으로 처리 되었습니다.");
		
	}
	 $(function() {
			$('#p_table').bootstrapTable({
				url:'<%=request.getContextPath()%>/perR/auth/deptlist/<%=counts%>',
				onClickRow : function(row,$element, field) {
					console.log(row);
					
					 
                     
                     $("#up_dept_no").val(row.DEPT_NO);
					 $("#up_dept_name").val(row.NAME);
					 $("#up_dept_note").val(row.NOTE);
					$("#exampleModalupdate").modal('show'); 
				}
			});
			var base = $('#liid'+<%=num%>);
			base.addClass('active');
		
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
		<button type="button" class="btn btn-primary" id="deptinsert" onclick="javascript:deptinsertbutton()">부서 및 팀 추가</button><br>
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
							<th data-field="DEPT_NO" data-width="15%">부서/팀번호</th>
							<th data-field="NAME" data-width="20%">부서/팀명</th>
							<th data-field="NOTE" data-width="20%">설명</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<nav>
					<ul class="pagination">
								<li><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/1" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list-1%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+1%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+2%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+3%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+4%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+5%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+6%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+7%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+8%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+9%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+10%>" aria-label="Previous"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/auth/deptupdatelist/<%=list+100%>" aria-label="Previous"><span aria-hidden="true"> >> </span></a></li>
							</ul>
				</nav>
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
         <button type="button" class="btn btn-primary" id="t_printinp" onclick="javascript:teaminsertnow()">팀추가</button>
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