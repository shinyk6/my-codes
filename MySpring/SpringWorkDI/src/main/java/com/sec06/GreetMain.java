package com.sec06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GreetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext06.xml");
        GreetService res = context.getBean("greetService", GreetService.class);
        res.sayHello();
	}

}
