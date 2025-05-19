package com.sec05;

public class c_Array {

	public static void main(String[] args) {

		Test();
	}

	public static void Test() {
		// 1) 배열 선언 생성 출력 확인
		// 동적할당
		int[] ar02 = new int[10]; // 0,0,0,0,0,0,0,0,0,0,0 10개의 방을 만들어 숫자를 0으로 채움.
									// ar02에 주소(만든 방)를 대입 시킴
									// 참조형 변수는 주소만 받기에 무조건 크기는 4byte

		// 2) 배열의 주소를 넘겨서 메소드에서 출력해보자.
		prn(ar02);
		// 3) 값을 채우자
		for (int i = 0; i < ar02.length; i++) {
			ar02[i] = i + 1;
		}
		// 4) 출력
		prn(ar02);
		
		// 5) 역순으로 출력
		reversePrn(ar02);
	}
	public static void reversePrn(int[] ar) {
		System.out.println("===반복 for문 역순으로 출력===");
		for (int i = ar.length-1; i >= 0; i--) {
			System.out.printf("%5d", ar[i]); // 1000
		}
		System.out.println();
	}	
	
	

	// 배열만 주고 출력하고 싶다.
	public static void prn(int[] ar) {
		System.out.println("===case02 반복 for문 출력===");
		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]); // 1000
		}
		System.out.println();
	}

}
