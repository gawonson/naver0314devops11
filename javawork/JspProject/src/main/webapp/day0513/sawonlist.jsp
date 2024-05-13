<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
        rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
</head>
<body>
<h5 class="alert alert-success">비트캠프 사원 목록</h5>
<form action="../bitcamp/sawon" method="post">
<fmt:requestEncoding value="utf-8"/>
	<b>부서명입력</b>
	<input type="text" width="120" name="search" value="${param.search}">
	<button type="submit" class="btn btn-outline-success">찾기</button>
</form>
<hr>
<h2>${param.search} 부서직원검색결과</h2>
<table class="table table-striped" style="width: 500px ;">
	<tr>
		<th  width="50">번호</th>
		<th  width="50">사진</th>
		<th  width="100">사원명</th>
		<th  width="100">부서명</th>
		<th  width="50">나이</th>
		<th>생일</th>
	</tr>
	<c:forEach var="a" items="${list}" varStatus="i">
	<c:if test="${param.search==a.buseo || param.search==''}">
		<tr>
			<td>${i.count}</td>
			<td >
				<c:if test="${a.photo=='no'}">
					<img src="../image/noimage.png" style="width:50px">
				</c:if>
				<c:if test="${a.photo!='no'}">
					<img src="${a.photo}" style="width:50px">
				</c:if>
			</td>
			<td>${a.name}</td>
			<td>${a.buseo}</td>
			<td>${a.age}세</td>
			<td>${a.birthday}</td>
		</tr>
	</c:if>
	</c:forEach>
</table>
</body>
</html>