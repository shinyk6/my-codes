package com.workshop03.test01;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx =  new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService res = (OrderService) ctx.getBean("orderServiceImpl");
		
		System.out.println(res.order(1, 10000));
	}

}
