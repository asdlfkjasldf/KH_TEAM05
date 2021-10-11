<%@page import="com.indimoa.board.model.vo.TipBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 --%>
<%
	ArrayList<TipBoard> volist = (ArrayList<TipBoard>)request.getAttribute("volist");
 	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount"); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팁공유 게시판</title>
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
			<td><a href="tboardcontent?no=<%=vo.getTipNo()%>"> <%=vo.getTipNo()%> </a></td>
			<td>
			<% 
			for(int i = 0;i<vo.getBreLevel();i++){
			%>
				Re :
				<% 
			}
			%>
			<%=vo.getTipTitle()%>
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
				<a href="tboardlist?pagenum=<%= i %>"> <%= i %> </a>
				<%
				if (i != endPage) {
					%> , <%				}
			}
			if (endPage < pageCount)
				%>	다음	<%
%>

<br>
<a href="tboardwrite">글쓰기</a>

</body>
</html>