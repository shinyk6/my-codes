package com.sec04;

public class ReturnTest {
	public static void main(String[] args) {
		int i;
		i = 10;
		while (true) {
			if (i == 0)
				return;
			System.out.print(i +" ");
			i--;
		}
		
		// System.out.println("==========main========"); //main메소드가 return을 만나 종료되기에 이부분의 코드는 실행되지 않음
	} 
}


