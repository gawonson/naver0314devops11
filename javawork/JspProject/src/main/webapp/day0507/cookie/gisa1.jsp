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
    </style>
</head>
<% 
	//amho라는 쿠키가 있으면 true 없으면 false
	boolean findAmho=false;
	Cookie []cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie ck:cookies){
			String name=ck.getName();
			if(name.equals("amho")){
				findAmho=true;
				break;
			}
		}
	}%>

<body>

<%if(findAmho){%>
	<pre>
		가수 겸 배우 아이유(30)가 어린이날을 맞아 어린이 재단에 1억원을 기부한 가운데 서울의 한 아동양육시설에 후원한 사실이 뒤늦게 전해졌다.
		
		지난 6일 온라인 커뮤니티와 소셜미디어(SNS) 등에는 ‘보육원 아이들에게 아웃백 쏜 아이유’라는 제목의 글이 올라왔다.
		
		해당 글에는 서울 성동구에 위치한 아동복지시설 ‘이든아이빌’ 측이 지난 5일 공식 인스타그램에 쓴 사연이 캡처돼 있었다.
		
		이든아이빌 측은 “오늘은 가수 아이유님의 후원으로 아웃백스테이크하우스에서 저녁 식사를 했다”며 “아이들에게는 최고의 어린이날이었다”고 밝혔다.
		
		공개된 사진에는 해당 프랜차이즈 음식점에서 식사를 하는 아이들의 모습이 담겼다.
		
		이든아이빌은 1950년에 개원한 아동복지 시설로, 18세 이하 보호가 필요한 아동들이 건강한 사회인으로 성장해 자립할 수 있게 안정적인 보금자리를 제공하고 있다.
		
		아이유는 데뷔 이래 어린이날과 성탄절 등 각종 계기마다 기부 등 선행을 이어왔다.
		
		올해 어린이날 당일에도 초록우산 어린이재단에 자신의 예명과 팬덤 ‘유애나’를 합친 ‘아이유애나’라는 후원자명으로 1억원을 쾌척했다.
		
		아이유 소속사 이담엔터테인먼트는 “모든 어린이들이 사랑받으며 건강한 어른으로 자라기를”이라며 “아이유애나가 올봄에도 응원을 보낸다”고 전했다.
		
		아이유는 지난해 5월 16일 자신의 생일에도 사랑의 달팽이, 한국미혼모가족협회 등에 총 2억1000만원을 기부했으며, 같은 해 12월 31일에는 아이유애나의 이름으로 한국노인종합복지관협회, 한국아동복지협회, 한국미혼모협회, 한국장애인복지시설협회까지 총 4곳에 난방비 2억원을 기부했다.
		
		이번 기부를 비롯해 현재까지 누적 기부금만 총 48억원이 넘는 것으로 알려졌다.
	</pre>
	
<%}else{%>
	<script type="text/javascript">
		alert("먼저 암호를 입력해주세요");
		history.back();
	</script>
<%}%>

</body>
</html>