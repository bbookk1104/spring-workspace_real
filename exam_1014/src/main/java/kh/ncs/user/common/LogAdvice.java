package kh.ncs.user.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	@Pointcut("execution(* kh.ncs.user.model.dao.UserDao.*(..))")
	public void allPointcut() {}
	
	@Before(value = "allPointcut()")
	public void printLog(JoinPoint jp) {
		Signature sig = jp.getSignature();
		String methodName = sig.getName();
		System.out.println(methodName);
	}
}