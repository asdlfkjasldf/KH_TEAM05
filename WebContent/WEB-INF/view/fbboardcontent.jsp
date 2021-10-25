<link rel="stylesheet" type="text/css" href="./css/boardStyle.css">
<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
<%@page import="com.indimoa.board.model.vo.FbBoardImg"%>
<%@page import="com.indimoa.member.model.vo.Member"%>
<%@page import="com.indimoa.board.model.vo.FbBoard"%>
<%@page import="com.indimoa.board.model.vo.FbBoardR"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	FbBoard vo = (FbBoard) request.getAttribute("boardvo");
FbBoardR vor = (FbBoardR) request.getAttribute("boardvor");
FbBoardImg img = (FbBoardImg) request.getAttribute("uploadfile");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
		<nav id="highmenu" class="topmenu">
			<div id="logo">
				<a href="./"><img src="./image/ex1.png"></a>
			</div>
			<ul>
				<li><a href="./GameList">상점</a></li>
				<li><button class="accordion">커뮤니티</button>
					<div class="panel">
						<ul>
							<li><a href="./fbboardlist">자유게시판</a></li>
							<li><a href="./gbboardlist">개발사게시판</a></li>
							<li><a href="./tboardlist">팁게시판</a></li>
						</ul>
					</div></li>

				<li><a href="./notice">뉴스</a></li>
				<li><a href="#">카테고리</a></li>
				<li><a href="./faq">지원</a></li>
				<li id="textboxli">
					<!-- todo 링크는 jstl을 이용해 txt박스의 값을 적어구문작성 -->
					<form action="./search?" method="get">
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
				<li><a href="./myinfo">마이페이지</a></li>
				<li><a href="./cartlist">장바구니</a></li>
			</ul>
		</nav>
	</header>

	<div id="promotion"></div>



	<div class="section">
		<div class="aside-left">

			<ul>
				<li><a href="./fbboardlist">자유게시판</a></li>
				<li><a href="./gbboardlist">개발사게시판</a></li>
				<li><a href="./tboardlist">팁게시판</a></li>
			</ul>
		</div>
		<div class="article">
			<!-- 페이지의 메인 아티클 -->
			<table>
				<tr>
					<td><%=vo.getFbNo()%></td>
					<td><%=vo.getFbDatetime()%></td>
					<td><c:if
							test="${sessionScope.member.mm_id != null && sessionScope.member.mm_id == boardvo.mmId }">
							<input type="button" value="삭제" id="btnDelete">
						</c:if></td>
				</tr>
				<tr>
					<td colspan="2"><%=vo.getFbTitle()%></td>
				</tr>
				<tr>
					<td colspan="3"><textarea cols="50" rows="20" readonly><%=vo.getFbContent()%></textarea></td>
				</tr>
				<%
					if (img != null) {
				%>
				<%
					if (img.getImgPath() != null) {
				%>
				<tr>
					<td colspan="3"><img src="<%=img.getImgPath()%>"></td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
				<tr>
					<td>신고수 : <%=vo.getFbReport()%></td>
				</tr>
				<tr>
					<td><input type="button" value="신고" id="btnReport"></td>
					<td><c:if
							test="${sessionScope.member.mm_id != null && sessionScope.member.mm_id == boardvo.mmId }">
							<input type="button" value="수정" id="btnUpdate">
						</c:if></td>
				</tr>
			</table>


			<table>
				<tr>
					<td><input type="text" name="reply"
						placeholder="댓글을 작성해주세요." id="inputTxt" autofocus></td>
				</tr>
				<tr>
					<td><input type="button" value="작성" id="btnInsert"></td>
				</tr>
			</table>

			<table>
				<c:if test="${vorlist != null}">
					<c:forEach items="${vorlist}" var="vor">
						<tr>
							<td>${vor.fbRId}</td>
							<td>${vor.fbRContent }</td>
							<td>${vor.fbRDatetime }</td>
						</tr>
					</c:forEach>
				</c:if>

			</table>



		</div>
	</div>

	<footer>
		INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 :
		홍길동 ｜ 개인정보관리책임자 : 홍길동<br> <br> Copyright © 2020-2021 INDIMOA
		GAME SHOPPING MALL
	</footer>
	<script>
		$("#btnInsert").click(ajaxInsert);
		$("#btnReport").click(ajaxReport);
		$("#btnDelete").click(ajaxDelete);
		$("#btnUpdate").click(goUpdate);

		function ajaxInsert() {
			var txt = $("#inputTxt").val().trim();
			if (txt == "") {
				alert("댓글을 입력하고 등록해주세요.");
				$("#inputTxt").focus();
				return;
			}
			console.log("fbNo: " + "${boardvo.fbNo}");
			console.log("txt: " + txt);
			$.ajax({
				type : "post",
				url : "fbboardwrite.ajax",
				data : {
					fbRContent : txt,
					fbRNo : "${boardvo.fbNo}"
				},
				success : function(data) {
					console.log(data);
					if (data == "OK") {
						location.reload();
						alert('댓글이 입력되었습니다.');
					}
				},
				error : function() {
					alert('오류 발생. 오류 코드: ' + error.code);
				}
			});
		}
		function ajaxReport() {
			console.log("신고 완료 : " + "${boardvo.fbNo}");
			$.ajax({
				type : "post",
				url : "fbboardreport.ajax",
				data : {
					fbNo : "${boardvo.fbNo}"
				},
				success : function(data) {
					console.log(data);
					if (data == "OK") {
						location.reload();
						alert('게시글이 신고되었습니다.');
					}
				},
				error : function() {
					alert('오류 발생. 오류 코드: ' + error.code);
				}
			});
		}
		function ajaxDelete() {
			console.log("삭제 중..: " + "${boardvo.fbNo}");
			$.ajax({
				type : "post",
				url : "fbboarddelete.ajax",
				data : {
					fbNo : "${boardvo.fbNo}"
				},
				success : function(data) {
					console.log(data);
					if (data == "OK") {
						console.log("삭제 완료..: " + "${boardvo.fbNo}");
						alert('게시글이 삭제되었습니다.');
						location.href = "fbboardlist";
					}
				},
				error : function() {
					alert('오류 발생. 오류 코드: ' + error.code);
				}
			});
		}
		function goUpdate() {
			location.href = "fbboardupdate?no=${boardvo.fbNo}";
		}

		var acc = document.getElementsByClassName("accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
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

	<div hidden="">
		돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a>
		from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a>
	</div>

</body>
</html>