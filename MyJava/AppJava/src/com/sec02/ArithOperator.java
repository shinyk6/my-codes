package com.sec02;

public class ArithOperator {		//전역변수 부분
	//	int result = 0;				// static이 아니기 때문에 주소가 없음.
	//	int value01 = 50;	
	//	int value02 = 20;	
						
		static int result = 0;				
		static int value01 = 50;	//변수 앞에 static을 명시.    
		static int value02 = 20;	
							

	public void prn() {		
		//	int result = 0;			//지역변수 (메인 메소드 안 변수)
		//	int value01 = 50;
		//	int value02 = 20;

			result = value01 + value02;
			System.out.println(value01 + "+ " + value02 + " =" + result);

			result = value01 - value02;
			System.out.println(value01 + "- " + value02 + " =" + result);

			result = value01 * value02;
			System.out.println(value01 + "* " + value02 + " =" + result);

			result = value01 / value02;
			System.out.println(value01 + "/ " + value02 + " =" + result);

			result = value01 % value02;
			System.out.println(value01 + "% " + value02 + " =" + result);
	}
		
	public static void main(String[] args) {
		new ArithOperator().prn();		//객체 생성하여 prn()호출
		System.out.println("=========================");
		new ArithOperator().prn();
		System.out.println("=========================");
		System.out.println(ArithOperator.result);      //result : 
	}
}
