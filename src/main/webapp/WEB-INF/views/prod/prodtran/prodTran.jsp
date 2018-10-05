<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%
	int counts = (Integer)request.getAttribute("counts");
	int list = (((counts-1)/10)*10)+1;
	int num = (counts%10);
%>
<script type="text/javascript">
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

	$(function() {
		$('#p_table').bootstrapTable({
			url : '<%=request.getContextPath()%>/proR/tran/<%=counts%>'
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
				<form class="form-horizontal" action="<%=request.getContextPath()%>/acc/wel_list" method="POST">
					<div class="page-header">
						<h1>거래내역서</h1>
					</div>
					<!--------------------- 작업 지시서 폼 ----------------------->
					<div class="form-group">

						<label class="col-sm-3 control-label" for="inputEmail">등록코드</label>
						<div class="col-sm-3">
							<input class="form-control" id="incode" name="incode" type="email"
								placeholder="등록코드">
						</div>
						<label class="col-sm-2 control-label" for="inputEmail">거래처</label>
						<div class="col-sm-3">
							<input class="form-control" id="opt" name="opt" type="email"
								placeholder="등록코드">
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
						<select class="form-control" name="opt" id="dtd" name="dtd">
							<option>결제타입</option>
							<option>현영</option>
							<option>카드</option>
							<option>세계</option>
						</select>
						</div>
						<label class="col-sm-2 control-label" for="inputEmail">거래량</label>
						<div class="col-sm-2">
							<input class="form-control" id="inputEmail" type="email"
								placeholder="거래량">
						</div>
						<div class="col-sm-2 sx-buttom">
							<button class="form-control" type="submit">조회하기</button>
						</div>
					</div>
			</div>

			<div class="form-group" id="emptable"></div>
			</form>
			<hr>
			<table class="table table-striped" id="p_table">
				<thead>
					<tr>
						<th data-field="번호">번호</th>
						<th data-field="결제일자">결제일자</th>
						<th data-field="등록코드">등록코드</th>
						<th data-field="거래처코드">거래처코드</th>
						<th data-field="결제방식">결제방식</th>
						<th data-field="결제코드">결제코드</th>
						<th data-field="거래량">거래량</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div class="row">
					<div class="col-xs-10 .col-md-10">
						<nav>
							<ul class="pagination">
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/1" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list-1%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+1%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+2%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+3%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+4%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+5%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+6%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+7%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+8%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+9%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+10%>" aria-label="Previous"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/prod/view/prodTran/<%=list+100%>" aria-label="Previous"><span aria-hidden="true"> >> </span></a></li>
							</ul>
						</nav>
					</div>
				</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>