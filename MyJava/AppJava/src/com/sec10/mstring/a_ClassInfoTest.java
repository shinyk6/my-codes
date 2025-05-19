package com.sec10.mstring;

import java.lang.reflect.Field;

//reflect의 선조인 탐색 interface를 이용하여 탐색하기
//클래스 객체를 리플렉트 하고 조작 실행 해보자.
class My{
	
	@SuppressWarnings("unused")
	private String name = "홍길동";
	
	@SuppressWarnings("unused")
	private int a = 10;	
}


public class a_ClassInfoTest {
	
	public static void main(String[] args) throws Exception {
		My m1 = new My();
		
		Class<?> clazz = m1.getClass();
		
		//필드 정보 가져오기	
		Field field = clazz.getDeclaredField("name"); //선언되어있는 필드가 name
		//private 멤버 접근
		field.setAccessible(true); 
		
		//필드 조작 ->필드 값 변경
		field.set(m1, "정길동");

		System.out.println("변경된 값 : " + field.get(m1)); //문자열이기에 get.  getString은 존재x 

		System.out.println("============================");
		//필드 정보 가져오기 새로 추가한 a
		field = clazz.getDeclaredField("a");
		//private 멤버 접근
		field.setAccessible(true);
		//필드 값 변경
		field.setInt(m1, 20); //정수형이기에 setInt
		System.out.println("변경된 값 : " + field.get(m1));
			
	}
}
