package kh.ncs.user.model.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import kh.ncs.user.model.vo.UserVO;

@Repository(value = "userDao")
public class UserDao {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	SqlSessionTemplate session;

	public UserVO loginUser(UserVO userVO) {
		return session.selectOne("user.loginUser", userVO);
	}

	public List userList() {
		return session.selectList("user.userList");
	}

	public int insertUser(UserVO userVO) {
		return session.insert("user.insertUser", userVO);
	}

}