<%@page import="com.indimoa.board.model.vo.TipBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	TipBoard vo = (TipBoard) request.getAttribute("boardvo");
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
<form method="post" action="./tboardupdate.do">  
    <fieldset>
        <input type="hidden" name="bno" value="<%=vo.getTipNo()%>" readonly>
      제목 :  <input type="text"  autofocus name="title" value="<%=vo.getTipTitle()%>" required><br>
      내용 :  <input type="text"  name="content" value="<%=vo.getTipContent()%>"><br>
      첨부파일 : <input type="file" name="uploadFile"/><br>
      
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </fieldset>
</form>
</body>
</html>