package com.sec02.exam;

public class a_Nan {

	public static void main(String[] args) {
		//Nan가 나오는 경우들
		//java.lang.Double 메소드에서 Nan을 처리해줌 
		double x = 0.0/0.0;
		double x1 = Math.sqrt(-1);		
		double x2 = Math.log(-1);
		System.out.println(x);
		System.out.println(x1);
		System.out.println(x2);
	}

}
