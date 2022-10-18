<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체아이디목록</h1>
	<hr>
	<form action="/searchMember3.do" method="post">
	<fieldset>
		<legend>아이디 선택</legend>
		<c:forEach items="${list }" var="memberId">
			<input type="checkbox" name="memberId" value="${memberId }" id="${memberId }">
			<label for="${memberId }">${memberId }</label>
		</c:forEach>
		<input type="submit" value="회원 조회">
	</fieldset>
	</form>
	
</body>
</html>