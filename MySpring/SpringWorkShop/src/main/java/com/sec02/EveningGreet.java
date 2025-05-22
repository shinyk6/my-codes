package com.sec02;

import com.sec01.*;

public class EveningGreet implements Greet {
	@Override
	public String greeting() {
		return "편안한 저녁입니다.";
	}
	
	
	// 생명주기 확인을 위한 메소드 추가
	public void init() {
		System.out.println("초기화");
	}
	
	//getBean이 올라오면 doJob이 수행됨
	public void doJob() {
		System.out.println("bean 수행중");
	}
	
	public void destroy() {
		System.out.println("소멸");
	}
	
}
