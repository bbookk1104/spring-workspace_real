package kr.or.dm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.dm.model.service.DirectMessageService;
import kr.or.dm.model.vo.DirectMessage;

@Controller
public class DirectMessageController {
	@Autowired
	private DirectMessageService service;
	
	@RequestMapping(value="/dmMain.do")
	public String dmMain() {
		return "dm/dmMain";
	}
	
	@ResponseBody
	@RequestMapping(value="/sendDm.do")
	public String sendDm(DirectMessage dm) {
		int result = service.sendDm(dm);
		/*
		String dmInfo = dm.getSender()+dm.getReceiver()+dm.getDmContent();
		if(result>0) {
			return dmInfo;
		}else {
			return "보내기 실패!";
		}
		*/
		return String.valueOf(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getReceiveDm.do", produces="application/json;charset=utf-8")
	public String getReceiveDm(DirectMessage dm) {
		ArrayList<DirectMessage> list = service.getReceiveDm(dm);
		return new Gson().toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSendDm.do", produces="application/json;charset=utf-8")
	public String getSendDm(DirectMessage dm) {
		ArrayList<DirectMessage> list = service.getSendDm(dm);
		return new Gson().toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value="/getMyDmList.do", produces="application/json;charset=utf-8")
	public String getMyDmList(DirectMessage dm) {
		ArrayList<DirectMessage> list = service.selectDmList(dm);
		return new Gson().toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value="/dmDetail.do", produces="application/json;charset=utf-8")
	public String dmDetail(int dmNo) {
		DirectMessage dm = service.selectOneDm(dmNo);
		return new Gson().toJson(dm);
	}
}
