package com.sec05;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application05.xml"); //리소스 읽어오기
		
		AddressRecord res = context.getBean("myaddress01", AddressRecord.class);
		
		System.out.println(res);
	}

}
