package com.sec05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec04.GreetService;

public class GreetMain {

	public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext1-05.xml");
        
        GreetManager res = context.getBean("greetManager", GreetManager.class);
        res.execute();
        
	}
}
