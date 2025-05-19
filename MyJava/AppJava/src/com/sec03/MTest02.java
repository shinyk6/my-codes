package com.sec03;
//생성자 

import java.util.Random;

//API의 생성자를 통해 객체를 생성해보고 메소드를 호출
public class MTest02 {

	public static void main(String[] args) {
		//Integer i = new Integer(100); //--suppresswaring : 박싱언박싱이 되니까 바로 값 주라는 뜻
		Integer i = (100);
		System.out.println(i.doubleValue()); 
		Integer i2 = new Integer("100");
		System.out.println(i2.doubleValue());
		
		String str = "abcdefg"; //String str = new String("abcdefg"); 과 동일함 //str이라는 객체를 생성자가 생성함.
		
		System.out.println("길이 = " + str.length());    //길이는 index를 가지고 있으면 length로, 아니면 sizeof로 구함
		System.out.println("전체 대문자 = " + str.toUpperCase());
		
		String res = str.toUpperCase();
		System.out.println("출력 : " + res + "->소문자로 : " + res.toLowerCase());
		
		//java.util.random 클래스가 있음, 객체를 생성하고 빈방을 만들어서 0 ~ 100까지 난수 생성하는 메소드 호출해서 출력
		// 1. 생성자 확인 -> 2. nextInt(int)를 활용 (non-static메소드)
		//Random r = new Random();	 ->random은 java.uti패키지에 있어서 풀네임 명명
		
		java.util.Random r = new java.util.Random(); //풀네임 명시
		System.out.println(r.nextInt(101));
		
		Random r2 = new Random(); //패키지 import
		System.out.println(r2.nextInt(101));  
		
		int r3 =((int)(Math.random()) *101);  // 0 ~ 100 범위
			System.out.println(r3);
	}
}
