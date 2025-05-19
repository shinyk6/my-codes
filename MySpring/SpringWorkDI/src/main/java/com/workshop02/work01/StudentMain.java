package com.workshop02.work01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextwr02.xml");
		Student res = ctx.getBean("student01", Student.class);
		System.out.println(res.toString());
		
//		StudentService res = ctx.getBean("studentService", StudentService.class);
//		res.PrintAllInfo();
	}
	

}
