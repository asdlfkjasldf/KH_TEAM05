<%@page import="com.indimoa.board.model.vo.TipBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 --%>
<%
	ArrayList<TipBoard> volist = (ArrayList<TipBoard>)request.getAttribute("volist");
//TODO paging처리 후 제대로 열기
/* 	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount"); */
	int startPage = 1;
	int endPage =1;
	int pageCount = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
	<h1>게 시 판</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
		<tr>
<%
		if(volist != null){
		for(TipBoard vo : volist){
%>
		<tr>
			<td><a href="boardcontent?no=<%=vo.getTipNo()%>"> <%=vo.getTipNo()%> </a></td>
			<td>
			<%=vo.getTipNo()%>
			</td>
			<td><%=vo.getGdGamedevid()%></td>
			<td><%=vo.getTipDatetime()%></td>
		<tr>	
<%
		}}
%>
	</table>
<%
			if (startPage > 1)
				%>	이전	<%
			for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="boardlist?pagenum=<%= i %>"> <%= i %> </a>
				<%
				if (i != endPage) {
					%> , <%				}
			}
			if (endPage < pageCount)
				%>	다음	<%
%>

<br>
<a href="tboardWrite">글쓰기</a>

</body>
</html>