package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class CollectionMainGroovy {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericGroovyApplicationContext("app04.groovy");
		
		MyCollection res = ctx.getBean("myCollection", MyCollection.class);
		
		res.printItems();
		res.printArray();
		res.printSet();
		res.printMap();
		res.printMyaddr();

	}

}
