<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>아이디 중복 확인</h3>
	<form method="get" action="${pageContext.request.contextPath }/nicknameCheck.do" name="frm">
		<table>
			<tr>
				<td><label for="nickname">닉네임</label></td>
				<td><input type="text" name="mm_nickname" id="nickname" value="${mm_nickname }"></td>
				<td><input type="submit" value="중복 체크"></td>
			</tr>
			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${result == 1 }">${mm_nickname }는 사용중인 닉네임입니다.</c:when>
						<c:when test="${result == -1 }">${mm_nickname }는 사용가능한 닉네임입니다. &nbsp;<input type="button" value="사용" onclick="nicknameOk()"></c:when>
						<c:otherwise></c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form>
	
	<script>
	function nicknameOk(){
		opener.joinform.mm_nickname.value = document.frm.mm_nickname.value;
		opener.joinform.renickname.value = document.frm.mm_nickname.value;
		
		self.close();
	}
	</script>
</body>
</html>