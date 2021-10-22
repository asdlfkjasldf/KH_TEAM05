<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<%@page import="com.indimoa.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>My Info View</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">


.h1 {
    text-align: center;
    height: 150px;
}

.t1 {
    width: 400px;
    margin-top: 20px;
}
.t1:first-child{margin-top: 0;}
.t1 input{
    width: 100%;
    padding: 20px 10px 10px;
    background-color: transparent;
    border: 1px solid black;
    font-size: 18px; color: black;
    outline: none;
}
.t1 label{
    font-size: 18px; color: #999;
    transition: top .5s ease;
}
.t2 {
    width: 400px;
    margin-top: 20px;
}
.t2:first-child{margin-top: 0;}
.t2 input{
    width: 100%;
    padding: 20px 10px 10px;
    background-color: transparent;
    border: none;
    font-size: 18px; color: black;
    outline: none;
}
.t2 label{
    font-size: 18px; color: #999;
    transition: top .5s ease;
}




.btn1 {margin-top: 30px;}
#btnn{
    width: 200px; height: 50px;
    margin-top: 70px;
    background: #166cea;
    color: #fff;
    font-size: 20px;
    border: none;
    border-radius: 25px;
    cursor: pointer;
}
.btn2 {
	text-align: center;
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
	
	<%
	Member m = (Member) session.getAttribute("membervo");
	%>
	<%
	if (m != null) {
	%>
	<div class="section">
	<h1 class="h1">내 정보</h1>

		<form action="myinfo" method="post">
				<p class="t1">
					<label for="id">아이디 : </label>
					<input type="text" name="id" readonly="readonly" value="<%=m.getMm_id()%>" >
				</p>
				<p class="t1">
					<label for="pwd">비밀번호 : </label>
					<input type="password" name="pwd" readonly="readonly" value="<%=m.getMm_pwd()%>">
					</p>
				<p class="t1">
					<label for="name">이름 : </label>
					<input type="text" name="name" readonly="readonly" value="<%=m.getMm_name()%>">
				</p>
				<p class="t1">
					<label for="email">이메일 : </label>
					<input type="text" name="email" readonly="readonly" value="<%=m.getMm_email()%>">
				</p>
				<p class="t1">
					<label for="phn">전화번호 : </label>
					<input type="text" name="phn" readonly="readonly" value="<%=m.getMm_phn()%>">
				</p>
				<p class="t1">
					<label for="com">OS : </label>
					<input type="text" name="com" readonly="readonly" value="<%=m.getMm_com()%>">
				</p>
				<p class="t2">
					<label for="profile">프로필 : </label>
					<input type="file" id="image" name="mm_profile" value="<%=m.getMm_profile()%>" onchange="setThumbnail(event);">
					<div id="image_container"></div>
				</p>
				<p class="t1">
					<label for="nickname">닉네임 : </label>
					<input type="text" name="nickname" readonly="readonly" value="<%=m.getMm_nickname()%>">
				</p>
				<p class="t1">
					<label for="membership">멤버쉽 : </label>
					<input type="text" name="membership" readonly="readonly" value="<%=m.getMm_membership()%>">
				</p>
				
			<p class="btn1">
				<button type="submit" id="btnn">회원 정보 수정</button>
				&nbsp; &nbsp;
				<input type="button" id="btnn"><a href="'memberdelete?id=<%=m.getMm_id()%>';">회원탈퇴</a>
			</p>
		</form>
	</div>
	
	<%
		} else {
	%>
	<jsp:forward page="newMember.jsp" />
	<!-- 가입하지 않은 사용자가 접속할 경우 newMember.jsp로 forwarding -->
	<%
		}
	%>
	<br>
	<br>
	<br>
	<br>
	<p class="btn2">
		<input type="button"><a href="/WEB-INF/view/index.jsp">메인으로가기</a>
	</p>
	
	
    <footer>
		INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
	</footer>
<div hidden="">돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></div>	
	
</body>
</html>