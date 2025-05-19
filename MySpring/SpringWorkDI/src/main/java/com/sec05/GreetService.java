package com.sec05;


public class GreetService {
	private Greet greet;
	
	public void setGreetService(Greet greet) {
		this.greet = greet;
	}
	
	public void sayHello() {
		System.out.println(greet.greeting());
	}
	
}
