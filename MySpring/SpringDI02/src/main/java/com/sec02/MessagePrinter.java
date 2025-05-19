package com.sec02;

//생성자 주입 클래스
public class MessagePrinter {

	private final Message message; //인터페이스를 선언하면 어떤 후손 클래스도 올 수 있음  1. 추상선언

	public MessagePrinter(Message message) { //<constructor-arg ref="hellomessage"/>값이 여기로 들어옴   2. 주소 대입
		super();
		this.message = message;
	}
	
	public void print() {
		System.out.println(message.getMessage()); //3. 대입된 주소의 객체. 메소드 호출()
	}
	
}
