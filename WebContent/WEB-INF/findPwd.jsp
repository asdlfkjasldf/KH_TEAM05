<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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

    .h1 {
        text-align: center;
        height: 150px;
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
    .int-area {
        width: 400px;
        margin-top: 20px;
    }
    .int-area:first-child{margin-top: 0;}
    .int-area input{
        width: 100%;
        padding: 20px 10px 10px;
        background-color: transparent;
        border: none;
        border-bottom: 1px solid #999;
        font-size: 18px; color:black;
        outline: none;
    }
    .int-area label{
        font-size: 18px; color: #999;
        transition: top .5s ease;
    }
    .int-area label.warning {
        color: red !important;
        animation: warning .3s ease;
        animation-iteration-count: 3;
    }

    .int-area input:focus + label,
    .int-area input:valid + label {
        top: -2px;
        font-size: 13px; color: #166cea;
    }

    .btn-area {margin-top: 30px;}
    .btn-area button{
        width: 100%; height: 50px;
        margin-top: 10px;
        background: #166cea;
        color: #fff;
        font-size: 20px;
        border: none;
        border-radius: 25px;
        cursor: pointer;
    }

    .caption{
        margin-top: 20px;
        text-align: center;
    }
    .caption a{
        font-size: 15px;
        color: #999;
        text-decoration: none;
    }

    #footer {
        clear: both;
        width: 1110px;
        height: 190px;
        margin: 0 auto;
        margin-bottom: 10px;
        padding: 10px;
        box-sizing: border-box;
        text-align: center;
    }
    </style>
    <title>비밀번호 찾기</title>
</head>
<body>
    <div id="header">
        <div id="logo">
        <img src=".jpg" width="200px" height="50px">
    </div>

    <h1 class="h1">비밀번호 찾기</h1>
    
    <div id="section">
        <form action="/search">
            <p class="int-area">
                <label for="name">이름</label>
                <input type="text" name="mm_name" id="name"  autocomplete="off" required>
            </p>
            <p class="int-area">
                <label for="id">아이디</label>
                <input type="text" name="mm_id" id="id"  autocomplete="off" required>
            </p>
            <p class="btn-area">
                <button id="btn" type="submit">찾기</button>
                <button id="btn" type="reset">취소</button>
            </p>
        </form>     
    </div>

    <script>
        let id = $("#name");
        let pw = $("#id");
        let btn = $("#btn");

        $(btn).on('click', function(){
            if($(id).val() == "") {
                $(id).next('label').addClass('warning');
                setTimeout(function(){
                    $('label').removeClass('warning');
                }, 1500);
            }            
            else if($(pw).val() == "") {
                $(pw).next('label').addClass('warning');
                setTimeout(function(){
                    $('label').removeClass('warning');
                }, 1500);
            }
        });
    </script>
    <div id="footer">
        <h1>footer</h1>
    </div>
</body>
</html>