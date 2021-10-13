<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            height: 50px;
        }


        #section {
            position: relative; z-index: 2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-size: cover;
            padding-bottom: 190px;
        }
        .t1 {
            width: 400px;
            margin-top: 10px;
        }
        .t1:first-child{margin-top: 0;}
        .t1 input{
            width: 100%;
            padding: 20px 10px 10px;
            background-color: transparent;
            border: none;
            border-bottom: 1px solid #999;
            font-size: 18px; color: black;
            outline: none;
        }
        .t1 label{
            font-size: 18px; color: #999;
            transition: top .5s ease;
        }
        .caption{
            margin-top: 50px;
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
    <title>아이디찾기결과</title>
</head>
<body>
    <div id="header">
		<div id="logo">
		<img src=".jpg" width="200px" height="50px">
	</div>

    <h1 class="h1">아이디 찾기 결과</h1>

    <div id="section">
		<form action="../../mupdate.lo" method="post">
				<p class="t1">
					<label for="id">아이디 : </label>
					<input type="text" name="mm_id" value="<%="m.getMm_id()"%>" readonly="readonly">  <!-- TODO -->
				</p>

                <p class="caption">
                    <a href="http://127.0.0.1:5500/INDIMOA/findPwd.html">비밀번호 찾기</a>
                </p>
        </form>
    </div>
    <div id="footer">
        <h1>footer</h1>
    </div>
</body>
</html>