package com.test;   //패키지는 파일 상단에 선언 (보안, 꾸러미 용도)
//static메소드는 선언과 동시에 bind가 되고 호출 시 클래스명.메소드명 으로 호출함.
//변수와 메소드는 호출하지 않으면 안 옴.

public class Test { //파일명과 같은 클래스명은 public이 붙음, 메인을 가지고 있으면서 진입점을 열어줌
	//빨간색은 전부 키워드임
	
	//기능 추가 메소드 안녕하세요 출력
	
	public static void prn() { //void : 리턴 값이 없음
		System.out.println("안녕하세요");
	}
	public static void main(String[] args) { //void : 리턴 값이 없음
		System.out.println(100);
		
		prn(); //prn() 같은 멤버 호출 -->  호출 : 클래스명.메소드 인데, 같은 클래스 내에 존재하기에 클래스명 생략 가능
		
		Test01.main(args);
	}

}
