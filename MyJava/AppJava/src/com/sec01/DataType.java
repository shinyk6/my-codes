package com.sec01;

public class DataType {
	//전역변수 영역 = 멤버 필드 영역
	
	public static void prn() {
		//지역변수 영역 (1bit방을 메인 안에 만들었기 때문에 메인이 끝나면 다 걷어감) = 멤버 필드 영역
		//main내에서만 호출 가능
		boolean result = true; //result라는 이름의 변수 선언하고 true값을 초기값으로 대입.
								//boolean -> 메모리에 1bit크기의 result라는 방을 만듦
		result= false; //재대입
		System.out.println("result =" + result); // 문자열+는 연결 문자열 
												 //1bit result를 호출하면 값(boolean) 리턴
	}
	
	public static void main(String[] args) {
		prn();
	}
}
