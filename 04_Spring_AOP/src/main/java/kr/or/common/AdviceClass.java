package kr.or.common;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import kr.or.member.model.vo.Member;

//servlet-context.xml대신 AOP어노테이션 사용
//@Component
//@Aspect
public class AdviceClass {
	//포인트컷 생성
	@Pointcut(value="execution(* kr.or.member.model.service.MemberService.*(..))")
	public void allPointcut() {}
	@Pointcut(value="execution(* kr.or.member.model.service.MemberService.selectOneMember(..))")
	public void selectOne() {}
	@Pointcut(value="execution(* kr.or.member.model.service.MemberService.insertMember(..))")
	public void insertPointcut() {}
	@Pointcut(value="execution(* kr.or.member.model.service.MemberService.*Member())")//Member로 끝나는 메소드 중 매개변수 없는 것 
	public void selectAll() {}
	
	//beforeAdvice
	@Before(value="insertPointcut()")
	public void pwChange(JoinPoint jp) {
		Object[] args = jp.getArgs();
		Member m = (Member)args[0];
		m.setMemberPw("1234");
	}
	
	@AfterReturning(value="selectAll()", returning = "returnObj")
	public void pwChange2(JoinPoint jp, Object returnObj) {
		ArrayList<Member> list = (ArrayList<Member>)returnObj;
		for(Member m : list) {
			m.setMemberPw("안알랴줌");
		}
	}
}
