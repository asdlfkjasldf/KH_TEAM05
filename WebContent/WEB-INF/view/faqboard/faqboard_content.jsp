<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<%@page import="com.indimoa.board.model.vo.FaqBoard" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<!-- jhSeong -->
<html>
<head>
<meta charset="UTF-8">
<title>${boardvo.fqTitle }</title>

<script>
$(document).ready(function(){
	$("#btnBoardDelete").on("click",function() {
		var confirmDelete = confirm("정말로 삭제하시겠습니까?");
		var url = "./faqdelete?no="+${ boardvo.fqNo };
		if (confirmDelete == true){
			$(location).attr('href', url);
		}
			
	});
});
</script>
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
	    <c:choose>
		<c:when test="${voList == null }">
			<li><a href="./enrollmember">회원가입</a></li>
		    <li><a href="./memberlogin">로그인</a></li>
		</c:when>
        <c:when test="${voList != null }">
	        	${voList.mm_id }님
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
	<div class="Asside-left">
	
	<!-- 왼쪽의 서브 메뉴 -->
	
	</div>
    <div class="Article">
    <!-- 페이지의 메인 아티클 -->
     <table border="1">
 <c:if test="${boardvo != null }">
	 <tr>
	 	<td >글번호</td>
		<td id="boardNo">${boardvo.fqNo }</td>
		<td>${boardvo.fqDatetime }	
		<td>조회수</td>
		<td>${boardvo.fqVisit }</td>
	 </tr>
	 <tr>
	 	<td>제목</td>
	 	<td colspan="4">${boardvo.fqTitle }</td>
	 </tr>
	 <tr>
	 	<td colspan="5">${boardvo.fqContent }</td>
	 </tr>
 
 </c:if>
 </table>
 <a href="faq">목록</a>
 <!-- 이 부분은 어드민한테만 보이도록 수정 필요 -->
 <a href="faqupdate?no=${boardvo.fqNo }">글수정</a>
 <button id="btnBoardDelete">글삭제</button>
 
		
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