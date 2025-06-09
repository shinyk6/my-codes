package com.sec05;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedulerJob {
	
	//5초마다 작업중 백그라운드
	//@Scheduled(fixedDelay = 5000) 
	@Scheduled(cron = "0 0 9 * * *") //매일 오전 9시
	public void runMyTime() {
		//System.out.println("작업 중..........${LocalDateTime.now()}");
		System.out.println("작업 중..........[" + Thread.currentThread().getName()+"]" + LocalDateTime.now());
		
	}
}
