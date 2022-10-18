package kr.or.dm.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dm.model.dao.DirectMessageDao;
import kr.or.dm.model.vo.DirectMessage;

@Service
public class DirectMessageService {
	@Autowired
	private DirectMessageDao dao;
	
	@Transactional
	public int sendDm(DirectMessage dm) {
		int result = dao.sendDm(dm);
		//insert성공 시 받은사람의 읽지않은 쪽지수를 리턴
		if(result>0) {
			result = dao.dmCount(dm.getReceiver());
			return result;
		}else {
			return -1;
		}
	}

	public ArrayList<DirectMessage> getReceiveDm(DirectMessage dm) {
		return dao.getReceiveDm(dm);
	}

	public ArrayList<DirectMessage> getSendDm(DirectMessage dm) {
		return dao.getSendDm(dm);
	}

	public ArrayList<DirectMessage> selectDmList(DirectMessage dm) {
		return dao.selectDmList(dm);
	}
	
	@Transactional
	public DirectMessage selectOneDm(int dmNo) {
		DirectMessage dm = dao.selectOneDm(dmNo);
		if(dm.getReadCheck()==0) {
			dao.updateReadCheck(dmNo);
		}
		return dm;
	}

	public int dmCount(String memberId) {
		return dao.dmCount(memberId);
	}
}
