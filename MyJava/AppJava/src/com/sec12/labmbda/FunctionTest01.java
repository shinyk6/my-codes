package com.sec12.labmbda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest01 {

	public static void main(String[] args) {
		//Interface BiFunction<T,U,R> 	R apply(T t, U u) - T, U를 받아서 R로 리턴
		 BiFunction<String, String, String> bi = (x, y) -> {      
		      return x + y;					//x, y는 t, u리턴함
		 };
		 
		//BiFunction<String, String,String> bi = (x, y) -> x + y;
	
		 String res = bi.apply("오늘은", "금요일이다!!"); //문자열이기에 String
		 
		 System.out.println("bi = " +  res);
		 
		    
		    Function<String,String> f = x-> x+" !";		  
		    //default <V> BiFunction<T,U,V> andThen(Function<? super R,? extends V> after)
		    //apply("Getting Start", "java")이 호출돼서 문자열이 합한 String 리턴되고 andThen()개수만큼
		    //실행됨
		    System.out.println(bi.andThen(f).andThen(f).apply("Getting Start", " java"));
		    	 
		    	
	}
}
