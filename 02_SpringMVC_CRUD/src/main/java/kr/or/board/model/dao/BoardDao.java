package kr.or.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardListRowMapper;
import kr.or.board.model.vo.BoardRowMapper;
import kr.or.board.model.vo.FileRowMapper;
import kr.or.board.model.vo.FileVO;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BoardDao() {
		super();
		System.out.println("BoardDao생성완료");
	}

	public ArrayList<Board> selectAllBoard() {
		String query="select board_no,board_title,board_writer,board_date from board order by 1 desc";
		List list = jdbcTemplate.query(query, new BoardListRowMapper());
		return (ArrayList<Board>) list;
	}

	public int insertBoard(Board b) {
		String query="insert into board values(board_seq.nextval, ?,?,?, to_char(sysdate,'yyyy-mm-dd'))";
		Object[] params= {b.getBoardTitle(), b.getBoardWriter(), b.getBoardContent()};
		int result = jdbcTemplate.update(query, params);
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		String query = "select * from board where board_no=?";
		Object[] params = {boardNo};
		List b = jdbcTemplate.query(query, params, new BoardRowMapper());
		return (Board)b.get(0);
	}

	public int selectBoardNo() {
		String query = "select max(board_no) from board";
		int boardNo = jdbcTemplate.queryForObject(query, int.class);
		return boardNo;
	}

	public int insertFile(FileVO fileVO) {
		String query = "insert into file_tbl values(file_seq.nextval, ?,?,?)";
		Object[] params = {fileVO.getBoardNo(), fileVO.getFilename(), fileVO.getFilepath()};
		int result = jdbcTemplate.update(query, params);
		return result;
	}

	public ArrayList<FileVO> selectAllFile(int boardNo) {
		String query = "select * from file_tbl where board_no=?";
		Object[] params = {boardNo};
		List fileList = jdbcTemplate.query(query, params, new FileRowMapper());
		return (ArrayList<FileVO>) fileList;
	}

	public FileVO selectOneFile(int fileNo) {
		String query = "select * from file_tbl where file_no=?";
		Object[] params = {fileNo};
		List f = jdbcTemplate.query(query, params, new FileRowMapper());
		return (FileVO)f.get(0);
	}

	public int updateBoard(Board b) {
		String query = "update board set board_title=?, board_content=? where board_no=?";
		Object[] params = {b.getBoardTitle(), b.getBoardContent(), b.getBoardNo()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public int deleteFile(int fileNo) {
		String query = "delete from file_tbl where file_no=?";
		Object[] params = {fileNo};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public int deleteBoard(int boardNo) {
		String query = "delete from board where board_no=?";
		Object[] params = {boardNo};
		int result = jdbcTemplate.update(query,params);
		
		return result;
	}
}
