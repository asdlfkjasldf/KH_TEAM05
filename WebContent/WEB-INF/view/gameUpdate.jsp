<link rel="stylesheet" type="text/css" href="./css/myStyle.css">

<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="com.indimoa.game.model.dao.GameDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
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
<title>게임 정보 수정</title>

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
		<!-- 맨위 쪽에 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 필요하며		
		아래의 choose문으로 세션에 따라서 회원가입,로그인이 보이도록 작동합니다.-->
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
    <h2 align="center">게임 정보 수정</h2>
	<hr>
	<form method="post" action="./GameUpdate.do" enctype="multipart/form-data">
	
	<input type="hidden" name="ggNo" value="<%=vo.getGgNo()%>" readonly>
		<table style="width:100%">
	
				<tr>
					<td>게임 타이틀 :</td>
					<td><input type="text" name="ggTitle" id="title" autofocus="autofocus" value="<%=vo.getGgTitle()%>" required></td>
				</tr>
				<tr>
					<td>가격 :</td>
					<td><input type="text" name="ggPrice" value="<%=vo.getGgPrice()%>"> 원</td>
				</tr>

				<tr>
					<td>시스템 요구사항 :</td>
					<td><input type="text" name="ggSystemRequirement" value="<%=vo.getGgSystemRequirement()%>"></td>
				</tr>

				<tr>
					<td>장르 :</td>
					<td>
					<!-- input type="text" name="ggGenre"> -->
					<select id="" name="ggGenre" value="<%=vo.getGgGenre()%>">
        			<option value="액션/슈팅">액션/슈팅</option>
        			<option value="스포츠">스포츠</option>
        			<option value="보드게임">보드게임</option>
        			<option value="아케이드">아케이드</option>
        			<option value="대전/격투">대전/격투</option>
        			<option value="RPG">RPG</option>
        			<option value="어드벤처">어드벤처</option>
        			<option value="시뮬레이션">시뮬레이션</option>
        			<option value="기타장르">기타장르</option>
        			<!--  <option value="인기게임">인기게임</option>-->
					</select>
					</td>
					
				</tr>

				<tr>
					<td>개발사 :</td>
					<td><input type="text" name="ggDeveloper" value="<%=vo.getGgDeveloper()%>"></td>
				</tr>

				<tr>
					<td>발매일 :</td>
					<td><input type="text" name="ggReleaseDate" value="<%=vo.getGgReleaseDate()%>"></td>
				</tr>

				<tr>
					<td>공급사 :</td>
					<td><input type="text" name="ggPublisher" value="<%=vo.getGgPublisher()%>"></td>
				</tr>

				<tr>
					<td>언어 :</td>
					<td><input type="text" name="ggLanguages" value="<%=vo.getGgLanguages()%>"></td>
				</tr>

				<tr>
					<td>정보 :</td>
					<td><input type="text" name="ggInfomation" value="<%=vo.getGgInfomation()%>"></td>
				</tr>
				<tr>
<%
if(ivo != null) {
for(Game voimg : ivo) {
%>
				  <td>
						
							<input type="checkbox" value="<%=voimg.getGiNo()%>" name="giNos">삭제
						
                    		<img src="<%=request.getContextPath()%>/upload/<%=voimg.getOriginFileAddress()%>" width="100"><br>
							<%=voimg.getOriginFileAddress()%>
						
                    </td>
<%}} %>
				</tr>
				
					<tr>
					
						<td>게임 이미지 파일 첨부1 :</td>
						<td><input type="file" name="image1" class="gameimage" value=""></td>
						<td>게임 이미지 파일 첨부2 :</td>
						<td><input type="file" name="image2" class="gameimage" value=""></td>
					</tr>

					<tr>
						<td>게임 이미지 파일 첨부3 :</td>
						<td><input type="file" name="image3" class="gameimage" value=""></td>
						<td>게임 이미지 파일 첨부4 :</td>
						<td><input type="file" name="image4" class="gameimage" value=""></td>
					</tr>

			
	</table>
	
				
				<div>
					<input type="submit" value="수정">
       				 <button type="button" onclick="location.href='gamecontent?no=<%=vo.getGgNo()%>'">취소
						<!--  <a href="gamecontent?no=<%=vo.getGgNo()%>">취소</a> 이건  정확한 표현식은 아니야 크롬이 해주는거야-->
					</button>
					
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