package com.sec01;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//[3] 이벤트 리스너 (동기 처리)
@Component 
public class SyncUserEnvetListener {
	
	// 실제 이벤트일을 수행하는 코드를 작성
	@EventListener 
	public void handleUserRegistered(UserRegisteredEvent event) { 
		//기타 코드 작성
		System.out.println("[1] 환영 메시지 전송 (Sync) : " + event.getUsername()); // -> 실행 1 
	} 
}
