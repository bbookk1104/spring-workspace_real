<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	ul{
		margin: 20px;
		padding: 0;
	}
	li{
		list-style-type: none;
	}
	input[type=text], input[type=password]{
		width: 250px;
		height: 30px;
		margin: 10px 0px 10px 0px;
		border: 0;
		border-bottom: 1px solid #396EB0;
		font-size: 16px;
	}
	input:focus{
		outline: 0;
		color: #396EB0;
		font-weight: bold;
	}
	input[type=submit]{
		margin-top: 15px;
		width:250px;
		height:50px;
		border: 1px solid #000;
		background-color: #fff;
		font-size: 18px;
	}
	input[type=submit]:hover{
		cursor: pointer;
		border-color: #396EB0;
		background-color: #396EB0;
		color: #fff;
		font-weight: bold;
		transition: 0.5s;
	}
	fieldset{
		width: 300px;
		position: relative;
	}
	fieldset>legend{
		color: #396EB0;
		font-weight: 900;
		font-size: 20px;
		text-align: center;
	}
</style>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="/login.do" method="post">
	<fieldset>
		<legend>LOGIN</legend>
		<ul>
			<li><input type="text" name="memberId" placeholder="아이디 입력"></li>
			<li><input type="password" name="memberPw" placeholder="비밀번호 입력"></li>
			<li><input type="submit" value="로그인">
		</ul>
	</fieldset>
	</form>
</body>
</html>