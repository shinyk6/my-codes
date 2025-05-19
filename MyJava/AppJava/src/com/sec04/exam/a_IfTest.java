package com.sec04.exam;

import java.util.Scanner;

public class a_IfTest {
	public static void main(String[] args) {
		System.out.println("ex)만일에 a가  0보다 크면 \"양수\" 출력");   //  \를 주면 뒤에 오는 것을 문자열로 간주함
		int a = 100;
		if (a>0) { //결과가 true일 경우만 명령을 수행함.
			System.out.println("양수");
		}
	
		
		System.out.println("만일에 a가 0보다 크면 \"양수\"출력, 그렇지 않으면 \"아니잖아!!\" 출력 ");

		if(a>0){	
			System.out.println("양수"); 
		}else{
			System.out.println("아니잖아!!!"); 
		}
		
	
		System.out.println("만일에 num이 0보다 크면 \"양수\", 0보다 작으면 \"음수\", 둘 다 아니면 \"0입니다.\" 출력");
		int num = 10;
		if(num>0){
			System.out.println("양수");   
		}else if(num<0){
			System.out.println("음수");
		}else {
			System.out.println("0입니다.");
		}
		
	}
}
