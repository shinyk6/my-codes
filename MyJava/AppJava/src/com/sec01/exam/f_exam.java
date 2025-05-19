package com.sec01.exam;

// 각 리터럴에 맞는 값을 주면서 메소드 호출을 해보자.
public class f_exam {

	public static void prn01(int res) { //메소드 호출할 때 정수값을 받으면서 지역변수 생성해서 값대입 됨. //(3) int res = 100; 초기값 100을 던져준 것을 4바이트 방 만들고 대입
		System.out.println("정수 res = " + res);
	}

	public static void prn02(char res) { 
		System.out.println("한 문자 res = " + res);
	}
	
	public static void prn03(double res) { //메소드 호출 할 때 실수, 정수값을 받으면서 지역변수 생성해서 값 대입 됨.
		System.out.println("실수 res = " + res);
	}
		
	public static void main(String[] args) {
		prn01(100); //정수, int
		prn02('a'); //한 문자, char
		prn03(90.1); //실수, float
		//캐스팅 되는 경우 -> 변수에 값 대입, 메소드에 값 전달, 상속 객체 전달(자식의 객체를 전달하면 부모가 대입 받음 =  I/O클래스 ) 할 때
	}

}
