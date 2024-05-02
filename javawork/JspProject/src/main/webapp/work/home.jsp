<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'Jua';
}
.main>li{
	float:left;
	display: block;
	width: 200px;
	height: 50px;
	font-size:25px;
	cursor: pointer;
	
}
.menu{
	margin-left:400px
}
#menuele2{
	list-style:none;
	font-size:18px;
	margin-top:10px;
}
.submenu{
	margin-top: 20px;
	padding-left: 0px;
}


</style>

</head>
<script>
$(function(){
	$(".submenu").hide();
	$("li.main").mouseover(function(){
		$(this).siblings("ul").slideDown('fast');
		$(this).parent().siblics('li').children('ul.submenu').slideUp('fast');
	})	
})
</script>
<body>
	<div class="menu">
		<ul style="background-color:red impo">
			<li onclick="location.href='./use.jsp'">사용 방법</li>
			<li id="menuele1" class="main" onclick="location.href='writeform.jsp'">학생 등록
				<ul class="submenu">
					<li id="menuele2">메모장으로 추가</li>
					<li id="menuele2">직접 입력</li>
					<li id="menuele2">데이터 불러오기</li>
				</ul>
			</li>
			<li id="menuele2" class="main" onclick="location.href='function.jsp'">기능 추가
				<ul class="submenu">
					<li id="menuele2">떨어뜨리기</li>
					<li id="menuele2">줄 정하기</li>
					<li id="menuele2">기타</li>
				</ul>
			</li>
			<li id="menuele">문의글</li>
		</ul>
	</div>
	<script type="text/javascript">

	</script>
</body>
</html>