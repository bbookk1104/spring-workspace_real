package kr.or.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardViewData;
import kr.or.board.model.vo.FileVO;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	public BoardService() {
		super();
		System.out.println("BoardService생성");
	}

	public ArrayList<Board> selectAllBoard() {
		ArrayList<Board> list = dao.selectAllBoard();
		return list;
	}

	public int insertBoard(Board b) {
		int result = dao.insertBoard(b);
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		Board b = dao.selectOneBoard(boardNo);
		ArrayList<FileVO> fileList = dao.selectAllFile(boardNo);
		b.setFileList(fileList);
		return b;
	}

	public int insertBoard2(Board b, ArrayList<FileVO> list) {
		int result = dao.insertBoard(b);
		//insert가 성공한 경우 파일을 insert
		//이 때 파일이 없으면 insert할 필요없음
		if(result>0) {
			int boardNo = 0;
			if(!list.isEmpty()) {
				//가장 최근에 들어간 boardNo를 조회
				boardNo = dao.selectBoardNo();
				for(FileVO fileVO : list) {
					//board테이블에 방금 insert한 board_no를 참조하기위해 setter로 값 세팅
					fileVO.setBoardNo(boardNo);
					result += dao.insertFile(fileVO);
				}
			}
		}
		return result;
	}

	public FileVO selectOneFile(int fileNo) {
		FileVO f = dao.selectOneFile(fileNo);
		return f;
	}

	public int updateBoard(Board b, int[] fileNoList) {
		//1. board테이블 수정(제목,내용) - 필수
		int result = dao.updateBoard(b);
		if(result>0) {
			//2. 새 첨부파일이 있으면 insert - 선택
			for(FileVO fv : b.getFileList()) {
				fv.setBoardNo(b.getBoardNo());
				result += dao.insertFile(fv);
			}
			//3. 삭제한 파일이 있으면 delete - 선택
			if(fileNoList != null) {
				for(int fileNo : fileNoList) {
					result += dao.deleteFile(fileNo);
				}
			}
		}
		return result;
	}

	public ArrayList<FileVO> deleteBoard(int boardNo) {
		ArrayList<FileVO> fileList = dao.selectAllFile(boardNo);
		//board테이블 삭제
		int result = dao.deleteBoard(boardNo);
		if(result>0) {
			return fileList;
		}else {
			return null;
		}
	}
}
