<%@page import="com.indimoa.board.model.vo.TipBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	ArrayList<TipBoard> volist = (ArrayList<TipBoard>)request.getAttribute("volist");
 	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount"); 
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팁공유 게시판</title>
</head>
<body>
	<h1>게 시 판</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
		</tr>
<%--
		if(volist != null){
		for(TipBoard vo : volist){
--%>
<c:if test="${volist != null}">
	<c:forEach items="${volist }" var="vo" >
		<tr>
			<td><a href="tboardcontent?no=${vo.tipNo }">${vo.tipNo } </a></td>
			<td>
			<%--
			for(int i = 0;i<vo.getBreLevel();i++){
			--%>
			<c:forEach begin="1" end="${vo.breLevel }" step="1">
				Re :
			</c:forEach>
			<%--
			}
			--%>
			${vo.tipTitle }
			</td>
			<td>[${vo.tipReply }]</td>
			<td>${vo.gdGamedevid }</td>
			<td>${vo.tipDatetime }</td>
		</tr>
	</c:forEach>
</c:if>	
<%--
		}}
--%>
	</table>
	<c:if test="${startPage >1 }"> 이전 </c:if>
		<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<a href="tboardlist?pagenum=${i}">${i}</a>
		</c:forEach>
	<c:if test="${endPage < pageCount }"> 다음 </c:if>
<br>
<a href="tboardwrite">글쓰기</a>

</body>
</html>