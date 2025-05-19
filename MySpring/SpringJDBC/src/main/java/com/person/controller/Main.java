package com.person.controller;
import com.person.config.*; //AppConfig import


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main { //진입점

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonController controller = ctx.getBean(PersonController.class);
		
		controller.run();
		
		((AbstractApplicationContext) ctx).close();

	}

}
