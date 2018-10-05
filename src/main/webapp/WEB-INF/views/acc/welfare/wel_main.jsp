<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript">
		function test(){
			var inputdata = $("#f_modalselect").serialize();
		 	$.ajax({
		        method:"POST"
		        ,url:"<%=request.getContextPath()%>/acc/slip/wordprint"
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
				url:'<%=request.getContextPath()%>/accR/slip/b/<%=counts%><%=datas%>',			
				onClickRow : function(row,$element, field) {
					console.log(row.번호);
					$("#selectdate").val(row.번호);	
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
	</script>

<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
			<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<div class="col-sm-10">
			<form class="form-signin" action="<%=request.getContextPath()%>/acc/wel_list" method="POST" >
				<h2 class="form-signin-heading">팀 운영비</h2>
				<div class="row" Style="margin-bottom: 5px">
					<div class="col-xs-1">
						<h5>날짜:</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" id="fromDate" type="text"
							placeholder="시작날짜" name="std">
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" id="toDate" type="text"
							placeholder="종료날짜" name="dtd">
					</div>
					<div class="col-xs-1">
						<h5>금액:</h5>
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" type="text" placeholder="시작금액" name="spay" id="spay">
					</div>
					<div class="col-xs-2 los">
						<input class="form-control" type="text" placeholder="종료금액" name="dpay" id="dpay">
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<select class="form-control" name="opt">
							<option>결제타입</option>
							<option>현영</option>
							<option>카드</option>
							<option>세계</option>
						</select>
					</div>
					<div class="col-xs-6">
						<input type="text" class="form-control" placeholder="Text input" name="intxt" id="intxt">
					</div>
					<div class="col-xs-2">
						<input type="submit" class="form-control" value="검색">
					</div>
				</div>
				<div class="row">
					<table class="table table-striped" id="p_table">
						<thead>
							<tr>
								<th data-field="번호">번호</th>
								<th data-field="일자">날짜</th>
								<th data-field="거래처">사용한내역</th>
								<th data-field="비용">비용</th>
								<th data-field="고정자산">고정자산</th>
								<th data-field="증빙">증빙</th>
								<th data-field="첨부자료">첨부자료</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-xs-10 .col-md-10">
						<nav>
							<ul class="pagination">
								<li><a href="<%=request.getContextPath()%>/acc/wel/1" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/acc/wel/<%=list-1%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/acc/wel/<%=list%><%=datas%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+1%><%=datas%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+2%><%=datas%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+3%><%=datas%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+4%><%=datas%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+5%><%=datas%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+6%><%=datas%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+7%><%=datas%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+8%><%=datas%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/acc/wel/<%=list+9%><%=datas%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/acc/wel/<%=list+10%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/acc/wel/<%=list+100%><%=datas%>" aria-label="Previous"><span aria-hidden="true"> >> </span></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</form>
		</div>
	</div>
	
		<form id="f_modalselect" method="post">
		<input type="hidden" id="selectdate" name="hday">
	</form>
	
			<!-- 상세내역 모달 페이지 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document" style="width: 635px">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">고용계약서 상세페이지</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      	<div id="d_viewwork"></div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" id="printinp">Print</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        
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
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>