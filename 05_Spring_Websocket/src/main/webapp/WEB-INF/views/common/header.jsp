<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
    
    <h3>읽지않은 쪽지 수 : <span id="dmCount"></span></h3>
    <input type="hidden" id="memberId" value="${sessionScope.m.memberId }">
    
    <script>
    	let memberId;
    	let ws;
    	$(function(){
    		memberId = $("#memberId").val();
    		ws = new WebSocket("ws://192.168.10.38/dm.do");
    		ws.onopen = onOpen;
    		ws.onmessage = receiveMsg;
    		ws.onclose = onClose;
    	});
    	function onOpen(){
    		console.log("쪽지소켓연결완료");
    		const data = {type:"enter", memberId:memberId};
    		ws.send(JSON.stringify(data));//handleTextMessage에서 data를 message로 받음
    	}
    	function receiveMsg(param) {
			console.log(param.data);
			//받은 json데이터를 js객체타입으로 변환
			const result = JSON.parse(param.data);
			if(result.type == "myDmCount"){
				$("#dmCount").text(result.dmCount);
				getReceiveDm();
			}else if(result.type == "sendDmResult"){
				if(result.sendResult == -1){
					alert("쪽지보내기 실패");	
				}else{
					closeModal();
					getSendDm();
				}
			}else if(result.type == "readDm"){
				getSendDm();
			}
		}
    	function onClose() {
    		console.log("쪽지소켓연결종료");
		}
    </script>