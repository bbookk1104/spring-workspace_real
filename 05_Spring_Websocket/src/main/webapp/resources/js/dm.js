/**
 * 
 */
function getReceiveDm(){
	const receiver = $("[name=sender]").val();
	$.ajax({
		url: "/getMyDmList.do",
		data: {receiver:receiver},
		success: function(list){
			const tbody = $("#receiveDmList");
			tbody.empty();
			for (let i = 0; i < list.length; i++) {
				const dm = list[i];
				const tr = $("<tr>");
				// 보낸사람, 내용, 시간, 읽음 여부
				const senderTd = $("<td>");
				senderTd.text(dm.sender);
				const contentTd = $("<td>");
				contentTd.text(dm.dmContent);
				contentTd.attr("onclick","dmDetail("+dm.dmNo+");");
				const dmDateTd = $("<td>");
				dmDateTd.text(dm.dmDate);
				const readTd = $("<td>");
				if (dm.readCheck == 0) {
					readTd.text("읽지않음");
					tr.css({"color":"darkcyan", "font-weight":"bold"});
				} else {
					readTd.text("읽음");
				}
				tr.append(senderTd).append(contentTd).append(dmDateTd).append(readTd);
				tbody.append(tr);
			}
		}
	});
}

function getSendDm(){
	const sender = $("[name=sender]").val();
	$.ajax({
		url: "/getMyDmList.do",
		data: {sender:sender},
		success: function(list){
			$("#sendDmList").empty();
			let readCheck;
			for(let i=0; i<list.length; i++){
				const dm = list[i];
				const tr = $("<tr>");
				tr.append($("<td>"+dm.receiver+"</td>"));
				tr.append($("<td>"+dm.dmContent+"</td>"));
				tr.append($("<td>"+dm.dmDate+"</td>"));
				if(dm.readCheck == 0){
					readCheck = "읽지않음";
				}else{
					readCheck = "읽음";
				}
				tr.append($("<td>"+readCheck+"</td>"));
				$("#sendDmList").append(tr);
			}
		}
	});
}

function sendDmModal(){
	$.ajax({
		url: "/selectAllMemberId.do",
		success: function(list){
			$("select[name=receiver]").empty();
			for(let i=0; i<list.length; i++){
				const option = $("<option>");
				option.val(list[i]);
				option.text(list[i]);
				$("select[name=receiver]").append(option);
			}
			$("#sendDm-modal").css("display","flex"); //show()쓰면 display:block
		}
	});
}

function closeModal(){
	$("#sendDm-modal").hide();
	$("textarea[name=dmContent]").val("");
}
function dmSend(){
	const sender = $("[name=sender]").val();
	const receiver = $("select[name=receiver]").val();
	const dmContent = $("[name=dmContent]").val();
	const data = {
		type:"sendDm",
		sender:sender,
		receiver:receiver,
		dmContent:dmContent
	}
	//웹소켓으로 쪽지보내기용 데이터 전송
	ws.send(JSON.stringify(data));
	/*
	$.ajax({
		url: "/sendDm.do",
		data: {sender:sender, receiver:receiver, dmContent:dmContent},
		success: function(data){
			getSendDm();
			if(data == "1"){
				closeModal();
				getSendDm();
			}else{
				alert("쪽지보내기 실패");	
			}
		}
	});
	*/
}

function dmDetail(dmNo){
	$.ajax({
		url : "/dmDetail.do",
		data : {dmNo : dmNo},
		success : function(data) {
			$("#detailSender").text(data.sender);
			$("#detailDate").text(data.dmDate);
			$("#detailContent").text(data.dmContent);
			/*
			if(data.readCheck==0){
				getReceiveDm();
			}
			*/
			$("#dmDetail").css("display","flex");
			//상세보기 화면 표시 후 웹소켓에 전달
			const wsData = {
				type: "readCheck",
				sender: data.sender,
				receiver: data.receiver
			};
			ws.send(JSON.stringify(wsData));
		}
	});
}

function closeDetail(){
	$("#dmDetail").hide();
}

$(function() {
	//getReceiveDm();
	getSendDm();
})