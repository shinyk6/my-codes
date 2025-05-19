package com.sec04;
import java.util.Scanner;

public class SwitchTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		char op = '\0';
		System.out.print(" 두수 와 연산자를 입력(+,-,*,/) : ");
		a = sc.nextInt();
		b = sc.nextInt();
		op = sc.next().charAt(0);     //charAt는 리턴값이 chr 맨 마지막 타입이 대입하는 곳 타입과 같아야함                

		switch (op) {
			case '+' :
				System.out.println(a + " + " + b + " = " + (a + b)); //case밑 명령이 많을 경우 {} 사용
				break;
			case '-' :
				System.out.println(a + " - " + b + " = " + (a - b));
				break;
			case '*' :
				System.out.println(a + " * " + b + " = " + (a * b));
				break;
			case '/' :
				System.out.println(a + " / " + b + " = " + (double) a / b);
				break;
			default :
				System.out.println("연산자 error");
		}// switch end
	}// main end
}// SwticTest01 end
