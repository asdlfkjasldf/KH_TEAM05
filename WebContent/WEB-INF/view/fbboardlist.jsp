<%@page import="com.indimoa.board.model.vo.FbBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<h1>자 유 게 시 판</h1>
	<table>
		<tr>
			<td>번호</td>
			<td colspan=2>제목</td>
			<td>작성자</td>
			<td>날짜</td>
		</tr>

<c:if test="${volist != null}">
	<c:forEach items="${volist }" var="vo" >
		<tr>
			<td><a href="fbboardcontent?no=${vo.fbNo }">${vo.fbNo } </a></td>
			<td>
			${vo.fbTitle }
			</td>
			<td>[${vo.fbReply}]</td>
			<td>${vo.mmId }</td>
			<td>${vo.fbDatetime }</td>
		</tr>
	</c:forEach>
</c:if>	
	</table>
	<c:if test="${startPage >1 }"> 이전 </c:if>
		<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<a href="fbboardlist?pagenum=${i}">${i}</a>
		</c:forEach>
	<c:if test="${endPage < pageCount }"> 다음 </c:if>
<br>
<a href="fbboardwrite">글쓰기</a>

</body>
</html>