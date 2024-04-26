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
<%
request.setCharacterEncoding("utf-8");
String menuname=request.getParameter("menuname");
String photo=request.getParameter("foodphoto");
String grade=request.getParameter("grade");
String member=request.getParameter("member");
%>
메뉴명 : <%=menuname %><br>
<%String arr[]=photo.split(",");%>
음식사진 : <img src="<%=arr[0] %>" style="width:100px; height:100px"><br>
가격 : <%=arr[1] %><br>
만족도 : <%=grade %><br>
회원 등급 : <%if(member==null){%>일반회원<%}else{%>우수회원<%}%>
</body>
</html>