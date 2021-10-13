<%@page import="com.indimoa.board.model.vo.GbBoardR"%>
<%@page import="com.indimoa.board.model.vo.GbBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%GbBoard vo = (GbBoard) request.getAttribute("boardvo");%>
<%GbBoardR vor = (GbBoardR) request.getAttribute("boardvor");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발자게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td><%=vo.getGbNo()%></td>
			<td><%=vo.getGbDatetime()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="2"><%=vo.getGbTitle()%></td>
		</tr>
		<tr>
			<td colspan="3"><%=vo.getGbContent()%></td>
		</tr>
	</table>

	<table>
		<tr><td><input type="text" name="reply" placeholder="댓글을 작성해주세요." id="inputTxt" autofocus></td></tr>
		<tr><td><input type="button" value="작성" id="bntInsert"></td></tr>
	</table>

	<table>
		<c:if test="${vorlist != null}">
			<c:forEach items="${vorlist}" var="vor">
				<tr>
					<td>${vor.gbRId}</td>
					<td>${vor.gbRContent }</td>
					<td>${vor.gbRDatetime }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

	<script>
		$("#bntInsert").click(ajaxInsert);
		
		function ajaxInsert(){
			var txt = $("#inputTxt").val().trim();
			if(txt == ""){
				alert("댓글을 입력하고 등록해주세요.");
				$("#inputTxt").focus();
				return;
			}
			console.log("gbNo: "+ "${boardvo.gbNo}");
			console.log("txt: "+ txt);
			$.ajax({
				type: "post",
				url: "gbboardwrite.ajax",
				data: { 
					gbRContent: txt,
					//gbRNo: "<%=vo.getGbNo()%>"
					gbRNo : "${boardvo.gbNo}"
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
	</script>
</body>
</html>