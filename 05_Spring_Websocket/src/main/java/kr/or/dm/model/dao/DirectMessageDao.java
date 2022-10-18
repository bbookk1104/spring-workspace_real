package kr.or.dm.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dm.model.vo.DirectMessage;

@Repository
public class DirectMessageDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int sendDm(DirectMessage dm) {
		return sqlSession.insert("dm.sendDm", dm);
	}

	public ArrayList<DirectMessage> getReceiveDm(DirectMessage dm) {
		List list = sqlSession.selectList("dm.getReceiveDm",dm);
		return (ArrayList<DirectMessage>) list;
	}

	public ArrayList<DirectMessage> getSendDm(DirectMessage dm) {
		List list = sqlSession.selectList("dm.getSendDm",dm);
		return (ArrayList<DirectMessage>) list;
	}

	public ArrayList<DirectMessage> selectDmList(DirectMessage dm) {
		List list = sqlSession.selectList("dm.selectDmList",dm);
		return (ArrayList<DirectMessage>) list;
	}

	public DirectMessage selectOneDm(int dmNo) {
		return sqlSession.selectOne("dm.selectOneDm",dmNo);
	}

	public void updateReadCheck(int dmNo) {
		sqlSession.update("dm.updateReadCheck",dmNo);
	}

	public int dmCount(String memberId) {
		return sqlSession.selectOne("dm.dmCount",memberId);
	}
}
