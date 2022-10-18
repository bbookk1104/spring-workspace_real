package kr.or.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardPageData;
import kr.or.board.model.vo.FileVO;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	public BoardPageData selectBoardList(int reqPage) {
		//한 페이지당 보여줄 게시물 수
		int numPerPage = 5;
		//reqPage 1 -> 1~5, reqPage 2 -> 6~10
		int end = reqPage * numPerPage;
		int start = end-numPerPage+1;
		//계산한 start, end이용해서 게시물 목록 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		ArrayList<Board> list = dao.selectBoardList(map);
		//pageNavi 시작
		//전체 페이지 수 계산 필요 -> 전체 게시물 수 조회
		int totalCount = dao.selectBoardCount();
		//전체페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage==0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		//pageNavi 사이즈 지정
		int pageNaviSize = 5;
		//pageNavi 시작번호 지정
		int pageNo = 1;
		if(reqPage>3) {
			pageNo = reqPage-2;
		}
		//pageNavi 생성
		String pageNavi = "";
		//이전버튼
		if(pageNo != 1) {
			pageNavi += "<a href='/boardList.do?reqPage="+(pageNo-1)+"'>[이전]</a>";
		}
		//페이지숫자 생성
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				//내가 요청한(보고있는)페이지의 숫자는 걍 span으로 감싸기
				pageNavi += "<span>"+pageNo+"</span>";
			}else {
				//나머지 숫자들은 a태그로 이동할 수 있도록 감싸고 reqPage로 전송되는 pageNo, 화면에 표시되는 pageNo입력
				pageNavi += "<a href='/boardList.do?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/boardList.do?reqPage="+pageNo+"'>[다음]</a>";
		}
		BoardPageData bpd = new BoardPageData(list,pageNavi,reqPage,numPerPage);
		return bpd;
	}

	public Board selectOneBoard(int boardNo) {
		//board테이블 조회
		Board b = dao.selectOneBoard(boardNo);
		//file_tbl테이블 조회
//		ArrayList<FileVO> list = dao.selectFileList(boardNo);
//		b.setFileList(list);
		return b;
	}

	public int insertBoard(Board b) {
		//board테이블 insert
		System.out.println("dao수행 전 : "+b.getBoardNo());
		int result = dao.insertBoard(b);
		System.out.println("dao수행 후 : "+b.getBoardNo());
		if(result>0) {
				//insert된 board_no조회
				//int boardNo = dao.selectBoardNo();
				//file_tbl테이블 insert - insert된 board_no을 참조해야함
			//...은 selectKey로 해결함!!!
			for(FileVO fv : b.getFileList()) {
				//fv.setBoardNo(boardNo());
				fv.setBoardNo(b.getBoardNo());
				result +=dao.insertFile(fv);
			}
		}
		return result;
	}
}
