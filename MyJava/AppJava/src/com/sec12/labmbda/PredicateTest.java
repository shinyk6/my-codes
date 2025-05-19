package com.sec12.labmbda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

//Predicate : 입력값을 받아서 조건을 체크한 후 true또는 false를 반환하는 인터페이스 boolean test(T t),
// -> 조건 집합을 정의하고 지정된 객체가 조건을 충족하는지 유무를 확인하는 메소드

public class PredicateTest {

	public static void main(String[] args) {
			//boolean test(T t)
			Predicate<String> i  = (s)-> s.length() >10; //(1) 문자열의 길이가 10보다 초과 유무
		    System.out.println(i.test("getting strart java"));	//(2) true
		    
		    IntPredicate p1 = n -> (n % 3) == 0; //(3) 3의 배수 판정
		    IntPredicate p2 = n -> (n % 5) == 0;//(4) 5의 배수 판정		    
		    IntPredicate p_res = p1. and (p2); //(5) 3의 배수 이면서 5의 배수인지 판정
		    
		    System.out.println(p_res.test(3)); //(6) false ->3의 배수이지만 5의 배수가 아니기에
		    System.out.println(p_res.test(4)); //(7) false ->3의 배수도 5의 배수도 아니기에
		    
		    IntPredicate p_res02 = p1. or (p2); //(8) 3의 배수 또는 5의 배수를 판정
		    System.out.println(p_res02.test(5)); // true 5의 배수
		    System.out.println(p_res02.test(15)); // true 3의 배수, 5의 배수
		    
		    
		    Predicate<String> str  = Predicate.isEqual("Dominica_kim");//(9) 문자열이 같은지 아닌지 판정
		    System.out.println(str.test("Dominica_kim")); // 같은 문자열 -> true
		    
		  
	}

}
