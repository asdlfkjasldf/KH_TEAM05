<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<link rel="stylesheet" type="text/css" href="./css/boardStyle.css">

<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"--%>



<%
	Game vo = (Game) request.getAttribute("gamevo");
%>

<%
ArrayList<Game> ivo = (ArrayList<Game>) request.getAttribute("imagevo");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 정보</title>


</head>

<body>

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
	</div>
	<div class="Asside-left">
	<!-- 왼쪽의 서브 메뉴 -->
	</div>
	
	 <div class="Article">

		<div class="Article">
		<!-- 페이지의 메인 아티클 -->
			<h1>게임 정보</h1>

			<table border="1" id="gamecontent">
               
                <tr>
                    <td>no</td>
                    <td ><%=vo.getGgNo()%></td>
           
                </tr>
                <tr>
                    <td colspan="2">게임 이미지</td>
                 </tr>
                 <tr>
                    <td colspan="2">
<%
if(ivo != null) {
	int i=1;
	
for(Game voimg : ivo) {
%>
 						<%=i %>
 						<%i++; %> 
                    	<img src="<%=request.getContextPath()%>/upload/<%=voimg.getOriginFileAddress()%>" width="100">
<%}} %>
                    </td>
                </tr>

			<!--	<tr>
					<td>게임 이미지</td>
					<td>
					<img src="<%=request.getContextPath()%>/upload/<%=vo.getOriginFileAddress()%>" width="100">
				</tr>
                -->
				<tr>
					<td>게임 제목</td>
					<td><%=vo.getGgTitle()%></td>
				</tr>

				<tr>
					<td>가격</td>
					<td ><%=vo.getGgPrice()%> 원</td>
				</tr>

				<tr>
					<td>시스템사양</td>
					<td ><%=vo.getGgSystemRequirement()%></td>
				</tr>

				<tr>
					<td>장르</td>
					<td ><%=vo.getGgGenre()%></td>
				</tr>

				<tr>
					<td>개발사</td>
					<td ><%=vo.getGgDeveloper()%></td>
				</tr>

				<tr>
					<td>발매일</td>
					<td ><%=vo.getGgReleaseDate()%></td>
				</tr>

				<tr>
					<td>공급사</td>
					<td ><%=vo.getGgPublisher()%></td>
				</tr>

				<tr>
					<td>언어</td>
					<td ><%=vo.getGgLanguages()%></td>
				</tr>

				<tr >
					<td>정보</td>
					<td ><%=vo.getGgInfomation()%></td>
				</tr>
				<tr >
				<tr >
					<td colspan="2">
                <button type="button"><a href="GameUpdate?no=<%=vo.getGgNo()%>">게임 정보 수정</a></button>
                <button type="button"><a href="GameDelete.do">게임 삭제</a></button>
					
					</td>
				
				</tr>
				<tr>
					<td colspan="2">
					<div>
					<button type="button">바로 구매</button>
					<button type="button">장바 구니</button>
					<button type="button">
						<a href="GameList">취소</a>
					</button>
					<!-- a href="GameList" 은 GameListServlet으로 연결됨요>  -->
					</div>
					</td>
				</tr>
			</table>
</div>
		</div>
		
		
		<footer>
		INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 :
		홍길동 ｜ 개인정보관리책임자 : 홍길동<br> <br> Copyright © 2020-2021 INDIMOA
		GAME SHOPPING MALL
	</footer>

	<script>
    var acc = document.getElementsByClassName("accordion");
    var i;
 
    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
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

	<div hidden="">
		돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a>
		from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a>
	</div>
	
</body>


</html>