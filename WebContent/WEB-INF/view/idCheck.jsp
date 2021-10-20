<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>중복 체크</title>

</head>
<body>
	<div id="header">
        <div id="logo">
        로고 추가할 곳
        </div>     
    
    	<div id="highmenu">
	 	<span>
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
        	<li><input type="text" id="btnSearchGame"></li>
        	<li><button type="button" onclick="searchGame()">돋보기그림추가할것</button></li>
    		</ul>
		</span>
		</div>
		<span id="topmenu">
	<ul>
        <li><a href="./enrollmember">회원가입</a></li>
        <li><a href="./memberlogin">로그인</a></li>
        <li><a href="./myInfo">마이페이지</a></li>
        <li><a href="./cartlist">장바구니</a></li>
	</ul>     
	</span>
	</div>


	<div id="section">
	<h3>아이디 중복 확인</h3>
	<form method="get" action="${pageContext.request.contextPath }/idCheck.do" name="frm">
		<table>
			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" name="mm_id" id="id" value="${mm_id }"></td>
				<td><input type="submit" value="중복 체크"></td>
			</tr>
			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${result == 1 }">${mm_id }는 사용중인 아이디입니다.</c:when>
						<c:when test="${result == -1 }">${mm_id }가 사용가능한 아이디입니다. &nbsp;<input type="button" value="사용" onclick="idOk()"></c:when>
						<c:otherwise></c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form>
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
	
	
	
	
	function idOk(){
		opener.joinform.mm_id.value = document.frm.mm_id.value;
		opener.joinform.reid.value = document.frm.mm_id.value;
		
		self.close();
	}
	</script>
	
	
	
</body>
</html>