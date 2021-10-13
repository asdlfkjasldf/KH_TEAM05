<%@page import="com.indimoa.board.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 관리</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <style>
 	table{
 	border: 1px solid black;
 	}
 </style>
</head>
<body>
<div class="Header"> </div>

<div class="Article">
<h1> 게시판 </h1>
<hr>
<div id="select">
	
	<select id="bmselect" name="bmselect">
		<option value="fb">자유게시판(회원)</option>
		<option value="gdb">개발사게시판</option>
		<option value="tipb">팁게시판</option>
	</select>
	<button type="button" id="btnBoardView">조회</button>
	
</div>



	

<div class="Board-list">
<!--  jstl을 이용해 ajax를 거친 데이터를 테이블로 보이게한다. -->
<table id="insertlist">
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th></th>
		<th></th>
	</tr>
	</thead>
	
</table>
목록들어 갈곳 
</div>

<div class="Board-Article">
	<div>
	<!--  제목칸의 데이터를 select option의 게시판의 글에 등록 -->
	제목<br>
	<input type="text" id="newTextTitle">
	</div>
	<div>
	<!--  내용칸의 데이터를 select option의 게시판의 글에 등록 -->
	내용<br>
	<input type="text" id="newTextContent">
	</div>
	
</div>
<button type="button" id="btnBoardWrite">등록</button>
</div>

<div class="Footer"></div>

	<script>
		
			
			$(document).on("click", "#btnBoardView",function() {
				

				$.ajax({
					type : "post",
					url : "indimoa/indimoa/boardrmanagement",
					dataType : "html",
					data : {
						targetvo: $("#bmselect").val(),
						
					},
				success : function(data){
					{
						$newTbody = $("<tbody class='new-tbody'></tbody>")
						$("#insertlist").append($newTbody)
						
						for(let list of data){
							let $cellsOfRow = $("<tr>" +
									"<td>"list.no<"</td>" +
									"<td>"list.title<"</td>" +
									"<td>"list.content<"</td>" +
									"<td><button type=button onclick='updateColumn()'>수정</button>" +
									"<td><button type=button onclick='deleteColumn()'삭제</button>" +
									"</tr>");
							$newTbody.append("$cellsOfRow");
									
						}
					}
					
					$('.Board-Article').html(data);
					
				}
					
				});	
			});

		

//현재 문제가 no,title,content를 지칭하는 게시판 db의 컬럼명이 다다르다.
	</script>
	


</body>
</html>