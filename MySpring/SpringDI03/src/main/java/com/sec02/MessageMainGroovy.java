package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class MessageMainGroovy {

	public static void main(String[] args) {
		
		// 프로젝트에서 리소스 path가 지정된 곳에 있는 xml 파일을 로드
		
		// .groovy 현재 버전에서 (ver.4 / spring ver.6 XX) importX
		ApplicationContext context = new GenericGroovyApplicationContext("app02.groovy","app02-2.groovy"); //해당 리소스 파일에 있는 것들 - beans는 beanFactory객체로 변형됨
		
		MessagePrinter res = context.getBean("messagePrint", MessagePrinter.class); //MassagePrinter 객체
		res.print();

		res = context.getBean("messagePrint02", MessagePrinter.class);
		res.print();
	}

}
