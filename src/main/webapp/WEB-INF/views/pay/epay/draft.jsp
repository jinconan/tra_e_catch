<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안 문서</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<style>
.los {
	padding-right: 5px;
	padding-left: 5px;
}

.table-striped {
	margin-top: 10px;
}

.sx-buttom {
	margin-top: 30px;
}
</style>
<%	
	
	String datas = "";
	if(request.getAttribute("datas")!=null){	
	datas = (String)request.getAttribute("datas");
	}
	int counts = (Integer)request.getAttribute("counts");
	int list = (((counts-1)/10)*10)+1;
	int num = (counts%10);
	
	

%>

</head>



<body>
<script type="text/javascript">
<%-- function test(){
	var inputdata = $("#f_modalselect").serialize();
 	$.ajax({
        method:"POST"
        ,url:"<%=request.getContextPath()%>/pay/epay/wordprint"
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
 --%>
 	/* function accept(){
 		$("#f_draft").attr("action","./empupdateaccept");
		$("#f_draft").submit(); 
 	} */
 
 
$(function(){
	//데이터 그리드
	$('#p_table').bootstrapTable({
		url:'<%=request.getContextPath()%>/payR/epay/draft/t/<%=counts%><%=datas%>'
		,	onClickRow : function(row,$element, field) {
			console.log(row.EMP_NO);
			console.log(row.DOC_NO)
			$("#emp_no").val(row.EMP_NO);
			$("#dtype_no").val(row.DTYPE_NO);
			$("#path").val(row.PATH);
			$("#content").val(row.CONTENT);
			$("#doc_no").val(row.DOC_NO);
			$("#up_date").val(row.UP_DATE);
			$("#title").val(row.TITLE);
			$("#exampleModal").modal('show');
			/* test(); test메소드에 아작스 처리하면 됨 쀼쀼 */
		}
	});
	var base = $('#liid'+<%=num%>);
	base.addClass('active');

});

 

</script>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<form class="form-horizontal" action="<%=request.getContextPath()%>/pay/pay_list" method="POST">
				<div class="page-header">
					<h1>기안 문서 목록</h1>
				</div>
				
				<!-- 분류 버튼 -->
				<div class="row">
				<div class="col-xs-3 col-md-3">
				<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false" id="optionnum" onclick="javascript:listoption()">
						분류 <span class="caret"></span>
						</button>
					<ul class="dropdown-menu" role="menu" >
						<li><a href="<%=request.getContextPath()%>/pay/epay/epaywait">대기중</a></li>
						<li><a href="<%=request.getContextPath()%>/pay/epay/epayend">승인완료</a></li>
					</ul>
				</div>
				</div>	
				</div>
				
				<div class="row" Style="margin-bottom: 5px">
					<div class="col-xs-1">
						<h5>등록일자</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" id="up_date" type="text"
							placeholder="시작날짜" name="up_date">
					</div>
					
					<div class="col-xs-1">
						<h5>서류분류</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" type="text" placeholder="서류분류" name="dtype_no" id="dtype_no">
					</div>
					<div class="col-xs-1">
						<h5>서류번호</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" type="text" placeholder="서류번호" name="doc_no" id="doc_no">
					</div>
				</div>
				<div class="row">
					<div class="col-xs-1">
						<h5>제목</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" type="text" placeholder="제목" name="title" id="title">
					</div>
					<div class="col-xs-1">
						<h5>내용</h5>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" placeholder="내용" name="content" id="content">
					</div>
					<div class="col-xs-1">
						<h5>사원번호</h5>
					</div>
					<div class="col-xs-2">
						<input type="text" class="form-control" placeholder="사원번호" name="emp_no" id="emp_no">
					</div>
					<div class="col-xs-1">
						<input type="submit" class="form-control" value="검색">
					</div>
				</div>
				
				
				<div class="row">
				<table class="table table-striped" id="p_table">
					<thead>
						<tr>
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<th data-field="EMP_NO">사원번호</th>
							<th data-field="DTYPE_NO">서류분류</th>
							<th data-field="PATH">경로</th>
							<th data-field="CONTENT">내용</th>
							<th data-field="DOC_NO">서류번호</th>
							<th data-field="UP_DATE">등록일자</th>
							<th data-field="TITLE">제목</th>
							<th>승인여부</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				</div>
				
			
<!--------------------- 페이지 네이션 영역 ----------------------------->
				
				 <nav>
					<div class="text-center">
						<ul class="pagination" id="pagination">
								<li><a href="<%=request.getContextPath()%>/pay/epay/draft/1" aria-label="Previous"> <span aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list-1%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+1%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+2%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+3%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+4%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+5%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+6%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+7%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+8%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+9%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+10%>" aria-label="Next"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/pay/epay/draft/<%=list+100%>" aria-label="Next"><span aria-hidden="true"> >> </span></a></li>
						</ul>
					</div>
				</nav> 
			</form>
			
			<!---------------------- 모달페이지 영역 --------------------------------->
	<form id="f_modalselect" method="post">
		<input type="hidden" id="selectdate" name="hday">
	</form>
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		 <div id="login-overlay" class="modal-dialog">
      <div class="modal-content" aria-hidden="true">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel">서류 결재 승인</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-7">
                      <div class="well">
 					 <form id="f_draft" method="POST">
                            <div class="form-group">
                                  <label for="emp_no" class="control-label">사원번호</label>
                                  <input type="text" class="form-control" id="emp_no" name="emp_no" value="" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                                 <div class="form-group">
                                  <label for="emp_name" class="control-label">서류분류</label>
                                  <input type="text" class="form-control" id="dtype_no" name="dtype_no" value="" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="dept" class="control-label">경로</label>
                                  <input type="text" class="form-control" id="path" name="path" value="" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                             <div class="form-group">
                                  <label for="team" class="control-label">내용</label>
								<input type="text" class="form-control" id="content" name="content" value="" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="ctlv" class="control-label">서류번호</label>
                                  <input type="text" class="form-control" id="doc_no" name="doc_no" value="" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                                <div class="form-group">
                                  <label for="loc" class="control-label">등록일자</label>
                                  <input type="text" class="form-control" id="up_date" name="up_date" value="" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                                <div class="form-group">
                                  <label for="loc" class="control-label">제목</label>
                                  <input type="text" class="form-control" id="title" name="title" value="" readonly="" title="Please enter you username">
                                  <span class="help-block"></span>
                              </div>
                          </form>
                      </div>
                  </div>
                 
 						</div>
                  </div>
              </div>
          </div>
          
          <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="printinp" onclick="javascript:accept()">승인</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
      
      </div>
  </div>

  </div>
		
	
	<script type="text/javascript">
		$('#fromDate').datetimepicker({
			language : 'ko', // 화면에 출력될 언어를 한국어로 설정한다.
			pickTime : false, // 사용자로부터 시간 선택을 허용하려면 true를 설정하거나 pickTime 옵션을 생략한다.
			defalutDate : new Date() // 기본값으로 오늘 날짜를 입력한다. 기본값을 해제하려면 defaultDate 옵션을 생략한다.
		});
	
		$('#toDate').datetimepicker({
			language : 'ko',
			pickTime : false,
			defalutDate : new Date()
		});
	</script>
	<%-- 	<jsp:include page="/WEB-INF/views/_common/footer.jsp" /> --%>
</body>
</html>