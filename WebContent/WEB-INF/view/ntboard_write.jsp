<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
<link rel='stylesheet' href='/css/defaultstyle.css' type='text/css'> <!-- 현재 링크로 불러오는게 안됌 -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css" >
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
a:link{
  text-decoration: none!important;
  color: green;
}
li{
            text-decoration: none;
            list-style-type: none;
 }
	
</style>

</head>
<body>

<div class="Header">
	<div id="logo">로고추가할곳</div>
	<div id="highmenu">
	 <span>
	    <ul>
        <li><a href="#">상점</a></li>
        <li><a href="#">커뮤니티</a></li>
        <li><a href="#">뉴스</a></li>
        <li><a href="#">카테고리</a></li>
        <li><a href="#">지원</a></li>
        <li><input type="text" id="btnSearchGame"></li>
        <li><button type="button" onclick="searchGame()">돋보기그림추가할것</button></li>
    	</ul>
	</span>
	</div>
	<span id="topmenu">
	<ul>
        <li><a href="#">회원가입</a></li>
        <li><a href="#">로그인</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">장바구니</a></li>
	</ul>     
	</span>
	</div>
	<div id="Middle-page">
	<div class="Asside-left">
			<ul>
				
				
			</ul>
		</div>
	<div class="Article">



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
	
</body>
</html>