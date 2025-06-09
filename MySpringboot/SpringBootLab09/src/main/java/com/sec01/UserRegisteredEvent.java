package com.sec01;

// [1] 이벤트 클래스
public class UserRegisteredEvent {  // 단순 POJO 사용 권장
	
	private final String username;
	
	public UserRegisteredEvent(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	} 
} 