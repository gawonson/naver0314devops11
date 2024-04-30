<%@page import="data.dao.SawonDao"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.SawonDto"%>
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
        .table {
        	border: 2px solid gray;
        	width: 400px;
        	height: 200px;
        }
    </style>
    
</head>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	SawonDao dao=new SawonDao();
	SawonDto dto=dao.getData(num);
%>
<body>
	<table class="table table-bordered">
		<caption align="top" style="text-align: center"><%=dto.getName()%>사원</caption>
		<tr>
			<td rowspan="5">
				<img src='<%=dto.getPhoto().equals("no")?"../image/noimage2.png":dto.getPhoto()%>' style="width: 200px ; height: 200px">
			</td>
			<td>부서 : <%=dto.getBuseo() %></td>
		</tr>
		<tr>
			<td>나이 : <%=dto.getAge() %></td>
		</tr>
		<tr>
			<td>주소 : <%=dto.getAddr() %></td>
		</tr>
		<tr>
			<td>성별 : <%=dto.getGender() %></td>
		</tr>
		<tr>
			<td>입사일 : <%=dto.getBirthday() %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-sm btn-warning" style="width: 80px" onclick="location.href='sawonform.jsp'">사원추가</button>
				<button type="button" class="btn btn-sm btn-warning" style="width: 80px" onclick="location.href='sawonlist.jsp'">사원목록</button>
				<button type="button" class="btn btn-sm btn-warning" style="width: 80px" onclick="location.href='sawonupdateform.jsp?num=<%=dto.getNum()%>'">정보수정</button>
				<button type="button" id="delsawon" class="btn btn-sm btn-warning" 
				style="width: 80px" num="<%=dto.getNum() %>" 
				sawonname="<%=dto.getName()%>">사원삭제</button>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		$("#delsawon").click(function(){
			let name=$(this).attr("sawonname");
			let num=$(this).attr("num");
			let ok=confirm(`\${name} 사원정보를 삭제할까요?`);
			if(ok){
				location.href="sawondelete.jsp?num="+num;
			}
		});
	</script>
</body>
</html>