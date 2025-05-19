package com.sec12.labmbda;

public class LambdaTest02 {
	
	@FunctionalInterface
	interface Func{
		public int Calc(int a, int b);
		 public static int Calc02(int a, int b) {return a+b;}
		 default int Calc03(int a, int b) {return a+b;}
	}

	public static void main(String[] args) {
		
			Func add = (int a, int b)->{
				return a+b;
			};
			Func sub = (int a, int b)-> a - b;
			
			Func mul = (int a, int b) -> a * b;
			Func div = (int a, int b) -> a / b;
			
			System.out.println(add.Calc(100, 50)); //default는 참조변수.메소드명으로 불러올 수 있기에 호출가능
			System.out.println(sub.Calc(100, 50));
			System.out.println(mul.Calc(100, 50));
			System.out.println(div.Calc(100, 50));
	}

}
