package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionAnnoMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		
		MyCollection res = ctx.getBean("myCollection", MyCollection.class);
		
		res.printItems();
		res.printArray();
		res.printSet();
		res.printMap();
		res.printMyaddr();

	}

}
