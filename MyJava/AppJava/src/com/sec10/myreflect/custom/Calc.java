package com.sec10.myreflect.custom;

public class Calc {
	private int a, b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@NotMyNo
	public int getHap(int a, int b) {
		return a + b;
	}

	@NotMyNo
	public int getCha(int a, int b) {
		return a - b;
	}

	@NotMyNo
	public int getMul(int a, int b) {
		return a * b;
	}

//	@NotMyNo
	public int getDiv(int a, int b) {
		return a / b;
	}

	@Override
	public String toString() {
		return ToCalcHelper.toString(this); //this를 다 넣음-> 전체 객체를 대입. 현재 오브젝트는 this는 동적할당 할 때 생성됨 (new Calc)
	}

	public static void main(String[] args) {
		Calc calc = new Calc();
		calc.setA(14);
		calc.setB(7);
		System.out.println(calc.toString());
	}
}
