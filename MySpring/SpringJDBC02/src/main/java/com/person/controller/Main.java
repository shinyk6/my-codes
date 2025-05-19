package com.person.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main { //진입점

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonController controller = ctx.getBean(PersonController.class);
		
		controller.run();
		
		((AbstractApplicationContext) ctx).close();

	}

}
