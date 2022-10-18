<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<a href="/boardWriteFrm.do">게시글 작성</a>
	</c:if>
	<table border="1">
		<thead>
			<tr>
				<th style="width: 10%;">번호</th>
				<th style="width: 55%;">제목</th>
				<th style="width: 10%;">작성자</th>
				<th style="width: 15%;">등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ bList}" var="b" varStatus="i">
				<tr>
					<th>${(reqPage-1)*numPerPage+i.count }</th>
					<td><a href="/boardView.do?boardNo=${b.boardNo }">${b.boardTitle }</a></td>
					<td>${b.boardWriter }</td>
					<td>${b.boardDate }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="4">${pageNavi }</th>
			</tr>
		</tfoot>
	</table>
	<h3><a href="/">메인페이지</a></h3>
</body>
</html>