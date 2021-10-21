<%@page import="com.indimoa.board.model.vo.TipBoardImg"%>
<%@page import="com.indimoa.member.model.vo.Member"%>
<%@page import="com.indimoa.board.model.vo.TipBoard"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	TipBoard vo = (TipBoard) request.getAttribute("boardvo");
	TipBoardImg img = (TipBoardImg) request.getAttribute("uploadfile");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팁게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td><%=vo.getTipNo()%></td>
			<td><%=vo.getTipDatetime()%></td>
			<td><c:if
					test="${sessionScope.member.mm_id != null && sessionScope.member.mm_id == boardvo.gdGamedevid }">
					<input type="button" value="삭제" id="btnDelete">
				</c:if></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="2"><%=vo.getTipTitle()%></td>
		</tr>
		<tr>
			<td colspan="3"><%=vo.getTipContent()%></td>
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
			<td>신고수 : <%=vo.getTipReport()%></td>
		</tr>
		<tr>
			<td><c:if
					test="${sessionScope.member.mm_id != null && sessionScope.member.mm_id == boardvo.gdGamedevid }">
					<input type="button" value="수정" id="btnUpdate">
				</c:if></td>
			<td><input type="button" value="신고" id="btnReport"></td>
		</tr>
	</table>

	<script>
		$("#btnReport").click(ajaxReport);
		$("#btnDelete").click(ajaxDelete);
		$("#btnUpdate").click(goUpdate);

		function ajaxReport() {
			console.log("신고 완료 : " + "${boardvo.tipNo}");
			$.ajax({
				type : "post",
				url : "tboardreport.ajax",
				data : {
					tipNo : "${boardvo.tipNo}"
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
			console.log("삭제 중..: " + "${boardvo.tipNo}");
			$.ajax({
				type : "post",
				url : "tboarddelete.ajax",
				data : {
					tipNo : "${boardvo.tipNo}"
				},
				success : function(data) {
					console.log(data);
					if (data == "OK") {
						console.log("삭제 완료..: " + "${boardvo.tipNo}");
						alert('게시글이 삭제되었습니다.');
						location.href = "tboardlist";
					}
				},
				error : function() {
					alert('오류 발생. 오류 코드: ' + error.code);
				}
			});
		}
		function goUpdate() {
			location.href = "tboardupdate?no=${boardvo.tipNo}";
		}
	</script>
</body>
</html>