package com.sec07.mytest03;

public class StaticTest {	
	public static int static_var = 0; //공용변수
	private int non_static; //멤버변수는 메모리 할당할때 자동으로 0으로 초기화됨 (객체 단위로 방 생김)

	public StaticTest() {
		static_var++;  //생성할때마다 ++ 
		non_static++;
	}
	
	public int getNon_static() {
		return non_static;
	}

	public static void main(String[] args) {
		for(int i=0; i<=5; i++) {
			new StaticTest();
			System.out.println(new StaticTest().getNon_static()); //6바퀴 돌면서 계속해서 방이 6번 생성되며 1이 들어감 (누적되지 않음!!!)
		}
		System.out.println(StaticTest.static_var);
	}
}
