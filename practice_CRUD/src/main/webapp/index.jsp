<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자가격리4일째</title>
<style>
	button{
		width: 190px;
		height: 50px;
		padding: 0px;
		border: 1px solid #000;
		background-color: #fff;
	}
	button>a{
		font-size: 25px;
		display: block;
		width: 100%;
		line-height: 46px;
	}
	a{
		text-decoration: none;
		color: #000;
	}
	button:hover{
		cursor: pointer;
		border-color: #5CB8E4;
		background-color: #5CB8E4;
		transition: 0.5s;
	}
	button:hover>a{
		color: #fff;
	}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.m }">
			<h1>코로나코로스 (ง •̀_•́)ง </h1>
			<hr>
			<button type="button"><a href="/joinFrm.do">회원가입</a></button>
			<button type="button"><a href="/loginFrm.do">로그인</a></button>
		</c:when>
		<c:otherwise>
			<h1><span style="color:#5CB8E4">${sessionScope.m.nickname }</span>님, 환영합니다 </h1>
			<hr>
			<button type="button"><a href="/mypage.do">마이페이지</a></button>
			<button type="button"><a onclick="contirmMsg('로그아웃');">로그아웃</a></button>
		</c:otherwise>
	</c:choose>
	<hr>
	<h2><a href="https://www.bbc.com/korean/features-62488296">필수상식</a></h2>
	<h2><a href="/boardList.do">자유게시판</a></h2>
</body>
<script>
	function contirmMsg(str)  {
		let msg = confirm(str+" 하시겠습니까?");
		if(msg){
			location.href="/logout.do";
		}
	}
</script>
</html>