package com.sec04;

public class WhileTest01 {
	public static void main(String[] args) {
		int i = 1;
		int evenhap = 0;// 짝수의 합을 저장할 변수
		int oddhap = 0; //홀수의 합을 저장할 변수
		while (i <= 100) { // 1 <= 100 t, 2 <= 100 t, 3 <= 100 t
			if ((i % 2) == 0) {
				evenhap += i;	//evenhap = evenhap + i 대입연산자 / evenhap = 0+2 = 2
			} else {
				oddhap += i;	//oddhap = oddhap + i / oddhap = 0+1 = 1 / oddhap = 1+3 = 4
			}
			i++;
		}
		System.out.println("짝수의 합 : " + evenhap);
		System.out.println("홀수의 합 : " + oddhap);
	}
}

