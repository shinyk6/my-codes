package com.sec09;

public class b_Test {
	
	public static void prn() throws ArithmeticException {	//나를 호출하는곳에서 예외처리해줬으면 할 때 throws사용
		///코드를 만줄 작성 - 예외
		
		throw new ArithmeticException(); //명시로 예외 발생
	}
	
	public static void prn01() throws ArithmeticException {
		prn();
	}
	
	public static void prn02() throws ArithmeticException{
		prn01();
	}
	
	public static void main(String[] args) {
		try {
			prn02();
		}catch(ArithmeticException e){
			System.out.println("위임");
		}
		
	}
}
