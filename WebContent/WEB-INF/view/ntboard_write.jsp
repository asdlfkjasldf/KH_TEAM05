<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
#textTitle{
	width: 1000px;
	height: 1em;
}
#textContent{
	width: 1000px;
	height: 500px;
}
.desc{
text-align: center;
}
.Article{
	align-content: center;
	margin: auto;
}
#btnSubmit,#hrefCancel,#mainTable{
	margin:auto;
    display:block;
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
        <li><a href="#">지원</a></li>
        <li id="textboxli">
        	<!-- todo 링크는 jstl을 이용해 txt박스의 값을 적어구문작성 -->
        	<form action="./GameList?" method="get">
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
	
	<!-- 왼쪽의 서브 메뉴 -->
	
	</div>
    <div class="Article">
    <!-- 페이지의 메인 아티클 -->
    <table id="mainTable">
<!-- 테스트 area의 공간이 너무 적다 style을 이용해 공간을 넓히고 정렬하는 게  좋을 듯하다 -->
<tr>

</tr>
<tr>
	<form action="noticewrite" method="post">
		<td><span class="desc">제목</span><input type="text" name="t" id="textTitle"></td>
		
		
	
</tr>
<tr>
	<td><span class="desc">내용</span> <input type="text" name="c" id="textContent"></td>
</tr>

</table>
	<div class="box">
		<button type="submit" id="btnSubmit">등록</button>
		<a href="notice" id="hrefCancel">취소</a>
	</div>
	</form>
		
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