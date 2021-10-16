<%@page import="com.indimoa.member.model.vo.Member"%>
<%@page import="com.indimoa.board.model.vo.FbBoard"%>
<%@page import="com.indimoa.board.model.vo.FbBoardR"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	FbBoard vo = (FbBoard) request.getAttribute("boardvo");
%>
<%
	FbBoardR vor = (FbBoardR) request.getAttribute("boardvor");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td><%=vo.getFbNo()%></td>
			<td><%=vo.getFbDatetime()%></td>
			<td>
				<c:if test="${sessionScope.member.mm_id != null && sessionScope.member.mm_id == boardvo.mmId }">
				<input type="button" value="삭제" id="btnDelete">
				</c:if>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="2"><%=vo.getFbTitle()%></td>
		</tr>
		<tr>
			<td colspan="3"><%=vo.getFbContent()%></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>신고수 : <%=vo.getFbReport()%></td>
		</tr>
		<tr>		
			<td>
				<c:if test="${sessionScope.member.mm_id != null && sessionScope.member.mm_id == boardvo.mmId }">
				<input type="button" value="수정" id="btnUpdate">
				</c:if>
			</td>
			<td>
				<input type="button" value="신고" id="btnReport">
			</td>
		</tr>
	</table>


	<table>
		<tr>
			<td><input type="text" name="reply" placeholder="댓글을 작성해주세요."
				id="inputTxt" autofocus></td>
		</tr>
		<tr>
			<td><input type="button" value="작성" id="bntInsert"></td>
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

	<script>
		$("#bntInsert").click(ajaxInsert);
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
	</script>
</body>
</html>