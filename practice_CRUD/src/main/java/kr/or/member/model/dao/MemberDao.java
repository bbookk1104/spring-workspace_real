package kr.or.member.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MemberDao() {
		super();
		System.out.println("MemberDao생성!");
	}

	public int insertMember(Member m) {
		String query = "insert into member_tbl values(member_seq.nextval,?,?,?,?,?,?, 3, to_char(sysdate,'yyyy/mm/dd'))";
		Object[] params = {m.getMemberId(),m.getMemberPw(),m.getMemberName(),m.getNickname(),m.getMemberPhone(),m.getMemberAddr()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public Member loginCheck(Member m) {
		String query = "select * from member_tbl where member_id=? and member_pw=?";
		Object[] params = {m.getMemberId(),m.getMemberPw()};
		List loginMember = jdbcTemplate.query(query,params,new MemberRowMapper());
		if(loginMember.isEmpty()) {
			return null;
		}else {
			return (Member)loginMember.get(0);
		}
	}
	
}
