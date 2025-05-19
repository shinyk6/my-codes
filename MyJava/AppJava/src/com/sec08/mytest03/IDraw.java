package com.sec08.mytest03;

/*
 public interface IDraw {
 public abstract int getDraw();
 }

 abstract class my implements IDraw { //추상클래스라도 인터페이스를 implements할 수 있음
 }									//myclass abstract(추상)인 이유는- 인터페이스의 추상메소드 getDraw()를 재정의하지 않아서...
 */

public interface IDraw {
	public static final int line = 1;
	public static final int circle = 2;
	public static final int rect = 3;

	int getDraw();

	default int getPoint() {
		return 10;
	}
	static void foo() {
		System.out.println("foo");
	}
}



