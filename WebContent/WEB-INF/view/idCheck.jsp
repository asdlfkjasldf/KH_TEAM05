<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>중복 체크</title>



</head>
<body>
	


	<div class="Article">
	<h3>아이디 중복 확인</h3>
	<form method="get" action="${pageContext.request.contextPath }/idCheck" name="frm">
		<table>
			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" name="mm_id" id="id" value="${mm_id }"></td>
				<td><input type="submit" value="중복 체크"></td>
			</tr>
			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${result == 1 }">${mm_id }는 사용중인 아이디입니다.</c:when>
						<c:when test="${result == -1 }">${mm_id }가 사용가능한 아이디입니다. &nbsp;<input type="button" value="사용" onclick="idOk()"></c:when>
						<c:otherwise></c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form>
	</div>
	
	<script>
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
		console.log("메소드 진입확인");
	  acc[i].addEventListener("click", function() {
	    this.classList.toggle("active");
	    var panel = this.nextElementSibling;
	    if (panel.style.maxHeight) {
	      panel.style.maxHeight = null;
	    } else {
	      panel.style.maxHeight = panel.scrollHeight + "px";
	    } 
	  });
	}
	
	
	
	
	function idOk(){
		opener.joinform.mm_id.value = document.frm.mm_id.value;
		opener.joinform.reid.value = document.frm.mm_id.value;
		
		self.close();
	}
	</script>
	
	
	
</body>
</html>