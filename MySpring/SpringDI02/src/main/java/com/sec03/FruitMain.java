package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FruitMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application03.xml");
		FruitService service = ctx.getBean("fruitService", FruitService.class);
		service.printName();
	}
}
