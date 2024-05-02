<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'Jua';
}

.view {
	font-style: italic;
	color: red;
	
}


</style>

</head>
<body>
	<div>
		<h3 style="text-align: center; font-size: 50px; margin-top: 60px">
			<b>사용방법</b>
		</h3>
		<table class="table"
			style="width: 100%; height: 100%; border-color: white">

			<tr>
				<td colspan="2" align="center"><br>
				<br>
					<h3 style="cursor: pointer; text-decoration: underline" onclick="location.href='writeform.jsp'" >학생
						등록 방법</h3>
					<br>
				<br> 해당 메뉴를 선택시 <b class="view">다양한 방법으로</b> 학생의 이름을 등록할 수
					있습니다.<br> <b class="view">로그인시</b> 해당 데이터는 보관되며 언제든지 사용가능합니다.<br>
					학생 등록 방법은 이름을 직접 등록하는 방법과 ","로 나뉜 학생의 명단을 입력하는 방법이 있습니다.<br>
				<br>
				<br></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><br>
				<br>
					<h3 onclick="location.href='function.jsp'" style="cursor: pointer; text-decoration: underline;">여러가지
						기능들</h3>
					<br>
				<br> <b class="view">떨어뜨리기 기능</b> : 명단에 등록된 두 학생을 <b
					class="view">붙어앉지 못하게</b> 결과를 재구성합니다. <br> <b class="view">줄
						정하기 기능</b> : 명단에 등록된 학생을 <b class="view">특정 줄에 배치하여</b> 결과를 재구성합니다. <br>
					<b class="view">기타 기능들</b> : 명단에 등록된 두 학생을 붙여 앉게 하거나 각 학생의 자리를 직접
					배치합니다. <br>
				<br>
				<br></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2">
				<img onclick="location.href='home.jsp'" class="icon" src="../image/icon1.png" style="cursor: pointer; width: 70px; height: 70px;">
				<td>
			</tr>
		</table>
	</div>
</body>
</html>