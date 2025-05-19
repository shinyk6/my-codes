package com.sec02.exam;

public class a_exam {

	public static void main(String[] args) {
		
		//Integer 클래스를 이용해서 다양한 기능을 호출해보자.
		//정수 100을 다양한 기능으로 호출해보자 -> Integer class 찾아가자
		int a = 100;
		//2진수 문자열 출력
		System.out.println("2진으로 "+Integer.toBinaryString(a)); //메소드 호출하면서 출력하는것
		 
		String res = Integer.toBinaryString(a);  //메소드 호출 후 리턴받아
		System.out.println("2진으로 "+res); //출력함
		
		System.out.println("2진으로 "+Integer.toBinaryString(a));
		
		//8진수 문자열 출력
		System.out.println("8진으로 "+Integer.toOctalString(a));		
		//16진수 문자열 출력
		System.out.println("8진으로 "+Integer.toHexString(a));	
		
		System.out.println("int의 범위는 " + Integer.MIN_VALUE +" ~ " + Integer.MAX_VALUE);
		System.out.println("Double의 범위는 " + Double.MIN_VALUE +" ~ " + Double.MAX_VALUE);
	}

}
