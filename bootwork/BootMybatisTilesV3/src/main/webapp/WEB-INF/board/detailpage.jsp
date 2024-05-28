<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}
th, td {
  padding: 15px;
}
</style>
<script type="text/javascript">
	$(function(){
		$("#btndelete").click(function(){
			let a=confirm("삭제하시겠습니까?")
			if(a){
				location.href="./delete?num="+${dto.num}+"&currentPage="+${currentPage};
				
			}
		})
	})
	</script>
</head>
<body>
	<div align="center">
		<table class="" style="width: 600px; height:500px; border: 1px solid #C0C0C0; padding: 5px 5px 5px" >
			<caption align="top"></caption>
			<tr>
				<th colspan="3" valign="middle"
					style="text-align: left; "><h1>
						${dto.subject }
					</h1></th>
			</tr>
			<tr >
				<td rowspan="2">
				<img src="../save/${profile_photo }"
					class="rounded-circle" style="width: 50px; border: 1px solid #C0C0C0">
				</td>
				<td><b>${dto.writer }</b></td>
				<td rowspan="2" style="color: gray"><i class="bi bi-chat-dots"
					style="color: gray; text-align: right"></i>&nbsp;댓글${dto.restep}&nbsp;URL복사</td>
			</tr>
			<tr>
				<td style="color: gray"  style="height: 10px">${dto.writeday }&nbsp;조회&nbsp;${dto.readcount }</td>
			</tr>
			<tr>
				<td colspan="3"
					style="height: 300px; border-top: 1px solid #C0C0C0; border-bottom: 1px solid #C0C0C0">
					<c:if test="${dto.uploadphoto!='no' }">
						<img src="../save/${dto.uploadphoto}" style="height: 150px;">
						<br>
						<br>
						<br>
					</c:if> ${dto.content }
				</td>
			</tr>
			<tr>
				<td colspan="3">
				<div style="">
					<button type="button" onclick="location.href='./form'"
						class="btn btn-success">
						<i class="bi bi-pencil"></i>&nbsp;글쓰기
					</button>
					<button type="button" class="btn btn-secondary" 
					onclick="location.href='./form?currentPage=${currentPage}&restep=${dto.restep }&regroup=${dto.regroup }&num=${dto.num }&relevel=${dto.relevel }'">답글</button>
					<button type="button"
						onclick="location.href='./list?currentPage=${currentPage}'"
						class="btn btn-secondary">목록으로</button> <c:if
						test="${sessionScope.loginid==dto.myid }">
						<button type="button" class="btn btn-secondary" onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
						<button type="button" class="btn btn-secondary" id="btndelete">삭제</button>
					</c:if>
					</div>
				</td>
			</tr>
		</table>
		
	</div>
	
</body>
</html>
