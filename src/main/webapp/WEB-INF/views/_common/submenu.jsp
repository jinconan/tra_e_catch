<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	//컨트롤러로 부터 넘겨받는 속성
	//subMenuList : List<Map<String, Object>>
	//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
	//curSubMenu : String
	int 						sizeOfSubMenu	= 0;
	String 						curSubMenu		= (String)request.getAttribute("curSubMenu");
	List<Map<String,Object>> 	subMenuList		= (List<Map<String,Object>>) request.getAttribute("subMenuList");
	if (subMenuList != null) {
		sizeOfSubMenu = subMenuList.size();
	}
%>

<nav id="submenu" class="col-sm-2 nav nav-pills nav-stacked nav-pills-stacked-example">
	<%
		for (int i = 0; i < sizeOfSubMenu; i++) {
			Map<String,Object> subMenuItem = subMenuList.get(i);
	%>
	<li role="presentation">
		<a href="<%=request.getContextPath() %><%= subMenuItem.get("sm_url")%>">
			<%=subMenuItem.get("sm_name") %>
		</a>
	</li>
	<%
		}
	%>
</nav>
<!-- 현재 선택된 서브메뉴를 활성화 시키는 스크립트 -->
<script>
	var $subMenuList = $("nav#submenu li");
	var $a = $subMenuList.find("a");
	var curSubMenu = "<%= curSubMenu %>";
	
	$a.each(function(i,data) {
		var sm_text = data.innerText;
		if(sm_text == curSubMenu) {
			$subMenuList.eq(i).addClass("active");
			return;
		}
	})
</script>