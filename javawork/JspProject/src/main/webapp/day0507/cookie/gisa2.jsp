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
		[뉴스데스크]
		◀ 앵커 ▶
		
		매달 수십만 원씩 지급되던 기초연금이 올해 대폭 감액되면서 관계 기관에 민원이 빗발치고 있습니다.
		
		지난해 크게 오른 금융권 이자가 기초연금 삭감의 이유가 된 건데요.
		
		이자율이 이례적으로 많이 오른 만큼 연금도 많이 줄었는데요.
		
		아예 지급 중지를 통보받은 경우도 있습니다.
		
		이주연 기자입니다.
		
		◀ 리포트 ▶
		
		4월은 상반기 기초연금 정기조사가 실시되는 달입니다.
		
		1인당 최고 33만 원가량 지급되던 기초연금의 감액이나 중단 등의 통보가 이뤄집니다.
		
		이 시기에는 구청마다 빗발치는 민원 전화에 골머리를 앓고 있습니다.
		
		[구청 관계자 (음성변조)]
		"저희가 지금 (민원이) 굉장히 많이 들어오고 있어요. 지금 계속해서 야근을 하면서까지 통보를 해드리고 있어요."
		
		매년 변동 사항이 발생하곤 했지만, 올해는 유독 더 많습니다.
		
		주된 이유는 바로 금융권의 이자율 상승입니다.
		
		지난해 이자율이 최고 6%까지 치솟으면서 예년과 비교해 이자를 2배가량 많이 받게 됐고, 이에 따른 소득 증가분이 올해 반영됐기 때문입니다.
		
		전주시에서 기초연금을 지급받는 대상자는 7만 2천여 명으로 노인 인구의 64% 수준입니다.
		
		지난달부터 진행된 조사에서 한 달간 1,389명이 급여 감소를 통지받았습니다.
		
		또 313명은 아예 급여 중지를 통지받았는데, 6월 말까지 2달간의 조사가 더 진행되면 그 수는 더 늘어날 전망입니다.
		
		[구청 관계자 (음성변조)]
		"올해는 기초연금 대상자들이 많이 (기초연금) 소득이 감소하고 그러더라고요. 이자 소득이 많이 발생했어요. 그래서 이자 소득 때문에…"
		
		부동산 공시가격이 오르거나 금융 재산이 증가하는 경우에도 지급 변동이 일어날 수 있지만, 올해는 이자율 변동이 가장 큰 요인이 됐습니다.
		
		보건복지부는 물가 상승을 반영한 꾸준한 기준 확대로 복지 혜택을 줄이지는 않았다는 입장입니다.
		
		만 65세 이상 노인 단독가구의 소득 기준이 지난해 월 202만 원에서 올해는 213만 원 이하로 높아져 기준 금액이 3.6% 상승한 것도 사실입니다.
		
		하지만 이자율 급상승으로 연금이 감액되는 노인들이 적지 않아 파장이 커지는 가운데, 기존 하위 70% 이하에서 50% 이하로 지급 대상을 축소하는 방안이 검토되면서 또 다른 변화를 예고했습니다.
		
		MBC뉴스 이주연입니다.
		
		영상취재: 강미이/전주
	</pre>
	
<%}else{%>
	<script type="text/javascript">
		alert("먼저 암호를 입력해주세요");
		history.back();
	</script>
<%}%>

</body>
</html>