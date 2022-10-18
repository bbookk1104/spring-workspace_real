<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판</h1>
	<hr>
	<c:if test="${not empty sessionScope.m }">
		<a href="/boardWriteFrm.do?memberId=${sessionScope.m.memberId}">글쓰기</a>
		<a href="/boardWriteFrm2.do?memberId=${sessionScope.m.memberId}">글쓰기(파일첨부)</a>
		<hr>
	</c:if>
	<table style="width:600px; text-align: center;">
		<tr>
			<th style="width:10%">No.</th>
			<th style="width:50%">제목</th>
			<th style="width:20%">작성자</th>
			<th style="width:20%">작성일</th>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td>${b.boardNo}</td>
				<td>
					<a href="/boardView.do?boardNo=${b.boardNo}">${b.boardTitle}</a>
				</td>
				<td>${b.boardWriter}</td>
				<td>${b.boardDate}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="/">메인페이지로 돌아가기</a>
</body>
</html>