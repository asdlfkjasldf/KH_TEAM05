<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Pagee</title>
</head>
<body>
	500Error 발생!!<br> 
	입력 사항을 확인해주세요!! <hr> 
	ERROR Info :: <%= exception.getClass().getName() %> 
	<a href="../index.jsp">뒤로가기</a>
</body>
</html>