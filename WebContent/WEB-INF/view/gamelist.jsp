<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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



<style type="text/css">
<link href="css/MemberMangement.css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

* {
	font-family: "Noto Sans KR", sans-serif;
}

body {
	margin: 20px;
	font: 15px;
	
	
}
a:link{
  text-decoration: none!important;
  color: green;
}

li {
	list-style-type: none;
	
}
#logo{
	width: 100px;
	
	position: absolute;
	
}
#highmenu ul li {
	
	display: inline-block;
	float: left;
	margin: 15px;
	text-align: center;
	position: relative;
	padding-bottom: 0px;
}
#topmenu ul li{
	display: inline-block;
	float: left;
	margin: 15px;
	padding: 10px;
	position: relative;
}



.Header {
	width: 100%;
	height: 220px;
	font: 16px;
	font-weight: bold;
	background-color: white;
}

.Asside-left {
	width: 15%;
	font: 16px;
	float: left;
	background-color: gainsboro;
	
	 
}
#Middle-page{
	
	
	 
}
#liRedirect{
	color: white;
}

.Article {
	width: 85%;
	font: 15px;
	float: right;
	
}

.Footer {
	font: 15px;
	width: 100%;
	height: 190px;
}

#table{
width: 85%;
	font: 15px;
	float: right;
	

}
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	
	<script type="text/javascript"> 
	

	
	

	function memberView(){
	    console.log("view 진입");
	    let members = document.querySelector(".members");
		var objOption = document.createElement("option");
		
		objOption.text = members.length+1 + "번";
		objOption.value = members.length+1;
		members.options.add(objOption);
	    
	}
	
	function searchGame() {
		
	}
	
	
	
</script>
	
	









</head>


<body>

	<div class="Header">
	<div id="logo">로고추가할곳</div>
	<div id="highmenu">
	 <span>
	    <ul>
        <li><a href="#">상점</a></li>
        <li><a href="#">커뮤니티</a></li>
        <li><a href="#">뉴스</a></li>
        <li><a href="#">카테고리</a></li>
        <li><a href="#">지원</a></li>
        <li><input type="text" id="btnSearchGame"></li>
        <li><button type="button" onclick="searchGame()">돋보기그림추가할것</button></li>
    	</ul>
	</span>
	</div>
	<span id="topmenu">
	<ul>
        <li><a href="#">회원가입</a></li>
        <li><a href="#">로그인</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">장바구니</a></li>
	</ul>     
	</span>
	</div>
	<div id="Middle-page">
	<div class="Asside-left">
			<ul>
				<li><a href="#">내 정보</a></li>
				<li><a href="indimoa/membermanagement" id="liRedirect">회원</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a href="GameList">게임</a></li>
				<li><a href="#">통계</a></li>
				
			</ul>
		</div>


<div class="Article">
<h1>  게임 상점 </h1>


	<form method=get action="<c:url value='/GameList'/>" >					
	<select id="sc" name="sc">
        <option value="nk">게임타이틀</option>
        <option value="ik">장르</option>
        <option value="nik">발매일</option>
	</select>
	
	<input type="text" name="sk" id="sk">
	<button type="submit" id="btnGameView">조회</button>
	</form>


<div>

<table border="1" collapse="collapse" >
			<tr>
			<td>번호</td>
			<td>게임 이미지</td>
			<td>게임 제목</td>			
			<td>가격</td>
			<td>장르</td>
			<td>개발사</td>
			<td>발매일</td>
			<td>언어</td>
			</tr>
<%
		if(volist != null){
			
			boolean flag = false;
			int no = 0;
			int i =1;
			
		for(Game vo : volist){
			
// 			if (no == vo.getGgNo()){
// 				flag = true;
// 			}else {
// 				flag = false;
// 				no=vo.getGgNo();
// 			}
// 			if(flag){
// 				continue;
// 			}
			
			
			// tr이 volist 갯수 만큼 생기게 됨.
			// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ; 없어야한다.
%>
		
		<tr>
			<td><%=vo.getGgNo()%></td>
			
			<td>
			<!--img alt="#" src="C:\z_worksapce\z_java\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\indimoa\upload/<%=vo.getOriginFileAddress()%>" width="100"-->
			<!--img alt="#" src="../wtpwebapps/upload/<%=vo.getOriginFileAddress()%>" width="100"-->
			<img src="<%=request.getContextPath()%>/upload/<%=vo.getOriginFileAddress()%>" width="100"> 
			<!--img src="${vo.imageSavePath}">  -->
			
			
			</td>	
		
		
		
		
		
		
		
			<td>
			<a href="gamecontent?no=<%=vo.getGgNo()%>"> <%=vo.getGgTitle()%> </a>
			</td>
			
			<td><%=vo.getGgPrice()%>원</td> 
			<!-- <td><%=vo.getGgSystemRequirement()%></td>	-->
			<td><%=vo.getGgGenre()%></td>			
			<td><%=vo.getGgDeveloper()%></td>
			<td><%=vo.getGgReleaseDate()%></td>
			<!-- <td><%=vo.getGgPublisher()%></td>	-->
			<td><%=vo.getGgLanguages()%></td>
			<!--<td><%=vo.getGgInfomation()%></td>	-->
			
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
			
		</tr>	
<%
		}}
%>

	</table>




 <!--   EL를 사용할떄  
     <c:if test="${startPage > 1 }"> <a href="GameList?pagenum=${startPage-1 }">이전</a> </c:if>
		<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<a href="GameList?pagenum=${i}">${i}</a>
		</c:forEach>
	  <c:if test="${endPage < pageCount }"> <a href="GameList?pagenum=${endPage+1 }">다음</a> </c:if> 
 -->
	 
	 	
<%
			if (startPage > 1){
%>				<a href="GameList?pagenum=<%= startPage-1 %>">이전</a>	
<% }
			for (int i = startPage; i <= endPage; i++) {
%>
				<a href="GameList?pagenum=<%= i %>"> <%= i %> </a>
				<%
				if (i != endPage) {
					%> , <%				}
			}
			if (endPage < pageCount){
				%>	<a href="GameList?pagenum=<%= endPage+1 %>">다음</a>	 
<%
			}
%>

<br>
<a href=EnrollGame>게임등록하러 가기!</a>

<!--  a href= get 방식으로 보냄 servlet에서 무조건 get으로 받아야됨!!-->

</div>


<div> 
<h1> 게시물 정렬 테스트 1</h1>
</div>





</body>
</html>