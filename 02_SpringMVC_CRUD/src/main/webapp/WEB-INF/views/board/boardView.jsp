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
	<h1>게시글상세조회</h1>
	<hr>
	<c:if test="${sessionScope.m.memberId eq b.boardWriter }">
		<button type="button"><a href="/updateBoardFrm.do?boardNo=${b.boardNo }">수정</a></button>
		<button type="button"><a href="/deleteBoard.do?boardNo=${b.boardNo }">삭제</a></button>
		<hr>
	</c:if>
	<table style="width: 600px" border=5>
		<tr>
			<th style="width: 20%">제목</th>
			<td colspan="3" style="width: 80%">${b.boardTitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td style="width: 30%">${b.boardWriter }</td>
			<th style="width: 15%">작성일</th>
			<td style="width: 35%">${b.boardDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
			<c:forEach items="${b.fileList}" var="f">
				<a href="/boardFileDown.do?fileNo=${f.fileNo}">${f.filename}</a>
				<br>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="4">${b.boardContent }</td>
		</tr>
	</table>
	<hr>
	<button type="button"><a href="/boardList.do">게시판으로 이동</a></button>
</body>
</html>