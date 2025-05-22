package com.sec07;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext07.xml");
		
		Greet g = (Greet)ctx.getBean("morningGreat");
		System.out.println(g.greeting());
	}

}
