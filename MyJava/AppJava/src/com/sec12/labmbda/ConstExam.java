package com.sec12.labmbda;

import java.util.function.BiFunction;
import java.util.function.Supplier;

class AA{
	int a;
	int b;
	
	public AA() {
		a = 100;
		b = 200;
	}
	public AA(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return String.format("AA [a=%s, b=%s]", a, b);
	}
	public int add() {
		return a+b;
	}
	public int sub() {
		return a-b;
	}
	public int mul() {
		return a*b;
	}
	public double div() {
		return (b!=0)? (double)a/b : Double.NaN;
	}
	
}

public class ConstExam {

	public static void main(String[] args) {
		Supplier<AA> res = AA::new;	//기본 생성자호출 ::
		AA obj1 = res.get();
		System.out.println(obj1);
		
		BiFunction<Integer, Integer, AA> res2 = AA::new;
		AA obj2 = res2.apply(10, 20);
		System.out.println(obj2);
		
		//메소드 참조를 활용한 사칙연산
		Supplier<Integer> addRes = obj2::add;
		Supplier<Integer> subRes = obj2::sub;
		Supplier<Integer> mulRes = obj2::mul;
		Supplier<Double> divRes = obj2::div;
		System.out.println(" + =>" +addRes.get()); //100+200
		System.out.println(" - =>" +subRes.get()); //100-200
		System.out.println(" * =>" +mulRes.get()); //100*200
		System.out.println(" / =>" +divRes.get()); //100/200

	}

}
