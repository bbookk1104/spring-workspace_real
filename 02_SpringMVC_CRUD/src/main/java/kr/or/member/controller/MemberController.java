package kr.or.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	//autowired : 스프링이 만든 객체중에 선언된 변수와 일치하는 타입을 찾아서 값을 대입
	@Autowired
	private MemberService service;
	
	public MemberController() {
		super();
		System.out.println("MemberController생성");
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	
	@RequestMapping(value="join.do")
	public String join(Member m) {//input의 name과 vo의 변수명 맞추면 Member로 가져오기 가능(id,pw)
		System.out.println(m);
		int result = service.insertMember(m);
		if(result>0) {
			return "member/joinSuccess";
		}else {
			return "member/joinFail";
		}
	}
	
	@RequestMapping(value="login.do")
	public String login(Member m, HttpSession session) {
		Member member = service.selectOneMember(m);
		if(member != null) {
			//과거 서블릿 방식: HttpSession session = request.getSession();
			session.setAttribute("m", member);
		}
		//메인페이지로 이동 -> return "redirect: 주소"
		//-> ViewResolver가 앞뒤에 값을 붙이지않고 주소 요청
		return "redirect:/";
	}
	
	@RequestMapping(value="searchMember.do")
	public String searchMember(String searchId, Model model) {
		Member m = service.selectOneMember(searchId);
		if(m == null) {
			return "redirect:/";
		}else {
			//model : controller와 화면 사이에 1회용 데이터를 주고받을 객체
			//request.setAttribute();
			model.addAttribute("m",m);
			return "member/searchMember";
		}
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="searchAllMember.do")
	public String searchAllMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/allMember";
	}
	
	@RequestMapping(value="mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping(value="update.do")
	public String updateMember(Member member, @SessionAttribute Member m) {
		int result = service.updateMember(member);
		if(result>0) {
			m.setMemberPw(member.getMemberPw());
			m.setPhone(member.getPhone());
			m.setEmail(member.getEmail());
			return "redirect:mypage.do";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="deleteMember.do")
	public String deleteMember(int memberNo) {
		int result = service.deleteMember(memberNo);
		if(result>0) {
			return "redirect:logout.do";
		}else {
			return "redirect:/";
		}
	}
}
