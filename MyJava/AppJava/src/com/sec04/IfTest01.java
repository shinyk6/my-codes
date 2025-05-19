package com.sec04;

import java.util.Scanner;

public class IfTest01 {
	public static void main(String[] args) {
		
		
		///Scanner' next()_공백(스페이스바, 탭, 엔터) nextLine()의 차이는?
		///공백을 만나기 전까지 문자열을 리턴				엔터키 치기 전까지 문자열로 인지
		///공백을 안받음.
		//한문자 입력받아 문자가 소문자이면  "소문자 입니다." 출력하자
		Scanner sc = new Scanner(System.in);
		char ch = '\0';		//0 ~ 65535 // '\0' >기본값
		System.out.print("한문자를 입력하세요 : ");
		/*
		 * String input_str = sc.next();
		   char ch_res = input_str.charAt(ch);	->이렇게 두줄을 한줄로 축약하면 밑의 코드.
		 */
		
		ch = sc.next().charAt(0);        //sc.next()-StringClass    charAt : 첫번째 인덱스의 데이터만 하나 추출
										//입력받은 문자열에서 sc.next(), 첫번째 한글자 위치의 문자 리턴 charAt(0)
		if (Character.isLowerCase(ch))
			System.out.println("소문자 입니다. ^.^ ");
	}
}
