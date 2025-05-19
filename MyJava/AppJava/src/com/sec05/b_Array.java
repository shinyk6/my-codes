package com.sec05;

public class b_Array {

	public static void main(String[] args) {
		
		Test();
	}
	
	public static void Test(){
		// 1) 배열 선언 생성 출력 확인
		// 나열형 값을 선언과 동시에 대입했다.
		int[] ar = {10, 20, 30, 40, 50};		//배열 선언과 동시에 초기화 방법 1	나열형 상수를 직대입함
		int ar02[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};		//배열 선언과 동시에 초기화 방법 2
	
		// 2) 배열의 주소를 넘겨서 메소드에서 출력해보자.
		System.out.println("===ar02출력===");
		System.out.println("호출 전 : "+ ar02[0]); //10
		prn(ar02);
		System.out.println(ar02[0]);
	}
		
	
		//배열만 주고 출력하고 싶다.
		public static void prn(int[]ar) { // int [] ar = ar02;  주소 참조 (또 다른 ar이 들어옴)  ar02라는 방을 만들어 Test()에 ar02[]주소를 받아 참조 함.!!!(같은곳을 잡고 있음)
			System.out.println("===case02 반복 for문 출력===");
			ar[0] = 1000;
			for(int i = 0; i<ar.length; i++) {
				System.out.printf("%5d", ar[i]); //1000
			}
			System.out.println();
			
		}
}
