package kr.or.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.common.LogAdvice1;
import kr.or.common.LogAdvice2;
import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.Visitor;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	public Member selectOneMember(Member member) {
		//System.out.println("selectOneMember 메소드 시작");
		Member m = dao.selectOneMember(member);
		//System.out.println("selectOneMember 메소드 끝");
		return m;
	}

	public ArrayList<Member> selectAllMember() {
		//System.out.println("selectAllMember메소드 시작");
		ArrayList<Member> list = dao.selectAllMember();
		//System.out.println("selectAllMember메소드 끝");
		return list;
	}
	
	@Transactional
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}
	
	@Transactional
	public Member updateMember(Member m) {
		int result = dao.updateMember(m);
		if (result > 0) {
			Member member = dao.selectOneMember(m);
			return member;
		} else {
			return null;
		}
	}
	
	@Transactional
	public int deleteMember(int memberNo) {
		return dao.deleteMember(memberNo);
	}

	public ArrayList<Member> selectAllMemberName(String memberName) {
		ArrayList<Member> list = dao.selectAllMemberName(memberName);
		return list;
	}

	public ArrayList<Member> searchMember1(String type, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 어떤 타입이 들어갈지 모르면 Object
		map.put("type", type);
		map.put("keyword", keyword);
		ArrayList<Member> list = dao.searchMember1(map);
		return list;
	}

	public ArrayList<Member> searchMember2(Member m) {
		ArrayList<Member> list = dao.selectMember2(m);
		return list;
	}

	public ArrayList<String> selectIdList() {
		ArrayList<String> list = dao.selectIdList();
		return list;
	}

	public ArrayList<Member> searchMember3(String[] memberId) {
		return dao.searchMember3(memberId);
	}

	public ArrayList<Member> searchMember4() {
		return dao.searchMember4();
	}

	public int updatePwMember(Member m) {
		return dao.updatePw(m);
	}

	public ArrayList<Visitor> selectVisitor() {
		return dao.selectVisitor();
	}

	public int insertVisitor(String ip) {
		return dao.insertVisitor(ip);
	}

	public Member searchPw(Member m) {
		return dao.searchPw(m);
	}
}
