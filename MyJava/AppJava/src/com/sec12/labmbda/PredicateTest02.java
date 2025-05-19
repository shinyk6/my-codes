package com.sec12.labmbda;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class PredicateTest02 {

	public static void main(String[] args) {
		//Q1. IntPredicate를 활용해서 짝수 이면서 7의 배수인지 판별 해보자.
		//짝수 판별
		IntPredicate isE = n -> (n%2)==0;
		//7의 배수 판별
		IntPredicate isM7 = n -> (n%7)==0;
		//짝수 이면서 7의 배수인지 판별
		IntPredicate result = isE.and(isM7);
		
		System.out.println(result.test(100));
		System.out.println(result.test(28));
		System.out.println(result.test(21));
		

		//Q2. Interface BiPredicate<T,U>를 사용해보자
		BiPredicate<Integer,Integer> bi = (x,y) -> x>y;  //매개인자 두개를 받아서 판별
		System.out.println(bi.test(10, 7));
	}

}
