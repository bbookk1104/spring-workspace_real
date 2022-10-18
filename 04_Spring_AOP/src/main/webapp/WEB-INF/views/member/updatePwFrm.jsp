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
	<h1>비밀번호 변경</h1>
	<hr>
	<fieldset>
		<legend>새 비밀번호 입력</legend>
		<form action="/updatePw.do" method="post">
			<input type="hidden" name="memberNo" value="${sessionScope.m.memberNo }">
			<input type="password" name="memberPw" placeholder="새 비밀번호">
			<!-- <input type="password" name="memberPwChk" placeholder="새 비밀번호 확인"><br> -->
			<input type="submit" value="비밀번호변경">
			<span id="pwChk"></span>
		</form>
	</fieldset>
</body>
</html>