<%@page import="com.indimoa.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

* {
	font-family: "Noto Sans KR", sans-serif;
}
body {
    margin: 0;
}

#header {
	width: 100%;
	margin: 0 auto; 
	height: 220px;
	position: relative;
}
a:link{
  text-decoration: none!important;
  color: green;
}
li {
	list-style-type: none;
}
#logo{
	width: 100px;
	position: absolute;
}
#highmenu ul li {
	float: left;
	margin: 15px;
	text-align: center;
	position: relative;
	padding-bottom: 0px;
}
#topmenu ul li{
	
	float: left;
	margin: 15px;
	padding: 10px;
	position: relative;
}

.h1 {
    text-align: center;
    height: 150px;
}

#section {
    position: relative; z-index: 2;
    font-family: 'Noto Sans KR', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-size: cover;
	padding-top: 220px;
	padding-bottom: 190px;
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
.btn1 button{
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

#footer {
    clear: both;
    width: 100%;
    height: 190px;
    margin: 0 auto;
    margin-bottom: 10px;
    padding: 10px;
    box-sizing: border-box;
    text-align: center;
}
</style>
<title>My Info View</title>

</head>
<body>
	<%
	Member m = (Member) session.getAttribute("member");
	%>
	<%
	if (m != null) {
	%>
    <div id="header">
		<div id="logo">
		<img src=".jpg" width="200px" height="50px">
		</div>
		
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

	<h1 class="h1">내 정보</h1>

	<div id="section">
		<form action="/myInfo" method="post">
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
					<input type="file" id="image" name="mm_profile" class="input1" accept="image/*" onchange="setThumbnail(event);">
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
				<button type="submit">회원 정보 수정</button>
				&nbsp; &nbsp;
				<button type="button" onclick="location.href='WEB-INF/view/deleteMember?id=<%=m.getMm_id()%>';">회원탈퇴</button>
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
		<button type="button" onclick="location.href='WEB-INF/view/main.jsp';">메인으로가기</button>
	</p>
    <div id="footer">
		<h1>footer</h1>
	</div>
	
	
</body>
</html>