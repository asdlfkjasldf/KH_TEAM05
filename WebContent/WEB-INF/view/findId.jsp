<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="style.css"> -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap');

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

    .int-area {
        width: 400px;
        margin-top: 10px;
    }
    .int-area:first-child{margin-top: 0;}
    .int-area input{
        width: 100%;
        padding: 20px 10px 10px;
        background-color: transparent;
        border: none;
        border-bottom: 1px solid #999;
        font-size: 18px; color: black;
        outline: none;
    }
    .int-area label{
        font-size: 18px; color: #999;
        transition: top .5s ease;
    }
    .int-area label.warning {
        color: red !important;
        animation: warning .3s ease;
        animation-iteration-count: 3;
    }

    .int-area input:focus + label,
    .int-area input:valid + label {
        top: -2px;
        font-size: 13px; color: #166cea;
    }

    .btn-area {margin-top: 50px;}
    .btn-area button{
        width: 100%; height: 50px;
        margin-top: 10px;
        background: #166cea;
        color: #fff;
        font-size: 20px;
        border: none;
        border-radius: 25px;
        cursor: pointer;
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
        width: 100%;
        height: 190px;
        margin: 0 auto;
        margin-bottom: 10px;
        padding: 10px;
        box-sizing: border-box;
        text-align: center;
    }
    </style>
    <title>아이디 찾기</title>
</head>
<body>
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

    <h1 class="h1">아이디 찾기</h1>
    
    <div id="section">
        <form action="/showid" method="post">
            <p class="int-area">
                <label for="name">이름</label>
                <input type="text" name="mm_name" id="name"  autocomplete="off" required>
            </p>
            <p class="int-area">
                <label for="email">이메일</label>
                <input type="text" name="mm_email" id="email"  autocomplete="off" required>
            </p>
            <p class="btn-area">
                <button id="btn" type="submit" onlick="id_search()">찾기</button>
                <button id="btn" type="reset" onclick="history.back()">취소</button>
            </p>
            <p class="caption">
                <a href='/selectpwd'>비밀번호 찾기</a>
            </p>
        </form>
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
    
    
    
    function id_search() {
    	var frm = document.idfindscreen;
    	
    	if(frm.mm_name.value.length < 1) {
    		alert("이름을 입력해주세요");
    		return;
    	}
    	if (frm.mm_email.value.length < 1) {
    		alert("이메일을 입력해주세요");
    		return;
    	}
    	frm.method = "post";
    	frm.action = "showId.jsp";
    	frm.submit();
    }
    
    
    
    
    
//        let name = $("#name");
//        let email = $("#email");
//        let btn = $("#btn");
//
//        $(btn).on('click', function(){
//            if($(id).val() == "") {
//                $(id).next('label').addClass('warning');
//                setTimeout(function(){
//                    $('label').removeClass('warning');
//                }, 1500);
//            } else if($(pw).val() == "") {
//                $(pw).next('label').addClass('warning');
//                setTimeout(function(){
//                    $('label').removeClass('warning');
//                }, 1500);
//            }
//        });
    </script>
    <div id="footer">
        INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
    </div>
</body>
</html>