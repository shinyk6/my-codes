package com.sec01;

public class DataType06 {
	public static void main(String[] args) {
			//byte : -128 ~ 127
		   byte b1=3;
	       byte b2=4;
	       //byte b3=b1+b2;     // error 발생 //+ - * % 계산은 int로 하기 때문에 int로 casting하라고 함
	       //short sh = b1+b2;  // error 발생      
	       //char ch = b1+b2;   // error 발생
	       int i=b1+b2;
	       long l = b1+b2;
	       float f = b1+b2;
	       double d = b1+b2;
	}
}
