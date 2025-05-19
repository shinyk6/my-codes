package com.sec09;

public class a_Test {

	public static void main(String[] args) {
		int a = 100;
		int b = 0;
		int res = 0;
		
		try {
			res = a/b;	//프로그램을 실행 할때 (런타임시) jvm이 중단하며 빨간글씨로 이유를 알려줌
		}catch(ArithmeticException AE) { //java.lang.ArithmeticException("/ by zero");
			b = 2;
			System.out.println("예외처리 했어 : " + AE.getMessage());
		}catch(RuntimeException RE) {
			System.out.println("또 다른 경우 RuntimeException");
		}catch(Exception E) {
			System.out.println("또 다른 경우 Exception");
		}finally {
			System.out.println("반드시 수행해야 할 구문");
		}
		
		System.out.printf("a=%5d b=%5d res=%5d\n",a,b,res);
	}
}
