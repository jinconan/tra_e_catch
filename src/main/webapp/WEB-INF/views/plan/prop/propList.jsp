<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기획서 리스트</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>


</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
		<div class="col-sm-10 col-sm-offset-1">
			<h1>기획서 리스트</h1>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>'기획서아이콘'</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>1빠</td>
						<td>견자단</td>
						<td>2015-09-30</td>
						<td></td>
					</tr>
					<tr>
						<td>2</td>
						<td>2빠</td>
						<td>홍금보</td>
						<td>2016-09-30</td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td>3빠</td>
						<td>주성치</td>
						<td>2015-09-30</td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td>4빠</td>
						<td>이연걸</td>
						<td>2015-09-30</td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td>5빠</td>
						<td>재키찬</td>
						<td>2016-09-30</td>
						<td></td>
					</tr>
					<tr>
						<td>6</td>
						<td>6빠</td>
						<td>이소룡</td>
						<td>2015-09-30</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<div class="text-center">
				<nav>
					<ul class="pagination">
						<li class="disabled">
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a></li>
					</ul>
				</nav>
			</div>
		</div>

	</div>
</body>
</html>