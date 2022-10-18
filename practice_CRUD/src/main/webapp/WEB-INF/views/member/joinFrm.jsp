<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
		width:200px;
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
	label{
		display: inline-block;
		width: 80px;
		height: 30px;
		color: #396EB0;
		font-weight: 900;
	}
	fieldset{
		width: 400px;
		position: relative;
	}
	fieldset>legend{
		color: #396EB0;
		font-weight: 900;
		font-size: 20px;
		text-align: center;
	}
	fieldset>span{
		position: absolute;
		right: 10px;
		font-size: 12px;
	}
	.require{
		color: red;
		font-size: 16px;
	}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="/join.do" method="post">
		<fieldset>
			<legend>회원정보 입력</legend>
			<span><span class="require">*</span>표시는 필수입력정보 입니다</span>
			<ul>
				<li>
					<label for="id">아이디<span class="require">*</span></label>
					<input type="text" name="memberId" id="id" placeholder="coronaki11" autocomplete="off" required>
				</li>
				<li>
					<label for="pw">비밀번호<span class="require">*</span></label>
					<input type="password" name="memberPw" id="pw" placeholder="c0r0nakill" autocomplete="off" required>
				</li>
				<li>
					<label for="name">이름<span class="require">*</span></label>
					<input type="text" name="memberName" id="name" placeholder="김덕팔" autocomplete="off" required>
				</li>
				<li>
					<label for="nickname">닉네임</label>
					<input type="text" name="nickname" id="nickname" placeholder="zㅣ존킹왕짱v" autocomplete="off" required>
				</li>
				<li>
					<label for="phone">전화번호</label>
					<input type="text" name="memberPhone" id="phone" placeholder="010-XXXX-XXXX" autocomplete="off">
				</li>
				<li>
					<label for="addr">주소</label>
					<input type="text" name="memberAddr" id="addr" placeholder="경기도 군포시 산본동" autocomplete="off">
				</li>
				<li style="text-align: center;"><input type="submit" value="가입하기"></li>
			</ul>
		</fieldset>
	</form>
</body>
</html>