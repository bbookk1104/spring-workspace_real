package kr.or.iei.controller;

import javax.servlet.http.HttpServletRequest;

public class LoginController implements Controller{

	@Override
	public String request(HttpServletRequest request) {
		//2. 값추출
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//3. 비즈니스로직(서비스를 통한 id,pw검증)
		// user01/1234
		boolean result1 = memberId.equals("user01");
		boolean result2 = memberPw.equals("1234");
		boolean result = result1 && result2;
		//4. 결과처리
		if(result) {
			return "loginSuccess";
		}else {
			return "loginFail";
		}
	}

}
