<%@page import="com.indimoa.board.model.vo.NtBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인디모아 공지사항 게시판에 오신것을 환영합니다.</title>
</head>
<script type="text/javascript">

//console.log(volist);
console.log("작동확인");
</script>
<body>

	<h1>게 시 판</h1>
	<table border="1" collapse="collapse">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
		</tr>
	
<c:if test="${volist != null }">
	<c:forEach items="${volist}" var="vo">
		<tr>
			<td><a href="#=${vo.ntNo }">${vo.ntNo }</a></td>
			<td>
			${vo.ntTitle }
			</td>
			<td>${vo.adId }</td>
			<td>${vo.ntDatetime }</td>
		</tr>
	</c:forEach>
</c:if>
</table>
<c:if test="${startPage > 1 }"> 이전 </c:if>
	<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
	<a href="notice?p=${i}">${i}</a>
	</c:forEach>
<c:if test="${endPage < pageCount }"> 다음 </c:if>


	<br>
	<a href="boardwrite"> 글쓰기 </a>
	<a href="boardupdate">글수정 </a>
	<a href="boarddelete">글삭제 </a>
	</body>
</html>
