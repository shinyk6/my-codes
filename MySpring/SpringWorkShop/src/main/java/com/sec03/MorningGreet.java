package com.sec03;


public class MorningGreet implements Greet { //Greet를 구현하는 구현체

	@Override
	public String greeting() {
		return "좋은 아침입니다.";
	}
	
}
