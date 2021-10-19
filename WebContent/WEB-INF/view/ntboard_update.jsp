<%@page import="com.indimoa.board.model.vo.NtBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항 글 수정하기</title>
<script type="">

</script>
</head>

<!-- 대략 흐름도 컨텐츠 부분의 bno를 ajax로 쏴서 타이틀 컨텐츠, 불러오고 success시 ajax로 바꿀 title,content를 보내준다.  -->
<body>


<table id="mainTable">
	<c:if test="${loadedboardvo != null }">
		<c:forEach items="${loadedboardvo}" var="vo">
		<form action="noticeupdate" method="post">
<tr>
	<td>글번호 <input type="text" name="no" value="${vo.ntNo }" readonly="readonly"></td>
</tr>
<tr>
	
	
	
		<td><span class="desc">제목</span><input type="text" name="t" id="textTitle" value="${vo.ntTitle}"></td>
		
		
	
</tr>
<tr>
	<td><span class="desc">내용</span> <input type="text" name="c" id="textContent" value="${vo.ntContent}"></td>
</tr>
		</c:forEach>
	</c:if>
		
</table>
	<div class="box">
		<button type="submit" id="btnSubmit">등록</button>
		<a href="notice" id="hrefCancel">취소</a>
</body>
</html>