<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>

<div class="container">
<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
<div class="col-md-10">
    <table class="table table-striped">
              <thead>
                <tr><!-- 김훈태 작업중  -->
                  <th>사원번호</th>
                  <th>계약서 종류</th>
                  <th>등록일자</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                                  </tr>
                </tbody>
                </table>
                <nav>
   <div class="text-center">
	  <ul class="pagination text-center" >
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li><a href="#">1</a></li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li><a href="#">4</a></li>
	    <li><a href="#">5</a></li>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
   
   </div>
</nav>
                </div>
                </div>
<jsp:include page="/WEB-INF/views/_common/footer.jsp" />                
</body>
</html>