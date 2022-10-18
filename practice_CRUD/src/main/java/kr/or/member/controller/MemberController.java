package kr.or.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	public MemberController() {
		super();
		System.out.println("MemberController생성!");
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	
	@RequestMapping(value="/join.do")
	public String join(Member m) {
		if(m.getNickname().trim().isEmpty()) {
			m.setNickname(m.getMemberName());
		}
		int result = service.insertMember(m);
		if(result>0) {
			return "member/joinSuccess";
		}else {
			return "member/joinFail";
		}
	}
	
	@RequestMapping(value="/loginFrm.do")
	public String loginFrm() {
		return "member/loginFrm";
	}
	
	@RequestMapping(value="/login.do")
	public String login(Member m, HttpSession session) {
		Member loginMember = service.loginCheck(m);
		session.setAttribute("m", loginMember);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
