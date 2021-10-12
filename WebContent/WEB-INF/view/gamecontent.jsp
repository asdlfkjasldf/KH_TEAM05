<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"--%> 



 <% Game vo = (Game)request.getAttribute("gamevo"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 게임 안냐 정보</h1>
    <table border="1">
   
        <tr>
            <td>no </td>
            <td><%=vo.getGgNo()%> </td>
        </tr>
        
        <tr>
            <td>게임 이미지 </td>
            <td>게임 이미지를 불러 와야 합니다!!!!!!!!!! </td>
        </tr>
       
        <tr>

            <td> 게임 제목 </td>
            <td>  <%=vo.getGgTitle()%>
               
               </td>

        </tr>
        <tr>
            <td> 가격 </td>
            <td> <%=vo.getGgPrice()%> 원
                </td>
        </tr>
        <tr>
            <td>시	스	템 	사	양 </td>
            <td> <%=vo.getGgSystemRequirement()%>
               </td>
        </tr>
        <tr>
            <td>장	르 </td>
            <td>  <%=vo.getGgGenre()%>
                </td>
        </tr>
        <tr>
            <td>개	발	사 </td>
            <td> <%=vo.getGgDeveloper()%>
                </td>
        </tr>
        <tr>
            <td>발	매	일</td>
            <td> <%=vo.getGgReleaseDate()%>
                </td>
        </tr>
        <tr>
            <td>공	급	사 </td>
            <td> <%=vo.getGgPublisher()%>
               </td>
        </tr>
        <tr>
            <td>언	어 </td>
            <td>  <%=vo.getGgLanguages()%>
                </td>
        </tr>
        <tr>
            <td>정		보 </td>
            <td> <%=vo.getGgInfomation()%> </td>
        </tr>
        
   
    </table>
    <button type="button">바로 구매</button> 
    <button type="button">장바 구니</button>
    <button type="button"><a href="GameList">취소</a></button>

</body>
</html>