package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class FruitMainGroovy {

	public static void main(String[] args) {
		GenericGroovyApplicationContext ctx = new GenericGroovyApplicationContext("app03.groovy");
		FruitService service = ctx.getBean("fruitService", FruitService.class);
		service.printName();
	}
}
