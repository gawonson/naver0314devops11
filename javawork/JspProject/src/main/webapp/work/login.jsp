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
        form{
        	position: absolute;
			left: 50%;
			top: 50%;
			transform:translate(-50%,-50%);
        }
    </style>
</head>
<body>

<form action="./loginaction.jsp" method="post">

	<table class="table table-bordered" style="width: 400px">
		<caption align="top" style="text-align:center; "><img  src="../image/pig1.png" style="width: 100px; height: 100px; margin-right: 30px"><label><h3><b>용돈기입장</b></h3></label></caption>
		<tr>
			<th width="100" class="table-success">이름</th>
			<td>
				<input type="text" name="myid" class="form-control" value="">
			</td>
		</tr>
		<tr>
			<th width="100" class="table-success">비밀번호</th>
			<td>
				<input type="password" name="mypass" class="form-control">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-outline-danger">회원 로그인 </button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>