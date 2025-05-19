package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {

	public static void main(String[] args) {
		
		// 프로젝트에서 리소스 path가 지정된 곳에 있는 xml 파일을 로드
		ApplicationContext context = new ClassPathXmlApplicationContext("application02.xml"); //해당 리소스 파일에 있는 것들 - beans는 beanFactory객체로 변형됨
		
		MessagePrinter res = context.getBean("messagePrint", MessagePrinter.class); //MassagePrinter 객체
		res.print();

		res = context.getBean("messagePrint02", MessagePrinter.class);
		res.print();
	}

}
