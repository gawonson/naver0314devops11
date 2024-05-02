<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dao.StudentDao"%>
<%@page import="data.dto.StudentDto"%>
<%@page import="data.dao.ShopDao"%>
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
        .table{
        	margin: 20px 20px 20px
        }
        .table td{
        	text-align: center
        }
        .table th{
        	text-align: center
        }
    </style>
     <script type="text/javascript">
		$("#delstu").click(function(){
			let name=$(this).attr("sname");
			let num=$(this).attr("num");
			console.log("d");
			let a=confirm(`\${name} 학생정보를 삭제할까요?`)
			if(a){
				location.href="delete.jsp?num="+num;
			}
		})
		
	</script>
    
</head>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	StudentDao dao=new StudentDao ();
	StudentDto dto=dao.getData(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일 mm분ss초");
	int sum=dto.getJava()+dto.getSpring()+dto.getHtml();
	double avg=sum/3.0;
	NumberFormat nf=NumberFormat.getInstance();
	nf.setMaximumFractionDigits(2);
%>
<body>
<div style="width: 100%; height: 100%">
<form action="./updateform.jsp">
 <table class="table table-striped" style="width: 350px ;height: 350px; border: 3px solid gray">
 	<caption align="top" style="text-align: center"><h3><b><%=dto.getName() %>님의 상세정보</b></h3> </caption>
 	<tr>
 		<th class="table-warning">등록일</th>
 		<td><%=sdf.format(dto.getWriteday()) %></td>
 	</tr>
 	<tr>
 		<th class="table-warning">이름</th>
 		<td><%=dto.getName() %></td>
 	</tr>
 	<tr>
 		<th class="table-warning">혈액형</th>
 		<td><%=dto.getBlood()%>형</td>
 	</tr>
 	<tr>
 		<th class="table-warning">운전면허</th>
 		<td> <%
				if(dto.getLicense()=='y'){
					%>있음<%
				}else{
					%>없음<%
				}
	%> </td>
 	</tr>
 	<tr>
 		<th class="table-warning">자바점수</th>
 		<td><%=dto.getJava() %>점</td>
 	</tr>
 	<tr>
 		<th class="table-warning">스프링점수</th>
 		<td><%=dto.getSpring() %>점</td>
 	</tr>
 	<tr>
 		<th class="table-warning">html점수</th>
 		<td><%=dto.getHtml()%>점</td>
 	</tr>
 	<tr>
 		<th class="table-warning">총 점</th>
 		<td><%=sum %>점</td>
 	</tr>
 	<tr>
 		<th class="table-warning">평균</th>
 		<td><%=nf.format(avg)%>점</td>
 	</tr>
 	<tr>
 		<td colspan="2">
 <button class="btn btn-outline-danger" onclick="location.href='./list.jsp'" style="margin-left: 20px">리스토로 이동</button>
 <button class="btn btn-outline-danger" onclick="location.href='./writeform.jsp'" >추가하기</button>
 <button type="button" class="btn btn-outline-danger" onclick="location.href='./updateform.jsp?num='+<%=dto.getNum()%>">수정하기</button>
 <button class="btn btn-outline-danger" id="delstu" num="<%=dto.getNum()%>" sname="<%=dto.getName()%>">삭제하기</button>
 		</td>
 	</tr>
 </table>
 </form> 
 </div>
</body>
</html>