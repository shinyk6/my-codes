package com.sec05;

public class a_Array {

	public static void main(String[] args) {

		Test();
	}

	public static void Test() {
		// 1) 배열 선언 생성 출력 확인
		// 나열형 값을 선언과 동시에 대입했다.
		int[] ar = { 10, 20, 30, 40, 50 }; // 배열 선언과 동시에 초기화 방법 1 나열형 상수를 직대입함
		int ar02[] = { 10, 20, 30, 40, 50 }; // 배열 선언과 동시에 초기화 방법 2
												// {}에 따라 ar이 참조하는
		
		

		// 개수(length)와 순서(index)와 는 -1차이가 남
		System.err.println("===case01 ar 직접 출력====");
		// case1 직접 출력
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		System.out.println(ar[2]);
		System.out.println(ar[3]);
		System.out.println(ar[4]); // 주소를 지정하면 안의 값이 출력됨

		System.out.println("===case02 반복 for문 출력===");
		for (int i = 0; i <= 4; i++) {
			System.out.println(ar[i]);
		}

		System.out.println("===case03 제네릭for문 = for-each루프 출력===");
		for (int res : ar) { // 마지막과 시작 주소를 아는 ar이 res에게 하나씩 던져주고 자동으로 루프를 돌음
			System.out.println(res);
		}
	}
}
