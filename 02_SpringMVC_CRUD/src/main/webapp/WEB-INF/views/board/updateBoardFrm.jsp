<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>게시글수정</h1>
	<hr>
	<form action="/updateBoard.do" id="updateFrm" method="post" enctype="multipart/form-data">
	<table style="width: 600px" border=5>
		<tr>
			<input type="hidden" name="boardNo" value="${b.boardNo }">
			<th style="width: 20%">제목</th>
			<td colspan="3" style="width: 80%">
				<input type="text" name="boardTitle" value="${b.boardTitle }" style="border:0; width:98.5%;">
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td style="width: 30%">${b.boardWriter }</td>
			<th style="width: 15%">작성일</th>
			<td style="width: 35%">${b.boardDate }</td>
		</tr>
		<tr>
			<th>첨부파일 추가</th>
			<td colspan="3"><input type="file" name="boardFile" multiple></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
			<c:forEach items="${b.fileList}" var="f">
				<p>${f.filename }
				<button type="button" onclick="deleteFile(this,${f.fileNo},'${f.filepath }');">삭제</button>
				<!-- 실제서버에 업로드된 파일삭제(filepath로), db데이터삭제(fileno로) -->
				</p>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="4"><textarea name="boardContent" style="border:0; width:99.5%; resize:none; height:200px">${b.boardContent }</textarea></td>
		</tr>
		<tr>
			<td colspan="4"><input type="submit" value="수정하기" style="border:0; width:100%; height:50px"></td>
		</tr>
	</table>
	</form>
	<hr>
	<button type="button"><a href="/boardList.do">게시판으로 이동</a></button>
	<script>
		function deleteFile(obj,fileNo,filepath){
			const fileNoInput = $("<input>");
			fileNoInput.attr("name","fileNoList");
			fileNoInput.val(fileNo);
			fileNoInput.hide();
			//<input type="text" name="fileNoList" value="fileNo">
			const filepathInput = $("<input>");
			filepathInput.attr("name","filepathList");
			filepathInput.val(filepath);
			filepathInput.hide();
			//<input type="text" name="filepathList" value="filepath">
			$("#updateFrm").append(fileNoInput).append(filepathInput);
			$(obj).parent().remove();
		}
	</script>
</body>
</html>