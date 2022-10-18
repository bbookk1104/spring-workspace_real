<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input:focus, textarea:focus{
		outline:0;
	}
</style>
</head>
<body>
	<h1>게시글 작성</h1>
	<hr>
	<form action="/boardWrite.do" method="post">
		<table style="width:600px" border=5>
			<tr>
				<th style="width:10%">제목</th>
				<td style="width:55%">
					<input type="text" name="boardTitle" style="border:0; width:98.5%;">
				</td>
				<th style="width:15%">작성자</th>
				<td style="width:20%">
					<input type="text" name="boardWriter" value="${memberId }" style="border:0; width:97%;" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea name="boardContent" style="border:0; width:99.5%; resize:none; height:200px"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="작성하기" style="border:0; width:100%; height:50px">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>