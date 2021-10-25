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


<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<style type="text/css">
@charset "UTF-8";

@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap')
	;

* {
	font-family: "Noto Sans KR", sans-serif;
	margin: 0;
	padding: 0;
}

body {
	font: 15px;
}

ul {
	overflow: hidden;
	margin: 0 auto;
}

a {
	text-decoration: none !important;
	color: black;
}

li {
	list-style-type: none;
}

header {
	width: auto;
	height: 130px;
	font-size: 16px;
	position: relative;
	margin: 0 auto;
}

#logo {
	margin-left: 300px;
	padding-bottom:40px;
	float:left;
}

#logo>a>img {
	width: 180px;
	height: 45px;
	position: relative;
}

#highmenu {
	bottom: 5px;
	position: absolute;
	overflow: hidden;
	display: flex;
	margin: 0 auto;
	width: 70%;
}

.panel a:hover {
	color: #919191;
}

#highmenu>ul>li {
	width: 100px;
	display: inline-block;
	margin: 0 auto;
	text-align: center;
}

#highmenu #textboxli {
	width: 250px;
}

header #topmenu_tnb {
	top: 0;
	right: 100px;
	overflow: hidden;
	position: absolute;
	border-radius: 5px;
	margin: 15px;
	padding: 5px;
	font-size: 14px;
}

#topmenu_tnb ul li {
	display: inline-block;
	margin: 5px;
	margin-top: 0px;
	position: relative;
}

/* section */
.section {
	width: 100%;
	margin: 0 auto;
}

.aside-left {
	width: 300px;
	font: 16px;
	float: left;
	padding: 80px 20px 20px 310px;
	margin: 0 auto;
}

.aside-left a:hover {
	color: #919191;
}

.article {
	width: 900px;
	min-height: 100%;
	padding: 50px 50px 50px 20px;
	margin: 0 auto;
	float:left;
}

#textSearchGame {
	height: 30px;
	padding-top: 9px;
}

#btnSearchGame {
	border: none;
	background-image: url("../image/free-icon-magnifier-71403.png");
	background-repeat: no-repeat;
	width: 24px;
	height: 24px;
	outline: 0;
	background-image: url("../image/free-icon-magnifier-71403.png");
	background-color: white;
	margin: 10px;
}

.imgIcon {
	border: none;
	width: 24px;
	height: 24px;
	bottom: 0;
}

.accordion {
	color: black;
	cursor: pointer;
	border: none;
	text-align: left;
	transition: 0.4s;
	font-size: 16px;
	background-color: white;
}

.panel {
	padding: 0 18px;
	max-height: 0px;
	overflow: hidden;
	transition: max-height 0.2s ease-out;
	float: left;
	/* width: 500px; */
}

.panel>ul {
	overflow: hidden;
	text-align: left;
}

.panel>ul>li {
	width: 100px;
	display: inline-block;
	margin-right: 20px;
}

footer {
	clear: both;
	width: 100%;
	height: 100px;
	background-color: #ccc;
	text-align: center;
	padding-top: 40px;
	font-size: 13px;
}
</style>




<style type="text/css">
.promotion{
	width: 1000px;
	margin: 0 auto;
}
</style>
</head>


<body>

	<header>
	<div id="logo"><a href="./"><img src="./image/ex1.png"></a></div>
	<nav id="highmenu" class="topmenu">
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
	        <li><a href="./enrollmember">회원가입</a></li>
	        <li><a href="./memberlogin">로그인</a></li>
	        <li><a href="#">마이페이지</a></li>
	        <li><a href="./cartlist">장바구니</a></li>
		</ul>     
		</nav>
	</header>
<div id="promotion">

	</div>
	 <div class="section">
	<div class="Asside-left">
			<ul>
				<li><a href="#">액션/슈팅</a></li>
				<li><a href="#">스포츠</a></li>
				<li><a href="#">보드게임</a></li>
				<li><a href="#">아케이드</a></li>
				<li><a href="#">대전/격투</a></li>
				<li><a href="#">RPG</a></li>
				<li><a href="#">어드벤처</a></li>
				<li><a href="#">시뮬레이션</a></li>
				<li><a href="#">인기 게임</a></li>
			</ul>
	</div> <br>
<div class="Article">
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

</div>
<div>

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
			
		<!--	
		<td>  
		     <%=vo.getGgNo()%> 
		     <%=vo.getGgTitle()%>
			<%=vo.getGgPrice()%>
			<%=vo.getGgSystemRequirement()%>
			<%=vo.getGgGenre()%>
			<%=vo.getGgDeveloper()%>
			<%=vo.getGgReleaseDate()%>
			<%=vo.getGgPublisher()%>
			<%=vo.getGgLanguages()%>
			<%=vo.getGgInfomation()%>
			<td>  
			-->
			
		</tr>	
<%
		}}
%>

	</table>




 <!--   EL를 사용할떄  
     <c:if test="${startPage > 1 }"> <a href="GameList?pagenum=${startPage-1 }">이전</a> </c:if>
		<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<a href="GameList?pagenum=${i}">${i}</a>
		</c:forEach>
	  <c:if test="${endPage < pageCount }"> <a href="GameList?pagenum=${endPage+1 }">다음</a> </c:if> 
 -->
	 
	 	
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
</div>


<footer>
    INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
	</footer>
	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
	console.log("메소드 진입확인");
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