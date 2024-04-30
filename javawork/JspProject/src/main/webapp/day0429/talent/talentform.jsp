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
          img.photo{
        	position: absolute;
        	left: 320px;
        	top: 100px;
        	width: 150px;
        	border: 3px solid gray;
        		
        }
    </style>
</head>
<body>
<form action="./talentaction.jsp" method="post">
<table class="table table-bordered" style="width: 300px; height: 100%; border: 3px solid gray">
	<caption align="top" >연예인 퀴이즈</caption>
	<tr>
		<th>이름</th>
			<td>
				<input type="text" id="tname" name="tname">
			</td>
	</tr>
	<tr>
		<th>나이</th>
			<td>
				<input type="number" max="50" min="20" id="tage" value="20" name="tage">세
			</td>
	</tr>
	<tr>
		<th>사진</th>
			<td>
				<select id="tphoto" name="tphoto">
				<%
					for(int i=1;i<=20;i++){
						%>
						<option value="../image/<%=i%>.jpg" >사진<%=i%>
						</option>
						<%
					}
				%>
				</select>
				<img src="../image/1.jpg" class="photo">
				<script type="text/javascript">
					//사진을 선택하면 이미지가 바뀌도록 이벤트 추가
					$("#tphoto").change(function(){
						$(".photo").attr("src",$(this).val());
					});
				</script>
			</td>
	</tr>
	<tr>
		<th>키</th>
			<td>
				<input type="text" id="theight" name="theight">cm
			</td>
	</tr>
	<tr>
		<th>고향</th>
			<td>
				<input type="text" id="thome" name="thome">
			</td>
	</tr>
	<tr>
		<th>팬 활동</th>
			<td>
				<select id="tfan" name="tfan">
				<option>유</option>
				<option>무</option>
				</select>
			</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
		<button type="submit" class="btn btn-outline-warning">db에 저장</button>
	</td>
	</tr>
</table>
</form>
</body>
</html>