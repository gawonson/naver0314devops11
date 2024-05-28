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
<c:if test="${sessionScope.loginok==null }">
	<script type="text/javascript">
		alert("먼저 로그인 후 글을 작성해주세요");
		history.back();
	</script>
	 
</c:if>
<body>
<form action="./insert" method="post" enctype="multipart/form-data">
<input type="hidden" name="num" value="${num }">
<input type="hidden" name="regroup" value="${regroup }">
<input type="hidden" name="restep" value="${restep }">
<input type="hidden" name="relevel" value="${relevel }">
<input type="hidden" name="currentPage" value="${currentPage }">

	<table class="table table-boardered" style="width: 400px">
		<caption align="top">
			<h4><b>${num==0?"새글쓰기":"답글쓰기" }</b></h4>
		</caption>
		<tr>
			<th  class="table table-boardered" style="width: 100px">제목</th>
			<td>
				<input type="text" name="subject"  style="width: 300px" required="required" value="${subject }" class="form-control">
			</td>
		</tr>
		<tr>
			<th width="100" class="table table-boardered">사진</th>
			<td>
				<input type="file" name="upload" id="upload"  class="form-control">
			</td>
		</tr>
		<tr>
			
			<td colspan="2">
				<textarea name="content" required="required" style="width: 100%; height: 150px;" placeholder="내용을 입력하세요"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-secondary" style="width: 100px">글 저장</button>
				
				<button type="button" class="btn btn-secondary" style="width: 100px" onclick="history.back()">이전으로</button>
			</td>
		</tr>
	</table>
	<div style="position:absolute; top: 100px; left: 430px ; border: 2px solid gray">
		<img src="../image/noimage2.png" id="showimg1" style="width: 200px"
			onerror="../image/noimage2.png">
	</div>
</form>
	
	<script>
        $(function(){
            $("#upload").change(function(){

                // console.log($(this)[0]);//type이 file인경우 배열타입으로 넘어온다
                let reg=/(.*?)\/(jpg|jpeg|png|gif)$/;
                let f=$(this)[0].files[0]
                if(!f.type.match(reg)){
                    alert("이미지파일만 가능합니다")
                    return;
                }
                if(f){
                    let reader=new FileReader();
                    reader.onload=function(e){
                        $("#showimg1").attr("src",e.target.result);
                    }
                
               reader.readAsDataURL($(this)[0].files[0]);
                }
            })
        })
        function preview(tag){
            if(tag.files[0]){
                let reg=/(.*?)\/(jpg|jpeg|png|gif)$/;
                let f=tag.files[0];
                if(!f.type.match(reg)){
                    //if(!f.type.match("img.*")){//도 가능
                    alert("이미지파일만 가능합니다")
                    return;
                }
                if(f){
                    let reader=new FileReader();  
                    reader.onload=function(e){
                        $("#showimg1").attr("src",e.target.result);
                    }
                
             reader.readAsDataURL(tag.files[0]);
                }
            }
        }
    </script>
</body>
</html>
