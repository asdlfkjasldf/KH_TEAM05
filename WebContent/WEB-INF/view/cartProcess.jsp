<%@page import="java.util.ArrayList"%>
<%@page import="com.indimoa.cart.model.vo.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
String content = request.getParameter("ct_content");
String price = request.getParameter("ct_price");

ArrayList<Cart> cart = null;

Object obj = session.getAttribute("cartIn");

if(obj == null) { //세션 정보 없을 때 배열 생성: 최초 주문
	cart = new ArrayList<Cart>();
} else {
	cart = (ArrayList<Cart>) obj; 
}

int pos = -1; //등록된 제품 없을 경우

//장바구니 세션에 등록된 제품이 없을 경우 : Cart 객체를 생성해서 배열에 등록
if(pos == -1) {
	Cart c = new Cart();
	c.setCt_content(content);
	c.setCt_price(Integer.parseInt(price.replace(",", "")));
	cart.add(c);
}

//cart 세션 객체 생성
session.setAttribute("cartIn", cart);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>