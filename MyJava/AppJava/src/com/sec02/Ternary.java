package com.sec02;


// 삼항연산자
// 조건식 ? true명령 : false명령
public class Ternary {

	public static void main(String[] args) {
		int y, k;
		y = 10;
		k = y < 0 ? -y : y;
		System.out.println(y + " 의 절대값 " + k);

		y = -10;
		k = y < 0 ? -y : y;
		System.out.println(y + " 의 절대값 " + k);
 
	}

}
 