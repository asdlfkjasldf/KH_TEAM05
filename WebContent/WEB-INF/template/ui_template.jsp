<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- jhSeong -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 사용법 
<link rel="stylesheet" type="text/css" href="./css/myStyle.css"> 를 
본인이 작성한 jsp 맨위에 복사후 붙여넣기

아래의 </body> 이전까지 복사 후 본인 body에 붙여넣기 이후  
<div class="Article"> </div> 사이에 본인이 작성한 페이지 적용-->

	<header>
	<nav id="highmenu" class="topmenu">
	<div id="logo"><a href="./"><img src="./image/ex1.png"></a></div>
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
		아래의 choose문으로 세션에 따라서 회원가입,로그인이 보이게하며 서블릿파일에 session.setAttribute("voList", voList);와
		 request.getRequestDispatcher("jsp경로").forward(request, response);가 있어야 작동합니다.-->
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