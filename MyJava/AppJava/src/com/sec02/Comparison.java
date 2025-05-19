package com.sec02;

public class Comparison { //논리연산 범위연산, 비교연산

	
	public static void test() {
		
		 int num, assign; num = 10;
		 
		 int a = 3; int b = 4;
		 
		
		
		 System.out.println((a > b++) && (a < b++));// false & true = false  앞이 false면 그 뒤는 수행하지않음. 그렇기에 b값은 다시 증가하지않음.
		  System.out.println("a=" + a + "  b=" + b);
		 
	}
	public static void main(String[] args) {
		
		test(); //&& 연산 시 먼저 계산되는 리턴값이 false이면 나머지 수행없이 false를 리턴
		
		/*
		 * int a = 10; int b = 2;
		 * 
		 * System.out.println(a > b); 
		 * System.out.println(a & b); //비트연산 (정수를 비트 변환) 후 정수를 리턴 
		 * System.out.println((a>b) && (b==a)); // &&두개들어가면 논리연산 a와b에 true/false가 있어야만 논리연산가능
		 * 
		 * 
		 */


	}

}
 