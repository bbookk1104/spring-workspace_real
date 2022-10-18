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
		System.out.println("Service생성");
	}

	public ArrayList<Member> selectAllMember() {
		ArrayList<Member> list = dao.selectAllMember();
		return list;
	}

	public int insertMember(Member m) {
		return dao.insertMember(m);
	}
	
}
