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
<title>�λ������ۼ�������</title>
<%-- <%@ include file="../common/commonUI.jsp" %> --%>

</head>
<body>
<br>
	<h><b>�� �� �� �� �� ��</b></h>
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
							<br> ���� ���� �ۼ�<br> <br>

						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<br> �λ� ���� �ǰ�<br> <br>

						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-7">
						<textarea class="form-control" rows="4" placeholder="�����򰡸� �ۼ��� �ּ���"></textarea>
						<br> <textarea class="form-control" rows="3" placeholder="(�̺κ��� DB�� ����� �λ������� �򰡸� �����ؼ� ���)" readonly=""></textarea>
					</div>
					</div>

				<div class="col-xs-4 col-sm-4">
				<div class="panel panel-primary">
						<div class="panel-heading">
				 <br> <br> ���� ���� �ۼ� <br> <br> <br> <br>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-7">
						<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
							�������� <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">������</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">����</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">�ֿ�ö</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">��ö��</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">���߿�</a></li>
						</ul>
						<textarea class="form-control" rows="5" placeholder="������·� �ִٰ� ���� �� �����ϰԵǸ� �ڵ����� â�� ��� ���� �Ե��� �?"></textarea>
					</div>
					</div>

				<div class="col-xs-4 col-sm-4">
				<div class="panel panel-primary">
						<div class="panel-heading">
					<br> ���� ���� �ۼ� <br>  <br> <br>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-7">
						<textarea class="form-control" rows="5" placeholder="�����򰡸� �ۼ��� �ּ���"></textarea>

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