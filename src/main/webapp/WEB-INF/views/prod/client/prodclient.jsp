<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<%
	String datas = "";
	if(request.getAttribute("datas")!=null){	
		datas = (String)request.getAttribute("datas");
	}
	int counts = (Integer)request.getAttribute("counts");
	int list = (((counts-1)/10)*10)+1;
	int num = (counts%10);
%>

<script type="text/javascript">
$(function() {
	$('#p_table').bootstrapTable({
		url : '<%=request.getContextPath()%>/proR/client/<%=counts%><%=datas%>',	
		onClickRow : function(row,$element, field) {
			console.log(row.번호);
			$("#client").val(row.업체번호);	
			$("#client1").html(row.업체번호);
			$("#client1").val(row.업체번호);	
			$("#client2").html(row.업체명);
			$("#client2").val(row.업체명);
			$("#client3").val(row.업체주소);	
			$("#client4").val(row.업체전화번호);
			$("#client5").val(row.담당자전화번호);	
			$("#client6").val(row.사업자번호);	
			$("#client6").html(row.사업자번호);	
			$("#exampleModal").modal('show');
			test();/* test메소드에 아작스 처리하면 됨 쀼쀼 */
		}
	});	
});

function exampleModalInsert(){
	$("#exampleModalInsert").modal('show'); 
}
</script>
<body>

<!---------------- 헤더 --- ------------>
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
	
	<hr>
  	<div class="container">
<!-------------- 서브메뉴 ----------------->   
   	<jsp:include page="/WEB-INF/views/_common/submenu.jsp"/> 
   	<div class="col-sm-10">

<!---------------- 제목 ------------------->
  			<div class="page-header">
					<h1>거래처 관리 대장</h1>
			</div>
  <div class="row">
    <div class="col-sm-10">
	 <br>
	 <br>   
		<table class="table table-striped" id="p_table">
		      <thead>
				  	    <tr>
				  	    	<th data-field="순번">순번</th>
				  			<th data-field="업체번호">업체번호</th>
				  			<th data-field="업체명">업체명</th>
				  			<th data-field="업체주소">업체주소</th>
				  			<th data-field="업체전화번호">업체전화번호</th>
				  			<th data-field="담당자전화번호">담당자전화번호</th>
				 			<th data-field="사업자번호">사업자번호</th>
				  		</tr>
				  	</thead>
				  	<tbody>				  		
				  	</tbody>		
				  </table>
	<center>
	
	<div class="row">
					<div class="col-xs-8 .col-md-10">
						<nav>
							<ul class="pagination">
								<li><a href="<%=request.getContextPath()%>/prod/view/client/1<%=datas%>" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/client/<%=list-1%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list%><%=datas%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+1%><%=datas%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+2%><%=datas%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+3%><%=datas%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+4%><%=datas%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+5%><%=datas%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+6%><%=datas%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+7%><%=datas%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+8%><%=datas%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+9%><%=datas%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+10%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/client/<%=list+100%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> >> </span></a></li>
							</ul>
						</nav>
					</div>
					<div class="col-sm-2 sx-buttom">
						<button class="form-control" onclick="javascript:exampleModalInsert()">추가하기</button>
					</div>
			</div>
	</center>
			  
	
	</div>
</div>	
</div>
<!-------------------- 하단 메뉴 ------------------->

<!-- 추가 모달 -->
	<div class="modal fade" id="exampleModalInsert" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div id="login-overlay" class="modal-dialog">
			<div class="modal-content" aria-hidden="true">
				<form id="f_deptinsert"  action="<%=request.getContextPath()%>/client_init" method="POST" enctype="multipart/form-data" class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">거래처 등록</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class=" col-xs-offset-3 col-xs-6">
								<div class="well">
									<div class="form-group">
										<label for="name" class="control-label">업체명</label>
										<div id="select1"><input type="text" name="업체명" class="form-control"></div>
									</div>
									<div class="form-group">
										<label for="name" class="control-label">업체주소</label>
										<div><input id="select2" type="text" name="업체주소" class="form-control"></div>
									</div>
									<div class="form-group">
										<label for="name" class="control-label">업체전화번호</label>
										<div><input id="select3" type="text" name = "업체전화번호" class="form-control"></div>
									</div>
									<div class="form-group">
										<label for="name" class="control-label">담당자전화번호</label>
										<div><input id="select4" type="text" name = "담당자전화번호" class="form-control"></div>
									</div>
									<div class="form-group">
										<label for="name" class="control-label">사업자번호</label>
										<div id="select5"><input type="text" name = "사업자번호" class="form-control"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">추가</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 추가 모달끝 -->
	
		<!-- 상세내역 모달 페이지 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document" style="width: 635px">
		    <div class="modal-content" aria-hidden="true">
				<form id="f_deptinsert"  action="<%=request.getContextPath()%>/client_update" method="POST" enctype="multipart/form-data" class="form-horizontal">
					<input type="hidden" name="cost0" id = "client">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">거래처 변경</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class=" col-xs-offset-3 col-xs-6">
								<div class="well"> 
									<div class="form-group">
										<label for="name" class="control-label">업체번호</label>
										<div id="client1"><label for="name" class="control-label" id = "client1" ></label></div>
									</div>
									<div class="form-group">
										<label for="name" class="control-label">업체명</label>
										<div id="client2"><label for="name" class="control-label" id = "client2" ></label></div>
									</div>
									<div class="form-group">
										<label for="new_dept_name" class="control-label">업체주소</label>
										<div ><input type="text" name = "cost1" id = "client3" class="form-control"></div>
									</div>
									<div class="form-group">
										<label for="new_dept_name" class="control-label">업체전화번호</label>
										<div ><input type="text" name = "cost2" id = "client4" class="form-control"></div>
									</div>
									<div class="form-group">
										<label for="new_dept_name" class="control-label">담당자전화번호</label>
										<div ><input type="text" name = "cost3" id = "client5" class="form-control"></div>
									</div>
									<div class="form-group">
										<label for="new_dept_name" class="control-label">사업자번호</label>
										<div id="client6"><label for="name" class="control-label" id = "client6" ></label></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">수정</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>
		  </div>
		</div>
		
		<!-- 모달창 종료 -->

<jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
	
			   
</body>
</html>