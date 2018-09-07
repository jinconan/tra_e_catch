<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>증명서 발급</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>

	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<div class="col-sm-10">
			<!-- 메인화면 -->
			<div class="panel panel-primary col-xs-8">
				<table>
					<tr>
						<td>증명서 종류 :</td>
						<td>
							<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
								증명서 선택 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">재직증명서</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">경력증명서</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">사직서</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">시말서</a></li>
							</ul>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>사용 용도</td>
						<td><input type="text" class="form-control" placeholder="ex)은행제출용"></td>
					<td>
					&nbsp;&nbsp;<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>OK
						</button>
						</td>
						</tr>
				</table>
			</div>

			<!-- 메인화면 끝 -->

			<!-- 증명서.jsp파일(ajax, 팝업창으로 처리) -->
			<!-- 해당버튼 테이블(ajax처리) -->
		</div>
	</div>
</body>
</html>