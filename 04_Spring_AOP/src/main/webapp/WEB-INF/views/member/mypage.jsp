<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<fieldset>
		<legend>내 정보</legend>
		<form action="/updateMember.do" method="post">
			<input type="hidden" name="memberId" value="${sessionScope.m.memberId }">
			회원번호 : <input type="text" value="${sessionScope.m.memberNo }" disabled><br>
			아이디 : <input type="text" value="${sessionScope.m.memberId }" disabled><br>
			<!-- 비밀번호 : <input type="password" name="memberPw" value="${sessionScope.m.memberPw }"><br> -->
			이름 : <input type="text" value="${sessionScope.m.memberName }" disabled><br>
			전화번호 : <input type="text" name="phone" value="${sessionScope.m.phone }"><br>
			이메일 : <input type="text" name="email" value="${sessionScope.m.email }"><br>
			<input type="submit" value="전화번호/이메일 변경" style="width:255px">
		</form>
		<button type="button" id="pwCheckFrmBtn" style="width:255px">비밀번호 변경</button>
		<div id="pwCheckFrm">
			<fieldset>
				<legend>현재 비밀번호</legend>
				<form action="/updatePwFrm.do" method="post">
					<input type="password" name="memberPw">
					<input type="button" value="입력" id="updatePwBtn"><br>
					<span id="pwChk"></span>
				</form>
			</fieldset>
		</div>
	</fieldset>
	<h3><a href="/">메인페이지</a></h3>
</body>
<script>
	//초기화면에서 숨겨놓은 후, 버튼누를 때마다 나타나거나 사라지는 토글효과
	$("#pwCheckFrm").hide();
	$("#pwCheckFrmBtn").on("click",function(){
		$("#pwCheckFrm").fadeToggle();
	});
	
	//비밀번호 입력칸에서 엔터누르면 submit되는거 방지
	$("[type=password]").keydown(function() {
		if (event.keyCode === 13) {
		event.preventDefault();
		};
	});
	
	//현재비밀번호 일치하는지 검사
	$("[name=memberPw]").on("change",function(){
		const memberPw = $(this).val();
		const memberId = $("[name=memberId]").val();
		$.ajax({
			url: "/pwCheck.do",
			data: {memberPw:memberPw, memberId:memberId},
			success: function(data){
				if(data==0){
					$("#pwChk").text("비밀번호가 일치하지 않습니다.");
					$("#pwChk").css("color","red");
					$("#updatePwBtn").attr("type","button");
				}else{
					$("#pwChk").text("비밀번호가 일치합니다. 변경하려면 입력버튼을 누르세요.");
					$("#pwChk").css("color","green");
					$("#updatePwBtn").attr("type","submit");
				}
			}
		});
	});
</script>
</html>