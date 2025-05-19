package com.sec03;

public class MyClass {
	
	private int a;
	
	public MyClass() { 
			System.out.println("나 기본 생성자 ~~~ " + this.a); //명시하지않아도 기본으로 
	}
	public MyClass(int a) {
		this.a = a;
		System.out.println("오버로드 생성자 : " + this.a);
	}
	
	public static void main(String[] args) {
		System.out.println(new MyClass()); //객체의 주소 출력(방 만듦)
		
		MyClass m = new MyClass();   //생성한 객체를 m변수에 대입
		//System.out.println(m);  //메모리에 객체 할당
		
		MyClass m1 = new MyClass(200); //매개인자가 있는 생성자는 매개인자를 받는 생성자만 호출 (매개인자 없는 생성자는 호출XXX)
	}
} 
