package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02MTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");
		
		Person g7 = (Person)context.getBean("g7");
		
		System.out.println("**** 강사 수업시작 ****");
		g7.classWork();
		
		System.out.println("======================================");
		

		Person student = (Person)context.getBean("student");

		System.out.println("**** 학생 수업시작 ****");
		student.classWork();
	}

}
