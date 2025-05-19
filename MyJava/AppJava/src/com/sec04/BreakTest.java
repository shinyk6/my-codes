package com.sec04;

public class BreakTest {
	public static void main(String[] args) {
		int i;
		i = 5;
		System.out.println("Countdown start!");
		
		while (true) {
			if (i == 3) {
				break; 	// i가 3일때 중단
			}	
			System.out.println(i);
			i--;
		}	
	}
}

