package com.sec07.mytest;

public class DD extends BB {

	private int d;

	public DD() { 
		//super(); 
		//BB에 명시되어 있는 생성자 호출
		System.out.println("'DD' 기본 생성자");
	}
	public DD(int i, int j, int k, int l) {
		super(i, j, k);
		this.d = l;
	}
	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	@Override
	public int getRes() {
		return super.getRes()*this.getD();    // 선조의 멤버를 부를 때 super. 자기자신을 부를 땐 this.
	}
	
	
	
	
	
/*
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		
		DD d1 = new DD(); //AA(), BB(), DD()가 생성자를 부르며 메모리에 올라감            (선조가 먼저 생성 -> 후손 생성)
		d1.setA(100);
		d1.setC(50);
		d1.setC(5);
		d1.setD(2);
		
		String res = String.format("(%d + %d) -%d *%d = %d \n" , d1.getA(), d1.getB(), d1.getC(), d1.getD(), d1.getRes());
		System.out.println("result : "+ res); //외부에서 호출 할 때 마지막에 오버라이드 된 메소드만 호출가능. 
		
	}
*/	
}
