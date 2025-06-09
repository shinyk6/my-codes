package com.sec02;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component 
public class AsyncUserEnvetListener {
	
	@Async // 비동기 하겠어
	@EventListener 
	public void handleUserRegistered(UserRegisteredEvent event) { 
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("환영 메시지 전송 (Async) : " + event.getUsername());
	} 
}
