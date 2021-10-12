<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    

<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <title>회원가입</title>
    <!-- <link rel="stylesheet" href="../../css/myStyle01.css"/> -->
    

    <style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap');


    body {
        font-family: 'Noto Sans KR', sans-serif;
        margin: 0;
    }

    #header {
        width: 1110px; 
        margin: 0 auto; 
        height: 220px;
        position: relative;
    }
   

/* body {
    font-family: 'Noto Sans KR', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-size: cover;
} */

.h1 {
    text-align: center;
    height: 150px;
    margin-bottom: 100px;
}

#section {
    position: relative; z-index: 2;
    font-family: 'Noto Sans KR', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-size: cover;
    padding-bottom: 190px;
}
.h1{
    font-size: 32px; color: black;
    text-align: center;  
    margin-bottom: 60px;  
}
.int-area {
    width: 400px;
    margin-top: 20px;
}
.int-area:first-child{margin-top: 0;}
.input1 {
    width: 100%;
    background-color: transparent;
    border: none;
    border-bottom: 1px solid #999;
    font-size: 18px; color: black;
    outline: none;
}
.int-area label{
    font-size: 18px; color: #999;
    transition: top .5s ease;
}
.btn-area {margin-top: 30px;}
.btn-area input{
    width: 100%; height: 50px;
    background: #166cea;
    color: #fff;
    font-size: 20px;
    border: none;
    border-radius: 25px;
    cursor: pointer;
}
#signup {
    width: 100px; height: 40px;
    font-size: 20px;
}
    
        /* 위치 포지셔닝 */
#footer {
            clear: both;
            width: 1110px;
            height: 190px;
            bottom: 0;
            margin: 0 auto;
            margin-bottom: 10px;
            padding: 10px;
            box-sizing: border-box;
            text-align: center;
            
        }
    </style>

    <script>
        window.addEventListener('load', function() {
		var signup = document.querySelector('#signup');
		
		//signup버튼을 클릭했을때
		signup.addEventListener('click', function() {
			// value로 사용시 객체 속성 사용이 불가능하여 포커스를 사용할 수가 없어서
			// 변수를 아래로 바꿨습니다.
			/* var id = document.querySelector('#id').value;
			var pw1 = document.querySelector('#pw1').value;
			var pw2 = document.querySelector('#pw2').value;
			var gender = document.querySelectorAll(".gender");
			var hobby = document.querySelectorAll(".hobby");
			var birth = document.querySelector('#birth').value;
			var age = document.querySelector('#age').value;
			var email = document.querySelector('#email').value;
			var memo = document.querySelector('#memo').value;
			 */
			 
			
			// 아이디와 비번,성별,취미,생일,나이,이메일,메모 객체 셋팅  
			var id = document.querySelector('#id');
			var pw1 = document.querySelector('#pw1');
			var pw2 = document.querySelector('#pw2');
			var name = document.querySelector('#name');
            var nickname = document.querySelector('#nickname');
			var email = document.querySelector('#email');
            var phone1 = document.querySelector('#phone1');
            var phone2 = document.querySelector('#phone2');
            var phone3 = document.querySelector('#phone3');
			
			
			

            //비밀번호 검사
            var regExp = /^[A-Z][A-Za-z0-9_!]{7,15}$/;
            if(!regExp.test(pw1value)){
                alert("첫 글자는 영어 대문자, 소문자 + 숫자 + 특수문자(_,#) 조건에 맞게 입력해주세요");
                return false;
            }

            //이름 검사
            var name = document.getElementById("name").value;
            var regExpName = /^[가-힣]{2,10}$/;
            if(!regExpName.test(name)){
                alert("한글만 입력가능, 2글자 이상 10글자 이하 조건에 맞게 입력해주세요");
                return false;
            }
			
			
			// 전체 검사
			// 아이디가 공백이거나 4글자 미만이면
			if (id.value == '' || id.value.length < 8) {
				alert('아이디를 8자이상 입력해주세요');
				//id포커스
				id.focus();
			// 비밀번호가 처음입력한 값과 다를시
			} else if (pw1.value != pw2.value) {
				alert('패스워드가 일치하지 않습니다.');
				pw2.focus();
			// 이메일이 입력되지 않았을시
			} else if (email.value == '') {
				alert('이메일을 입력해주세요.');
				email.focus();
			// 전부완료되면 indimoa카페로 이동
			} else {
				location.href = "";
			}

		});
	});
    </script>
</head>
<body>
    <div id="header">
        <div id="logo">
        <img src=".jpg" width="200px" height="50px">
        </div>     
    </div>
    
    <h1 class="h1">회원가입</h1><br><br>
    <div id="section">
    <form action="" method="POST">
        <p class="int-area">
            <label for="id">아이디 : </label>
            <input id="id" type="text" name="mm_id" class="input1">
        </p>
        <p class="int-area">
            <label for="pwd">비밀번호 : </label>
            <input id="pwd" type="password" name="mm_pwd" class="input1">
        </p>
        <p class="int-area">
            <label for="repwd">비밀번호 확인 : </label>
            <input id="repwd" type="password" name="mm_pwd" class="input1">
        </p>
        <p class="int-area">
            <label for="name">이름 : </label>
            <input id="name" type="text" name="mm_name" class="input1">
        </p>
        <p class="int-area">
            <label for="nickname">닉네임 : </label>
            <input id="nickname" type="text" name="mm_nickname" class="input1">
        </p>
        <p class="int-area">
            <label for="email">이메일 : </label>
            <input id="email" type="email" name="mm_email" class="input1">
        </p>
        <p class="int-area">
            <label for="phone">전화번호 : </label>
            <input id="phone" type="text" name="mm_phn" class="input1">
        </p>
        <p class="int-area">
            <label for="os">OS : </label><br>
            <input id="os" type="radio" value="window" name="mm_com" class="input2">WINDOW<br>
            <input id="os" type="radio" value="mac" name="mm_com" class="input2">MAC<br>
        </p><br>
        <p class="int-area">
            <label for="separate">구분 : </label><br>
            <input id="separate" type="radio" value="user" name="mm_com" class="input2">개인<br>
            <input id="separate" type="radio" value="developer" name="mm_com" class="input2">개발자<br>
        </p><br>
        <p class="int-area">
            <label for="profile">프로필 : </label>
            <input type="file" id="image" name="mm_profile" class="input1" accept="image/*" onchange="setThumbnail(event);">
            <div id="image_container"></div>
        </p><br>
        <p class="btn-area">
            <input type="submit" id="signup" value="회원가입">
        </p>
        </form>
    </div>
<div id="footer">
    <h1>footer</h1>
</div>
</body>
</html>