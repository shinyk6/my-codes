package com.test;

//static final 키워드, abstract메소드, default메소드 , static메소드
// 단 인터페이스는 defualt를 써도 완전 추상이기에 new객체 생성, 생성자x,다중구현 ->추상클래스와의 차이점

public interface IAA {
	int a =10; // 반드시 초기값  ->public static final int a = 10;
	public static final int b = 10; // 풀네임을 명시해도, 명시하지 않아도 똑같음
	
	void prn();					
	public abstract void disp();  // prn()과 같음 (풀네임을 명시해도, 명시하지 않아도 같음)
	
	default void view() { //다른 클래스에서 재정의 가능 //toString과 같은 결로 사용하기 위해
		System.out.println(a);
	}
	static void view02() {
		System.out.println(a);
	}
}
