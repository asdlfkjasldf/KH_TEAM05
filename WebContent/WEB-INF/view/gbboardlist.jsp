<%@page import="com.indimoa.board.model.vo.GbBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발자 게시판</title>
</head>
<body>
	<h1>게 시 판</h1>
	<table>
		<tr>
			<td>번호</td>
			<td colspan=2>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>카테고리</td>
		</tr>
<c:if test="${volist != null}">
	<c:forEach items="${volist }" var="vo" >
		<tr>
			<td><a href="gbboardcontent?no=${vo.gbNo }">${vo.gbNo } </a></td>
			<td>
			${vo.gbTitle }
			</td>
			<td>[${vo.gbReply }]</td>
			<td>${vo.gdGamedevid }</td>
			<td>${vo.gbDatetime }</td>
			<td>${vo.heHeading }</td>
		</tr>
	</c:forEach>
</c:if>	
	</table>
	<c:if test="${startPage >1 }"> 이전 </c:if>
		<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<a href="gbboardlist?pagenum=${i}">${i}</a>
		</c:forEach>
	<c:if test="${endPage < pageCount }"> 다음 </c:if>
<br>
<a href="gbboardwrite">글쓰기</a>

</body>
</html>