<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인증메일 전송</h1>
	<hr>
	<form action="/sendMail.do" method="post">
		<input type="text" name="email" placeholder="이메일주소 입력">
		<input type="button" value="전송">
	</form>
</body>
</html>