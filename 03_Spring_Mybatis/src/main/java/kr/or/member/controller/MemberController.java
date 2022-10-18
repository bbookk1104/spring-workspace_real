package kr.or.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.gson.Gson;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/login.do")
	public String login(Member member, HttpSession session) {
		Member m = service.selectOneMember(member);
		if(m!=null) {
			session.setAttribute("m", m);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/selectAllMember.do")
	public String selectAllMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	
	@RequestMapping(value="join.do")
	public String join(Member m) {
		int result = service.insertMember(m);
		if(result>0) {
			return "redirect:/";
		}else {
			return "member/joinFrm";
		}
	}
	
	@RequestMapping(value="/searchMemberId.do")
	public String searchMemberId(Member member, Model model) {
		Member m = service.selectOneMember(member);
		if(m!=null) {
			model.addAttribute("m", m);
			return "member/searchMember";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping(value="/updateMember.do")
	public String updateMember(Member m, Model model, HttpSession session) {
		Member member = service.updateMember(m);
		if(member!=null) {
			session.setAttribute("m", member);
			return "redirect:/mypage.do";
		}else {
			model.addAttribute("msg","회원정보수정");
			return "member/failMsg";
		}
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(@SessionAttribute Member m, Model model) {
		int result = service.deleteMember(m.getMemberNo());
		if(result>0) {
			return "redirect:/logout.do";
		}else {
			model.addAttribute("msg","회원탈퇴");
			return "member/failMsg";
		}
	}
	
	@RequestMapping(value="/searchMemberName.do")
	public String searchMemberName(String memberName, Model model) {
		ArrayList<Member> list = service.selectAllMemberName(memberName);
		if(list.isEmpty()) {
			model.addAttribute("msg","회원검색");
			return "member/failMsg";
		}else {
			model.addAttribute("list",list);
			return "member/memberList";
		}
	}
	
	@RequestMapping(value="/searchMember1.do")
	public String searchMember(String type, String keyword, Model model) {
		ArrayList<Member> list = service.searchMember1(type,keyword);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/searchMember2.do")
	public String searchMember2(Member m, Model model) {
		ArrayList<Member> list = service.searchMember2(m);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/idList.do")
	public String idList(Model model) {
		ArrayList<String> list = service.selectIdList();
		model.addAttribute("list",list);
		return "member/idList";
	}
	
	@RequestMapping(value="searchMember3.do")
	public String searchMember3(String[] memberId, Model model) {
		ArrayList<Member> list = service.searchMember3(memberId);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/searchMember4.do")
	public String searchMember4(Model model) {
		ArrayList<Member> list = service.searchMember4();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@ResponseBody//페이지이동 안하고 data넘겨주기만 하는 경우
	@RequestMapping(value="/idCheck.do")
	public String idCheck(Member m) {
		//String memberId로 받기도 가능
		Member member = service.selectOneMember(m);
		if(member == null) {
			//사용가능한 아이디
			return "0";
		}else {
			//이미 사용중인 아이디
			return "1";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxAllMember.do",produces="application/json;charset=utf-8")
	//produces로 한글 인코딩
	public String ajaxAllMember() {
		ArrayList<Member> list = service.selectAllMember();
		//자바와 자바스크립트 사이에서 데이터 주고받을수있는 형식 - json, gson
		//json은 문자열데이터 (ex: {"key1":"value1","key2":"value2","key3":"value3"},{"key4":"value4"})
		Gson gson = new Gson();
		String result = gson.toJson(list);
		System.out.println(result);
		return result;
	}
}
