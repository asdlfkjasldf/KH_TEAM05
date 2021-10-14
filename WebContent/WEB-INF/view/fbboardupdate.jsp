<%@page import="com.indimoa.board.model.vo.FbBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	FbBoard vo = (FbBoard) request.getAttribute("boardvo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>게시판</h1>
<form method="post" action="./fbboardupdate.do">  
    <fieldset>
        <input type="hidden" name="bno" value="<%=vo.getFbNo()%>" readonly>
      제목 :  <input type="text"  autofocus name="title" value="<%=vo.getFbTitle()%>" required><br>
      내용 :  <input type="text"  name="content" value="<%=vo.getFbContent()%>"><br>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </fieldset>
</form>
</body>
</html>