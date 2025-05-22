package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06MTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans06.xml");
		
		System.out.println("====================================================");
		
		//Student student = context.getBean("student", Student.class);
		Person student = (Person)context.getBean("student");
		System.out.println("**** 학생 수업시작 ****");
		student.classWork();
//		student.homeWork();
//		student.meeting("팀프로젝트");
//		
//		student.study();
//		student.relax();
//		student.eat("젤리");
//		System.out.println(student.getScore());
		
		((AbstractApplicationContext) context).close();
	}
}
