<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../bootcss/css/bootstrap.min.css">
<link rel="stylesheet" href="../bootcss/css/bootstrap-theme.min.css">
<script src="../bootcss/js/jquery-2.2.4.min.js"></script>
<script src="../bootcss/js/bootstrap.min.js"></script>
<meta charset="EUC-KR">
<title>인사평정작성페이지</title>
<%-- <%@ include file="../common/commonUI.jsp" %> --%>

</head>
<body>
<br>
	<h><b>근 무 평 정 작 성</b></h>
	<table>
	<tr>
	<td width="900" height="550">
	<div class="panel panel-primary col-xs-7" style="
    margin-bottom: 10px;
    margin-top: 10px;
    padding-top: 10px;
">

				<div class="col-xs-4 col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<br> 개인 평정 작성<br> <br>

						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<br> 인사 팀장 의견<br> <br>

						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-7">
						<textarea class="form-control" rows="4" placeholder="개인평가를 작성해 주세요"></textarea>
						<br> <textarea class="form-control" rows="3" placeholder="(이부분은 DB에 저장된 인사팀장의 평가를 셀렉해서 띄움)" readonly=""></textarea>
					</div>
					</div>

				<div class="col-xs-4 col-sm-4">
				<div class="panel panel-primary">
						<div class="panel-heading">
				 <br> <br> 팀원 평정 작성 <br> <br> <br> <br>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-7">
						<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
							팀원선택 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">김훈태</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">이진</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">최운철</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">신철우</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">신중욱</a></li>
						</ul>
						<textarea class="form-control" rows="5" placeholder="숨김상태로 있다가 팀원 을 선택하게되면 자동으로 창을 띄울 생각 님들은 어떰?"></textarea>
					</div>
					</div>

				<div class="col-xs-4 col-sm-4">
				<div class="panel panel-primary">
						<div class="panel-heading">
					<br> 팀장 평정 작성 <br>  <br> <br>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-7">
						<textarea class="form-control" rows="5" placeholder="팀장평가를 작성해 주세요"></textarea>

					</div>
					</div>

	</div>
	</td></tr>
</table>

	<button type="button" class="btn btn-primary">
		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> OK
	</button>

	<button type="button" class="btn btn-success">
		<span class="glyphicon glyphicon-save" aria-hidden="true"></span>SAVE
	</button>

	<button type="button" class="btn btn-danger">
		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Remove
	</button>

</body>
</html>