<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//프로젝트 번호
	int projNo = (Integer) request.getAttribute("projNo");
	//게시판 리스트 받아오기
	List<Map<String,Object>> projBoardList = (List<Map<String,Object>>)request.getAttribute("projBoardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 게시판 관리</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
var isModify = false;
var $table = null;
//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
$(document).ready(function() {
	$table = $("#tb_boardList");
	
	$("#modalAddBoard").on("hidden.bs.modal", function(e) {
		$("#add_board_name").val("");
	})
	
	$("#modalModBoard").on("hidden.bs.modal", function(e) {
		$("#mod_board_name").val("");
		$("#mod_board_no").val("");
	})
	$("#modalModBoard").on("show.bs.modal", function(e) {
		var board = $table.bootstrapTable("getSelections");
		if(board.length > 0) {
			var boardNo = board[0].board_no;
			var beforeName = board[0].board_name;
			
			console.log(beforeName);
			$("#mod_board_name").val(beforeName);
			$("#mod_board_no").val(boardNo);
		} else {
			alert("이름 변경할 게시판을 선택해주세요.");
			return false;
		}
	})
})
</script>
<script>
//게시판 생성 버튼 클릭 이벤트
function btnAddClick() {
	var $input = $("#add_board_name");
	var boardName = $input.val().trim();
	if(boardName == "") {
		alert("게시판명을 입력해주세요.")
		return false;
	} else {
		$.ajax({
			method:"post"
			,url:"<%=request.getContextPath()%>/plan/projBoardInsert"
			,data:"proj_no=<%=projNo%>&board_name="+boardName
			,success:function(data) {
				$table.bootstrapTable("refresh");
				alert("변경되었습니다.");
				$("#modalAddBoard").modal("toggle");
			}
		})
		
	}
}

//게시판 이름변경 버튼 클릭 이벤트
function btnModClick() {
	var $modBoardName = $("#mod_board_name");
	var $modBoardNo = $("#mod_board_no");
	var boardName = $modBoardName.val().trim();
	var boardNo = $modBoardNo.val();
	
	if(boardName == "") {
		alert("게시판명을 입력해 주세요.");
		return false;
	} else {
		$.ajax({
			method:"post"
			,url:"<%=request.getContextPath()%>/plan/projBoardUpdate"
			,data:"proj_no=<%=projNo%>&board_no="+boardNo+"&board_name="+boardName
			,success:function(data) {
				$table.bootstrapTable("refresh");
				alert("변경되었습니다.");
				$("#modalModBoard").modal("toggle");
			}
		})
	}
}

//게시판 삭제버튼 클릭 이벤트
function btnDelClick() {
	var board = $table.bootstrapTable("getSelections");
	if(board.length > 0) {
		var projNo = board[0].proj_no; 
		var boardNo = board[0].board_no;
		var boardName = board[0].board_name;
		
		if(confirm("["+boardName+"]을 정말 삭제하시겠습니까? 삭제된 게시판의 기록은 전부 제거됩니다.")) {
			$.ajax({
				method:"post"
				,url:"<%=request.getContextPath()%>/plan/projBoardDelete"
				,data:"proj_no="+projNo+"&board_no="+boardNo
				,success:function(data) {
					$table.bootstrapTable("refresh");
					alert("삭제되었습니다.");
				}
			})
		}
	} else {
		alert("삭제할 게시판을 선택해주세요.");
		return false;
	}
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
				<div class="row">
					<div class="page-header">
						<h2>
						<strong>게시판 관리</strong>
						</h2>
					</div>

					<div class="table-toolbar">
						<a class="btn btn-success" data-toggle="modal" data-target="#modalAddBoard">추가</a>
						<a class="btn btn-warning" data-toggle="modal" data-target="#modalModBoard">변경</a>
						<a class="btn btn-danger" href="javascript:btnDelClick()">삭제</a>
					</div>
					<div class="table-responsive">
						<table id="tb_boardList" 
							data-single-select="true"
							data-toolbar=""
							data-url="<%=request.getContextPath() %>/planR/json/projBoardList?projNo=<%=projNo %>"
							data-toggle="table">
						    <thead>
						        <tr>
						        	<th data-checkbox="true" data-field="cbBoard" data-visible="false"></th>
						        	<th data-field="board_no">#</th>
						            <th data-field="board_name">게시판명</th>
						        </tr>
						    </thead>
						</table>
					</div>
				</div>
		</div>
		
	</div>
	<!-- 게시판 추가 모달 -->
	<div id="modalAddBoard" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalAddBoardLabel" aria-hidden="true" style="display: none;">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header bg-success">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="modalAddBoardLabel">
						<strong>게시판 추가</strong>
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<label for="add_board_name" class="col-sm-2 control-label">게시판명</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="add_board_name" name="add_board_name" placeholder="게시판명"/>
						</div>
						<div class="col-sm-2">
							<a id="btn_modalAddBoard" class="btn btn-primary" href="javascript:btnAddClick()">추가</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 게시판 수정 모달 -->
	<div id="modalModBoard" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalModBoardLabel" aria-hidden="true" style="display: none;">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header bg-warning">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="modalModBoardLabel">
						<strong>게시판 이름 변경</strong>
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<label for="mod_board_name" class="col-sm-2 control-label">게시판명</label>
						<div class="col-sm-8">
							<input type="hidden" id="mod_board_no"/>
							<input type="text" class="form-control" id="mod_board_name" placeholder="게시판명"/>
						</div>
						<div class="col-sm-2">
							<a id="btn_modalModBoard" class="btn btn-warning" href="javascript:btnModClick()">변경</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
	<script>
	var $a = $("#submenu>li>a");
	
	$a.each(function(i,data) {
		var href= $(this).attr("href");
		if($(this).text().trim() == "전체 프로젝트 리스트") {
			return;
		}
		$(this).attr("href", href+"${projNo}" );
	});	
	</script>
</body>
</html>