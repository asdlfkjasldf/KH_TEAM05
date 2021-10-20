<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
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

  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">


.h1{
    font-size: 32px; color: black;
    text-align: center;
    height: 150px;
    margin-bottom: 10px;
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
#pay {
    width: 100px; height: 40px;
    font-size: 20px;
}

    </style>
</head>
<body>
    <!-- modal box -->
    <div id="modal_01" class="modal">
        <div class="modal-content">
                <p class="close"> &times; &nbsp; &#10006;</p>
            <p>카드결제</p>
            <form action="ex-01.html" method="get">
                카드사<select size="1" id="bank" class="input1">
                    <option value="">선택하세요.</option>
                    <option value="10">하나은행</option>
                    <option value="11">신한은행</option>
                    <option value="12">국민은행</option>
                </select>
                카드번호<input type="text" name="a1">
                <br>
                결제 비밀번호<input type="text" name="a1">
                <br>
                <input type="submit" value="결제">
            </form>
        </div>
    </div>


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
        	<form action="./GameList?" method="get">
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


	<div class="section">
    <div class="Article">
    <h1 class="h1">결제창</h1><br><br>


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
        <select size="1" id="howpay" class="input1">
            <option value="">선택하세요.</option>
            <option value="10">카드</option>
            <option value="11">핸드폰 결제</option>
            <option value="12">무통장 입금</option>
        </select>
        </p><br><br>

        <p class="btn-area">
            <button id="pay">결제하기</button>
        </p>
    </form>
</div>
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
    
    
        $("#pay").click(function() {
            $(".modal").show();
        });
        $(".close").click(function() {
            $(".modal").hide();
        });
    </script>
        


<footer>    
    INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
</footer>

<div hidden="">돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></div>
</body>
</html>