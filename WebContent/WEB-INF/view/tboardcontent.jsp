<%@page import="com.indimoa.board.model.vo.TipBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% TipBoard vo = (TipBoard)request.getAttribute("boardvo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팁공유 게시판</title>
</head>
<body>
	<table>
	<tr>
		<td>글번호</td>
		<td><%=vo.getTipNo()%></td>
		<td><%=vo.getTipDatetime()%></td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="2"><%=vo.getTipTitle()%></td>
	</tr>
		<tr>
		<td colspan="3"><%=vo.getTipContent()%></td>
	</tr>
	</table>
	<a href="tboardwrite?bno=<%=vo.getTipNo()%>">답글작성</a>
		<form action="#" method="post">
	<table>
	<tr><td> <input type="text"  name="reply" placeholder="댓글을 작성해주세요." autofocus></td></tr>
	<tr><td><input type="submit" value="작성"></td></tr>
	</table>
	</form>
</body>
</html>