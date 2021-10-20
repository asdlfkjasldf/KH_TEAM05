 <link rel="stylesheet" type="text/css" href="./css/myStyle.css">
 <%@page import="com.indimoa.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	//이곳은 자바 문법에 따른다.
        	ArrayList<Member> volist = (ArrayList<Member>)request.getAttribute("boardvolist");
            int startPage = (int)request.getAttribute("startPage");
            int endPage = (int)request.getAttribute("endPage");
            int pageCount = (int)request.getAttribute("pageCount");
            
            Member vo2 = new Member();
            vo2.setSearchCondition(request.getParameter("sc"));
            vo2.setSearchKeyword(request.getParameter("sk"));
            

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지  회원관리</title>
<base href="/">
<style type="text/css">


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
	
		<header>
	<div id="logo"><a href="./"><img src="./image/ex1.png"></a></div>
	<nav id="highmenu" class="topmenu">
	    <ul>
        <li><a href="./GameList">상점</a></li>
        <li><button class="accordion">커뮤니티</button>
        	<div class="panel">
        	<ul>
        	<li><a href="./fbboardlist">자유게시판</a></li>
        	<li><a href="./gbboardlist">개발사게시판</a></li>
        	<li><a href="./tboardlist">팁게시판</a></li>
        	</ul>
        	</div>
        </li>
        
        <li><a href="./notice">뉴스</a></li>
        <li><a href="#">카테고리</a></li>
        <li><a href="#">지원</a></li>
        <li id="textboxli">
        	<!-- todo 링크는 jstl을 이용해 txt박스의 값을 적어구문작성 -->
        	<form action="./GameList?" method="get">
        	<input type="text" id="textSearchGame" name="q">
        	<button type="submit" id="btnSearchGame"></button>
        	</form>
        	
        </li>
    	</ul>
	</nav>
		<nav id="topmenu_tnb">
		<ul>
	        <li><a href="./enrollmember">회원가입</a></li>
	        <li><a href="./memberlogin">로그인</a></li>
	        <li><a href="#">마이페이지</a></li>
	        <li><a href="./cartlist">장바구니</a></li>
		</ul>     
		</nav>
	</header>
	
	<div id="promotion">
	
	
	
	</div>
	
	
	
    <div class="section">
	<div class="Asside-left">
	
	<!-- 왼쪽의 서브 메뉴 -->
	
	</div>
    <div class="Article">
    <!-- 페이지의 메인 아티클 -->
    
	<h1>회원</h1>
	
	<form method=get action="<c:url value='/adminmembers'/>" >					
	<select id="sc" name="sc">
        <option value="nk">이름</option>
        <option value="ik">ID</option>
        <option value="nik">닉네임</option>
	</select>
	
	<input type="text" name="sk" id="sk">
	<button type="submit" id="btnMemberView">조회</button>
	</form>  
	<table border="1" collapse="collapse">	
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

	
		<form method="get" action="<c:url value='/admindeletemembers'/>">
		<tr>
		
		<td><input type="checkbox" id="checkName" name="checkName" value="<%=vo.getMm_id() %>">
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
			<a href="<c:url value='/adminmembers?pagenum='/><%=i%>"> <%=i%>
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
	
	
	
	<input type="text" id="grantPoint" name="grantPoint">
	<button type="button" id="btnGrantPoint" onclick="" >포인트지급</button>
	
	
	<button type="submit" id="btnDeleteMember">회원강제탈퇴 </button>
	</form>
	
	
	<div class="box"></div>
		
	<script>
		$(document).ready(function(){
			$("#btnGrantPoint").on("click",function() {
				$.ajax({
					type : "get",
					url : "<c:url value='/adminupdatemembers'/>",
					data : {
						targetid: $("input:checkbox[name='checkName']:checked").val(),
						pointvalue :  $("#grantPoint").val()
					},
					
				success : function(data){
					console.log("포인트확인");
					$('.box').html(data);
				}
					
				});
			})
		});
	</script>
		
    </div>
    </div>

	<div class="footer">
    INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
	</div>
	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
	console.log("메소드 진입확인");
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  });
}
</script>

<div hidden="">돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></div>

	
	
	</body>
</html>


