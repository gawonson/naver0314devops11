<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
    </style>
</head>
<body>
<table class="table" style="width: 500px;height: 300px; margin-left: 10px ">


	<tr>
		<th colspan="2" style="text-align: center"><h3>${dto.subject }</h3></th>
	</tr>
	<tr style="border-bottom: white; ">
		<td style="color:gray">작성자 : ${dto.writer }</td>
		<td style="color:gray ; float: right">
			<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="color:gray;" >조회수 : ${dto.readcount }
			<b style="margin-left: 10px; color:gray;">추천 &nbsp; 
				<span class="chu">${dto.chu }&nbsp;</span>
					<i class="bi bi-hand-thumbs-up mychu" style="font-size: 20px ; cursor: pointer"></i>
				
			</b>
		</td>
		
	</tr>
	<tr>
		<td>
			<img src="../image/s${dto.avata }.JPG" style="border-radius: 500px; border: 2px solid gray">
		</td>
		<td style="text-align: center; white-space: pre-line; font-size: 20px "valign="middle">
			${dto.content }
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center">
			<button class="btn btn-success" onclick="location.href='./form'">글쓰기</button>
			<button class="btn btn-success" onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
			<button class="btn btn-success" onclick=del();>삭제</button>
			<button class="btn btn-success" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
		</td>
	</tr>
</table>
<script type="text/javascript">
	function del() {
		let num=${dto.num};
		let cp=${currentPage};
		
	let a=confirm("해당 게시글을 삭제하시겠습니까?");
	if(a){
		location.href=`./delete?num=\${num}&currentPage=\${cp}`;
	}
		
	}
	//chu 클릭시 숫자 증가
	$(".mychu").click(function(){
		let num=${dto.num};
		$.ajax({
			type:"get",
			dataType:"json",
			data:{"num":num},
			url:"./updatechu",
			success:function(data){
				$("span.chu").text(data.chu);
			}
		})
	})
</script>
</body>
</html>