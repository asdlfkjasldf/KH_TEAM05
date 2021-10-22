<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"--%>


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
</head>

<body>
	<h2 align="center">게임 등록 하기</h2>
	<hr>
	<section id="myinfo"> 
	

		<form action="EnrollGameDo" id="enrollForm" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>게임 타이틀 :</td>
					<td><input type="text" name="ggTitle" id="title" autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>가격 :</td>
					<td><input type="text" name="ggPrice"></td>
				</tr>

				<tr>
					<td>시스템 요구사항 :</td>
					<td><input type="text" name="ggSystemRequirement"></td>
				</tr>

				<tr>
					<td>장르 :</td>
					<td>
					<!-- input type="text" name="ggGenre"> -->
					<select id="" name="ggGenre">
        			<option value="액션/슈팅">액션/슈팅</option>
        			<option value="스포츠">스포츠</option>
        			<option value="보드게임">보드게임</option>
        			<option value="아케이드">아케이드</option>
        			<option value="대전/격투">대전/격투</option>
        			<option value="RPG">RPG</option>
        			<option value="어드벤처">어드벤처</option>
        			<option value="시뮬레이션">시뮬레이션</option>
        			<option value="기타장르">기타장르</option>
        			<!--  <option value="인기게임">인기게임</option>-->
					</select>
					</td>
					
				</tr>

				<tr>
					<td>개발사 :</td>
					<td><input type="text" name="ggDeveloper"></td>
				</tr>

				<tr>
					<td>발매일 :</td>
					<td><input type="text" name="ggReleaseDate"></td>
				</tr>

				<tr>
					<td>공급사 :</td>
					<td><input type="text" name="ggPublisher"></td>
				</tr>

				<tr>
					<td>언어 :</td>
					<td><input type="text" name="ggLanguages"></td>
				</tr>

				<tr>
					<td>정보 :</td>
					<td><input type="text" name="ggInfomation"></td>
				</tr>
				
				

					<tr>
						<td>게임 이미지 파일 첨부1(대표이미지) :</td>
						<td><input type="file" name="image1" class="gameimage"></td>
						<td>게임 이미지 파일 첨부2 :</td>
						<td><input type="file" name="image2" class="gameimage"></td>
					</tr>

					<tr>
						<td>게임 이미지 파일 첨부3 :</td>
						<td><input type="file" name="image3" class="gameimage"></td>
						<td>게임 이미지 파일 첨부4 :</td>
						<td><input type="file" name="image4" class="gameimage"></td>
					</tr>

				</section>


			</table>
			<p align="center">
				<button type="submit">게임 등록하기</button>
				&nbsp; &nbsp;
				<button type="reset">초기화</button>
				&nbsp; &nbsp;
				<button type="button">
					<a href="GameList">취소</a>
				</button>
			</p>
		</form>
		<!-- </section>
    <br> <br>
    <p align="center">
        <button type="button" onclick="location.href='../../index.jsp';">메인으로 가기</button>
    </p>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $("#enrollForm").submit(function (event) {
            var regex = /^[A-Za-z0-9]{5,14}$/; // 정규식을 통한 문자열 패턴 분석 
            var chk = 0;
            if ($('#userid').val().length < 5) {
                alert("아이디는 5자 이상이어야 합니다.");
            } else if (!regex.test($('#userid').val())) {
                alert("아이디는 영문자와 숫자만 가능합니다.");
            } else {
                $.ajax({ // ajax를 통한 아이디 중복 값 체크 
                    url: "../../dupid.lo",
                    type: "post",
                    async: false,
                    data: {
                        id: $('#userid').val()
                    },
                    dataType: "text",
                    success: function (value) {
                        if (value === "fail") {
                            alert("이미 존재하는 아이디입니다.\n 다른 아이디로 정하십시오.");
                        } else { alert("정상 가입이 되었습니다."); chk++; }
                    },
                    error: function (request, status, error) {
                        alert("code:" + request.status + "\n" + "message:" +
                            request.responseText + "\n" + "error:" + error);
                    }
                });
            }
            if (chk == 0) event.preventDefault();
        });
    </script>
    -->
</body>

</html>