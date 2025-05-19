package com.sec02;

//데이터 압축 및 메모리 최적화 : shift 연산을 사용하면 여러개의 작은 값을 하나의 정수형 변수에 저장 후 사용
public class ShiftOp { //곱하기 나누기 빠르게 계산하려고 사용

	public static void main(String[] args) {
		
		//Q1. RGB색상값을 하나의 int로 저장
		int r = 255, g = 158, b = 64;
		int rgb = (r<<16) | (g<<8) | b;
		System.out.println(Integer.toBinaryString(rgb));  //rgb값이 32bit 정수로 변환 문자열 리턴
		
		//Q2. XOR -> 간단한 암호 만들 때 사용
		
		
		

		int x = 100;
		// x를 5비트 오른쪽으로 시프트 , 왼쪽 비트를 0으로 채움
		System.out.println(" x >> 5 value  = " + (x >> 5));

		int x1 = -100;

		// x를 5비트 오른쪽으로 시프트 , 왼쪽 비트를 1로 채움
		System.out.println(" x1 >> 5   value  = " + (x1 >> 5));

		// x를 5비트 오른쪽으로 시프트 ,왼쪽 비트를 0으로 채움
		System.out.println(" x1 >>> 5 value  = " + (x1 >>> 5)); //>>>세개짜리는 무조건 왼쪽을 0으로 채워서 양수로 만듦
 
	} 

}
