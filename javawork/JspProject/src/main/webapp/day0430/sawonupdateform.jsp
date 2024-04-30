<%@page import="data.dto.SawonDto"%>
<%@page import="data.dao.SawonDao"%>
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
        	left: 340px;
        	top: 250px;
        	width: 150px;
        	border: 2px solid gray;
        }
    </style>
    <%
    int num=Integer.parseInt(request.getParameter("num"));
    
    SawonDao dao=new SawonDao();
    
    SawonDto dto=dao.getData(num);
    %>
</head>
<body>
<div style="margin:  20px ;width: 300px ">
<form action="./sawonupdate.jsp" method="post">
<input type="hidden" name="num" value="<%=num%>">;
	<table class="table table-bordered">
		<caption align="top">
			<h5 class="alert alert-warning">사원정보 수정</h5>
		</caption>
		<tr>
			<th width="100" class="table-danger">사원명</th>
			<td>
				<input type="text" name="name" class="form-control" required="required" autofocus="autofocus"  value="<%=dto.getName()%>">
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">나이</th>
			<td>
				<input type="number" name="age" class="form-control" required="required" min="1" max="100" step="1" value="<%=dto.getAge()%>">
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">주소</th>
			<td>
				<input type="text" name="addr" class="form-control" required="required"  value="<%=dto.getAddr()%>">
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">부서</th>
			<td>
				<select class="form-select" name="buseo"  >
					<option <%=dto.getBuseo().equals("교육부")?"selected":""%>>교육부</option>
					<option <%=dto.getBuseo().equals("인사부")?"selected":""%>>인사부</option>
					<option <%=dto.getBuseo().equals("홍보부")?"selected":""%>>홍보부</option>
					<option <%=dto.getBuseo().equals("해외파견부")?"selected":""%>>해외파견부</option>
				</select>
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">성별</th>
			<td>
				<label>
					<input type="radio" name="gender" value="남자" checked="<%=dto.getGender().equals("남자")?"checked":""%>" > 남자
				</label>
				<label>
					<input type="radio" name="gender" value="여자" checked="<%=dto.getGender().equals("여자")?"checked":""%>" >여자
				</label>
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">프로필사진</th>
			<td>
				<img src="<%=dto.getPhoto()%>" class="photo" onerror="this.src='../image/noimage2.png'" >

				<select name="photo" id="photo" class="form-select">
					<option value="no">프로필사진 없음</option>
				<%
					for(int i=1;i<=20;i++){
					String v="../image/"+i+"."+"jpg";
					
					if(v.equals(dto.getPhoto())){
				%>		<option value="<%=v%>" selected>프로필사진<%=i%></option>
				<%}
				else{%>
				<option value="<%=v%>">프로필사진<%=i%></option>
					<%
					} 
				}%>
				
				</select>
				<script type="text/javascript">
					$("#photo").change(function(){
						let noimage="../image/noimage2.png";
						let src=$(this).val();
						if(src=="no"){
							$(".photo").attr("src",noimage);
						}else
						$(".photo").attr("src",src);
					});
				</script>
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">생년월일</th>
			<td>
				<input type="date" name="birthday" class="form-control"  value="<%=dto.getBirthday()%>">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button  class="btn btn-outline-secondary btn-sm" style="width: 80px" type="submit">사원저장</button>
				
			</td>		
		</tr>
	</table>
</form>
</div>
</body>
</html>