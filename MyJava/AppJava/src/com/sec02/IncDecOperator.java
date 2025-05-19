package com.sec02;
public class IncDecOperator {
	public static void main(String[] args) {
		// 전위(변수 앞), 후위 연산자(변수 뒤)
		// 전위연산자  ++a --a	 : a값을 1증가하고 리턴, a값을 1감소하고 리턴
		// 후위연산자  a++ b--	 : a값을 리턴하고 1증가, a값을 리턴하고 1감소

		int op = 10; 

		System.out.println(op++); 	//10을 리턴하고 11이 됨
		System.out.println(op); 	//11

		System.out.println(++op);  //11을 1증가 후 12리턴
		System.out.println(op);    //12

		System.out.println(op--); //12를 리턴 후 1감소
		System.out.println(op);   //11

		System.out.println(--op); //10리턴
		System.out.println(op); //10

	}
}




