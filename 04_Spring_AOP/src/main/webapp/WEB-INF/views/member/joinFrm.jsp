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
	<h1>회원가입</h1>
	<hr>
	<form action="join.do">
		<fieldset>
			<legend>가입정보</legend>
			아이디 : <input type="text" name="memberId" placeholder="아이디 입력">
			<span id="idChk"></span><br>
			비밀번호 : <input type="password" name="memberPw" placeholder="비밀번호 입력"><br>
			이름 : <input type="text" name="memberName" placeholder="이름 입력"><br>
			전화번호 : <input type="text" name="phone" placeholder="010-1234-5678"><br>
			이메일 : <input type="text" name="email" placeholder="email@mail.com"><br>
			<input type="submit" value="회원가입">
		</fieldset>
	</form>
	<h3><a href="/">메인페이지</a></h3>
</body>
<script>
	$("[name=memberId]").on("change",function(){
		const memberId = $(this).val();
		$.ajax({
			url: "/idCheck.do",
			data: {memberId:memberId},
			success: function(data){
				console.log(data)
				if(data == "0"){
					$("#idChk").text("사용가능한 아이디 입니다.");
					$("#idChk").css("color","green");
				}else{
					$("#idChk").text("이미 사용중인 아이디 입니다.");
					$("#idChk").css("color","red");
				}
			}
		});
	});
</script>
</html>