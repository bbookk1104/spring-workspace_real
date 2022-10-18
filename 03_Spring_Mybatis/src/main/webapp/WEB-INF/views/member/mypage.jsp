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
	<fieldset>
		<legend>내 정보</legend>
		<form action="/updateMember.do" method="post">
			<input type="hidden" name="memberId" value="${sessionScope.m.memberId }">
			회원번호 : <input type="text" value="${sessionScope.m.memberNo }" disabled><br>
			아이디 : <input type="text" value="${sessionScope.m.memberId }" disabled><br>
			비밀번호 : <input type="text" name="memberPw" value="${sessionScope.m.memberPw }"><br>
			이름 : <input type="text" value="${sessionScope.m.memberName }" disabled><br>
			전화번호 : <input type="text" name="phone" value="${sessionScope.m.phone }"><br>
			이메일 : <input type="text" name="email" value="${sessionScope.m.email }"><br>
			<input type="submit" value="수정하기">
		</form>
	</fieldset>
	<h3><a href="/">메인페이지</a></h3>
</body>
</html>