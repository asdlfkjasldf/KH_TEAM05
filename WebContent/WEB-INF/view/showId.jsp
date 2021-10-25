<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<%@page import="com.indimoa.member.model.vo.Member"%>
<%@page import="com.indimoa.member.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
	Member m = (Member) session.getAttribute("membervo");
%>    
    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    
    <title>아이디찾기결과</title>
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

<%
request.setCharacterEncoding("UTF-8");
String mm_name = request.getParameter("mm_name");
String mm_email = request.getParameter("mm_email");

MemberDao dao = new MemberDao();
int mm_id = dao.selectId(mm_name, mm_email);   //TODO

%>

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
	
	

    <h1 class="h1">아이디 찾기 결과</h1>

<form action="showid" method="post">
	<%
	if (mm_id != 0) {
	%>
    <div id="section">
    	<div class = "found-success">
				<p class="t1">
					<label for="id">아이디: </label>
					<div class="find-id"><%=m.getMm_id()%></div>
				</p>
				<p class="caption">
					<button type="button" id="btnLogin"/><a href="./memberlogin">로그인</a>
				</p>

                <p class="caption">
                    <a href='./findpwd'>비밀번호 찾기</a>
                </p>
        
        </div>
        
    </div>
    <%
	} else {
    %>
    
    
   <div id="section">
    	<div class="found-fail">
    		<h4> 등록된 정보가 없습니다.</h4>
    		
    		<p class="caption">
    			<input type="button" id="btnback" value="다시 찾기" onClick = "history.back()"/>
    			<input type="button" id="btnjoin" value="회원가입" onClick="location.href='WEB-INF/view/newMember.jsp';"/>
    		</p>
    	</div>
   </div>
    
    <%
	}
    %>
  </form>
    <div id="footer">
        INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
    </div>
    
    <div hidden="">돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></div>
</body>
</html>