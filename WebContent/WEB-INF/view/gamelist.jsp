<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <%
    
	ArrayList<Game> volist = (ArrayList<Game>)request.getAttribute("volist");
//TODO paging처리 후 제대로 열기
 	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount"); 

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GAME LIST</title>



</head>


<body>


<header>
	<nav id="highmenu" class="topmenu">
	<div id="logo"><a href="./main"><img src="./image/ex1.png"></a></div>
	    <ul>
        <li><a href="./GameList">상점</a></li>
        <li><button class="accordion">커뮤니티</button>
        	<div class="panel">
        	<ul>
        	<li><a href="./fbboardlist">자유게시판</a></li>
        	<li><a href="./gbboardlist">개발사게시판</a></li>
        	<li><a href="./tboardlist">팁게시판</a></li>
        	</ul>
        	</div>
        </li>
        
        <li><a href="./notice">뉴스</a></li>
        <li><a href="#">카테고리</a></li>
        <li><a href="./faq">지원</a></li>
        <li id="textboxli">
        	<!-- todo 링크는 jstl을 이용해 txt박스의 값을 적어구문작성 -->
        	<form action="./search?" method="get">
        	<input type="text" id="textSearchGame" name="q">
        	<button type="submit" id="btnSearchGame"></button>
        	</form>
        	
        </li>
    	</ul>
	</nav>
		<nav id="topmenu_tnb">
		<ul>
		<!-- 맨위 쪽에 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 필요하며		
		아래의 choose문으로 세션에 따라서 회원가입,로그인이 보이도록 작동합니다.-->
	    <c:choose>
		<c:when test="${voList == null }">
			<li><a href="./enrollmember">회원가입</a></li>
		    <li><a href="./memberlogin">로그인</a></li>
		</c:when>
        <c:when test="${voList != null }">
	        <c:forEach items="${voList}" var="vo">
	        	${vo.mm_id }님
	        </c:forEach>
        </c:when>
    	</c:choose>
	        <li><a href="./myinfo">마이페이지</a></li>
	        <li><a href="./cartlist">장바구니</a></li>
		</ul>     
		</nav>
	</header>
	
	<div id="promotion">
	</div>
	
    <div class="section">
	<div class="aside-left">
	
	<!-- 왼쪽의 서브 메뉴 -->
	
	</div>
    <div class="article">
    <!-- 페이지의 메인 아티클 -->
    <h1>  게임 상점 </h1>
	<form method=get action="<c:url value='/GameList'/>" >					
	<select id="sc" name="sc">
        <option value="nk">게임타이틀</option>
        <option value="ik">장르</option>
        <option value="nik">발매일</option>
	</select>
	
	<input type="text" name="sk" id="sk">
	<button type="submit" id="btnGameView">조회</button>
	</form>

<table border="1" collapse="collapse" >
			<tr>
			<td>번호</td>
			<td>게임 이미지</td>
			<td>게임 제목</td>			
			<td>가격</td>
			<td>장르</td>
			<td>개발사</td>
			<td>발매일</td>
			<td>언어</td>
			</tr>
<%
		if(volist != null){
			
			boolean flag = false;
			int no = 0;
			int i =1;
			
		for(Game vo : volist){
			
// 			if (no == vo.getGgNo()){
// 				flag = true;
// 			}else {
// 				flag = false;
// 				no=vo.getGgNo();
// 			}
// 			if(flag){
// 				continue;
// 			}
			
			
			// tr이 volist 갯수 만큼 생기게 됨.
			// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ; 없어야한다.
%>
		
		<tr>
			<td><%=vo.getGgNo()%></td>
			
			<td>
			<!--img alt="#" src="C:\z_worksapce\z_java\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\indimoa\upload/<%=vo.getOriginFileAddress()%>" width="100"-->
			<!--img alt="#" src="../wtpwebapps/upload/<%=vo.getOriginFileAddress()%>" width="100"-->
			<img src="<%=request.getContextPath()%>/upload/<%=vo.getOriginFileAddress()%>" width="100"> 
			<!--img src="${vo.imageSavePath}">  -->
			
			
			</td>	
		
		

			<td>
			<a href="gamecontent?no=<%=vo.getGgNo()%>"> <%=vo.getGgTitle()%> </a>
			</td>
			
			<td><%=vo.getGgPrice()%>원</td> 
			<!-- <td><%=vo.getGgSystemRequirement()%></td>	-->
			<td><%=vo.getGgGenre()%></td>			
			<td><%=vo.getGgDeveloper()%></td>
			<td><%=vo.getGgReleaseDate()%></td>
			<!-- <td><%=vo.getGgPublisher()%></td>	-->
			<td><%=vo.getGgLanguages()%></td>
			<!--<td><%=vo.getGgInfomation()%></td>	-->
			
		</tr>	
<%
		}}
%>

	</table>


	 	
<%
			if (startPage > 1){
%>				<a href="GameList?pagenum=<%= startPage-1 %>">이전</a>	
<% }
			for (int i = startPage; i <= endPage; i++) {
%>
				<a href="GameList?pagenum=<%= i %>"> <%= i %> </a>
				<%
				if (i != endPage) {
					%> , <%				}
			}
			if (endPage < pageCount){
				%>	<a href="GameList?pagenum=<%= endPage+1 %>">다음</a>	 
<%
			}
%>

<br>
<a href=EnrollGame>게임등록하러 가기!</a>

<!--  a href= get 방식으로 보냄 servlet에서 무조건 get으로 받아야됨!!-->

    </div>

	<footer>
    INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
	</footer>
	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  });
}
</script>

<div hidden="">돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></div>

</body>
</html>