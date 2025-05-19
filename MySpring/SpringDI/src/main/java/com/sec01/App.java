package com.sec01;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application01.xml"); //리소스 읽어오기
		MyAddress res = (MyAddress) context.getBean("myaddress"); //Object타입을 MyAddress타입으로 형변환
														         // context.getBean("myaddress", MyAddress.class); 라고 해도 됨
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
