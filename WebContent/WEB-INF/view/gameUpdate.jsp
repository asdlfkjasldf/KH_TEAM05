<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="com.indimoa.game.model.dao.GameDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%--@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"--%>


<%
	Game vo = (Game) request.getAttribute("gamevo");
%>

<%
ArrayList<Game> ivo = (ArrayList<Game>) request.getAttribute("imagevo");

%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게임 정보 수정</title>
<link rel="stylesheet" href="../../css/myStyle.css" />
</head>

<body>
	<h2 align="center">게임 정보 수정</h2>
	<hr>
	<form method="post" action="./GameUpdate.do" enctype="multipart/form-data">
	
	<input type="hidden" name="ggNo" value="<%=vo.getGgNo()%>" readonly>
		<table style="width:100%">
	
				<tr>
					<td>게임 타이틀 :</td>
					<td><input type="text" name="ggTitle" id="title" autofocus="autofocus" value="<%=vo.getGgTitle()%>" required></td>
				</tr>
				<tr>
					<td>가격 :</td>
					<td><input type="text" name="ggPrice" value="<%=vo.getGgPrice()%>"> 원</td>
				</tr>

				<tr>
					<td>시스템 요구사항 :</td>
					<td><input type="text" name="ggSystemRequirement" value="<%=vo.getGgSystemRequirement()%>"></td>
				</tr>

				<tr>
					<td>장르 :</td>
					<td>
					<!-- input type="text" name="ggGenre"> -->
					<select id="" name="ggGenre" value="<%=vo.getGgGenre()%>">
        			<option value="액션/슈팅">액션/슈팅</option>
        			<option value="스포츠">스포츠</option>
        			<option value="보드게임">보드게임</option>
        			<option value="아케이드">아케이드</option>
        			<option value="대전/격투">대전/격투</option>
        			<option value="RPG">RPG</option>
        			<option value="어드벤처">어드벤처</option>
        			<option value="시뮬레이션">시뮬레이션</option>
        			<option value="기타장르">기타장르</option>
        			<!--  <option value="인기게임">인기게임</option>-->
					</select>
					</td>
					
				</tr>

				<tr>
					<td>개발사 :</td>
					<td><input type="text" name="ggDeveloper" value="<%=vo.getGgDeveloper()%>"></td>
				</tr>

				<tr>
					<td>발매일 :</td>
					<td><input type="text" name="ggReleaseDate" value="<%=vo.getGgReleaseDate()%>"></td>
				</tr>

				<tr>
					<td>공급사 :</td>
					<td><input type="text" name="ggPublisher" value="<%=vo.getGgPublisher()%>"></td>
				</tr>

				<tr>
					<td>언어 :</td>
					<td><input type="text" name="ggLanguages" value="<%=vo.getGgLanguages()%>"></td>
				</tr>

				<tr>
					<td>정보 :</td>
					<td><input type="text" name="ggInfomation" value="<%=vo.getGgInfomation()%>"></td>
				</tr>
				<tr>
<%
if(ivo != null) {
for(Game voimg : ivo) {
%>
				  <td>
						
							<input type="checkbox" value="<%=voimg.getGiNo()%>" name="giNos">삭제
						
                    		<img src="<%=request.getContextPath()%>/upload/<%=voimg.getOriginFileAddress()%>" width="100"><br>
							<%=voimg.getOriginFileAddress()%>
						
                    </td>
<%}} %>
				</tr>
				
					<tr>
					
						<td>게임 이미지 파일 첨부1 :</td>
						<td><input type="file" name="image1" class="gameimage" value=""></td>
						<td>게임 이미지 파일 첨부2 :</td>
						<td><input type="file" name="image2" class="gameimage" value=""></td>
					</tr>

					<tr>
						<td>게임 이미지 파일 첨부3 :</td>
						<td><input type="file" name="image3" class="gameimage" value=""></td>
						<td>게임 이미지 파일 첨부4 :</td>
						<td><input type="file" name="image4" class="gameimage" value=""></td>
					</tr>

			
	</table>
	
				
				<div>
					<input type="submit" value="수정">
       				 <button type="button" onclick="location.href='gamecontent?no=<%=vo.getGgNo()%>'">취소
						<!--  <a href="gamecontent?no=<%=vo.getGgNo()%>">취소</a> 이건  정확한 표현식은 아니야 크롬이 해주는거야-->
					</button>
					
				</div>
	</form>
	
</body>

</html>