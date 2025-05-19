package com.javastudy;

public class CallbyValue {

	public static void main(String[] args) {
		
		int num = 10;
		method(num);
		System.out.println(method(num));
		System.out.println(num);
	}
	
	static int method(int x) {
		x += 1;
		return x;
	}
}
