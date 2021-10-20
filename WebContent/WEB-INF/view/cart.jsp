<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<%@page import="java.util.ArrayList"%>
<%@page import="com.indimoa.cart.model.vo.Cart"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
    
    
<%
request.setCharacterEncoding("UTF-8");
ArrayList<Cart> cart = null;

Object obj = session.getAttribute("cart");	//세션 객체에서 cart 값을 가져온다.

if(obj == null) {	//세션 정보가 없으면 배열을 생성 : 주문한 제품이 없다
	cart = new ArrayList<Cart>();	
} else {			//세션 정보가 있으면 강제로 캐스팅 : 주문한 제품이 있다
	cart = (ArrayList<Cart>) obj;
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>장바구니</title>
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
</style>

</head>
<body>
    <header>
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
	</header>


<div align="center" class="Article">
	<h3>[장바구니 보기]</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>게임명</th>
			<th>가격</th>
			<th>총액</th>
		</tr>
	
	
	
	
	
	<%
		if(cart.size() == 0) {
	%>
		<tr align='center'>
			<td colspan= '3'>
				장바구니에 담긴 상품이 없습니다.
				<a href= '/GameList'>쇼핑하기</a>
			</td>
		</tr>
	<%
		} else {
			int totalSum = 0, total = 0;
			DecimalFormat df = new DecimalFormat("￦#,##0");
			for(int i = 0; i < cart.size(); i++) {
				Cart ct = cart.get(i);
	%>
		<tr align= 'center'>
			<td><%=ct.getCt_no() %></td>
			<td><%=ct.getCt_content() %></td>
			<td><%=df.format(ct.getCt_price()) %></td>
			<% 
				total = ct.getCt_price();
			%>
			<td><%=df.format(total) %></td>
		</tr>
		<% 
			totalSum += total;
		}
		%>
		<tr align = 'center'>
			
			
			
		<!--    <input type='button' value='결제하기' onclick='fnPay()' />
				<input type='button' value='장바구니 비우기' onclick='fnClear()' />
				<input type='button' value='쇼핑 계속하기' onclick='fnGo()' />    -->
			</td>
		<td>
		 <%=df.format(totalSum) %>
		 </td>
		</tr>
		<% 
			}//if else
		%>
	</table>
			<div align = 'center'>
				<button id="btn" onclick='fnPay()'>결제하기</button>
				<button id="btn" onclick='fnClear()'>장바구니 비우기</button>
				<button id="btn" onclick='fnGo()'>쇼핑 계속하기</button>
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




function fnPay(){
	if(confirm("결제하시겠습니까?")) {
        location.href = "/cartpay";
    }
}

function fnClear(){
	if(confirm("장바구니를 비우시겠습니까?")) {
		alert("장바구니가 삭제되었습니다.");
		location.href = "/cartdelete";	
	}
}

function fnGo(){
	location.href = "/GameList";
}
</script>

<div id="footer">
        INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
    </div>
</body>
</html>