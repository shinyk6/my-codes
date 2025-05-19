package com.javastudy;

import java.util.Arrays;

public class EnumTest01 {

	public static void main(String[] args) {
		//Season w = Season.WINTER;
		Season[] season = Season.values(); //모든 열거 객체 배열로 리턴
		System.out.println(Arrays.toString(season));

		for(Season res : Season.values()) { //배열 순회
			System.out.println(res); //순서대로 열거 객체 출력
		}
		
	}

}

enum Season{
	
	SPRING, SUMMER, FALL, WINTER;
	
}