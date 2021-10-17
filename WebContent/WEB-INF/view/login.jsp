<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');


* {
	font-family: "Noto Sans KR", sans-serif;
}
body {
    margin: 0;
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
    #header {
        width: 100% 
        margin: 0 auto; 
        height: 220px;
        position: relative;
    }



* {margin: 0; padding: 0; box-sizing: border-box;}

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
}
/* .login-form h1{
    font-size: 32px; color: #fff;
    text-align: center;  
    margin-bottom: 60px;  
} */
.int-area {
    width: 400px;
    margin-top: 20px;
}
.int-area:first-child{margin-top: 0;}
.int-area input{
    width: 100%;
    padding: 20px 10px 10px;
    background-color: transparent;
    border: none;
    border-bottom: 1px solid #999;
    font-size: 18px; 
    color: black;
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

.btn-area {margin-top: 30px;}
.btn-area button{
    width: 100%; height: 50px;
    margin-top: 70px;
    background: #166cea;
    color: #fff;
    font-size: 20px;
    border: none;
    border-radius: 25px;
    cursor: pointer;
}

.caption{
    margin-top: 70px;
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
    <title>로그인</title>
</head>
<body>


    <div id="header">
        <div id="logo">로고 추가할 곳
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



    <h1 class="h1">로그인</h1>
    <div id="section">
        <form action="/login" method="post">
            <p class="int-area">
                <label for="id">아이디</label>
                <input type="text" name="mm_id" id="id" autocomplete="off" required>
            </p>
            <p class="int-area">
                <label for="pwd">비밀번호</label>
                <input type="password" name="mm_pwd" id="pwd" autocomplete="off" required>
            </p>
            <p class="btn-area">
                <button id="btn" type="submit" onclick="location.href ='"return loginCheck()'">로그인</button>
            </p>
            <p class="caption">
                <a href='WEB-INF/view/findId.jsp'>아이디 찾기</a>
            </p>
            <p class="caption">
                <a href='WEB-INF/view/findPwd.jsp'>비밀번호 찾기</a>
            </p>
        </form>
    </div>

    <script>
    function loginCheck(){
    	if (document.loginform.userid.value == ""){
    		alert("아이디를 입력해 주세요.");
    		document.loginform.userid.focus();
    		return false;
    	} else if (document.loginform.pwd.value == ""){
    		alert("비밀번호를 입력해주세요.");
    		document.loginform.pwd.focus();
    		return false;
    	} else {
    		return true;
    	}
    }
    
    
    
    
    
//        let id = $("#id");
//        let pw = $("#pwd");
//        let btn = $("#btn");
//
//        $(btn).on('click', function(){
//            if($(id).val() == "") {
//                $(id).next('label').addClass('warning');
//                setTimeout(function(){
//                    $('label').removeClass('warning');
//                }, 1500);
//            }            
//            else if($(pw).val() == "") {
//                $(pw).next('label').addClass('warning');
//                setTimeout(function(){
//                    $('label').removeClass('warning');
//                }, 1500);
//           }
//        });
        
        
    </script>
    <div id="footer">
        <h1>footer</h1>
    </div>
</body>
</html>