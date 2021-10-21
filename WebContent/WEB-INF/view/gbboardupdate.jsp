<%@page import="com.indimoa.board.model.vo.GbBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	GbBoard vo = (GbBoard) request.getAttribute("boardvo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발자 게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>게시판</h1>
<form method="post" action="./gbboardupdate.do">  
    <fieldset>
        <input type="hidden" name="bno" value="<%=vo.getGbNo()%>" readonly>
      제목 :  <input type="text"  autofocus name="title" value="<%=vo.getGbTitle()%>" required><br>
      내용 :  <input type="text"  name="content" value="<%=vo.getGbContent()%>"><br>
      첨부파일 : <input type="file" name="uploadFile"/><br>
      			<select name="heading">
				<option value="wanted">구인</option>
				<option value="seek">구직</option>
				<option value="talk">잡담</option>
			</select><br>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </fieldset>
</form>
</body>
</html>