<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h5 class="alert alert-danger">JSTL 공부 #1</h5>
<h6>일단 서블릿에서 저장한 request 변수 읽어오기</h6>
<h6>메세지 : ${message}, ${requestScope.message}</h6><!-- requestScope. 은 생략가능 -->
<h6>날짜 : ${today}</h6>
<h6>숫자1 : ${num1 }</h6>
<h6>숫자2 : ${num2 }</h6>
<hr>
<h3>JSTL 의 연산자</h3>
<h5>더하기 : ${num1 + num2 }</h5>
<h5>빼기 : ${num1 - num2 }</h5>
<h5>곱하기 : ${num1 * num2 }</h5>
<h5>나누기 : ${num1 / num2 }</h5>
<h5>영문 div를 이용한 나누기 : ${num1 div num2}</h5>
<h5>나머지 : ${num1 % num2 }</h5>
<h5>영문 mod를 이용한 나머지 : ${num1 mod num2}</h5>
<hr>
<h5>간단한 if 문(JSTL에는 else가 없음 따라서 두 경우 모두 if로 해주어야함)</h5>
<c:if test="${num1>num2 }">
	<h4>숫자 1이 숫자 2보다 더 큽니다.</h4>
</c:if>
<c:if test="${num1<num2 }">
	<h4>숫자 1이 숫자 2보다 더 작습니다.</h4>
</c:if>
<hr>
<h6> jsp 에서 직접 JSTL로 변수선언을 하고자 할 경우</h6>
<c:set var="name" value="이영자"/>
<c:set var="age" value="19"/>
<h5>이름 : ${name }</h5>
<h5>나이 : ${age }</h5>

</body>
</html>