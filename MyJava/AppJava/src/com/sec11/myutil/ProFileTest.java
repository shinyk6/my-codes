package com.sec11.myutil;

public class ProFileTest {
	public static void main(String[] args) {
		ProFile<String> p1 = new ProFile<>("Dominica", "관리자"); //dept에 넣을 타입을 명시(타입은 클래스를 줘야함(객체))
																//<> 뒤에는 비워도 상관없음
		ProFile<Integer> p2 = new ProFile<Integer>("Dominico", 1111); 
		ProFile<Double> p3 = new ProFile<Double>("Dominico", 1111.0);
		
		System.out.println(p1.getName() + "   " + p1.getDept());
		System.out.println(p2.getName() + "   " + p2.getDept());
	}
}
