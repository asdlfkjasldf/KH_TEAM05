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
    <title>아이디찾기결과</title>
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

    <h1 class="h1">비밀번호 찾기 결과</h1>

    <div id="section">
		<form action="WEB-INF/view/showPwd.jsp" method="post">
            <p class="t1">
                <label for="pwd">비밀번호 : </label>
                <input type="password" name="mm_pwd" readonly="readonly" value="<%="m.getMm_pwd()"%>" >   <!-- TODO -->
            </p>

                <p class="caption">
                    <a href='WEB-INF/view/login.jsp'>로그인하기</a>
                </p>
        </form>
    </div>
    <div id="footer">
        <h1>footer</h1>
    </div>
</body>
</html>