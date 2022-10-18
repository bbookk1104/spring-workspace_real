<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<link rel="stylesheet" href="/resources/css/dmCss.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h1>내 쪽지함</h1>
	<hr>
	<h3>쪽지보내기</h3>
	<p>받는사람, 내용 입력해서 전송하는 경우 ajax로 dm테이블에 insert</p>	
		<!-- 
		<fieldset>
			<input type="hidden" name="sender" value="${sessionScope.m.memberId }">
			<input type="text" name="receiver" id="receiver" placeholder="받는사람"><br>
			<textarea name="dmContent" placeholder="내용을 입력하세요."></textarea><br>
		</fieldset>
		 -->
		<input type="button" value="쪽지보내기" onclick="sendDmModal();">
	<hr>
	<h3>받은 쪽지함</h3>
	<table border="1" class="receiveDmTbl">
		<thead>
		<tr>
			<th>보낸사람</th>
			<th>쪽지내용</th>
			<th>받은시간</th>
			<th>읽음여부</th>
		</tr>
		</thead>
		<tbody id="receiveDmList"></tbody>
	</table>
	<hr>
	<h3>보낸 쪽지함</h3>
	<table border="1" class="sendDmTbl">
		<thead>
		<tr>
			<th>받은사람</th>
			<th>쪽지내용</th>
			<th>보낸시간</th>
			<th>읽음여부</th>
		</tr>
		</thead>
		<tbody id="sendDmList"></tbody>
	</table>
	<!-- 쪽지보내기 모달 -->
	<div id="sendDm-modal" class="modal-wrapper" style="display:none;">
		<div class="modal">
			<div class="modal-header">
				<h2>쪽지보내기</h2>
			</div>
			<hr>
			<div class="modal-content">
				<div class="sendDmFrm">
					<input type="hidden" name="sender" value="${sessionScope.m.memberId }">
					<label>수신자 : </label>
					<select name="receiver"></select>
					<textarea name="dmContent" placeholder="내용을 입력하세요."></textarea>
					<button onclick="dmSend();">전송</button>
					<button onclick="closeModal();">창닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 쪽지상세보기 모달 -->
	<div id="dmDetail" class="modal-wrapper" style="display:none;">
		<div class="modal">
			<div class="modal-header">
				<h2>쪽지내용</h2>
			</div>
			<hr>
			<div class="modal-content">
				<div class="dmFrm">
					<div>
						<span>발신자 : </span>
						<span id="detailSender"></span>
					</div>
					<div>
						<span>날짜 : </span>
						<span id="detailDate"></span>
					</div>
					<div id="detailContent"></div>
					<button onclick="replyDm();">답장</button>
					<button onclick="closeDetail();">창닫기</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/resources/js/dm.js"></script>
</html>