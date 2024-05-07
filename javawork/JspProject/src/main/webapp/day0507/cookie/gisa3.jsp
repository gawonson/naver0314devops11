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
		
		김건희 여사의 명품백 수수 의혹을 수사하고 있는 검찰 수사팀 내에서 윤석열 대통령의 법 위반 여부를 확인해야 한다는 의견이 나온 것으로 파악됐습니다.
		
		청탁금지법에는 배우자가 공직자의 직무와 관련해 부적절한 금품을 받았을 경우, 그 공직자는 금품제공자의 인적 사항과 금품의 종류와 가격, 반환 여부 등을 세세하게 적어서 기관장에게 제출하도록 돼 있습니다.
		
		윤 대통령은 본인이 기관장인 만큼 신고서를 제출할 필요가 없다는 의견과, 법에 명시된 대로 작성해서 제출했어야 한다는 의견이 수사팀 내부에서 엇갈리고 있는 겁니다.
		
		정상빈 기자가 보도합니다.
		
		◀ 리포트 ▶
		
		김건희 여사의 명품 가방 수수 의혹.
		
		청탁금지법은 배우자가 공직자의 직무와 관련해 1백만 원 넘는 금품을 받은 사실을 안 경우 공직자가 소속기관장에게 지체없이 서면으로 신고하도록 하고 있습니다.
		
		서면 신고 의무를 어기면 3년 이하 징역 또는 3천만 원 이하 벌금형에 처해집니다.
		
		이번 사건의 경우 공직자는 윤 대통령, 소속기관장도 윤 대통령입니다.
		
		윤 대통령이 자신에게 서면으로 신고해야하는 셈입니다.
		
		수사팀 안에서는 해석이 엇갈린 것으로 알려졌습니다.
		
		윤 대통령이 신고받는 기관장이라 서면 신고 여부를 따지는 게 필요 없다는 의견과 법 조항대로 서면 신고를 반드시 해야 한다는 의견이 함께 나온 것으로 파악됐습니다.
		
		수사팀 사정을 잘 아는 검찰 간부는 "윤 대통령이 신고서를 써서 보관하고 있어야 한다는 수사팀 검토가 있었다"면서 "그게 죄형 법정주의에 맞는다는 얘기"라고 했습니다.
		
		청탁금지법은 신고서에 써야할 내용도 세세하게 정해놓고 있습니다.
		
		금품을 준 사람의 성명, 연락처, 직업 등 인적사항과, 금품의 종류와 가액, 금품 반환 여부도 적어야 합니다.
		
		명품 가방을 건넨 최재영 목사의 이름과 연락처, 디올백의 가격, 반환 여부도 기록으로 남겨둬야 한다는 얘기입니다.
		
		수사팀 판단이 서면 신고가 있어야 한다는 쪽으로 기운다면, 수사는 윤 대통령을 겨냥할 수도 있는 겁니다.
		
		윤 대통령은 이 사건을 정치공작으로 보고 있습니다.
		
		[윤석열 대통령/KBS 특별대담 (올해2월)]
		"선거를 앞둔 시점 1년 전 일을 터뜨리는 것 자체가 정치 공작이라 볼 수밖에‥"
		
		하지만 김 여사의 명품백 수수 사실을 언제 알았는지, 서면 신고는 남겼는지, 가방을 어떻게 처리했는지 윤 대통령 본인이 구체적으로 밝힌 적은 없습니다.
		
		MBC뉴스 정상빈입니다.
		
		영상편집 : 이정근
				
	</pre>
	
<%}else{%>
	<script type="text/javascript">
		alert("먼저 암호를 입력해주세요");
		history.back();
	</script>
<%}%>
</body>
</html>