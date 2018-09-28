<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원명부</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%
	List<Map<String,Object>> getEmpList = (List<Map<String,Object>>)request.getAttribute("getEmpList");
%>
<script type="text/javascript">
$(function() {
		$("#btn_emp").click(function(){
			
			$('#p_table').bootstrapTable({
				method: "post",
				contentType: 'application/x-www-form-urlencoded',
				queryParams: function(p){
                    return{
                    	lev_no : $("#lev-no").val(),
                    	name : $("#per-name").val(),
                    	dept_no : $("#dept-no").val(),
                    };
				}
				,url:'<%=request.getContextPath()%>/perR/empList'
			});
			/* var lev_no = $("#lev-no").val();
			var name = $("#name").val();
			var dept_no = $("#dept-no").val();
			
			param = "lev-no="+lev_no+"&name="+name+"&dept-no="+dept_no */

			/* var param = {};
			param.lev_no = $("#lev-no").val();
			param.name = $("#name").val();
			param.dept_no = $("#dept-no").val(); */
			
			
			<%-- alert(param);
			$.ajax({
				url:'<%=request.getContextPath()%>/perR/empList'
				,data:param
				,dataType:"json"
				,method:"POST"
				,success:function(data){
					alert(data);
					$('#p_table').bootstrapTable({data:data})
				}
			 ,error:function(Object){
		    	 alert("error : "+Object.responseText);
		     }
			}); --%>
		/* 	$.ajax({
				url:"/tra_e_catch/per/emptable"
				,method:"GET"
				,success:function(data){
					alert("아작스 성공");
					$("#emptable").html(data);
				}
			 ,error:function(Object){
		    	 alert("error : "+Object.responseText);
		     }
			});
			return false; */
		});
	});
</script>
	<!-- <script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker();
		$('#datetimepicker2').datetimepicker();
		$('#datetimepicker3').datetimepicker();
	});
</script> -->
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
<div class="container">
	<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
	<div class="col-md-10">
		<form class="form-horizontal">
		  <div class="page-header">
          <h1>사원명부 <small>basic form</small></h1>
         </div>
         <form id="f_info">
			<div class="form-group">
				<label class="col-sm-3 control-label" for="per-name">이름</label>
				<div class="col-sm-3">
					<input class="form-control" name="name" id="per-name" type="per-name"
						placeholder="이름">
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="lev-no">직급코드</label>
				<div class="col-sm-4">
					<input class="form-control" name="lev-no" id="lev-no" type="lev-code"
						placeholder="직접코드">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="dept-no">부서코드</label>
				<div class="col-sm-4">
					<input class="form-control" name="dept-no" id="dept-no" type="dept-code"
						placeholder="부서코드">
					
				</div>
			</div>
			</form>
			<!-- <div class="form-group">
				<label class="col-sm-3 control-label" for="loc-no">지역코드</label>
				<div class="col-sm-4">
					<input class="form-control" id="loc-no" type="loc-code"
						placeholder="지역코드">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="hire-date">입사일자</label>
				<div class="col-sm-3">
					<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" placeholder="입사일자"/> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar" ></span>
							</span>
						</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="birthday">생일</label>
				<div class="col-sm-3">
					<div class='input-group date' id='datetimepicker2'>
							<input type='text' class="form-control" placeholder="생일"/> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar" ></span>
							</span>
						</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="resign-yn">퇴사여부</label>
				<div class="col-sm-5">
					<input class="form-control" id="resign-yn" type="resign-yn"
						placeholder="퇴사여부">
				</div>
			</div>		
			<div class="form-group">
				<label class="col-sm-3 control-label" for="last-date">마지막근무일</label>
				<div class="col-sm-3">
					<div class='input-group date' id='datetimepicker3'>
							<input type='text' class="form-control" placeholder="마지막근무일"/> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar" ></span>
							</span>
						</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="emp-id">아이디</label>
				<div class="col-sm-3">
					<input class="form-control" id="emp-id" type="id"
						placeholder="아이디">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="emp-pass">password</label>
				<div class="col-sm-3">
					<input class="form-control" id="emp-pass" type="password"
						placeholder="password">
				</div>
			</div>				 -->
			</div>
			<div class="form-group">
				<div class="col-sm-12 text-center">
					<button id="btn_emp"class="btn btn-primary">
						검색<i class="fa fa-check spaceLeft"></i>
					</button>
					
				</div>
			</div>
			<!-- <div class="form-group" id="emptable">
				
			</div>   -->
			<div class="table-responsive col-xs-9">
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
						
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<!-- <th width="15%" data-field="EMP_NO">사원번호</th> -->
							<th width="10%" data-field="NAME">이름</th>
							<th width="20%" data-field="HIRE_DATE">입사일자</th>
							<th width="20%" data-field="LEV_NO">직급코드</th>
							<th width="20%" data-field="DEPT_NO">부서코드</th>
							<th width="10%" data-field="LOC_NO">지역코드</th>
							<th width="20%" data-field="BIRTHDAY">생일</th>
							<th width="20%" data-field="EMAIL">이메일</th>
							<th width="15%" data-field="TEAM_NO">팀코드</th>
							

						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
		</form>
		<hr>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>