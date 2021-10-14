<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>Enroll Member</title>
    <style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap');

* {
	font-family: "Noto Sans KR", sans-serif;
}
body {
        margin: 0;
}



#header {
        width: 100%; 
        margin: 0 auto; 
        height: 220px;
        position: relative;
}
a:link{
  text-decoration: none!important;
  color: green;
}
li {
	list-style-type: none;
}
#logo{
	width: 100px;
	position: absolute;
}
#highmenu ul li {
	float: left;
	margin: 15px;
	text-align: center;
	position: relative;
	padding-bottom: 0px;
}
#topmenu ul li{
	
	float: left;
	margin: 15px;
	padding: 10px;
	position: relative;
}
    

    #footer {
            clear: both;
            width: 100%;
            height: 190px;
            bottom: 0;
            margin: 0 auto;
            margin-bottom: 10px;
            padding: 10px;
            box-sizing: border-box;
            text-align: center;
            
        }

    
    </style>
</head>
<body>
    <div id="header">
        <div id="logo">
        로고 추가할 곳
        <img src=".jpg" width="200px" height="50px">
        </div>     
    
    	<div id="highmenu">
	 	<span>
	    	<ul>
        	<li><a href="#">상점</a></li>
        	<li><a href="#">커뮤니티</a></li>
        	<li><a href="#">뉴스</a></li>
        	<li><a href="#">카테고리</a></li>
        	<li><a href="#">지원</a></li>
        	<li><input type="text" id="btnSearchGame"></li>
        	<li><button type="button" onclick="searchGame()">돋보기그림추가할것</button></li>
    		</ul>
		</span>
		</div>
		<span id="topmenu">
	<ul>
        <li><a href="#">회원가입</a></li>
        <li><a href="#">로그인</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">장바구니</a></li>
	</ul>     
	</span>
	</div>

	<h2 align="center">회원 가입 하기</h2>
	<hr>
	<section id="myinfo">
		<form action="../../minsert.lo" id="enrollForm" method="post">
			<table align="center">
				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="mm_id" id="id"></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="pwd" name="mm_pwd"></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" name="mm_name"></td>
				</tr>
				<tr>
					<td>이메일 :</td>
					<td><input type="email" name="mm_email"></td>
				</tr>
                <tr>
					<td>전화번호 :</td>
					<td><input type="phn" name="mm_phn"></td>
				</tr>
                <tr>
					<td>OS :</td>
					<td>
                        <input id="os" type="radio" value="window" name="mm_com" class="input2">WINDOW<br>
                        <input id="os" type="radio" value="mac" name="mm_com" class="input2">MAC<br>
                    </td>
				</tr>
                <tr>
					<td>구분 :</td>
					<td>
                        <input id="os" type="radio" value="개인" name="separate" class="input2">개인<br>
                        <input id="os" type="radio" value="개발사" name="separate" class="input2">개발사<br>
                    </td>
				</tr>
                <tr>
					<td>프로필 :</td>
					<td>
                        <input type="file" id="image" name="mm_profile" class="input1" accept="image/*" onchange="setThumbnail(event);">
                        <img id="profile_img" src="" width="200px">
                    </td>
				</tr>
                <tr>
					<td>닉네임 :</td>
					<td><input type="nickname" name="mm_nickname" placeholder="개발사는 회사 이름을 작성"></td>
				</tr>
			</table>
			<p align="center">
				<button type="submit" >회원 가입하기</button>
				&nbsp; &nbsp;
				<button type="reset">작성 양식 초기화</button>
			</p>
		</form>
	</section>
	<br>
	<br>
	<p align="center">
		<button type="button" onclick="location.href='../../index.jsp';">메인으로
			가기</button>
	</p>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$("#enrollForm").submit(
				function(event) {
					var regex = /^[A-Za-z0-9]{5,14}$/; // 정규식을 통한 문자열 패턴 분석 
					var chk = 0;
					if ($('#userid').val().length < 5) {
						alert("아이디는 5자 이상이어야 합니다.");
					} else if (!regex.test($('#userid').val())) {
						alert("아이디는 영문자와 숫자만 가능합니다.");
					} else {
						$.ajax({ // ajax를 통한 아이디 중복 값 체크 
							url : "WEB-INF/view/dupidchk.jsp",
							type : "post",
							async : false,
							data : {
								id : $('#userid').val()
							},
							dataType : "text",
							success : function(value) {
								if (value == "fail") {
									alert("이미 존재하는 아이디입니다.\n 다른 아이디로 정하십시오.");
								} else {
									alert("정상 가입이 되었습니다.");
									chk++;
								}
							},
							error : function(request, status, error) {
								alert("code:" + request.status + "\n"
										+ "message:" + request.responseText
										+ "\n" + "error:" + error);
							}
						});
					}
					if (chk == 0)
						event.preventDefault();
				});
	</script>

<div id="footer">
    <h1>footer</h1>
</div>
</body>
</html>