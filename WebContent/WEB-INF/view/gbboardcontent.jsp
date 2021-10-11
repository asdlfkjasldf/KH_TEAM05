<%@page import="com.indimoa.board.model.vo.GbBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% GbBoard vo = (GbBoard)request.getAttribute("boardvo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발자 게시판</title>
</head>
<body>
	<table>
	<tr>
		<td>글번호</td>
		<td><%=vo.getGbNo()%></td>
		<td><%=vo.getGbDatetime()%></td>
		<td><%=vo.getHeHeading()%></td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="2"><%=vo.getGbTitle()%></td>
	</tr>
		<tr>
		<td colspan="3"><%=vo.getGbContent()%></td>
	</tr>
	</table>
	<a href="gbboardwrite?bno=<%=vo.getGbNo()%>">답글작성</a>
</body>
</html>