package com.sec01;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppAnnoMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
		MyAddress res = (MyAddress) context.getBean("myaddress");   // context.getBean("myaddress", MyAddress.class); 라고 해도 됨
														        
		System.out.println(res);
		System.out.println(res.toString());
		
		
		//재대입
		res = context.getBean("myaddress02", MyAddress.class); 
															
		System.out.println(res);
		System.out.println(res.toString());
		
		//AddressInfo 객체
		AddressInfo res02 = context.getBean("info", AddressInfo.class); 
		System.out.println(res02.toString());
		res02.prn();
			
	}

}
