package com.sec02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Service 
public class AsyncUserService { // ApplicationEventPublisher을 주입받아 registerUser 메소드에 publishEvent() 를 호출
	
	@Autowired  
	private ApplicationEventPublisher publisher; 
	
	public void registerUser(String username) { 
		// 이벤트를 시스템에게 알려준다. 
		publisher.publishEvent(new UserRegisteredEvent(username)); 
		System.out.println("사용자 등록 완료 (Async)"); 
	} 
}
