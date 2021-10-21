<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<%@page import="com.indimoa.board.model.vo.FaqBoard" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardvo.fqTitle }</title>
<script type="text/javascript">
</script>
</head>
<body>
 <table border="1">
 <c:if test="${boardvo != null }">
	 <tr>
	 	<td>글번호</td>
		<td>${boardvo.fqNo }</td>
		<td>${boardvo.fqDatetime }	
		<td>조회수</td>
		<td>${boardvo.fqVisit }</td>
	 </tr>
	 <tr>
	 	<td>제목</td>
	 	<td colspan="4">${boardvo.fqTitle }</td>
	 </tr>
	 <tr>
	 	<td colspan="5">${boardvo.fqContent }</td>
	 </tr>
 
 </c:if>
 </table>
 <a href="faq">목록</a>
 <!-- 이 부분은 어드민한테만 보이도록 수정 필요 -->
 <a href="faqUpdate?no=${boardvo.fqNo }">글수정</a>
 <a href="faqDelete?no=${boardvo.fqNo }">글삭제</a>
 
</body>
</html>