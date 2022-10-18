package kr.or.member.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	public MemberController() {
		super();
		System.out.println("Controller생성");
	}
	
	@RequestMapping(value="selectAllMember.do")
	public String selectAllMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/allMember";
	}
	
	@RequestMapping(value="/joinMember.do")
	public String joinMember(Member m) {
		int result = service.insertMember(m);
		if(result>0) {
			return "joinSuccess";
		}else {
			return "joinFail";
		}
	}
}
