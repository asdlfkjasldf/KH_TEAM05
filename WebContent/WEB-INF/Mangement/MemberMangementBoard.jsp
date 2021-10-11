 <%@page import="com.indimoa.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//이곳은 자바 문법에 따른다.
        	ArrayList<Member> volist = (ArrayList<Member>)request.getAttribute("boardvolist");
            int startPage = (int)request.getAttribute("startPage");
            int endPage = (int)request.getAttribute("endPage");
            int pageCount = (int)request.getAttribute("pageCount");
    %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지  회원관리</title>
<base href="/">
<style type="text/css">
<
link
 
href
="
css
/
MemberMangement
.css
"
>
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
	background-color: gray;
}

.Footer {
	font: 15px;
	width: 100%;
	height: 190px;
}
</style>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
	$(function(){
		$("#userid").on('click',function(){
			
			$.ajax({
				type : "POST",
				url : "membermanagement",
				data : {
					id : $("userid").val()
				},
				dataType : "json",
				
			})
		})
	});
	</script>
	
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
				<li><a href="#">게임</a></li>
				<li><a href="#">통계</a></li>
				
			</ul>
		</div>
	<div class="Article">
	<h1>회원</h1>
	
	<form method="post" action="indimoa/membermanagement?membersearch=" >					
	<select class="members">
        <option value="nk">이름</option>
        <option value="ik">ID</option>
        <option value="nk">닉네임</option>
	</select>
	
	<input type="text" name="membersearch" id="membersearch">
	<button type="submit" id="btnMemberView">조회</button>
	</form>  
	<table border="1" collapse="coplapse">	
		<tr>
		<td>ID</td>
		<td>비밀번호</td>
		<td>NICKNAME</td>
		<td>가입일자</td>
		<td>EMAIL</td>
		<td>번호</td>
		<td>사양</td>
		<td>프로필</td>
		<td>맴버십</td>
		<td>이름</td>
		<td>포인트</td>
		<tr>
	<%
		if(volist != null) {
			for(Member vo : volist){
			// tr이 volist 갯수 만큼 생기게 됨.
			// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ; 없어야한다.
	%>

	
		<form method="post" action="indimoa/delete/member-from-management">
		<tr>
		
		<td><input type="checkbox" name="checkName" value="<%=vo.getMm_id() %>">
		<%=vo.getMm_id() %></td>

		<td>
		<!-- 	<%
				// 답글 몇단에 따라서 Re: 붙여주기
				//for(int i = 0; i<vo.(); i++){
					%>
					Re:
			<%
			//	}
			%> -->
		<%=vo.getMm_pwd()%></td>
		<td><%=vo.getMm_nickname() %></td>
		<td><%=vo.getMm_enrolldate()%></td>
		<td><%=vo.getMm_email()%></td>
		<td><%=vo.getMm_phn()%></td>
		<td><%=vo.getMm_com()%></td>
		<td><%=vo.getMm_profile()%></td>
		<td><%=vo.getMm_membership()%></td>
		<td><%=vo.getMm_name()%></td>
		<td><%=vo.getMm_point()%></td>
		<tr>
		<%
	} }
		%>		
	</table>
			<%
				if (startPage > 1) {
			%>
			이전
			<%
				}
			for (int i = startPage; i <= endPage; i++) {
			%>
			<a href="indimoa/membermanagement?pagenum=<%=i%>"> <%=i%>
			</a>
			<%
				if (i != endPage) {
			%>
			,
			<%
				}
			}
			if (endPage < pageCount) {
			%>
			다음
			
			<%
			}
			%>

	
	<br>
	<!--  <a href="bembermanagementboardwrite">회원생성 </a>-->
	<!--  <a href="bembermanagementboard">회원수정 </a>-->
	<input type="text" id="grantPoint">포인트지급
	<button type="submit">회원강제탈퇴 </button>
	</form>
		</div>
	</div>
	</body>
</html>


