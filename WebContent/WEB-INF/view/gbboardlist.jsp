<%@page import="com.indimoa.board.model.vo.GbBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 --%>
<%
	ArrayList<GbBoard> volist = (ArrayList<GbBoard>)request.getAttribute("volist");
 	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount");

%>
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
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
		<tr>
<%
		if(volist != null){
		for(GbBoard vo : volist){
%>
		<tr>
			<td><a href="gbboardcontent?no=<%=vo.getGbNo()%>"> <%=vo.getGbNo()%> </a></td>
			<td>
			<%=vo.getGbNo()%>
			</td>
			<td><%=vo.getGdGamedevid()%></td>
			<td><%=vo.getGbDatetime()%></td>
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
				<a href="gbboardlist?pagenum=<%= i %>"> <%= i %> </a>
				<%
				if (i != endPage) {
					%> , <%				}
			}
			if (endPage < pageCount)
				%>	다음	<%
%>

<br>
<a href="gbboardwrite">글쓰기</a>

</body>
</html>