<%@page import="javax.xml.crypto.Data"%>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
 <style>
 	table{
 	border: 1px solid black;
 	}
 	
 	input[type="text"]{
 	width: 800px;
 	height: 300px;
 	}
 	.description, #btnBoardWriteBox{
 	text-align: center;
 	}

 </style>
 
 <script>
 var btnUpdateValue = "";
 $(document).ready(function(){
		$("#btnBoardView").on("click",function() {
	$.ajax({
		url : "<c:url value='/boardmanagement'/>",
		type : "post",
		data :{
			bmselect : $("#bmselect option:selected").val()
		},
		async : false,
		dataType : 'json',
		success : function(data){
			const rowCnt = 1;
			const columnCnt = 5;
			
			console.log(data);
			var tabEle = document.getElementById('listTable');
			//Articel 비우기
			$('.Board-Article').empty();
			$('#btnBoardWriteBox').empty();
			
			//테이블 비우기
			tabEle.innerHTML = "";
			tabEle.innerHTML += ('<tr>');
			  for (var j = 0; j < columnCnt; j++)  {
				  
				  
				  if (!(data.volist[j].fbTitle == null)) {
					  //여러줄로 나뉘니 테그도 원하는대로 되지 않다가 한줄로 만들어서 +로 이어주니 원하는 대로 테그가 속해졌다.
					  tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].fbNo+ " ");
					  tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].fbTitle + " " 
							 	+ '<button  class="btnUpdate">수정</button>'
							  	+ '<button>삭제</button>'
							  	+ '</td>');
				}else if (!(data.volist[j].gbTitle == null)) {
					tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].gbNo+" " );
					tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].gbTitle + " " 
								+ '<button  class="btnUpdate">수정</button>'
								+ '<button>삭제</button>'
								+ '</td>');
				}else if (!(data.volist[j].tipTitle == null)) {
					tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].tipNo+" ");
							tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].tipTitle+" "
								+ '<button  class="btnUpdate">수정</button>'
								+ '<button>삭제</button>'
								+ '</td>');
				}
				  
				  
				  
				  tabEle.innerHTML +=('</tr>')
				  
				  
				  
				  
				  
			} //반목문 끝
			
			$(document).on('click', ".btnUpdate", function (){ 
				  //$(this).text("바뀌는지 확인");
				  $(this).parents("tbody").prev().find(".boardNo").css("color","red");
				  console.log($(this).parent().parent().parent().prev().children().children(".boardNo").html()); //작동확인
				  console.log(typeof(btnUpdateValue));
				  btnUpdateValue =  $(this).parents("tbody").prev().find(".boardNo").html().trim();
				    //디버깅 용 console.log
				  //console.log("업데이트버튼의 this값: "+ String($(btnUpdateValue).val())  );
				  //console.log("업데이트버튼의 this값 노벨류: "+$(btnUpdateValue) );
				  //console.log("업데이트버튼의 this값 텍스트: "+$(btnUpdateValue).html() );
				  $('.Board-Article').empty();
				  $('#btnBoardWriteBox').empty();
					var $divTitle = $('<div class="description">제목<br><input type="text" id="newTextTitle" value=""></div>');
						$('.Board-Article').append($divTitle);

						var $divContent = $('<div class="description">내용<br><input type="text" id="newTextContent" value=""></div>');
						$('.Board-Article').append($divContent);
						var $divWriteBtn = $('<button type="button" class="btnBoardWrite">등록</button>');
						$('#btnBoardWriteBox').append($divWriteBtn);
					});
			  
			  
				//기존 (엘리먼트).click을 사용했을 때 ajax가 생성된 엘리먼트의 버튼 생성자를 인지하지 못해서 변경
				$(document).on('click', ".btnBoardWrite", function (){
					//alert("확인?");
					
					console.log("let : "+$(btnUpdateValue).val());
					//console.log("업데이트버튼의 부모: "+$(this).perent().val());
					$.ajax({
						url : "<c:url value='/boardmanagementupdate'/>",
						type : "post",
						async : false,
						data :{
							bmselect : $("#bmselect option:selected").val(),
							t : $("#newTextTitle").val(),
							c : $("#newTextContent").val(),
							bno : btnUpdateValue
							//bno : 23
							
							
							},
							dataType : "json",
							success : function(data){
								console.log("업데이트 ajax 리턴확인");
								if (data.result == -1) {
									console.log("게시글이 수정되지 않았습니다.");	
								}else {
									console.log("게시글이 수정되었습니다.");
								}
							},error : function(request,status,error) {
								 alert("code:"+request.status+"\n"+"message:"+request.responseText+
								"\n"+"error:"+error);
								 } 
							
						});
					}); //a작스안의 a작스끝
			
			
		},
		error : function(request,status,error) {
			 alert("code:"+request.status+"\n"+"message:"+request.responseText+
			"\n"+"error:"+error);
			 } 

		
		
	
		});
	});
		

		

	});
 
	

		
 

		//현재 문제가 no가 특정되서 ajax로 보내지지 않는다.
	</script>
	<script>

	</script>
 
</head>
<body>
<div class="Header"> </div>

<div class="Article">
<h1> 게시판 </h1>
<hr>
<div id="select">
	
	<select id="bmselect" name="bmselect" ">
		<option value="fb">자유게시판(회원)</option>
		<option value="gdb">개발사게시판</option>
		<option value="tipb">팁게시판</option>
	</select>
	<button type="button" id="btnBoardView">조회</button>
	
</div>



	

<div class="Board-list">
<!--  jstl을 이용해 ajax를 거친 데이터를 테이블로 보이게한다. -->
	<table id="listTable">

	</table>
	<c:if test="${startPage >1 }"> 이전 </c:if>
		<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<a href="boardmanagement?pagenum=${i}">${i}</a>
		</c:forEach>
	<c:if test="${endPage < pageCount }"> 다음 </c:if>
</div>

<div class="Board-Article">

	
	
</div>
<div id="btnBoardWriteBox">

</div>

</div>

<div class="Footer"></div>
</body>
</html>