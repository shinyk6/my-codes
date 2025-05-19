package com.sec12.labmbda;

import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class U_BOperatorTest {
	public static void main(String[] args) {
		//단항 연산 apply
		IntUnaryOperator op1 = n -> n * 10; 	//단항 연산
		IntUnaryOperator op2 = n -> n + 1; 		//단항 연산
		IntUnaryOperator op = op1. compose (op2); //두 단항을 연결   applyAsInt로 준 2를 가지고 op2실행->연결해서 op1실행 ->30
		System.out.println(op.applyAsInt(2));

		
		UnaryOperator<String> op02 = UnaryOperator. identity (); 
		System.out.println(op02.apply("aaa"));
		
		BinaryOperator<String> op03 = BinaryOperator. minBy ((s1, s2) -> s1.compareTo(s2)); 
		String s_res = op03.apply("aaa", "ddd");
		System.out.println("aaa,ddd 중 작은값 리턴 :" +s_res);
		
		//static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
		BinaryOperator<String> op04 = BinaryOperator. maxBy ((s1, s2) -> s1.compareTo(s2)); //static이기에 interface.메소드 해서 호출
		String s_res01 = op04.apply("aaa", "ddd");
		System.out.println("aaa,ddd 중 큰값 리턴 :"+s_res01);
		
		
	}
}
