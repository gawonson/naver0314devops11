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
	
	ul.menu {
		list-style: none;
		margin-left: 10%;
	}
	
	ul.menu li {
		float: left;
		width: 120px;
		font-size: 22px;
		border-top-left-radius: 8px;
		border-top-right-radius: 8px;
		text-align: center;
		margin-right: 10px;
	}
	
	ul.menu li:hover {
		box-shadow: 0px 2px 0px #3f63bf;
		background-color: rgba(0, 0, 0, 0.01);
	}
	
	ul.menu li:hover a {
		color: #3f63bf;
	}
	
	ul.menu li a:hover {
		text-decoration: none;
	}
	div.loginarea{
		position: fixed;
		right: 50px;
		top:100px;
		}
	div.loginarea button{
	width: 100px;
	}
</style>
<c:set var="root" value="<%=request.getContextPath() %>" />
<script type="text/javascript">
	$(function(){
		$("#loginfrm").submit(function(e){
			//기본이벤트 무효화
			e.preventDefault();
			//폼 안의 입력값 읽기
			let fdata=$(this).serialize();
			//alert(fdata);
			$.ajax({
				type:"get",
				dataType:"json",
				url:`${root}/member/login`,
				data:fdata,
				success:function(data){
					if(data.status=='success'){
						//페이지 새로고침
						location.reload();
						
					}else{
						alert("아이디 또는 비밀번호가 맞지않습니다.")
					}
				}
			})
			
		})
		//로그아웃번튼
		$("#btnlogout").click(function(){
			$.ajax({
				type:"get",
				dataType:"text",
				url:`${root}/member/logout`,
				success:function(){
					//전체페이지 새로고침
					location.reload();
				}
			})
		})
	})
</script>
</head>
<body>
<!-- The Modal -->
<div class="modal" id="myLoginModal">
  <div class="modal-dialog madal-sm">
  <form id="loginfrm">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원 로그인</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      
       		<table class="table table-bordered">
       		<caption align="top">
       			<label><input type="checkbox" name="saveid" 
       			${sessionScope.saveid==null or sessionScope.saveid=='no'?"":"checked" }>&nbsp;아이디 저장</label>
       		</caption>
       			<tr>
       				<th class="table-success" width="80" >아이디</th>
       				<td>
       					<input type="text" name="myid" class="form-control" required="required"
       					value="${sessionScope.saveid!=null and sessionScope.saveid=='yes'?sessionScope.loginid:'' }">
       				</td>
       			</tr>
       			<tr>
       				<th class="table-success" width="80">비밀번호</th>
       				<td>
       					<input type="password" name="pass" id="pass" class="form-control" required="required">
       				</td>
       			</tr>
       		</table>
       	
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="submit" class="btn btn-outline-danger">로그인</button>
        <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal" id="btnclose" >닫기</button>
      </div>

    </div>
    </form>
  </div>
</div>

	
	<ul class="menu">
		<li><a href="${root }/">홈</a> &nbsp;</li>
		<li><a href="${root }/member/list">회원 목록</a>&nbsp;</li>
		<li><a href="${root }/member/form">회원등록</a></li>
		<li><a href="${root }/board/list">게시판</a>&nbsp;</li>
		<li><a href="${root }/guest/list">방명록</a>&nbsp;</li>
	</ul>
	<div class="loginarea">
		<c:if test="${sessionScope.loginok==null }">
			<button type="button" id="btnlogin" class="btn btn-lg btn-outline-success" data-bs-toggle="modal" data-bs-target="#myLoginModal">로그인</button>
		</c:if>
		<c:if test="${sessionScope.loginok!=null }">
			<b style="font-size: 20px;">
				${sessionScope.loginid }님
			</b>
			<button type="button" id="btnlogout" class="btn btn-lg btn-outline-success" style="margin-left: 20px">로그아웃</button>
		</c:if>
	</div>
</body>
</html>
