<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}
ul.menu{
	list-style: none;
	margin-left: 10%; 
}

ul.menu li{
	float: left;
	width: 120px;
	font-size: 22px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	
	text-align: center;
	margin-right: 10px;
	
	
}
ul.menu li:hover{
	box-shadow: 0px 2px 0px #3f63bf;
	background-color: rgba(0,0,0,0.01);


}
ul.menu li:hover a{
	color: #3f63bf;

}
ul.menu li a:hover{
	text-decoration: none;

}

</style>

</head>
<body>
	<c:set var="root" value="<%=request.getContextPath() %>" />
	<ul class="menu">
		<li><a href="${root }/" >홈</a> &nbsp;</li>
		<li><a href="${root }/member/list">회원 목록</a>&nbsp;</li>
		<li><a href="${root }/member/form">회원등록</a></li>
		<li><a href="${root }/board/list">게시판</a>&nbsp;</li>
		<li><a href="${root }/guest/list">방명록</a>&nbsp;</li>
	</ul>
</body>
</html>
