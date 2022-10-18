<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<h1>05_Spring_WebSocket</h1>
	<c:choose>
		<c:when test="${empty sessionScope.m }">
			<form action="/login.do" method="post">
				<fieldset>
					<legend>로그인</legend>
					아이디 : <input type="text" name="memberId"><br>
					비밀번호 : <input type="password" name="memberPw"><br>
					<input type="submit" value="로그인">
				</fieldset>
			</form>
			<h3><a href="/joinFrm.do">회원가입</a></h3>
			<h3><a href="/searchIdPw.do">아이디/비밀번호찾기</a></h3>
			<hr>
			<form action="/searchMemberId.do">
				아이디 : <input type="text" name="memberId" placeholder="아이디 검색">
				<input type="submit" value="회원조회">
			</form>
			<hr>
			<h3><a href="/boardList.do?reqPage=1">게시판</a></h3>
		</c:when>
		<c:otherwise>
			<h2>[${sessionScope.m.memberName }]님, 안녕하세요.</h2>
			<jsp:include page="/WEB-INF/views/common/header.jsp"/>
			<hr>
			<h3><a href="/allMemberChat.do">전체채팅</a></h3>
			<h3><a href="/dmMain.do">쪽지함가기</a></h3>
			<h3><a href="/boardList.do?reqPage=1">게시판</a></h3>
			<hr>
			<h3><a href="/selectAllMember.do">전체회원조회</a></h3>
			<h3><a href="/logout.do">로그아웃</a></h3>
			<h3><a href="/mypage.do">마이페이지</a></h3>
			<h3><a onclick="deleteConfirm();">회원탈퇴</a></h3>
			<hr>
			<form action="/searchMemberId.do">
				아이디 : <input type="text" name="memberId" placeholder="아이디 검색">
				<input type="submit" value="회원조회">
			</form>
			<hr>
			<form action="/searchMemberName.do">
				이름 : <input type="text" name="memberName" placeholder="이름 검색">
				<input type="submit" value="회원조회">
			</form>
			<hr>
			<form action="/searchMember1.do" method="post">
				<select name="type">
					<option value="id">아이디</option>
					<option value="name">이름</option>
				</select>
				<input type="text" name="keyword" placeholder="검색옵션 선택">
				<input type="submit" value="회원조회">
			</form>
			<hr>
			<h3>아이디 or 이름으로 검색</h3>
			<p>아이디만 입력하고 검색하는 경우 아이디로 조회, 이름만 입력하고 검색하는 경우 이름으로 조회,
			둘다 입력하고 검색하는 경우 두개 and로 조회</p>
			<form action="/searchMember2.do" method="post">
				<input type="text" name="memberId" placeholder="아이디 입력"><br>
				<input type="text" name="memberName" placeholder="이름 입력"><br>
				<input type="submit" value="회원조회" style="width:177px">
			</form>
			<hr>
			<h3><a href="/idList.do">전체회원 아이디 목록</a></h3>
			<hr>
			<h3><a href="/searchMember4.do">회원번호 10 미만인 회원조회</a></h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<button id="allMemberAjax">전체회원조회(AJAX)</button>
	<div id="ajaxResult"></div>
	<hr>
	<div id="visitorList"></div>
</body>
<script>
	$("#allMemberAjax").on("click",function(){
		$.ajax({
			url : "/ajaxAllMember.do",
			success : function(data){
				const table = $("<fieldset><legend>회원목록</legend><table>");
				const titleTr = $("<tr>");
				titleTr.html("<th style='width:10%;'>번호</th><th style='width:25%;'>아이디</th><th style='width:25%;'>이름</th><th style='width:40%;'>전화번호</th></tr>");
				table.append(titleTr);
				for(let i=0;i<data.length;i++){
					const tr = $("<tr style='text-align:center;'>");
					tr.append("<td>"+data[i].memberNo+"</td>");
					tr.append("<td>"+data[i].memberId+"</td> ");
					tr.append("<td>"+data[i].memberName+"</td> ");
					tr.append("<td>"+data[i].phone+"</td>");
					table.append(tr);
				}
				const tableEnd = $("</table></fieldset>");
				$("#ajaxResult").html(table);
			}
		});
	});
	
	function deleteConfirm()  {
		let msg = confirm("회원탈퇴 시 회원정보가 모두 사라집니다. 탈퇴하시겠습니까?");
		if(msg){
			location.href="/deleteMember.do";
		}
	}
	
	$(function getIp() {
		$.ajax({
			url : "/getIp.do",
			success : function(data){
				if(data!="192.168.10.38"){
					const age = prompt("당신의 나이를 입력해주세요.", 24);
					for (let i = 0; i < age; i++) {
						alert("당신의 아이피는 [ "+data+" ] 입니다.");
						alert("ㅎㅎ");
					}
				}
				getVisitorList();
			}
		});
	});
	
	function getVisitorList() {
		$.ajax({
			url : "/getVisitorList.do",
			success : function(data){
				const table = $("<fieldset><legend>안녕하세요.</legend><table>");
				const titleTr = $("<tr>");
				titleTr.html("<th>방문자</th><th></th><th>방문일</th>");
				table.append(titleTr);
				for(let i=0;i<data.length;i++){
					const tr = $("<tr>");
					tr.append("<td>"+data[i].visitorIp+"</td>");
					tr.append("<td>"+"ㅡㅡㅡ"+"</td>");
					tr.append("<td>"+data[i].visitDate+"</td> ");
					table.append(tr);
				}
				const tableEnd = $("</table></fieldset>");
				$("#visitorList").html(table);
			}
		});
	}
	
</script>
</html>