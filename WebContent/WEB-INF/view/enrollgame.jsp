<%@page import="com.indimoa.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--@ taglib prefix=”c” uri="http://java.sun.com/jstl/core"--%> 


    
    
    
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
        <form action="EnrollGameServlet" id="enrollForm" method="post">
            <table>
                <tr>
                    <td>게임 타이틀 :</td>
                    <td><input type="text" name="id" id="title"></td>
                </tr>
                <tr>
                    <td>가격 :</td>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <td>시스템 요구사항 :</td>
                    <td><input type="text" name="SystemRequirement"></td>
                </tr>
                <tr>
                    <td>장르 :</td>
                    <td><input type="text" name="Genre"></td>
                </tr>

                
                <td>개발사 :</td>
                <td><input type="text" name="Developer"></td>
                </tr>
                <td>발매일 :</td>
                <td><input type="text" name="ReleaseDate"></td>
                </tr>
                <td>공급사 :</td>
                <td><input type="text" name="Publisher"></td>
                </tr>
                <td>언어 :</td>
                <td><input type="text" name="Languages"></td>
                </tr>
                <td>정보 :</td>
                <td><input type="text" name="Infomation"></td>
                </tr>

            </table>
            <p align="center">
                <button type="submit"><a href="EnrollGameServlet"></a>게임 등록하기</button> &nbsp; &nbsp;
                <button type="reset">작성 양식 초기화</button>
                <button type="button"><a href="GameList">취소</a></button>
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