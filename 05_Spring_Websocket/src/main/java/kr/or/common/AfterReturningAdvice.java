package kr.or.common;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;

import kr.or.member.model.vo.Member;

//비즈니스로직 수행 시 결과값이 에러없이 리턴되는 경우
public class AfterReturningAdvice {
	public void afterReturn(JoinPoint jp, Object returnObj) {
		String methdName = jp.getSignature().getName();
		System.out.println(methdName+"AfterReturning");
		ArrayList<Member> list = (ArrayList<Member>)returnObj;
		for(Member m:list) {
			m.setMemberPw("비밀번호는 안 알랴줌");
		}
	}
}
