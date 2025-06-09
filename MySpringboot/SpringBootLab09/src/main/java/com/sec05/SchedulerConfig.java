package com.sec05;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer{

	//커스텀 스레드 풀 조정
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		ThreadPoolTaskScheduler my_s = new ThreadPoolTaskScheduler();
		my_s.setPoolSize(5); //스레드 5개 등록
		my_s.setThreadNamePrefix("My-"); 
		my_s.initialize(); //초기화
		taskRegistrar.setTaskScheduler(my_s);
	}
}
