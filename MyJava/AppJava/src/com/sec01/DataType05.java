package com.sec01;
// 래퍼클래스(Wrapper Class)의 객체로 형변환 후 Object 클래스가 가진 .getClass().getSimpleName -> 타입을 알 수 있음
public class DataType05 {
	public static void main(String[] args) {
		float f = 3.141f;
		double d = 3.141d;
		double d2 = 3.141;
		char ch = 'a';
		System.out.println(f);
		System.out.println(d);
		System.out.println(d2);
		

		// 데이터 타입 확인 해보자
		System.out.println("float 타입 확인 : " + ((Object)f).getClass().getSimpleName() );
		System.out.println("double 타입 확인 : " + ((Object)d).getClass().getSimpleName() );		
		System.out.println("char 타입 확인 : " + ((Object)ch).getClass().getSimpleName());
	}
}


