package com.sec01.exam;
/*
 * 	4칙연산을 하고 싶다. [직접 출력sysout, 변수를 통해 연산, 사용자자료형_class, 네트워크 처리] 
 * 	단 div 결과는 double로 하고 싶다.
 *  a=100 b=200
 * 	100 + 200 = hap
 *  200 - 100 = sub
 *  100 * 200 = mul
 *  200 / 100 = div
 *
 *  선언 -> 값 대입 -> 연산 -> 출력
 *  
 */
public class j_exam {
	
	
	public static void main(String[] args) {
		//선언->지역변수 선언
		int a,b,hap,sub,mul;
		double div;
		//값대입
		a = 100;
		b = 200;
		hap = sub = mul = 0; 
		div = 0.0;
		//연산을 메소드로 하겠다.
		hap = Calc.getHap(a,b); //같은 클래스 내에 없기에 클래명을 같이 명시.
		sub = Calc.getSub(a,b);
		mul = Calc.getMul(a,b);
		div = Calc.getDiv(a,b);
		//출력 100 + 200 = hap
		System.out.println(a+" + "+b+" = "+hap);
		System.out.println(b+" - "+a+" = "+sub);
		System.out.println(a+" * "+b+" = "+mul);
		System.out.println(b+" / "+a+" = "+div);
		
		
	}
}
