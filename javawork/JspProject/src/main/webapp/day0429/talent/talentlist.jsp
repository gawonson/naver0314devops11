<%@page import="data.dto.TalentDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.TalentDao"%>
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
<%
	//dao 선언
	TalentDao dao=new TalentDao();
	//db에 등록된 상품 가져오기 dto를 list 형태로 가져오기(dao에 메서드 만들기)
	List <TalentDto> list=dao.getTalentDatas();
%>
<body>

	<h5 class="alert alert-danger"><b>총 <%=list.size() %>개의 상품이 있습니다.</b></h5>
	<table class="table table-bordered">
	
	</table>
</body>
</html>