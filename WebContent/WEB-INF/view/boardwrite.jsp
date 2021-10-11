<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String bno = request.getParameter("bno"); 
	if(bno==null || bno.equals("")){
		bno="";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite</title>
</head>
<body>
    <h1>게시판</h1>
<form method="get" action="./tboardWrite.do">
    <fieldset>
        <input type="hidden" name="bno" value="<%=bno%>" readonly>
      제목 :  <input type="text"  autofocus name="title" placeholder="제목" required><br>
      내용 :  <input type="text"  name="content"><br>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </fieldset>
</form>
</body>
</html>