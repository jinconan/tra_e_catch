<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//프로젝트 번호
	int projNo = (Integer) request.getAttribute("projNo");
	//게시판 리스트 받아오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 관리</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
	$(document).ready(function() {
		var $a = $("#submenu>li>a");
		
		$a.each(function(i,data) {
			var href= $(this).attr("href");
			$(this).attr("href", href+"${projNo}" );
			var href= $(this).attr("href");
		});
		
		$("#btn_add_board").click(function() {
			$(this).attr("data-toggle", "modal");
			$(this).attr("data-target", "#modalBoardConfig");
			$("#board_name").val("");
			$("#modalBoardConfigLabel").html("<strong>게시판 추가</strong>")
			$("#btn_modalBoardConfig").attr("class", "btn btn-primary");
			$("#btn_modalBoardConfig").text("추가");
		})
		
		$(".btns_boardConfig").each(function(i,data) {
			var boardNo = $("tbody>tr").eq(i).find("td").eq(0)[0].innerText;
			var boardName = $("tbody>tr").eq(i).find("td").eq(1)[0].innerText;
			
			//각 게시판 별 수정 버튼
			$(".btns_boardConfig").eq(i).find("button").eq(0).click(function() {
				$(this).attr("data-toggle", "modal");
				$(this).attr("data-target", "#modalBoardConfig");
				$("#board_name").val(boardName);
				$("#modalBoardConfigLabel").html("<strong>게시판 변경</strong>")
				$("#btn_modalBoardConfig").attr("class", "btn btn-warning");
				$("#btn_modalBoardConfig").text("변경");
			})
			
			//각 게시판 별 삭제 버튼
			$(".btns_boardConfig").eq(i).find("button").eq(1).click(function() {
				var result = confirm("이 게시판을 정말 삭제하시겠습니까?");
			})
		})
	})
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
						<strong>게시판 관리</strong>
						<button type="button" id="btn_add_board" class="btn btn-primary">추가</button>
					</h2>
				</div>

				<div class="row">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th width="10%">#</th>
									<th width="60%">게시판명</th>
									<th width="30%"></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>게시판1</td>
									<td>
										<div class="btns_boardConfig btn-group">
											<button type="button" class="btn btn-warning">이름변경</button>
											<button type="button" class="btn btn-danger">삭제</button>
										</div>
									</td>								
								</tr>
								<tr>
									<td>2</td>
									<td>게시판2</td>
									<td>
										<div class="btns_boardConfig btn-group">
											<button type="button" class="btn btn-warning">이름변경</button>
											<button type="button" class="btn btn-danger">삭제</button>
										</div>
									</td>							
								</tr>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
		
	</div>
<div id="modalBoardConfig" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalBoardConfigLabel" aria-hidden="true" style="display: none;">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<div class="modal-header bg-primary">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="modalBoardConfigLabel">
						<strong>게시판 추가</strong>
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<label for="board_name" class="col-sm-2 control-label">게시판명</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="board_name" name="board_name" placeholder="게시판명" required/>
						</div>
						<div class="col-sm-2">
							<button id="btn_modalBoardConfig" class="btn btn-primary">추가</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>