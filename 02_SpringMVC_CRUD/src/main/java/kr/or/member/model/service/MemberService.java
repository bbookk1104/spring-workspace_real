package kr.or.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	public MemberService() {
		super();
		System.out.println("MemberService생성");
	}
	public int insertMember(Member m) {
		int result = dao.insertMember(m);
		return result;
	}
	public Member selectOneMember(Member m) {
		Member member = dao.selectOneMember(m);
		return member;
	}
	public Member selectOneMember(String searchId) {
		return dao.selectOneMember(searchId);
	}
	public ArrayList<Member> selectAllMember() {
		ArrayList<Member> list = dao.selectAllMember();
		return list;
	}
	public int updateMember(Member m) {
		int result = dao.updateMember(m);
		return result;
	}
	public int deleteMember(int memberNo) {
		int result = dao.deleteMember(memberNo);
		return result;
	}

}
