<%@page import="com.indimoa.board.model.vo.FbBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 --%>
<%
	ArrayList<FbBoard> volist = (ArrayList<FbBoard>)request.getAttribute("volist");
 	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
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
		for(FbBoard vo : volist){
%>
		<tr>
			<td><a href="fbboardcontent?no=<%=vo.getFbNo()%>"> <%=vo.getFbNo()%> </a></td>
			<td>
			<%=vo.getFbNo()%>
			</td>
			<td><%=vo.getMmId()%></td>
			<td><%=vo.getFbDatetime()%></td>
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
				<a href="fbboardlist?pagenum=<%= i %>"> <%= i %> </a>
				<%
				if (i != endPage) {
					%> , <%				}
			}
			if (endPage < pageCount)
				%>	다음	<%
%>

<br>
<a href="fbboardwrite">글쓰기</a>

</body>
</html>