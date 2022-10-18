package kr.or.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileVO;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public ArrayList<Board> selectBoardList(HashMap<String, Object> map) {
		List list = sqlSession.selectList("board.selectBoardList",map);
		return (ArrayList<Board>) list;
	}

	public int selectBoardCount() {
		int totalCount = sqlSession.selectOne("board.totalCount");
		return totalCount;
	}

	public Board selectOneBoard(int boardNo) {
		return sqlSession.selectOne("board.selectOneBoard",boardNo);
	}
	/*
	public ArrayList<FileVO> selectFileList(int boardNo) {
		List list = sqlSession.selectList("board.selectFileList",boardNo);
		return (ArrayList<FileVO>) list;
	}
	*/

	public int insertBoard(Board b) {
		return sqlSession.insert("board.insertBoard",b);
	}
	
	public int selectBoardNo() {
		return sqlSession.selectOne("board.selectBoardNo");
	}

	public int insertFile(FileVO fv) {
		return sqlSession.insert("board.insertFile",fv);
	}
	
}
