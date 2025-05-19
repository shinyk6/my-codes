package com.sec04;
import java.util.Scanner;

public class DoTest01 {
	public static void main(String[] args) {
		int counter = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("How many Hellos? ");
		counter = sc.nextInt(); //숫자 출력 받음

		do {
			System.out.println("Hello"); //무조건 한번은 실행
			counter--;
		} while (counter > 0);
		System.out.println("counter is: " + counter);
	}
}

