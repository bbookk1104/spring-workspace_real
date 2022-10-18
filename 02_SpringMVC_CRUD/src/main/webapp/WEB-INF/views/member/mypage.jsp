<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<form action="/update.do" method="post">
		<fieldset>
			<legend>회원정보수정</legend>
			회원번호 : <input type="text" name="memberNo" value="${sessionScope.m.memberNo }" disabled><br>
			아이디 : <input type="text" name="memberId" value="${sessionScope.m.memberId }" readonly><br>
			비밀번호 : <input type="text" name="memberPw" value="${sessionScope.m.memberPw }"><br>
			이름 : <input type="text" name="memberName" value="${sessionScope.m.memberName }" disabled><br>
			전화번호 : <input type="text" name="phone" value="${sessionScope.m.phone }"><br>
			이메일 : <input type="text" name="email" value="${sessionScope.m.email }"><br>
			<input type="submit" value="정보수정"><br>
			<a href="/">메인페이지로 이동</a>
		</fieldset>
	</form>
</body>
</html>