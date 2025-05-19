package com.test;
//Test'prn을 호출해보자      //Test가 가지고 있는 prn
public class Test01 {

	public static void main(String[] args) {
		
	//	Test.prn(); //같은 패키지 내에 있어서 Test의 멤버 prn()을 호출 가능 //컴파일 할때 사라지는 주석
					//class.xx() -> 무조건 static
					/*public class Test{
					 * pbulic static void prn(){
					 * 	System.out.println("안녕하세요");
					 * }
					}*/
		
		Test02.disp(); // Test02.disp야
		
	}

}
