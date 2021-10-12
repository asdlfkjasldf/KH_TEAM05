<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"%> 
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>

  
    
    <%
    
	ArrayList<GameVO> volist = (ArrayList<Game>)request.getAttribute("volist");
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
<title>GAME LIST</title>
</head>
<h1>  게임 리스트</h1>
<table>
<tr>
<td>번호</td>
			<td>제목</td>
			<td>가격</td>
			<td>시스템 사양</td>
			<td>장르</td>
			<td>개발사</td>
			<td>발매일</td>
			<td>공급사</td>
			<td>언어</td>
			<td>정보</td>
			
		<tr>
<%
		if(volist != null){
		for(GameVO vo : volist){
%>
		<tr>
			<td><a href="boardcontent?no=<%=vo.getGgNo()%>"> <%=vo.getGgNo()%> </a></td>
			<td><%=vo.getGgTitle()%></td>
			<td><%=vo.getGgPrice()%></td>
			<td><%=vo.getGgSystemRequirement()%></td>
			<td><%=vo.getGgGenre()%></td>
			<td><%=vo.getGgDeveloper()%></td>
			<td><%=vo.getGgReleaseDate()%></td>
			<td><%=vo.getGgPublisher()%></td>
			<td><%=vo.getGgLanguages()%></td>
			<td><%=vo.getGgInfomation()%></td>
			
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
				%>	다음	 <%
%>

<br>
<a href="tboardWrite">글쓰기</a>

</body>
</html>