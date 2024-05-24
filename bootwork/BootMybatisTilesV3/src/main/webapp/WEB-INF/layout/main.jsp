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
<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
<div >
<img  src="${root }/food/pho1.jpeg" style="width: 100%; cursor: pointer" onclick="location.href='https://shopping.naver.com/festa/onsale/play/6639e924a5bc9350c5ac9533'" >
<img  src="${root }/food/pho2.jpeg" style="width: 100%; cursor: pointer" onclick="location.href='https://shopping.naver.com/festa/onsale/mfashion/662884b01bd78f7f91fbbac9'">
<img  src="${root }/food/pho3.jpeg" style="width: 100%; cursor: pointer" onclick="location.href='https://shopping.naver.com/festa/onsale/wfashion/663c4ab4a5bc9350c5ace753'">
</div>
<hr>
<br><br>
<div>
<pre style="color:gray">
코오롱위크 모바일 쿠폰 이벤트 유의사항
- 본 이벤트는 기간 내 (5/22~5/24) 코오롱위크 참여 브랜드의 대상 상품을 구매하신 고객 대상으로 자동 응모됩니다.
> 참여브랜드 : 럭키슈에뜨,이로, 에피그램, 레코드, 쿠론, 슈콤마보니, 마크제이콥스, 왁, 잭니클라우스, 골든베어, 엘로드
- 본 이벤트 당첨고객은 6/14(금) 발표 예정이며, 개별로 연락드릴 예정입니다. (안심번호는 제외 됩니다.)
- 본 이벤트는 자사의 사정에 따라 사전 고지 없이 변경 및 취소될 수 있습니다.</pre>
</div>

</body>
</html>
