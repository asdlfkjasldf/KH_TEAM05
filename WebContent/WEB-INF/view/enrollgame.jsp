<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--@ taglib prefix=ācā uri="http://java.sun.com/jstl/core"--%>


<%-- 
	String ggNo = request.getParameter("ggNO"); 
	if(ggNo==null || ggNo.equals("")){
		ggNo="";
	}
--%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Enroll Game</title>
<link rel="stylesheet" href="../../css/myStyle.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>



<style type="text/css">
@charset "UTF-8";

@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap')
	;

* {
	font-family: "Noto Sans KR", sans-serif;
	margin: 0;
	padding: 0;
}

body {
	font: 15px;
}

ul {
	overflow: hidden;
	margin: 0 auto;
}

a {
	text-decoration: none !important;
	color: black;
}

li {
	list-style-type: none;
}

header {
	width: auto;
	height: 130px;
	font-size: 16px;
	position: relative;
	margin: 0 auto;
}

#logo {
	margin-left: 300px;
	padding-bottom:40px;
	float:left;
}

#logo>a>img {
	width: 180px;
	height: 45px;
	position: relative;
}

#highmenu {
	bottom: 5px;
	position: absolute;
	overflow: hidden;
	display: flex;
	margin: 0 auto;
	width: 70%;
}

.panel a:hover {
	color: #919191;
}

#highmenu>ul>li {
	width: 100px;
	display: inline-block;
	margin: 0 auto;
	text-align: center;
}

#highmenu #textboxli {
	width: 250px;
}

header #topmenu_tnb {
	top: 0;
	right: 100px;
	overflow: hidden;
	position: absolute;
	border-radius: 5px;
	margin: 15px;
	padding: 5px;
	font-size: 14px;
}

#topmenu_tnb ul li {
	display: inline-block;
	margin: 5px;
	margin-top: 0px;
	position: relative;
}

/* section */
.section {
	width: 100%;
	margin: 0 auto;
}

.aside-left {
	width: 300px;
	font: 16px;
	float: left;
	padding: 80px 20px 20px 310px;
	margin: 0 auto;
}

.aside-left a:hover {
	color: #919191;
}

.article {
	width: 900px;
	min-height: 100%;
	padding: 50px 50px 50px 20px;
	margin: 0 auto;
	float:left;
}

#textSearchGame {
	height: 30px;
	padding-top: 9px;
}

#btnSearchGame {
	border: none;
	background-image: url("../image/free-icon-magnifier-71403.png");
	background-repeat: no-repeat;
	width: 24px;
	height: 24px;
	outline: 0;
	background-image: url("../image/free-icon-magnifier-71403.png");
	background-color: white;
	margin: 10px;
}

.imgIcon {
	border: none;
	width: 24px;
	height: 24px;
	bottom: 0;
}

.accordion {
	color: black;
	cursor: pointer;
	border: none;
	text-align: left;
	transition: 0.4s;
	font-size: 16px;
	background-color: white;
}

.panel {
	padding: 0 18px;
	max-height: 0px;
	overflow: hidden;
	transition: max-height 0.2s ease-out;
	float: left;
	/* width: 500px; */
}

.panel>ul {
	overflow: hidden;
	text-align: left;
}

.panel>ul>li {
	width: 100px;
	display: inline-block;
	margin-right: 20px;
}

footer {
	clear: both;
	width: 100%;
	height: 100px;
	background-color: #ccc;
	text-align: center;
	padding-top: 40px;
	font-size: 13px;
}
</style>




<style type="text/css">
.promotion{
	width: 1000px;
	margin: 0 auto;
}
</style>


</head>

<body>
<header>
	<div id="logo"><a href="./main"><img src="./image/ex1.png"></a></div>
	<nav id="highmenu" class="topmenu">
	    <ul>
        <li><a href="./GameList">ģģ </a></li>
        <li><button class="accordion">ģ»¤ė®¤ėķ°</button>
        	<div class="panel">
        	<ul>
        	<li><a href="./fbboardlist">ģģ ź²ģķ</a></li>
        	<li><a href="./gbboardlist">ź°ė°ģ¬ź²ģķ</a></li>
        	<li><a href="./tboardlist">ķź²ģķ</a></li>
        	</ul>
        	</div>
        </li>
        
        <li><a href="./notice">ė“ģ¤</a></li>
        <li><a href="#">ģ¹“ķź³ ė¦¬</a></li>
        <li><a href="./faq">ģ§ģ</a></li>
        <li id="textboxli">
        	<!-- todo ė§ķ¬ė jstlģ ģ“ģ©ķ“ txtė°ģ¤ģ ź°ģ ģ ģ“źµ¬ė¬øģģ± -->
        	<form action="./search?" method="get">
        	<input type="text" id="textSearchGame" name="q">
        	<button type="submit" id="btnSearchGame"></button>
        	</form>
        	
        </li>
    	</ul>
	</nav>
		<nav id="topmenu_tnb">
		<ul>
	        <li><a href="./enrollmember">ķģź°ģ</a></li>
	        <li><a href="./memberlogin">ė”ź·øģø</a></li>
	        <li><a href="#">ė§ģ“ķģ“ģ§</a></li>
	        <li><a href="./cartlist">ģ„ė°źµ¬ė</a></li>
		</ul>     
		</nav>
	</header>

	<h2 align="center">ź²ģ ė±ė” ķźø°</h2>
	<hr>
	<section id="myinfo"> 
	

		<form action="EnrollGameDo" id="enrollForm" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>ź²ģ ķģ“ķ :</td>
					<td><input type="text" name="ggTitle" id="title" autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>ź°ź²© :</td>
					<td><input type="text" name="ggPrice"></td>
				</tr>

				<tr>
					<td>ģģ¤ķ ģźµ¬ģ¬ķ­ :</td>
					<td><input type="text" name="ggSystemRequirement"></td>
				</tr>

				<tr>
					<td>ģ„ė„“ :</td>
					<td>
					<!-- input type="text" name="ggGenre"> -->
					<select id="" name="ggGenre">
        			<option value="ģ”ģ/ģķ">ģ”ģ/ģķ</option>
        			<option value="ģ¤ķ¬ģø ">ģ¤ķ¬ģø </option>
        			<option value="ė³“ėź²ģ">ė³“ėź²ģ</option>
        			<option value="ģģ¼ģ“ė">ģģ¼ģ“ė</option>
        			<option value="ėģ /ź²©ķ¬">ėģ /ź²©ķ¬</option>
        			<option value="RPG">RPG</option>
        			<option value="ģ“ėė²¤ģ²">ģ“ėė²¤ģ²</option>
        			<option value="ģė®¬ė ģ“ģ">ģė®¬ė ģ“ģ</option>
        			<option value="źø°ķģ„ė„“">źø°ķģ„ė„“</option>
        			<!--  <option value="ģøźø°ź²ģ">ģøźø°ź²ģ</option>-->
					</select>
					</td>
					
				</tr>

				<tr>
					<td>ź°ė°ģ¬ :</td>
					<td><input type="text" name="ggDeveloper"></td>
				</tr>

				<tr>
					<td>ė°ė§¤ģ¼ :</td>
					<td><input type="text" name="ggReleaseDate"></td>
				</tr>

				<tr>
					<td>ź³µźøģ¬ :</td>
					<td><input type="text" name="ggPublisher"></td>
				</tr>

				<tr>
					<td>ģøģ“ :</td>
					<td><input type="text" name="ggLanguages"></td>
				</tr>

				<tr>
					<td>ģ ė³“ :</td>
					<td><input type="text" name="ggInfomation"></td>
				</tr>
				
				

					<tr>
						<td>ź²ģ ģ“ėÆøģ§ ķģ¼ ģ²Øė¶1(ėķģ“ėÆøģ§) :</td>
						<td><input type="file" name="image1" class="gameimage"></td>
						<td>ź²ģ ģ“ėÆøģ§ ķģ¼ ģ²Øė¶2 :</td>
						<td><input type="file" name="image2" class="gameimage"></td>
					</tr>

					<tr>
						<td>ź²ģ ģ“ėÆøģ§ ķģ¼ ģ²Øė¶3 :</td>
						<td><input type="file" name="image3" class="gameimage"></td>
						<td>ź²ģ ģ“ėÆøģ§ ķģ¼ ģ²Øė¶4 :</td>
						<td><input type="file" name="image4" class="gameimage"></td>
					</tr>

				</section>


			</table>
			<p align="center">
				<button type="submit">ź²ģ ė±ė”ķźø°</button>
				&nbsp; &nbsp;
				<button type="reset">ģ“źø°ķ</button>
				&nbsp; &nbsp;
				<button type="button">
					<a href="GameList">ģ·Øģ</a>
				</button>
			</p>
		</form>
	
	<footer>
    INDIMOA ļ½ ģ¬ģģė±ė”ė²ķø : 821-85-00000 ļ½ ģģø ź°ėØ ģ 2020-01ķø ļ½ ėķģ : ķźøøė ļ½ ģ±ģģ : ķźøøė ļ½  ź°ģøģ ė³“ź“ė¦¬ģ±ģģ : ķźøøė<br><br>
        Copyright Ā© 2020-2021 INDIMOA GAME SHOPPING MALL
	</footer>
	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
	console.log("ė©ģė ģ§ģķģø");
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
</script>

<div hidden="">ėė³“źø°ģģ“ģ½ ģ ģģ <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></div>
	
	
</body>

</html>