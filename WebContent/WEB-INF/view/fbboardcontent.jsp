<%@page import="com.indimoa.board.model.vo.FbBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% FbBoard vo = (FbBoard)request.getAttribute("boardvo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<table>
	<tr>
		<td>글번호</td>
		<td><%=vo.getFbNo()%></td>
		<td><%=vo.getFbDatetime()%></td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="2"><%=vo.getFbTitle()%></td>
	</tr>
		<tr>
		<td colspan="3"><%=vo.getFbContent()%></td>
	</tr>
	</table>
	<a href="fbboardwrite?bno=<%=vo.getFbNo()%>">답글작성</a>
</body>
</html>