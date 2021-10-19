<%@page import="com.indimoa.board.model.vo.NtBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardvo.ntTitle }</title>
<script type="text/javascript">
console.log(boardvo);
</script>
</head>
<body>

<table border="1">
<c:if test="${boardvo != null }">
	
				<tr>
					<td>글번호</td>

					<td>${boardvo.ntNo }</td>
					<td>${boardvo.ntDatetime }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="2">${boardvo.ntTitle }</td>
				</tr>
				<tr>
					<td colspan="3">${boardvo.ntContent }</td>
				</tr>
	
</c:if>
</table>
<a href="notice">목록</a>
</body>
</html>