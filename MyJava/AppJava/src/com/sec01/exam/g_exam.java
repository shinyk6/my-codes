package com.sec01.exam;

//각 리터럴에 맞는 값을 주면서 메소드 호출을 해보자.
//리터럴이 대입된 타입을 알려면 무엇을 사용해야할까?
// -래퍼클래스(Wrapper Class)의 객체로 형변환 후 Object 클래스가 가진 .getClass().getSimpleName -> 타입을 알 수 있음
public class g_exam {

	public static void prn01(long res) { //메소드 호출할 때 정수값을 받으면서 지역변수 생성해서 값대입 됨. //(3) int res = 100; 초기값 100을 던져준 것을 4바이트 방 만들고 대입
		System.out.println("정수 res = " + res);
	}
	
	public static void prn02(long res, int a) { //메소드 호출 할 때 실수, 정수값을 받으면서 지역변수 생성해서 값 대입 됨.
		System.out.println("정수 res = " + res + " 정수 a = " + a);
	}	

	public static void main(String[] args) {
		prn01(100); //정수, int
		prn01('a'); //한 문자, char -> int  자동형변환
		prn01((long) 90.1); //실수, double은 [명시형변환] 후 호출함
		prn02((long)90.1, 100); //실수, double
		prn02(100, 100); // 자동 형변환해서 잘 들어감
		prn02(100, 'a'); //메소드 호출 할 때 전달하는 값을 자동형변환 후 대입 및 실행 
		//캐스팅 되는 경우 -> 변수에 값 대입, 메소드에 값 전달, 상속 객체 전달(자식의 객체를 전달하면 부모가 대입 받음 =  I/O클래스 ) 할 때
		//ex) public static void prn02(java.lang.Object c){}
	}

}
