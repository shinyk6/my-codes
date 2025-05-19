package com.javastudy;

public class ThreadTest{

		
	public static void main(String[] args) {

		 hapMethod(1,10);
		 hapMethod(11,20);
		System.out.println();
	}
	
	static void hapMethod(int x, int y) {
		
		int sum = 0;
		for(int i=x; i<=y; i++) {
			sum+=i;
		}
		
		System.out.println("sum1 : "+sum);
		
	}
	
	

}
