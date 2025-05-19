package com.sec04;

import com.sec03.Greet;


public class EveningGreet implements Greet {

	@Override
	public String greeting() {
		return "안녕하세요 (저녁 인사)";
	}
	
}
