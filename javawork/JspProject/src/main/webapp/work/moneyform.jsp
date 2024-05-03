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
        .addmoney{
        
        }
    </style>
</head>
<script type="text/javascript">

		$(function() {
			let depsit;
			let withdraw;
			let foodexpen;
			let fixedexpen;
			let transportexpen;
			let medicalexpen;
			let rason;
			let onereason;
			let count=0;
			deposit=$("#deposit").val();
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
				foodexpentf = $(".foodexpen").is(":checked");
				fixedexpentf = $(".fixedexpen").is(":checked");
				transportexpentf = $(".transportexpen").is(":checked");
				medicalexpentf = $(".medicalexpen").is(":checked");
				unextf = $(".unex").is(":checked");
				if (foodexpentf == true) {
					foodexpen = $(".foodexpen").val();
					onreason=foodexpen;
				}
				if (fixedexpentf == true) {
					fixedexpen = $(".fixedexpen").val();
					onereason = fixedexpen;
				}
				if (transportexpentf == true) {
					transportexpen = $(".transportexpen").val();
					onereason = transportexpen;
				}
				if (medicalexpentf == true) {
					medicalexpen = $(".medicalexpen").val();
					onereason = medicalexpen;
				}
				if (unextf == true) {
					reason = $("#addmoneytext").val();
					onereason = reason;
				}
				count++;
				deposit=$("#deposit").val();
				withdraw=$("#withdraw").val();
				
				
				
				$(".aa").append(
						`<tr>
							<th>\${count}.</th>
								<td>입금</td>
								<td>+\${deposit}</td>
								<td>출금(\${onereason})</td>
								<td>-\${withdraw}</td>
						</tr>
						`)
			$("#deposit").val('');
			$("#withdraw").val('');
			
			})
		})
	</script>
<body>
	<form action="moneyaction.jap">

		<table>
			<caption align="top"><h3>기록</h3></caption>
			
			<tr>
				<td>입금액
					<input type="number" class="form-control" id="deposit" value="0" min="0" step="1000">
				</td>
			</tr>
			<tr>
				<td>출금액
				
					<input type="number" class="form-control" id="withdraw" value="0" min="0" step="1000">
					<button type="button" id="addbtn" class="btn btn-outline-secondary">추가하기</button>
				</td>
				
					<td>
					<div class="addmoney" style="display: none">
						<label><input type="radio" name="addmoneycont" id="addmoneycont" class="foodexpen form-check-input" value="식비" checked>식비</label>						
						<label><input type="radio" name="addmoneycont"  id="addmoneycont" class="fixedexpen form-check-input" value="고정지출">고정지출</label>
						<label><input type="radio" name="addmoneycont"  id="addmoneycont" class="transportexpen form-check-input" value="교통비">교통비</label>
						<label><input type="radio" name="addmoneycont"  id="addmoneycont" class="medicalexpen form-check-input" value="의료비">의료비</label>
						<label><input type="radio" name="addmoneycont"  id="addmoneycont" class="unex form-check-input" >예상외 지출</label>
						<input type="text" id="addmoneytext" class="form-control" placeholder="지출 내용 입력">
					</div>
						<button type="button" class="btn btn-outline-secondary" name="addlist" id="addlist">확인</button>
					
					</td>
					</table>
	
					<table class="table table-striped aa" style="width: 500px; border: 1px solid gray">
						<caption align="top">추가내역</caption>
					
					</table>			
					<button type="submit" class="btn btn-outline-secondary">통장내역보기</button>
	
	
</form>	
</body>
</html>