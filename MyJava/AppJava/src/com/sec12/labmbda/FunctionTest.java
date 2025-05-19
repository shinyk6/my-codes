package com.sec12.labmbda;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
			//Interface Function<T,R>    R apply(T t) - T로 받아 R로 리턴
		
		    Function<Integer,String> M_fun = (i)-> Integer.toString(i);	
		    
		    //integer받아서 String리턴하겠다는 의미
		    //괄호 안 변수는 integer타입 변수이름은 상관없음
		   
		    
		    
		    System.out.println(M_fun.apply(100).length());
		    System.out.println(M_fun.apply(1000).length());
	}

}
