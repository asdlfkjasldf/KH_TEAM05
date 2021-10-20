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
        </div>     
    
    	<div id="highmenu">
	 	<span>
	    	<ul>
        	<li><a href="./GameList">상점</a></li>
        	<li><button class="accordion">커뮤니티</button>
        	<div class="panel">
        	<ul>
        	<li><a href="./fbboardlist">자유게시판</a></li>
        	<li><a href="./gbboardlist">개발사게시판</a></li>
        	<li><a href="./tboardlist">팁게시판</a></li>
        	</ul>
        	</div>
        	</li>
        	
        	<li><a href="./notice">뉴스</a></li>
        	<li><a href="#">카테고리</a></li>
        	<li><a href="#">지원</a></li>
        	<li><input type="text" id="btnSearchGame"></li>
        	<li><button type="button" onclick="searchGame()">돋보기그림추가할것</button></li>
    		</ul>
		</span>
		</div>
		<span id="topmenu">
	<ul>
        <li><a href="./enrollmember">회원가입</a></li>
        <li><a href="./memberlogin">로그인</a></li>
        <li><a href="./myInfo">마이페이지</a></li>
        <li><a href="./cartlist">장바구니</a></li>
	</ul>     
	</span>
	</div>
	
	<div id="section">
	<h2 align="center">회원 가입 하기</h2>
	<hr>
		<form action="/enrollmember" id="enrollForm" method="post" enctype="multipart/form-data">
			<table align="center">
				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="mm_id" id="id"><input type="hidden" name="reid" class="input"><input type="button" value="중복확인" onclick="return idCheck()"></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password" id="pwd" name="mm_pwd" class="input"></td>
				</tr>
				<tr>
					<td>비밀번호 확인 :</td>
					<td><input type="password" id="repwd" name="mm_pwd" class="input"></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" name="mm_name" id="name" class="input"></td>
				</tr>
				<tr>
					<td>이메일 :</td>
					<td><input type="email" name="mm_email" id="email" class="input"></td>
				</tr>
                <tr>
					<td>전화번호 :</td>
					<td><input type="text" name="mm_phn1" id="phn1" class="input" required></td> -
					<td><input type="text" name="mm_phn2" id="phn2" class="input" required></td> -
					<td><input type="text" name="mm_phn3" id="phn3" class="input" required></td> -
				</tr>
                <tr>
					<td>OS :</td>
					<td>
                        <input id="os" type="radio" value="window" name="mm_com" class="input">WINDOW<br>
                        <input id="os" type="radio" value="mac" name="mm_com" class="input">MAC<br>
                    </td>
				</tr>
                <tr>
					<td>구분 :</td>
					<td>
                        <input id="os" type="radio" value="개인" name="separate" class="input">개인<br>
                        <input id="os" type="radio" value="개발사" name="separate" class="input">개발사<br>
                    </td>
				</tr>
                <tr>
					<td>프로필 :</td>
					<td>
                        <input type="file" id="profile" name="mm_profile" class="input" accept="image/*" onchange="setThumbnail(event);">
                        <img id="profile_img" src="" width="200px">
                    </td>
				</tr>
                <tr>
					<td>닉네임 :</td>
					<td><input type="text" id="nickname" name="mm_nickname" placeholder="개발사는 회사 이름을 작성" class="input"><input type="hidden" name="renickname"></td>
				</tr>
			</table>
			<p align="center">
				<button type="submit" id="btn1"  >회원 가입하기</button>
				&nbsp; &nbsp;
				<button type="reset">작성 양식 초기화</button>
			</p>
		</form>
	<br>
	<br>
	<p align="center">
		<input type="button"><a href="index.jsp">메인으로</a>
			가기</button>
	</p>
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
	
	
		/**
회원정보 입력 필수 입력 사항 확인
이름, 아이디, 암호
아이디 4글자 이상
re id의 값이 존재하는지 확인하여 중복체크여부를 검사
 */

 window.addEventListener("load", pageLoadedHandler);
 function pageLoadedHandler(){
     //submit 버튼이 눌려지면 이벤트 등록
     // document.getElementById("submit").addEventListener("click", btnSubmit);
     document.getElementById("btn1").addEventListener("click", btnSubmit);
 }

 // common function
 function checkNullValue( n1, index, arr) {
     console.log("1:" +  n1 + ", 2:"+index + ", 3:"+arr );
     if(n1.value.length == 0){
         alert("입력해주세요.");
         n1.focus();
         return false;
     } else 
         return true;
 }


 // submit 클릭 관련 함수는 onload 밖에 정의하는 경우가 많음. why? 인라인 형태로 호출될 가능성이 높으므로..
 function btnSubmit(){
     console.log("btnSubmit 진입");

     var pw1 = document.getElementById("pwd");
     var pw2 = document.getElementById("repwd");

     var pw1value = pw1.value;
     var pw2value = pw2.value;

     // 입력되지 않은 칸이 있는지 확인
     // 방법 3
     var inputElements = document.getElementsByClassName("input");
     // element 형태인 경우 foreach 메소드 동작되지 않음. inputElements.forEach(checkNullValue);
     // 해결 기존 for 사용
     for(var i=0; i<inputElements.length; i++){
         var cnv = checkNullValue(inputElements[i]);
         if(cnv == false){ return false; }
     }
     
     
     var id = document.getElementById("id").value;
     var regExpId = /^[a-zA-Z0-9]{5,15}$/;
     if( !regExpId.test(id) ){
         alert("영어 대소문자 + 숫자, 5자이상 15자 이하 조건에 맞게 입력해주세요");
         return false;
     }
     
     
     // 방법 2
     // var cnv = checkNullValue(document.getElementById("id"));
     // if(cnv == false){ return false; }
     // var cnv = checkNullValue(document.getElementById("pwd"));
     // if(cnv == false){ return false; }
     // var cnv = checkNullValue(document.getElementById("repwd"));
     // if(cnv == false){ return false; }
     // var cnv = checkNullValue(document.getElementById("name"));
     // if(cnv == false){ return false; }

     // 방법 1
     // if(document.getElementById("id").value.length == 0) {
     //     alert("입력해주세요.");
     //     document.getElementById("id").focus();
     //     return false;
     // }
     // if(document.getElementById("pwd").value.length == 0) {
     //     alert("입력해주세요.");
     //     document.getElementById("pwd").focus();
     //     return false;
     // }
     // if(document.getElementById("repwd").value.length == 0) {
     //     alert("입력해주세요.");
     //     document.getElementById("repwd").focus();
     //     return false;
     // }
     // if(document.getElementById("name").value.length == 0) {
     //     alert("입력해주세요.");
     //     document.getElementById("name").focus();
     //     return false;
     // }

     // 비밀번호 6글자이상, 12글자 이하  ==> 정상
     // 경고 popup “조건에 맞게 입력해주세요”  // action 으로 이동되지 않음.
     // if(pw1value.length < 6 || pw1value.length > 12) {
     //     alert("6~12자 조건에 맞게 입력해주세요");
     //     return false;
     // } 
     // 비밀번호와 비밀번호 확인란이 
     // 동일하지 않으면 alert창으로 “동일하게 입력해주세요”  // action 으로 이동되지 않음.
     if(pw1value != pw2value) {
         alert("동일하게 입력해주세요");
         return false;
     } 
     // 영어 대소문자 + 숫자 + 특수문자(_#) 유효, 6글자이상, 12글자 이하
     // 정규표현식 RegExp 
     // /패턴/ 
     // ^ 시작문자, $ 끝부분
     // []  문자 1개, 그 안에 유효한 문자, 예) [0123456789] [0-9]
     // {3} 자릿수
     // var regExp = /^[A-Za-z0-9_#]{6,12}$/;
     // 첫글자는 영어 대문자이고 영문자+ 숫자 + 특수문자(_!) 유효, 8글자이상, 16글자 이하
     var regExp = /^[A-Z][A-Za-z0-9_!]{7,15}$/;
     if( !regExp.test(pw1value) ){
         alert("영어 대소문자 + 숫자 + 특수문자(_#), 7자이상 15자 이하 조건에 맞게 입력해주세요");
         return false;
     }

     // 이름 입력은 한글입력만 가능 2글자 이상 10글자 이하
     var name = document.getElementById("name").value;
     var regExpName = /^[가-힣]{1,15}$/;
     if( !regExpName.test(name) ){
         alert("한글 1글자이상, 15글자 이하 조건에 맞게 입력해주세요");
         return false;
     }

     // 휴대폰번호 입력은 
     // 첫번째 입력란에 010, 011, 016, 017, 018, 019 유효, 
     // 두번째 입력란은 숫자 3-4글자 입력
     // 세번째 입력란은 숫자 4글자 입력
     var phn1 = document.getElementById("phn1").value;
     var phn2 = document.getElementById("phn2").value;
     var phn3 = document.getElementById("phn3").value;
     var regExpTel1= /^01[016789]$/;
     if( !regExpTel1.test(tel1) ){
         alert("010, 011, 016, 017, 018, 019 유효 조건에 맞게 입력해주세요");
         return false;
     }
     var regExpTel2= /^[0-9]{3,4}$/;
     if( !regExpTel2.test(tel2) ){
         alert("3-4 자리 유효 조건에 맞게 입력해주세요");
         return false;
     }
     var regExpTel3= /^[0-9]{4}$/;
     if( !regExpTel3.test(tel3) ){
         alert("4 자리 유효 조건에 맞게 입력해주세요");
         return false;
     }

    

     // 그 외는 action 으로 데이터 전달하면서 이동됨.
     // {
     //     var frm1 = document.getElementById("frmId1");
     //     if(document.getElementById("id").value == "admin"){
     //         frm1.action = "#관리자페이지";
     //     } else {
     //         frm1.action = "#일반페이지";
     //     }                
     //     frm1.method = "post";
     //     frm1.submit();     //submit 매우 중요해
     //     // return true;
     // }
     // 페이지 이동할때 a태그(그냥이동, 실어서 갈 수도 있어)/ form태그(입력받아서 이동) 두가지로 이동 가능
 }        
	</script>

<div id="footer">
     INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
</div>
</body>
</html>