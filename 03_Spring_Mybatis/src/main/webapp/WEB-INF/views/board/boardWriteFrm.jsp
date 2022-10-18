<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<hr>
	<form action="/boardWrite.do" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th><label for="boardTitle">제목</label></th>
			<td colspan="3"><input type="text" name="boardTitle" id="boardTitle"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="boardWriter" value="${sessionScope.m.memberId }" readonly></td>
			<th>첨부파일</th>
			<td><input type="file" name="boardFile" multiple></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea name="boardContent"></textarea></td>
		</tr>
		<tr>
			<td colspan="4"><input type="submit" value="글쓰기"></td>
		</tr>
	</table>
	</form>
</body>
</html>