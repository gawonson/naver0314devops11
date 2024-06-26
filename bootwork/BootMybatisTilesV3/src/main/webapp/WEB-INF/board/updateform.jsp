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
   <c:set var="stpath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"/>
</head>
<c:if test="${sessionScope.loginok==null }">
	<script type="text/javascript">
		alert("먼저 로그인 후 글을 작성해주세요");
		history.back();
	</script>
	 
</c:if>
<body>
<form action="./update" method="post" enctype="multipart/form-data">
<input type="hidden" name="num" value="${dto.num }">
<input type="hidden" name="currentPage" value="${currentPage }">

	<table class="table table-boardered" style="width: 400px">
		<caption align="top">
			<h4><b>글수정</b></h4>
		</caption>
		<tr>
			<th  class="table table-warning" style="width: 100px">제목</th>
			<td>
				<input type="text" name="subject"  style="width: 300px" required="required" value="${dto.subject }" class="form-control">
			</td>
		</tr>
		<tr>
			<th width="100" class="table table-warning">사진</th>
			<td>
			<b>사진을 선택하지 않으면 기존사진이 유지됩니다</b><br>
				<input type="file" name="upload" id="upload"  class="form-control">
			</td>
		</tr>
		<tr>
			
			<td colspan="2">
				<textarea name="content" required="required" style="width: 100%; height: 150px;" placeholder="내용을 입력하세요">${dto.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-secondary" style="width: 100px">글 수정</button>
				
				<button type="button" class="btn btn-secondary" style="width: 100px" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
			</td>
		</tr>
	</table>
	<div style="position:absolute; top: 100px; left: 430px ; border: 2px solid gray">
		<img src="${stpath }/${dto.uploadphoto }" id="showimg1" style="width: 200px"
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
