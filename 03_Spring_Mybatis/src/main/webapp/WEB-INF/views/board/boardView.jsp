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
	<h1>[${b.boardTitle }] 상세조회</h1>
	<hr>
	<table border="1">
		<tr>
			<th style="width: 10%;">글번호</th>
			<td style="width: 20%;">${b.boardNo }</td>
			<th style="width: 10%;">제목</th>
			<td style="width: 60%;">${b.boardTitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${b.boardWriter }</td>
			<th>작성일</th>
			<td>${b.boardDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
			<c:forEach items="${b.fileList }" var="f">
				<p>
					<a href="#">${f.filename }</a>
				</p>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				${b.boardContent }
			</td>
		</tr>
	</table>
</body>
</html>