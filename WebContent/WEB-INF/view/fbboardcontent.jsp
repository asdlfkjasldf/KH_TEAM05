<%@page import="com.indimoa.board.model.vo.FbBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% FbBoard vo = (FbBoard)request.getAttribute("boardvo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
</head>
<body>
	<table>
	<tr>
		<td>글번호</td>
		<td><%=vo.getFbNo()%></td>
		<td><%=vo.getFbDatetime()%></td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="2"><%=vo.getFbTitle()%></td>
	</tr>
		<tr>
		<td colspan="3"><%=vo.getFbContent()%></td>
	</tr>
	</table>
	
	
	<table>
	<tr><td> <input type="text"  name="reply" placeholder="댓글을 작성해주세요." id = "inputTxt" autofocus></td></tr>
	<tr><td><input type="button" value="작성" id="bntInsert"></td></tr>
	</table>
	
	<script>
		$("#bntInsert").click(ajaxInsert);
		
		function ajaxInsert(){
			var txt = $("#inputTxt").val().trim();
			if(txt == ""){
				alert("댓글이 입력하고 등록해주세요.");
				$("#inputTxt").focus();
				return;
			}
			console.log("fbNo: "+ "${boardvo.fbNo}");
			console.log("txt: "+ txt);
			$.ajax({
				type: "post",
				url: "fbboardwrite.ajax",
				data: { 
					fbRContent: txt,
					//fbRNo: "<%=vo.getFbNo()%>"
					fbRNo: "${boardvo.fbNo}"
				},
				// 기다림.. 응답이 올떄까지
				success : function(data){
					console.log(data);
					if(data =="OK"){
						
					}
					// TODO
				},
				error: function(){
				// TODO: 교재 copy	
				}				
			});
			
			
		}
	</script>
</body>
</html>