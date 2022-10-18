package kr.or.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.Visitor;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member selectOneMember(Member member) {
		//"member = <mapper namespace="member">찾기
		//.selectOneMember" = <select id="selectOneMember">찾아서 쿼리문 수행
		Member m = sqlSession.selectOne("member.selectOneMember",member);
		return m;
	}

	public ArrayList<Member> selectAllMember() {
		//조회 여러줄인 경우 selectList()
		List list = sqlSession.selectList("member.selectAllMember");
		return (ArrayList<Member>)list;
	}

	public int insertMember(Member m) {
		int result = sqlSession.insert("member.insertMember",m);
		return result;
	}

	public int updateMember(Member m) {
		int result = sqlSession.update("member.updateMember",m);
		return result;
	}

	public int deleteMember(int memberNo) {
		int result = sqlSession.delete("member.deleteMember",memberNo);
		return result;
	}

	public ArrayList<Member> selectAllMemberName(String memberName) {
		List list = sqlSession.selectList("member.selectAllMemberName",memberName);
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> searchMember1(HashMap<String, Object> map) {
		List list = sqlSession.selectList("member.searchMember1",map);
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> selectMember2(Member m) {
		List list = sqlSession.selectList("member.searchMember2",m);
		return (ArrayList<Member>) list;
	}

	public ArrayList<String> selectIdList() {
		List list = sqlSession.selectList("member.selectIdList");
		return (ArrayList<String>) list;
	}

	public ArrayList<Member> searchMember3(String[] memberId) {
		List list = sqlSession.selectList("member.searchMember3",memberId);
		/* 배열이 다음과 같은 형태로 전달됨~
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("array",memberId);
		List list = sqlSession.selectList("member.searchMember3",map);
		*/
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> searchMember4() {
		List list = sqlSession.selectList("member.searchMember4");
		return (ArrayList<Member>) list;
	}

	public int updatePw(Member m) {
		return sqlSession.update("member.updatePw",m);
	}

	public ArrayList<Visitor> selectVisitor() {
		List list = sqlSession.selectList("visitor.selectVisitor");
		return (ArrayList<Visitor>) list;
	}

	public int insertVisitor(String ip) {
		return sqlSession.insert("visitor.insertVisitor",ip);
	}

	public Member searchPw(Member m) {
		return sqlSession.selectOne("member.searchPw",m);
	}
	
}
