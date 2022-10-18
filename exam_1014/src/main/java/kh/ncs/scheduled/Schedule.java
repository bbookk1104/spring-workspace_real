package kh.ncs.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
	
	@Scheduled(fixedDelay = 5000)
	public void scheduleTask() {
		System.out.println("Hello Schedule");
	}
	
}