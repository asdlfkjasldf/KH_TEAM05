<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>인디모아에 오신 것을 환영합니다.</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">
.accordion{
	background: #eee;
	color: green;
	cursor: pointer;
	border: none;
	text-align: center;
	transition: 0.4s;
}
.ac:active, .accordion:hover {
	background: #ccc;
}
.panel{
	padding: 0 18px;
	background: white;
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.2s ease-out;
}
</style>

</head>
<body>

	<header>
	<div id="logo">로고추가할곳</div>
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
        <li><a href="#">지원</a></li>
        <li><input type="text" id="textSearchGame"></li>
        <li><button type="button" onclick="searchGame()" id="btnSearchGame" style="border: none;" ><img src="./image/free-icon-magnifier-71403.png" class="imgIcon" width="24px" height="24px"> </button></li>
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
	</div>
    <div class="Article">
		<!-- TODO -->
    </div>
    </div>

	<div class="footer">
    INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
	</div>
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