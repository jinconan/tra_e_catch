<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안 문서</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>


</head>
<body>
<script type="text/javascript">
$(function(){
	$('#p1_table').bootstrapTable({
		url:'<%=request.getContextPath()%>/pay/epay/epayjson'
		,singleSelect:true
	});
});
</script>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<form class="form-horizontal">
				<div class="page-header">
					<h1>기안 문서 목록</h1>
				</div>
				
				<!-- 분류 버튼 -->
				<div class="row">
				<div class="col-xs-3 col-md-3">
				<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false">
						분류 <span class="caret"></span>
						</button>
					<ul class="dropdown-menu" role="menu" id="optionum"
						onclick="listoption()">
						<li><a href="#">대기중</a></li>
						<li><a href="#">승인완료</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</div>
				</div>	
				<div class="col-xs-3 col-md-3">
					<form class="form-inline" id="f_search">
  					   <div class="form-group">
		 			     <select id="cb_type" class="form-control" name="cb_type">
		    			   <option value="p_dtype">서류분류</option>
		    			   <option value="p_docno">서류번호</option>
		   				   <option value="p_date">등록일자</option>
		   				   <option value="p_content">내용</option>
		 				 </select>
				  		<input type="email" id="sb_keyword" name="sb_keyword" class="form-control">
	     		  		<button class="btn btn-default btn-m" id="btn_sea" type="submit">상세조회</button>
						</div>
						</li>
					</form>
				</div>
				</div>
			

				<table class="table table-striped" id="p1_table">
					<thead>
						<tr>
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<th data-field="EMP_NO">사원번호</th>
							<th data-field="DTYPE_NO">서류분류</th>
							<th data-field="PATH">경로</th>
							<th data-field="CONTENT">내용</th>
							<th data-field="DOC_NO">서류번호</th>
							<th data-field="UP_DATE">등록일자</th>
							<th>승인여부</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

				<div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_pay" class="btn btn-primary">
					조회<i class="fa fa-check spaceLeft"></i>
				</button>
				
			</div>
		</div>
			
				<nav>
					<div class="text-center">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</div>
				</nav>
			</form>
		</div>
	</div>
</body>
</html>