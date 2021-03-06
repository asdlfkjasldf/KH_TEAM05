 <link rel="stylesheet" type="text/css" href="./css/myStyle.css">
 <%@page import="com.indimoa.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jhSeong -->        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과 </title>
<style type="text/css">

<!--#highmenu ul li {  
	
	display: inline-block;
	float: left;
	margin: 15px;
	text-align: center;
	position: relative;
	padding-bottom: 0px;
}
#topmenu ul li{
	display: inline-block;
	float: left;
	margin: 15px;
	padding: 10px;
	position: relative;
}-->


td#info{
	table-layout:fixed;
	width: 200px;
	height: 100px;
	text-overflow: ellipsis;
	overflow: hidden;
}


</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	
	<script type="text/javascript"> 
	

	
	

	function memberView(){
	    console.log("view 진입");
	    let members = document.querySelector(".members");
		var objOption = document.createElement("option");
		
		objOption.text = members.length+1 + "번";
		objOption.value = members.length+1;
		members.options.add(objOption);
	    
	}
</script>
	
	
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
	        <li><a href="./enrollmember">회원가입</a></li>
	        <li><a href="./memberlogin">로그인</a></li>
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
    
	<h1>검색결과</h1>
	
	<form method=get action="./search" >					
	<select id="sc" name="sc">
       
	</select>
	
	<input type="text" name="sk" id="sk">
	<button type="submit" id="btnGameView">조회</button>
	</form>  
	
	<table border="1" collapse="collapse">	
		<tr>
		<td>번호</td>
		<td>게임 이미지</td>
		<td>게임 제목</td>			
		<td>가격</td>
		<td>장르</td>
		<td>개발사</td>
		<td>발매일</td>
		<td>언어</td>
		<td>정보</td>
		</tr>
	

	<c:forEach items="${vosearchresult}" var="vo">
		
		<tr>
		<td>${vo.ggNo }</td>
		<td>${vo.originFileAddress }</td>
		<td>${vo.ggTitle }</td>
		<td>${vo.ggPrice }</td>
		<td>${vo.ggGenre }</td>
		<td>${vo.ggDeveloper }</td>
		<td>${vo.ggReleaseDate }</td>
		<td>${vo.ggLanguages }</td>
		
		</tr>
	</c:forEach>		
	</table>
	<c:if test="${startPage > 1 }"> 이전 </c:if>
	<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
	<a href="./search?pagenum=${i}">${i}</a>
	</c:forEach>
<c:if test="${endPage < pageCount }"> 다음 </c:if>


	
	
		

		
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


