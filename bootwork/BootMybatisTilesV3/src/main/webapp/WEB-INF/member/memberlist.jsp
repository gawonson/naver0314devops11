<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Jua';
       }
       
   </style>
</head>
<body>
<h2 class="alert" style="background-color: #87CEEB"  style="width: 100%">총${totalCount }명의 회원이 있습니다. 
<span style="float: right;">
	<button type="button" class="btn btn-sm btn-warning" onclick="location.href='./form'">멤버등록</button>
</span></h2>
<h3 style="margin-left: 500px">회원 명단</h3>
<table class="table table-bordered" style="width: 100%">
	<tr>
		<th class="table-warning" style="background-color: #87CEEB">번호</th>
		<th class="table-warning" style="background-color: #87CEEB">회원명</th>
		<th class="table-warning" style="background-color: #87CEEB">아이디</th>
		<th class="table-warning" style="background-color: #87CEEB">핸드폰</th>
		<th class="table-warning" style="background-color: #87CEEB">상세보기</th>
	</tr>
	<c:forEach var="ele" items="${list }">
		<tr>
			<td>${ele.num }</td>
			<td>
				<img src="../save/${ele.photo }"  style="border: 1px solid black; border-radius: 30px; width: 30px ; height: 30px" onerror="this.src='../image/noimage2.png'">
				${ele.name }
			</td>
			<td>${ele.myid }</td>
			<td>${ele.hp }</td>
			<td>
				<button class="btn btn-sm btn-outline-warning" onclick="location.href='./detail?num=${ele.num}'">상세보기</button>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
