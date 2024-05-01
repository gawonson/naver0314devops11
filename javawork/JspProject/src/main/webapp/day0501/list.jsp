<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.StudentDao"%>
<%@page import="data.dto.StudentDto"%>
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
      .table-danger{
      	text-align: center;
      }
      td{
      text-align: center;
      }
    </style>
</head>
<%
StudentDao dao=new StudentDao();
List<StudentDto> list=dao.getAllStudent();

SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");

%>
<body>
<table class="table table-striped" style="width: 300px; height: 300px; border: 3px solid gray">
	<caption align="top" style="text-align: center"><h3><b>학생정보</b></h3></caption>
	<tr>
	<th class="table-danger">이름</th>
	<th class="table-danger">등록일</th>
	<th class="table-danger">상세보기</th>
	</tr>
	<%
		for(StudentDto dto:list){
			%>
			<tr>
				<td><%=dto.getName() %></td>
				<td><%=sdf.format(dto.getWriteday())%></td>
				<td style="text-align: center">
					<button class="btn btn-outline-warning" onclick="location.href='./detail.jsp?num=<%=dto.getNum()%>'" >상세보기</button>
				</td>
			</tr>
			<%}%>
			
	<tr>
		<td colspan="3" style="text-align: center">
			<button class="btn btn-outline-danger" onclick="location.href='./writeform.jsp'">학생정보 추가</button>
		</td>
	</tr>
</table>
</body>
</html>