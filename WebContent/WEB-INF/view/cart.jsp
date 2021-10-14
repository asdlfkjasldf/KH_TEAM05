<%@page import="java.util.ArrayList"%>
<%@page import="com.indomoa.cart.model.vo.Cart"%>
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
    
    

</style>
<title>장바구니</title>

<script type="text/javascript">


function fnPay(){
	if(confirm("결제하시겠습니까?")) {
        location.href = "WEB-INF/view/buyPage.jsp";
    }
}

function fnClear(){
	if(confirm("장바구니를 비우시겠습니까?")) {
		location.href = "WEB-INF/view/CartClear.jsp";	
	}
}

function fnGo(){
	location.href = "WEB-INF/view/gamelist.jsp";
}
</script>
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


<div align="center">
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
				<a href= 'WEB-INF/view/gamelist.jsp'>쇼핑하기</a>
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
			<td colspan= '3'>
				<button id="btn" onclick='fnPay()'>결제하기</button>
				<button id="btn" onclick='fnClear()'>장바구니 비우기</button>
				<button id="btn" onclick='fnGo()'>쇼핑 계속하기</button>
			
			
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
</div>

<div id="footer">
        <h1>footer</h1>
    </div>
</body>
</html>