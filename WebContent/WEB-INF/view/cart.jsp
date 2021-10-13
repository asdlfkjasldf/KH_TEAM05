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
<title>장바구니</title>

<script type="text/javascript">


function fnPay(){
	if(confirm("결제하시겠습니까?")) {
        location.href = "WEB-INF/view/buyPage.jsp";
    }
}

function fnClear(){
	if(confirm("장바구니를 비우시겠습니까?")) {
		location.href = "../pro/CartClear.jsp";	
	}
}

function fnGo(){
	location.href = "WEB-INF/view/gamelist.jsp";
}
</script>
</head>
<body>
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
				<input type='button' value='결제하기' onclick='fnPay()' />
				<input type='button' value='장바구니 비우기' onclick='fnClear()' />
				<input type='button' value='쇼핑 계속하기' onclick='fnGo()' />
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
</body>
</html>