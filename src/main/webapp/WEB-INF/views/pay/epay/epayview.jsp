<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안문서 작성</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<!-- title, dtname, content,ceno,aeno -->
			<form action="<%=request.getContextPath() %>/pay/epay/epayInsert" class="form-horizontal" method="post">
				<div class="page-header">
					<h1>기안문서 작성</h1>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="doc_name">제목</label>
					<div class="col-sm-6">
						<input class="form-control" id="title" name="title" type="text" placeholder="제목" required="required">
					</div>
				</div>

				<div class="form-group">
					<label for="dtname" class="col-sm-3 control-label">문서 분류</label>
					<div class="col-sm-6">
						<select class="form-control" id="dtname" name="dtname">
							<option value="휴가">휴가</option>
							<option value="외근">외근</option>
							<option value="프로젝트보고서">프로젝트보고서</option>
							<option value="협찬보고서">협찬보고서</option>
							<option value="협업승인서">협업승인서</option>
							<option value="작업지시서">작업지시서</option>
							<option value="공간대여">공간대여</option>
							<option value="공용장비대여">공용장비대여</option>
							<option value="주말근무보고서">주말근무보고서</option>
							<option value="회식보고서">회식보고서</option>
							<option value="계약서">계약서</option>
							<option value="근로계약서">근로계약서</option>
							<option value="고용계약서">고용계약서</option>
							<option value="사직서">사직서</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="ceno">승인자</label>
					<div class="col-sm-2">
						<input type="number" class="form-control" id="ceno" name="ceno" placeholder="승인자" required="required"/>
					</div>
					<label class="col-sm-2 control-label" for="aeno">결재자</label>
					<div class="col-sm-2">
						<input type="number" class="form-control" id="aeno" name="aeno" placeholder="결재자" required="required"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label" for="content">내용</label>
					<div class="col-sm-6">
						<textarea class="form-control" id="content" name="content" rows="20"  style="resize:vertical;" required="required"></textarea>
					</div>
				</div>
			 
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-6">
						<button class="btn btn-primary">작성</button>
						<a href="draft" class="btn btn-danger">취소</a>
					</div>
				</div>
			</form>
		</div>

	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>