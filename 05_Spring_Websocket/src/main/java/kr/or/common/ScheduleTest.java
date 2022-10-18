package kr.or.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.member.model.service.MemberService;

//@Component//객체생성이 첫번째
public class ScheduleTest {
	@Autowired
	private MemberService service;
	
	/*
	@Scheduled(fixedDelay = 5000)
	public void scheduleTest1() {
		System.out.println("예약작업 자동 실행메소드! -- 5초");
	}
	//Scheduled()는 매개변수 호출불가, NoArgsMethod, 리턴도 void, 데이터정리용(화면에서 사용X)
	@Scheduled(fixedDelay = 10000)
	public void scheduleTest2() {
		System.out.println("10초마다 동작하는 함수");
	}
	@Scheduled(cron = "0 44 10 * * *")
	public void scheduleTest3() {
		//couponService.deleteCoupon(); <이런식으로 지정한 시간마다 쿠폰삭제할수있다
		//service.deleteMember(24);
		System.out.println("(매분 10초마다)크론식으로 동작하는 함수");
	}
	*/
	@Scheduled(fixedDelay = 5000)
	public void scheduleTask() {
		System.out.println("Hello Schedule");
	}

}
