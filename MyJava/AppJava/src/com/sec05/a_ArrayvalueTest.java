package com.sec05;
//2025-03-10
public class a_ArrayvalueTest {
	public static void main(String[] args) {

		int[] ar = new int[] { 10, 20, 30, 40, 50 };
		System.out.println("ar의 요소의 개수 =" + ar.length);

		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]);
		}

		ar = new int[] { 100, 200, 300 }; //재대입 (재참조 - 새로 참조함) 이전 배열은 메모리에 둥둥 떠있다가 메인이 끝나야 소거가 됨

		System.out.println("\n ar의 재할당된  요소의 개수 =" + ar.length);

		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]);
		}
	}
}
