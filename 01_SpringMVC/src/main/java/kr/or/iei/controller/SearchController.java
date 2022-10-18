package kr.or.iei.controller;

import javax.servlet.http.HttpServletRequest;

public class SearchController implements Controller{

	@Override
	public String request(HttpServletRequest request) {
		//2. 값추출
		String memberId = request.getParameter("memberId");
		//3. 비즈니스로직(서비스를 통한 id조회)
		boolean result = memberId.equals("user01");
		// 4. 결과처리
		if (result) {
			return "searchSuccess";
		} else {
			return "searchFail";
		}
	}
	
}
