<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디찾기</h2>
	<hr>
	<h2>비밀번호찾기</h2>
	<form action="/searchPw.do" method="post">
		아이디 : <input type="text" name="memberId"><br>
		이메일 : <input type="text" name="email"><br>
		<input type="submit" value="비밀번호찾기">
	</form>
</body>
</html>