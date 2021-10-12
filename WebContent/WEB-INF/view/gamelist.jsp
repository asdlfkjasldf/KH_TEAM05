<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"--%> 


  
    
    <%
    
	ArrayList<Game> volist = (ArrayList<Game>)request.getAttribute("volist");
//TODO paging처리 후 제대로 열기
 	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount"); 

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GAME LIST</title>
</head>
<h1>  게임 리스트</h1>
<table border="1">
<tr>
<td>번호</td>
			<td>제목</td>
			<td>게임 이미지</td>			
			<td>가격</td>
			<td>장르</td>
			<td>개발사</td>
			<td>발매일</td>
						<td>언어</td>
			
			
		<tr>
<%
		if(volist != null){
		for(Game vo : volist){
%>
		
		<tr>
			<td>
			<%=vo.getGgNo()%>
			</td>
			
			<td>게임 이미지</td>	
		
			<td>
			<a href="gamecontent?no=<%=vo.getGgNo()%>"> <%=vo.getGgTitle()%> </a>
			</td>
			
			<td>  
			<%=vo.getGgPrice()%>원
			</td> 
			
			<!--
			<td>  
			<%=vo.getGgSystemRequirement()%>
			</td>
			-->
			 
			<td> 			
			<%=vo.getGgGenre()%>
			</td>
			
			<td>  
			<%=vo.getGgDeveloper()%>
			</td>
			
		
		
			<td> 
			<%=vo.getGgReleaseDate()%>
			</td>
			<!--
			<td>  
			<%=vo.getGgPublisher()%>
			</td>
			-->
			
			<td> 
			<%=vo.getGgLanguages()%>
			</td>
		<!--		
			<td>  
			<%=vo.getGgInfomation()%>
			</td>
			-->
			
		<!--	
		<td>  
		     <%=vo.getGgNo()%> 
		     <%=vo.getGgTitle()%>
			<%=vo.getGgPrice()%>
			<%=vo.getGgSystemRequirement()%>
			<%=vo.getGgGenre()%>
			<%=vo.getGgDeveloper()%>
			<%=vo.getGgReleaseDate()%>
			<%=vo.getGgPublisher()%>
			<%=vo.getGgLanguages()%>
			<%=vo.getGgInfomation()%>
			<td>  
			-->
			
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
				<a href="GameList?pagenum=<%= i %>"> <%= i %> </a>
				<%
				if (i != endPage) {
					%> , <%				}
			}
			if (endPage < pageCount)
				%>	다음	 <%
%>

<br>
<a href="EnrollGameServlet">게임등록하러 가기</a>

</body>
</html>