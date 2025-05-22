package com.sec04;

import com.sec03.Greet;

public class GreetService {
	private Greet greet;
	
	public GreetService(Greet greet) {
		this.greet = greet;
	}
	
	public void sayHello() {
		System.out.println(greet.greeting());
	}
	
}
