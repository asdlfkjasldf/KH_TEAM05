<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<%@page import="com.indimoa.member.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title>비밀번호 찾기결과</title>
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
        
        
        .h1 {
            text-align: center;
            height: 50px;
        }


        #section {
            position: relative; z-index: 2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-size: cover;
            padding-bottom: 190px;
        }
        .t1 {
            width: 400px;
            margin-top: 10px;
        }
        .t1:first-child{margin-top: 0;}
        .t1 input{
            width: 100%;
            padding: 20px 10px 10px;
            background-color: transparent;
            border: none;
            border-bottom: 1px solid #999;
            font-size: 18px; color: black;
            outline: none;
        }
        .t1 label{
            font-size: 18px; color: #999;
            transition: top .5s ease;
        }
        .caption{
            margin-top: 50px;
            text-align: center;
        }
        .caption a{
            font-size: 15px;
            color: #999;
            text-decoration: none;
        }

        #footer {
        clear: both;
        width: 100%
        height: 190px;
        margin: 0 auto;
        margin-bottom: 10px;
        padding: 10px;
        box-sizing: border-box;
        text-align: center;
    }

    </style>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String mm_name = request.getParameter("mm_name");
String mm_id = request.getParameter("mm_id");
String mm_email = request.getParameter("mm_email");

MemberDao dao = new MemberDao();
int mm_pwd = dao.selectPwd(mm_name, mm_id, mm_email);   //TODO

%>




    <div id="header">
        <div id="logo">
        로고 추가할 곳
        </div>     
    
    	<div id="highmenu">
	 	<span>
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
        	<li><input type="text" id="btnSearchGame"></li>
        	<li><button type="button" onclick="searchGame()">돋보기그림추가할것</button></li>
    		</ul>
		</span>
		</div>
		<span id="topmenu">
	<ul>
        <li><a href="./enrollmember">회원가입</a></li>
        <li><a href="./memberlogin">로그인</a></li>
        <li><a href="./myInfo">마이페이지</a></li>
        <li><a href="./cartlist">장바구니</a></li>
	</ul>     
	</span>
	</div>
	
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
	
	

    
	<form action="WEB-INF/view/showPwd.jsp" method="post">
	<%
	if (mm_pwd != 0) {
	%>
<div id = "section">
    <h1 class="h1">비밀번호 찾기 결과</h1>

    	<div class = "found-success">
            <p class="t1">
                <label for="pwd">비밀번호 : </label>
                <div class="find-pwd"><%=mm_pwd%></div>
            </p>

                <p class="caption">
                    <input type="button" id="btnLogin" value="로그인" onClick = "location.href='WEB-INF/view/login.jsp';"/>
                </p>
        
    	</div>
		
</div>
    <%
	} else {
    %>
    <div id="section">
    	<div class="found-fail">
    		<form method="post" action="<c:url value='/selectpwd'/>" >
    		<h4> 등록된 정보가 없습니다.</h4>
    		
    		<p class="caption">
    			<input type="button" id="btnback" value="다시 찾기" onClick = "history.back()"/>
    		</p>
    		</form>
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
</body>
</html>