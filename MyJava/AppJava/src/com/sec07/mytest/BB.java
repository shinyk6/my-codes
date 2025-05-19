package com.sec07.mytest;

public class BB extends AA{ //상속관계
	private int c;
	
	public BB() { 
		//super(); 
		//AA에 명시되어있는 기본 생성자가 호출
		System.out.println("'BB' 기본 생성자");
	}

	public BB(int i, int j, int k) {
		super(i, j);
		this.c = k;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public int getRes() {
		return (getHap()-getC());
	}
}
