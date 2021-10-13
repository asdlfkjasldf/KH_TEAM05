<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"--%> 



 <% Game vo = (Game)request.getAttribute("gamevo"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<style type="text/css">
<link href="css/MemberMangement.css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

* {
	font-family: "Noto Sans KR", sans-serif;
}

body {
	margin: 20px;
	font: 15px;
	
	
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
}



.Header {
	width: 100%;
	height: 220px;
	font: 16px;
	font-weight: bold;
	background-color: white;
}

.Asside-left {
	width: 15%;
	font: 16px;
	float: left;
	background-color: gainsboro;
	
	 
}
#Middle-page{
	
	
	 
}
#liRedirect{
	color: white;
}

.Article {
	width: 85%;
	font: 15px;
	float: right;
	background-color: gray;
}

.Footer {
	font: 15px;
	width: 100%;
	height: 190px;
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
	
	function searchGame() {
		
	}
	
	
	
</script>
	
	















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
				<li><a href="#">내 정보</a></li>
				<li><a href="indimoa/membermanagement" id="liRedirect">회원</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a href="GameList">게임</a></li>
				<li><a href="#">통계</a></li>
				
			</ul>
		</div>










<h1> 게임 안냐 정보</h1>

    <table border="1">
   
        <tr>
            <td>no </td>
            <td><%=vo.getGgNo()%> </td>
        </tr>
        
        <tr>
            <td>게임 이미지 </td>
            <td>게임 이미지를 불러 와야 합니다!!!!!!!!!! </td>
        </tr>
       
        <tr>

            <td> 게임 제목 </td>
            <td>  <%=vo.getGgTitle()%>
               
               </td>

        </tr>
        <tr>
            <td> 가격 </td>
            <td> <%=vo.getGgPrice()%> 원
                </td>
        </tr>
        <tr>
            <td>시	스	템 	사	양 </td>
            <td> <%=vo.getGgSystemRequirement()%>
               </td>
        </tr>
        <tr>
            <td>장	르 </td>
            <td>  <%=vo.getGgGenre()%>
                </td>
        </tr>
        <tr>
            <td>개	발	사 </td>
            <td> <%=vo.getGgDeveloper()%>
                </td>
        </tr>
        <tr>
            <td>발	매	일</td>
            <td> <%=vo.getGgReleaseDate()%>
                </td>
        </tr>
        <tr>
            <td>공	급	사 </td>
            <td> <%=vo.getGgPublisher()%>
               </td>
        </tr>
        <tr>
            <td>언	어 </td>
            <td>  <%=vo.getGgLanguages()%>
                </td>
        </tr>
        <tr>
            <td>정		보 </td>
            <td> <%=vo.getGgInfomation()%> </td>
        </tr>
        


    <button type="button">바로 구매</button> 
    <button type="button">장바 구니</button>
    <button type="button"><a href="GameList">취소</a></button>
       <!--  
        a href="GameList" 은 GameListServlet으로 연결됨요>
       -->
       

  

</body>
</html>