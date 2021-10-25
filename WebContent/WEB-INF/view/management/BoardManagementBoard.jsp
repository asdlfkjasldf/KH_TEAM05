<link rel="stylesheet" type="text/css" href="./css/myStyle.css">
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
 	#newTextTitle{
 	width: 800px;
 	height: 2em;
 	}
 	
 	#newTextContent{
 	width: 800px;
 	height: 300px;
 	padding-bottom: 286px;
 	}
 	.description, #btnBoardWriteBox{
 	text-align: center;
 	}

 </style>
 
 <script>
 var btnUpdateValue = ""; 	//업데이트 버튼 클릭시 글번호 저장후 등록 버튼때 불러와서 사용하기 위해 선언
 $(document).ready(function(){
		$("#btnBoardView").on("click",function() {
	$.ajax({
		url : "<c:url value='/boardmanagement'/>",
		type : "post",
		data :{
			bmselect : $("#bmselect option:selected").val()
		},
		async : false,
		//ajax를 sucess 오브젝트 안에 중복해서 쓰므로 하나의 ajax가 동기로 계속 붙잡는 것을 막기 위해 사용함
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
			tabEle.innerHTML += ('<tr style="border: 1px;">');
			  for (var j = 0; j < columnCnt; j++)  {
				  
				  
				  if (!(data.volist[j].fbTitle == null)) {
					  //여러줄로 나뉘니 테그도 원하는대로 되지 않다가 한줄로 만들어서 +로 이어주니 원하는 대로 테그가 속해졌다.
					  tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].fbNo+ " ");
					  tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].fbTitle + " ");
					  tabEle.innerHTML += ('</td><td class="boardContent">' + data.volist[j].fbContent + " " 
							 	+ '<button  class="btnUpdate">수정</button>'
							  	+ '<button class="btnDelete">삭제</button>'
							  	+ '</td>');
				}else if (!(data.volist[j].gbTitle == null)) {
					tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].gbNo+" ");
					tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].gbTitle + " ");
					tabEle.innerHTML += ('</td><td class="boardContent">' + data.volist[j].gbContent + " " 
								+ '<button  class="btnUpdate">수정</button>'
								+ '<button class="btnDelete">삭제</button>'
								+ '</td>');
				}else if (!(data.volist[j].tipTitle == null)) {
					tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].tipNo+" ");
					tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].tipTitle + " ");
					tabEle.innerHTML += ('</td><td class="boardContent">' + data.volist[j].tipContent+" "
								+ '<button  class="btnUpdate">수정</button>'
								+ '<button class="btnDelete">삭제</button>'
								+ '</td>');
				}else if (!(data.volist[j].ntTitle == null)) {
					tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].ntNo+" ");
					tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].ntTitle + " ");
					tabEle.innerHTML += ('</td><td class="boardContent">' + data.volist[j].ntContent+" "
						+ '<button  class="btnUpdate">수정</button>'
						+ '<button class="btnDelete">삭제</button>'
						+ '</td>');
				}else if (!(data.volist[j].fqTitle == null)) {
					tabEle.innerHTML += ('<td class="boardNo">' + data.volist[j].fqNo+" ");
					tabEle.innerHTML += ('</td><td class="boardTitle">' + data.volist[j].fqTitle + " ");
					tabEle.innerHTML += ('</td><td class="boardContent">' + data.volist[j].fqContent+" "
						+ '<button  class="btnUpdate">수정</button>'
						+ '<button class="btnDelete">삭제</button>'
						+ '</td>');
				}
				  
				  
				  
				  tabEle.innerHTML +=('</tr>')
				  
				  
				  
				  
				  
			} //반목문 끝
			
			
			//기존 (엘리먼트).click을 사용했을 때 ajax가 생성된 엘리먼트의 버튼 생성자를 인지하지 못해서 변경
			$(document).on('click', ".btnUpdate", function (){ 
				  //jhSeong 수정중인 검색페이지의 글번호를 빨갛게 해준다.
				  $(this).parents("tbody").prev().prev().find(".boardNo").css("color","red");
				  console.log("수정할 글 번호 : " +$(this).parent().parent().parent().prev().children().children(".boardNo").html()); //작동확인
				  btnUpdateValue =  $(this).parents("tbody").prev().prev().find(".boardNo").html().trim();
		
				  $('.Board-Article').empty();
				  $('#btnBoardWriteBox').empty();
					var $divTitle = $('<div class="description">제목<br><input type="text" id="newTextTitle" value=""></div>');
						$('.Board-Article').append($divTitle);

						var $divContent = $('<div class="description">내용<br><input type="text" id="newTextContent" value=""></div>');
						$('.Board-Article').append($divContent);
						var $divWriteBtn = $('<button type="button" class="btnBoardWrite">등록</button>');
						$('#btnBoardWriteBox').append($divWriteBtn);
					});
			  
			  
				
					
					
			
		},
		error : function(request,status,error) {
			 alert("code:"+request.status+"\n"+"message:"+request.responseText+
			"\n"+"error:"+error);
			 } 

		
		
	
		});
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
							alert("게시글이 수정되지 않았습니다.");	
						}else {
							alert("게시글이 수정되었습니다.");
						}
					},error : function(request,status,error) {
						 alert("code:"+request.status+"\n"+"message:"+request.responseText+
						"\n"+"error:"+error);
						 } 
					
				});
			}); //a작스안의 a작스끝
	
			
		$(document).on('click', ".btnDelete", function () {
			var confirmDelete = confirm("정말로 삭제하시겠습니까?");
			
			
			if (confirmDelete == true) {
				var btnDeleteValue = $(this).parents("tbody").prev().prev().find(".boardNo").html().trim();
				//삭제여부가 확인,취소창이 뜨며 확인은 그대로 진행, 취소 누를시 return으로 메소드 탈출
				console.log("삭제할 글 번호 : " + $(this).parent().parent().parent().prev().children().children(".boardNo").html()); 
				  $.ajax({
					  url : "<c:url value='/boardmanagementdelete'/>",
					  type : "post",
					  async : false,
					  data : {
						  bmselect : $("#bmselect option:selected").val(),
						  bno : btnDeleteValue
					  },
					  dataType : "json",
					  success : function (data) {
						  console.log("업데이트 ajax 리턴확인");
							if (data.result == -1) {
								alert("게시글이 삭제되지 않았습니다.");	
							}else {
								alert("게시글이 삭제되었습니다.");
							}
						
					},error : function (request, status, error) {
						alert("code:"+request.status+"\n"+"message:"+request.responseText+
								"\n"+"error:"+error);
					}
					  
				  
				  		});
				
			}else{
				return;
			}
			
			
			
				});
			

	});
 
	

		
 

		//현재 문제가 no가 특정되서 ajax로 보내지지 않는다.
	</script>
	<script>

	</script>
 
</head>
<body>

	<header>
	<div id="logo"><a href="./"><img src="./image/ex1.png"></a></div>
	<nav id="highmenu" class="topmenu">
	    <ul>
        <li><a href="./search?">상점</a></li>
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
        <li><a href="./faq">지원</a></li>
        <li id="textboxli">
        	<!-- todo 링크는 jstl을 이용해 txt박스의 값을 적어구문작성 -->
        	<form action="./search?" method="get">
        	<input type="text" id="textSearchGame" name="q">
        	<button type="submit" id="btnSearchGame"></button>
        	</form>
        	
        </li>
    	</ul>
	</nav>
		<nav id="topmenu_tnb">
		<ul>
	    <c:choose>
		<c:when test="${voList == null }">
			<script>
				location.href="./";
			</script>
		</c:when>
        <c:when test="${voList != null }">
	        	${voList.mm_id }님
        </c:when>
    	</c:choose>
	        <li><a href="./myinfo">마이페이지</a></li>
	        <li><a href="./cartlist">장바구니</a></li>
		</ul>     
		</nav>
	</header>
	
	<div id="promotion">
	
	
	
	</div>
	
	
	
    <div class="section">
	<div class="Asside-left">
			<ul>
				<li><a href="#">내 정보</a></li>
				<li><a href="./adminmembers" id="liRedirect">회원</a></li>
				<li><a href="./boardmanagement">FAQ</a></li>
			</ul>
	</div>
    <div class="Article">
    <!-- 페이지의 메인 아티클 -->

<div class="Article">
<h1> 게시판 관리 </h1>
<hr>
<div id="select">
	
	<select id="bmselect" name="bmselect" ">
		<option value="fb">자유게시판(회원)</option>
		<option value="gdb">개발사게시판</option>
		<option value="tipb">팁게시판</option>
		<option value="ntb">공지사항게시판</option>
		<option value="faqb">지원게시판</option>
	</select>
	<button type="button" id="btnBoardView">조회</button>
	
</div>



	

<div class="Board-list">
<!--  jstl을 이용해 ajax를 거친 데이터를 테이블로 보이게한다. -->
	<table id="listTable" style="border: 1px solid black; background-color: gainsboro">

	</table>
	<!-- 페이지 확인은 일단 보류
	<c:if test="${startPage >1 }"> 이전 </c:if>
		<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<a href="boardmanagement?pagenum=${i}">${i}</a>
		</c:forEach>
	<c:if test="${endPage < pageCount }"> 다음 </c:if>
	 -->
</div>

<div class="Board-Article">

	
	
</div>
<div id="btnBoardWriteBox">

</div>

</div>

		
    </div>
    </div>

	<footer>
    INDIMOA ｜ 사업자등록번호 : 821-85-00000 ｜ 서울 강남 제2020-01호 ｜ 대표자 : 홍길동 ｜ 책임자 : 홍길동 ｜  개인정보관리책임자 : 홍길동<br><br>
        Copyright © 2020-2021 INDIMOA GAME SHOPPING MALL
	</footer>
	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
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

<div hidden="">돋보기아이콘 제작자 <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></div>


</body>
</html>