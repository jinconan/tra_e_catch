<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
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

	function f_updates(){
		$('#f_update').submit();
	};

	function test(){
		var inputdata = $("#f_modalselect").serialize();
	 	$.ajax({
	        method:"POST"
	        ,url:"<%=request.getContextPath()%>/TRAN/wordprint"
	        ,data:inputdata,
	        success : function(log){	        	
	        	console.log(log);
	        	$("#d_viewwork").html(log);	        	
	        }
			,error : function(xhr) {
				console.log("땡");
			}
	    }); 
	}

	$(function() {
		$('#p_table').bootstrapTable({
			url : '<%=request.getContextPath()%>/proR/tran/<%=counts%><%=datas%>',	
			onClickRow : function(row,$element, field) {
				console.log(row.번호);
				$("#selectdate").val(row.등록코드);	
				$("#exampleModal").modal('show');
				test();/* test메소드에 아작스 처리하면 됨 쀼쀼 */
			}
		});		
		
		$('#printinp').click(function(){
			$('#printtable').printThis(); <!-- print 할 부분에 설정 -->
		});
		
		var base = $('#liid'+<%=num%>);
		base.addClass('active');
	});

	function exampleModalInsert(){
		var str;
		$.ajax({ 
            type: 'GET', 
            url: '<%=request.getContextPath()%>/proR/trancli', 
            dataType:'json',
            success: function (data) { 
            	str = "<select class=\"form-control\" id= \"cail\" name=\"cail\" onClick=\"LangSelect()\">";
            	$.each(data, function(key, value){
            	    $.each(value, function(key, value){
            	        console.log(key, value);
            	        str = str+"<option value="+key+">"+key+"</option>";   
            	    });
            	});
/*             	for(var i = 0; i< _len; i++){
            		var post = data[i]; 
               		 str = str+"<option>"+post.회사명+"</option>";            		 
            	} */
            	str = str+"<select>" ;
            	$('#select1').html(str);
            }
        });
		$("#exampleModalInsert").modal('show'); 
	}
	function LangSelect(){
		var th = $('#cail').val();
		var str;
		$.ajax({ 
            type: 'GET', 
            url: '<%=request.getContextPath()%>/proR/trancli', 
            dataType:'json',
            success: function (data) { 
            	str = "<select class=\"form-control\" id= \"goods\" name=\"goods\">";
            	$.each(data, function(key, value){
            	    $.each(value, function(key, value){
            	    	if(key==th){
            	    	$.each(value, function(key, value){
                	        console.log(key, value);
                	        str = str+"<option value="+value.번호+">"+value.상품이름+"</option>";   
                	    });}
            	    });
            	});
/*             	for(var i = 0; i< _len; i++){
            		var post = data[i]; 
               		 str = str+"<option>"+post.회사명+"</option>";            		 
            	} */
            	str = str+"<select>" ;
            	$('#select2').html(str);
            }
        });
	}

	$(function() {
		$('#datetimepicker1').datetimepicker({
			format : 'yyyy-mm-dd',
			minView : 2
		});
		$('#datetimepicker2').datetimepicker({
			format : 'yyyy-mm-dd',
			minView : 2
		});
	});

	
	
</script>


</head>
<body>
	<!---------------------- 헤더 --------------------------->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<div class="container">
		<!---------------------- 서브메뉴 ------------------------>
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />

		<div class="col-sm-10">

			<!----------------------- 제목 -------------------------->
			<div class="col-md-10">
				<form class="form-horizontal" action="<%=request.getContextPath()%>/Tran_list/1" method="POST">
					<div class="page-header">
						<h1>거래내역서</h1>
					</div>
					<!--------------------- 작업 지시서 폼 ----------------------->
					<div class="form-group">

						<label class="col-sm-3 control-label" for="inputEmail">등록코드</label>
						<div class="col-sm-3">
						<input type="text" class="form-control" id="incode" name="incode"
								placeholder="등록코드">
						</div>
						<label class="col-sm-2 control-label" for="inputEmail">거래처</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="cata" name="cata" 
								placeholder="거래처">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputNumber">결제시작</label>
						<div class="col-sm-3" style="padding-right: 0px;">
							<div class='input-group date' id='datetimepicker1'>
								<input type='text' class="form-control" id="std" name="std" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<label class="col-sm-2 control-label" for="inputNumber">결제종료</label>
						<div class="col-sm-3" style="padding-right: 0px;">
							<div class='input-group date' id='datetimepicker2'>
								<input type='text' class="form-control" id="dtd" name="dtd" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputEmail">결제타입</label>
						<div class="col-sm-3" style="padding-right: 0px;">
						<select class="form-control" name="opt">
							<option>결제타입</option>
							<option>현영</option>
							<option>카드</option>
							<option>세계</option>
						</select>
						</div>
						<label class="col-sm-2 control-label" for="inputEmail">거래량</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="sums"
								placeholder="거래량">
						</div>
						<div class="col-sm-2 sx-buttom">
							<button class="form-control" type="submit">조회하기</button>
						</div>
					</div>
				</form>
			</div>

			<div class="form-group" id="emptable"></div>
			
			<hr>
			<table class="table table-striped" id="p_table">
				<thead>
					<tr>
						<th data-field="번호">번호</th>
						<th data-field="결제일자">결제일자</th>
						<th data-field="등록코드">등록코드</th>
						<th data-field="거래처코드">거래처코드</th>
						<th data-field="결제방식">결제방식</th>
						<th data-field="거래량">거래량</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div class="row">
					<div class="col-xs-8 .col-md-10">
						<nav>
							<ul class="pagination">
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/1<%=datas%>" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list-1%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list%><%=datas%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+1%><%=datas%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+2%><%=datas%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+3%><%=datas%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+4%><%=datas%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+5%><%=datas%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+6%><%=datas%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+7%><%=datas%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+8%><%=datas%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+9%><%=datas%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+10%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+100%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> >> </span></a></li>
							</ul>
						</nav>
					</div>
					<div class="col-sm-2 sx-buttom">
						<button class="form-control" onclick="javascript:exampleModalInsert()">추가하기</button>
					</div>
			</div>
		</div>
	</div>

	<!-- 추가 모달 -->
	<div class="modal fade" id="exampleModalInsert" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div id="login-overlay" class="modal-dialog">
			<div class="modal-content" aria-hidden="true">
				<form id="f_deptinsert"  action="<%=request.getContextPath()%>/Tran_init" method="POST" enctype="multipart/form-data" class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">부서정보 추가</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class=" col-xs-offset-3 col-xs-6">
								<div class="well">
									<div class="form-group">
										<label for="new_dept_no" class="control-label">결제 방식 </label>
										<select class="form-control" name="opt">
											<option value = "1">현금영수증</option>
											<option value = "2">카드</option>
											<option value = "3">세금계산서</option>
										</select> <span class="help-block"></span>
									</div>
									<div class="form-group">
										<label for="new_dept_name" class="control-label">회사명</label>
										<div id="select1"></div>
									</div>
									<div class="form-group">
										<label for="new_dept_name" class="control-label">상품명</label>
										<div id="select2"></div>
									</div>
									<div class="form-group">
										<label for="new_dept_note" class="control-label">개수</label> <input
											type="text" class="form-control" id="new_dept_note"
											name="new_dept_note" title="Please enter you username">
										<span class="help-block"></span>
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
	
	<!-- 모달창  -->
	
	<form id="f_modalselect" method="post">
		<input type="hidden" id="selectdate" name="hday">
	</form>
	
		<!-- 상세내역 모달 페이지 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document" style="width: 635px">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">거래내역서 상세페이지</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      	<div id="d_viewwork"></div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" id="printupdate" onclick="f_updates();">수정</button>
		        <button type="button" class="btn btn-primary" id="printinp">출력</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">종료</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 모달창 종료 -->
		
	
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>