package com.sec04;


public class WhileTest {
	
	public static void test01() {
		int i = 1;
		System.out.println("Countdown start!");

		while (i <= 5) {
			System.out.printf("%5d", i);
			i++;
		}// while end
		System.out.println("\n end i =" + i);
		
	}
	
	private static void test02() {
		int i = 1;	 //지역변수 초기화
		while (i <= 5) {					// 1 <= 5true,  2<=5t    3 <=5 t,    5<= 5,    6<=5t						
			i++;							// 2 , 3, 4, 5, 6
			System.out.printf("%5d", i);    // 2, 3, 4, 5, 6
		}
		System.out.println("\n end i =" + i);
	}
	
	/*
	 * 1~100 까지 숫자를 출력해보자. while로 작성하자 
	 * 조건 1 : 짝수만 출력하자.
	 * 조건 2 : 짝수의 개수를 출력하자.
	 * 
	 */
	public static void test03() {
		
		int i = 1; // 초기값 
		int cnt = 0; //개수 출력 변수
		while (i <= 100) {
			if (i % 2 == 0) { //조건 1
				System.out.printf("%5d", i);
				cnt++;   //짝수 일때만 증가 조건2
			}
			i++; // 숫자 증가
			
		}
		System.out.println("\nend i =" + i +"\n짝수의 개수 cnt =" + cnt);	
	}
	
	/*
	 * 
	 * 1~100까지 숫자를 출력해보자 while로 작성하자
	 * 조건 1 : 5의 배수에는 하트를 주자
	 * 조건 2 : 5의 배수 단위로 줄바꿈 하자
	 * 조건 3 : 하트의 개수는 몇개일까?
	 */
	public static void test04() {
		
		int i = 1; // 초기값 
		int cnt = 0; //개수 출력 변수
		while (i <= 100) {
			if (i % 5 == 0) { //조건 1
				System.out.printf("%5c\n", '❤');
				cnt++;   //짝수 일때만 증가 조건2
			}else {
				System.out.printf("%5d", i);
			}
			i++; // 숫자 증가
			
		}
		System.out.println("\n end i = " + i +"\n 하트의 개수 cnt =" + cnt);
		
	}
	
	
	
	public static void main(String[] args) {

		//test03();
		test04();
	}

			
}


