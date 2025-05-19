package com.sec03;

public class GreetService { //의존성 주입 (Greet인터페이스를 주입받아 사용하는 서비스 클래스)
							//구현체를 직접 알 필요 없이 Greet 타입의 의존성만 주입 받음
							//Greet인터페이스를 주입 받아 메세지를 출력하는 비즈니스 로직을 담당
	
	private Greet greet; 
	
	public void setGreet(Greet greet) { //public setter메소드를 사용해서 의존성을 주입
		this.greet = greet;
	}
	
	public void sayHello() {
		System.out.println(greet.greeting());
	}
}
