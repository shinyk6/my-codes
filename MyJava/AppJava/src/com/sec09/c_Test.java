package com.sec09;

import java.util.Scanner;

public class c_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = 0;
		try {
			r = sc.nextInt(); //integer로 리턴
		}catch(java.util.InputMismatchException IE) { //InputMismatchException : int범위를 넘어갔을 때 생기는 예외
			r = 0;
			IE.getMessage();
			IE.getStackTrace();
			System.out.println("r = " + r + " 이유 : " + IE.getMessage()); 
		}
		
	}
}
