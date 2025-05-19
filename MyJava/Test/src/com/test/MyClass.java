package com.test;

public class MyClass {

	public static void main(String[] args) {
	
		System.out.println(100);
		System.out.println("100");
		System.out.println(100.1);
		System.out.println('1'+"00");
		System.out.println("한글");
		System.out.println("한글"+"한글");
		System.out.println("한글"+100);
		
		for (int i= 0; i<args.length; i++)
				System.out.println(i==0?args[i]:""+args[i]);
		System.out.println();
}

}
