<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<h1>여기는 ex5번의 forward1파일입니다.</h1>
<!-- 
redirect: 1. url 주소 바뀜 2. response, request 가 새로생성 (reqeust를 통해 데이터를 못보냄)
forward: 1. url 주소가 안바뀜 2. response, request 가 새로 생성 안됨(request를 통해 데이터를 보낼수 있음)
 -->
 <%
 //reques에  List 데이터를 저장해보자
 List <String >list=Arrays.asList("벤츠","아우디","BMW","현대");
 request.setAttribute("list", list);
 %>
<jsp:forward page="./ex5_forward2.jsp"/>
</body>
</html>