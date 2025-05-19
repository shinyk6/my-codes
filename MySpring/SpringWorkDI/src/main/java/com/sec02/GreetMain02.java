package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec01.*;


public class GreetMain02 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1-02.xml");
		
		//선조인 인터페이스로 리턴
		Greet greet = context.getBean("eveningGreet", Greet.class);
		System.out.println(greet.greeting());
		
		Greet greet02 = context.getBean("lunchGreet", Greet.class);
		System.out.println(greet02.greeting());
		
		
		((AbstractApplicationContext) context).close();
		
	}

}
