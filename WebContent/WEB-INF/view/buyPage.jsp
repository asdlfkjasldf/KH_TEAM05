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
    
    <title>BuyPage</title>

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

.h1{
    font-size: 32px; color: black;
    text-align: center;
    height: 150px;
    margin-bottom: 10px;
}
#section {
    position: relative; z-index: 2;
    font-family: 'Noto Sans KR', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-size: cover;
    padding-bottom: 190px;
}

.int-area {
    width: 400px;
    margin-top: 20px;
}

.int-area:first-child{margin-top: 0;}
.input1 {
    width: 100%;
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


.btn-area {margin-top: 50px;}
.btn-area input{
    width: 100%; height: 50px;
    background: #166cea;
    color: #fff;
    font-size: 20px;
    border: none;
    border-radius: 25px;
    cursor: pointer;
    
}
#signup {
    width: 100px; height: 40px;
    font-size: 20px;
}

#footer {
            clear: both;
            width: 100%;
            height: 190px;
            bottom: 0;
            margin: 0 auto;
            margin-bottom: 10px;
            padding: 10px;
            box-sizing: border-box;
            text-align: center;  
        }
    </style>
</head>
<body>
    <div id="header">
        <div id="logo">
        <img src=".jpg" width="200px" height="50px">
        
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

    <h1 class="h1">결제창</h1><br><br>


    <div id="section">
        <form action="#" method="get" id="buyform">
        <p class="t1">
            <label for="buyobject">구매상품명 : </label>
            <input type="text" name="gg_title" class="input1" value="<%="m.getGg_title()"%>" readonly="readonly"> <!-- TODO -->
        </p><br>
        
        <p class="int-area">
            <label for="price">상품가격:</label>
            <input type="text" name="gg_price" class="input1" value="<%="m.getGg_price()"%>" readonly="readonly"> <!-- TODO -->
        </p><br>
        
        <p class="int-area">
        <label for="pay">결제 수단</label>
        <select size="1" id="pay" class="input1">
            <option value="">선택하세요.</option>
            <option value="10">카드</option>
            <option value="11">핸드폰 결제</option>
            <option value="12">무통장 입금</option>
        </select>
        </p><br><br>

        <p class="btn-area">
            <input type="submit" id="signup" value="결제하기">
        </p>
    </form>
</div> 
        


<div id="footer">
    <h1>footer</h1>
</div>
</body>
</html>