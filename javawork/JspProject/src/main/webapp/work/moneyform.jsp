<%@page import="data.dto.moneyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'Jua';
}

#result {
	width: 800px;
	height: 500px;
	display: none;
}

.resultview {
	text-align: center;
	alignt-center;
}

.resultviewtable {
	margin-left: px
}

.writeform {
	margin-left: 400px;
	position:relative;
	
}

#addlist {
	margin-left: 30px
}

.resultview {
	float: left;
}
.aa{
	position: absolute;
	left:1000px;
	
	top:50px;

}
.bottom{
width:1525px;
background-color:#e5e5e5;
border-radius: 30px;
}


</style>
</head>
<body>
	<div class="resultview">
		
		<button type="button" class="btn btn-outline-secondary" id="storage">통장내역보기</button>

		<!-- 통장내역 표시할 div -->
		<div id="result"  style="background-color:#999999; border-radius:30px"></div>
		<table class="table table-striped aa" style="width: 300px; border: 1px solid gray; display: none" >
			<caption align="top" >추가내역</caption>
		</table>

<div class="bottom">
	<table class="writeform">
		<caption align="top" style="text-align: center">
			<h3>기록</h3>
		</caption>

		<tr>
			<td  >입금액 <input type="number" name="deposit"
				class="form-control" id="deposit" value="0" min="0" step="1000"></td>
			<td>출금액 <input type="number" class="form-control"
				name="withdraw" id="withdraw" value="0" min="0" step="1000"></td>
			<td><button type="button" class="btn btn-outline-secondary"
					name="addlist" id="addlist" style="margin-top:20px">확인</button></td>
					<td>
				<div class="addmoney" style="display: none">
					<label><input type="radio" name="addmoneycont"
						id="addmoneycont" class="foodexpen form-check-input" value="식비">식비</label>
					<label><input type="radio" name="addmoneycont"
						id="addmoneycont" class="fixedexpen form-check-input" value="고정지출">고정지출</label>
					<label><input type="radio" name="addmoneycont"
						id="addmoneycont" class="transportexpen form-check-input"
						value="교통비">교통비</label> <label><input type="radio"
						name="addmoneycont" id="addmoneycont"
						class="medicalexpen form-check-input" value="의료비">의료비</label> <label><input
						type="radio" name="addmoneycont" id="addmoneycont"
						class="unex form-check-input">예상외 지출</label> <input type="text"
						id="addmoneytext" class="form-control" placeholder="지출 내용 입력">
				</div>

			</td>
		<tr>
			<td></td>
			<td><button type="button" id="addbtn"
					class="btn btn-outline-secondary">출금 사유 추가하기</button></td>
			<td></td>
		
			
		</tr>
	</table>
	</div>
	</div>

	<script type="text/javascript">


	$(function() {
		
		let totfoodexpen=0;
		let totfixedexpen=0;
		let tottranspotexpen=0;
		let totmedicalexpen=0;
		let totunexpected=0;
		let totdeposit=0;
		let totwithdraw=0;
	
		let deposit;
		let withdraw;
		let foodexpen;
		let fixedexpen;
		let transportexpen;
		let medicalexpen;
		let rason;
		let onereason;
		let count=0;
	

	//출금액 적고 추가하기 누르면 .addmoney 나오게하기
	$("#addbtn").click(function() {
		if ($("#withdraw").val() == 0) 
		{
			alert("지출을 입력하세요");
		} 
		else {
			$("#addmoneytext").hide();
			$(".addmoney").slideDown('fast');
			}
	})
	//예상외 지출 $unexeppen을 누르면 지출내용 #addmoneytext 입력 창 나옴
	$(".addmoney").change(function() {

			let a = $(".unex").is(":checked");
			if (a) {
				$("#addmoneytext").slideDown();
			} else {
				$("#addmoneytext").slideUp();
			}
		})
	//.addmoney적고 확인 누르면 .addmoneylist 나오게해서 tr추가	
	$("#addlist").click(function() {
			count++;
		
			deposit=$("#deposit").val();
			withdraw=$("#withdraw").val();
			foodexpentf = $(".foodexpen").is(":checked");
			fixedexpentf = $(".fixedexpen").is(":checked");
			transportexpentf = $(".transportexpen").is(":checked");
			medicalexpentf = $(".medicalexpen").is(":checked");
			unextf = $(".unex").is(":checked");
			if (foodexpentf == true) {
				foodexpen = $(".foodexpen").val();
				onreason=foodexpen;
				totfoodexpen+=Number(withdraw);
				localStorage.setItem("food",totfoodexpen);
			}
			if (fixedexpentf == true) {
				fixedexpen = $(".fixedexpen").val();
				onereason = fixedexpen;
				totfixedexpen+=Number(withdraw);
				localStorage.setItem("fixed",totfixedexpen);

			}
			if (transportexpentf == true) {
				transportexpen = $(".transportexpen").val();
				onereason = transportexpen;
				tottranspotexpen+=Number(withdraw);
				localStorage.setItem("trans",tottranspotexpen);

			}
			if (medicalexpentf == true) {
				medicalexpen = $(".medicalexpen").val();
				onereason = medicalexpen;
				totmedicalexpen+=Number(withdraw);
				localStorage.setItem("medi",totmedicalexpen);

			}
			if (unextf == true) {
				reason = $("#addmoneytext").val();
				onereason = reason;
				totunexpected+=Number(withdraw);
				
				localStorage.setItem("unex",totunexpected);

			}
			
			
			
			
			$(".aa").slideDown('slow');
			$(".aa").append(
					`<tr>
						<th>\${count}.</th>
							<td>입금</td>
							<td>+\${deposit}</td>
							<td>출금(\${onereason})</td>
							<td>-\${withdraw}</td>
					</tr>
					`)
					
		//중첩 더하기
		
		
		totdeposit+=Number(deposit);
		totwithdraw+=Number(withdraw);
		//로컬스토리지에 저장
		localStorage.setItem("dp",totdeposit);
		localStorage.setItem("wd",totwithdraw);
		
		$("#deposit").val('');
		$("#withdraw").val('');
		
		})
		
		 $("#storage").click(function() {
			 $("#result").slideDown('slow');
		        // localStorage에서 저장된 값들 가져오기
		        let lodeposit = parseFloat(localStorage.getItem("dp")) || 0;
		        let lowithdraw = parseFloat(localStorage.getItem("wd")) || 0;
		        let lofoodexpen = parseFloat(localStorage.getItem("food")) || 0;
		        let lofixedexpen = parseFloat(localStorage.getItem("fixed")) || 0;
		        let lotranspotexpen = parseFloat(localStorage.getItem("trans")) || 0;
		        let lomedicalexpen = parseFloat(localStorage.getItem("medi")) || 0;
		        let lounexpected = parseFloat(localStorage.getItem("unex")) || 0;
				let total=Number(lodeposit)-Number(lowithdraw);
		        // 새로운 div에 추가할 HTML 템플릿 생성
		        let tableHtml = `
		            <table class="table table-striped resultviewtable"  style="border: 1px solid gray;">
		                <caption align="top" style="text-align:center"><h3><b>ㅇㅇㅇ님의 통장</h3></b></caption>
		             
		                <tr >
		                    <td >입금액</td>
		                    <td>+\${lodeposit}</td>
		                </tr>
		                <tr>
		                    <td>식비</td>
		                    <td>-\${lofoodexpen}</td>
		                </tr>
		                <tr>
		                    <td>고정지출</td>
		                    <td>-\${lofixedexpen}</td>
		                </tr>
		                <tr>
		                    <td>교통비</td>
		                    <td>-\${lotranspotexpen}</td>
		                </tr>
		                <tr>
		                    <td>의료비</td>
		                    <td>-\${lomedicalexpen}</td>
		                </tr>
		                <tr>
		                    <td>예상외 지출</td>
		                    <td>-\${lounexpected}</td>
		                </tr>
		                <tr>
		                    <td>총 출금액</td>
		                    <td>-\${lowithdraw}</td>
		                </tr>
		                <tr >
	                    <td style="color:red; font-size:30px">현재 잔고</td>
	                    <td style="color:red; font-size:30px">\${total}</td>
	                </tr>
		            </table>
		        `;

		        // 새로운 div에 생성한 테이블 HTML 추가
		        $("#result").html(tableHtml);
		    });
			
	})
	
		
	</script>
</body>
</html>