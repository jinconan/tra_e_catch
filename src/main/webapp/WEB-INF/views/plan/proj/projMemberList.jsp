<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//프로젝트 번호
	int projNo = (Integer) request.getAttribute("projNo");
	boolean isLeader = (Boolean) request.getAttribute("isLeader");
	int empNo = (Integer) session.getAttribute("emp_no");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 프로젝트 참여자 리스트</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
var isModify = false;
var $table = null;
var $notMemberTable = null;

//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
$(document).ready(function() {
	$table = $("#tb_memberList");
	$notMemberTable = $("#tb_notMemberList");
	
	$("#modalInsertMember").on("hidden.bs.modal", function(e) {
		$("#tb_notMemberList").bootstrapTable("uncheckAll");
	})
	
})
</script>
<script>
//편집버튼 클릭시 메뉴 활성화/비활성화
function btnModGroupClick() {
	isModify = !isModify;
	if(isModify == true) {
		$("#btnGroupProjMember>a").eq(0).text("편집완료");
		$table.bootstrapTable('showColumn','cbEmp');
		
	}
	if(isModify == false) {
		$("#btnGroupProjMember>a").eq(0).text("편집시작");
		$table.bootstrapTable('uncheckAll');
		$table.bootstrapTable('hideColumn','cbEmp');
	}
	$("#btnGroupProjMember>a").eq(1).toggle();
	$("#btnGroupProjMember>a").eq(2).toggle();
	$("#btnGroupProjMember>a").eq(3).toggle();
}

//삭제버튼 클릭시 삭제 처리
function btnDelClick() {
	var emp = $table.bootstrapTable("getSelections");
	if(emp.length < 1)
		alert("삭제할 멤버를 선택하세요");
	else {
		var result = confirm(emp[0].empName+" "+emp[0].levName+"을(를) 정말 리스트에서 삭제하시겠습니까?");	
		if(result == true) {
			$.ajax({
				url:"${pageContext.request.contextPath}/plan/memberDelete"
				,type:"post"
				,data:"projNo=<%=projNo%>&empNo="+emp[0].empNo
				,success:function(data) {
					alert(emp[0].empName+" "+emp[0].levName+"이(가) 삭제되었습니다.");
					$table.bootstrapTable("refresh");
					$notMemberTable.bootstrapTable("refresh");
					
					if(emp[0].empNo == <%=empNo%>)
						$("#btnGroupProjMember").hide();
				}
				,error:function(xhr) {
					console.log("error");
				}
			})
		} 
	}
}

//변경버튼 클릭시 멤버 변경 처리
function btnModClick() {
	var emp = $table.bootstrapTable("getSelections");
	var leader = $table.bootstrapTable('getRowByUniqueId','팀장');
	
	if(emp.length < 1)
		alert("변경할 멤버를 선택하세요");
	else {
		var result = null;
		if(leader == null) {
			result = confirm(emp[0].empName+" "+emp[0].levName+"을(를) 팀장으로 임명하시겠습니까?");
		}
			
		else {
			if(leader == emp[0]) {
				alert("이미 팀장입니다.");
				return false;
			}
			else {
				result = confirm(leader.empName+" "+leader.levName+ "에서 " 
						+emp[0].empName+" "+emp[0].levName+"(으)로 팀장을 변경하시겠습니까?");
				
			}
		}
		
		if(result == true) {
			if(leader!=null) {
				$.ajax({
					url:"<%=request.getContextPath()%>/plan/memberUpdate"
					,type:"post"
					,data:"projNo=<%=projNo%>&empNo="+leader.empNo+"&roleName=팀원"
					,success:function(data) {
						$table.bootstrapTable("refresh");
					}
					,error:function(xhr) {
						console.log("error");
					}
				})
			}
			$.ajax({
				url:"<%=request.getContextPath()%>/plan/memberUpdate"
				,type:"post"
				,data:"projNo=<%=projNo%>&empNo="+emp[0].empNo+"&roleName=팀장"
				,success:function(data) {
					$table.bootstrapTable("refresh");
				}
				,error:function(xhr) {
					console.log("error");
				}
			})
		}
	}
}

//추가버튼 클릭시 멤버 추가 처리
function btnAddClick() {
	var emp = $notMemberTable.bootstrapTable("getSelections");
	var empList = [];
	$.each(emp,function(i,data) {
		empList[i]=data.empNo;		
	})
	console.log(empList)
	if(empList.length > 0) {
		$.ajax({
			url:"${pageContext.request.contextPath}/plan/memberInsert"
			,type:"post"
			,data:{
				"projNo":<%=projNo%>
				,"empNo":empList[0]
			}
			,success:function(data) {
				$table.bootstrapTable("refresh");
				$notMemberTable.bootstrapTable("refresh");
			}
			,error:function(xhr) {
				console.log("error");
			}
		})
		
	}
	
	$('#modalInsertMember').modal('hide');
}
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>

		<!-- 작성할 부분 -->
		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong>참여자 리스트</strong>
						<%if(isLeader == true) { %>
						<span id="btnGroupProjMember" class="btn-group">
							<a class="btn btn-primary" href="javascript:btnModGroupClick()">편집시작</a>
							<a class="btn btn-success" data-toggle="modal" data-target="#modalInsertMember" style="display: none;">추가</a>
							<a class="btn btn-warning" href="javascript:btnModClick()" style="display: none;">변경</a>
							<a class="btn btn-danger" href="javascript:btnDelClick()" style="display: none;">삭제</a>
						</span>
						<%} %>
					</h2>
				</div>

				<div class="row">
					<div class="table-responsive">
						<table id="tb_memberList" 
							data-unique-id="roleName"
							data-single-select="true"
							data-pagination="true" 
							data-page-list="[10]"  
							data-search="true" 
							data-toggle="table"
							data-url="<%=request.getContextPath() %>/planR/json/projMemberList?projNo=<%=projNo %>">
						    <thead>
						        <tr>
						        	<th data-checkbox="true" data-field="cbEmp" data-visible="false"></th>
						        	<th data-field="empNo" data-visible="false">사원번호</th>
						            <th data-sortable="true" data-field="empName">사원명</th>
						            <th data-sortable="true" data-field="roleName">역할</th>
						            <th data-sortable="true" data-field="levName">직급</th>
						            <th data-sortable="true" data-field="deptName">부서</th>
						            <th data-sortable="true" data-field="teamName">팀</th>
						            <th data-field="startDate">참여일자</th>
						        </tr>
						    </thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<% if(isLeader == true) { %>
	<!-- 멤버 추가 모달 -->
	<div class="modal fade" id="modalInsertMember" tabindex="-1" role="dialog" aria-labelledby="mLabelInsertMember" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-success">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="mLabelInsertMember">멤버 추가</h4>
				</div>
				<div class="modal-body">
					<table id="tb_notMemberList" data-pagination="true" data-page-list="[10]" data-search="true" data-toggle="table" data-url="<%=request.getContextPath() %>/planR/json/notProjMemberList?projNo=<%=projNo %>">
						<thead>
							<tr>
								<th data-checkbox="true" data-field="cbEmp"></th>
								<th data-field="empNo" data-visible="false">사원번호</th>
								<th data-field="empName">사원명</th>
								<th data-field="roleName">역할</th>
								<th data-field="levName">직급</th>
								<th data-field="deptName">부서</th>
								<th data-field="teamName">팀</th>
								<th data-field="startDate">참여일자</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="btnAddClick()">추가</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<%} %>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
	<script>
	var $a = $("#submenu>li>a");
	$a.each(function(i, data) {
		var href= $(this).attr("href");
		if($(this).text().trim() == "전체 프로젝트 리스트") {
			return;
		}
		$(this).attr("href", href+"${projNo}" );
	});
	</script>
</body>
</html>