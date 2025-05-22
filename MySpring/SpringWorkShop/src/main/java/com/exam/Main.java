package com.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// 같은 스레드 안에서는 같은 객체가 리턴되고, 다른 스레드에서는 다른 객체가 생성된다.
public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextExam.xml");

		//Thread.curruntThread().getName
		Runnable task = ()->{
			UserBean bean = ctx.getBean("userBean", UserBean.class);
			UserBean bean1 = ctx.getBean("userBean", UserBean.class);
			
			System.out.println(bean == bean1);
			System.out.println(Thread.currentThread().getName());
		};
		
		Thread t1 = new Thread(task, "야옹이");
		Thread t2 = new Thread(task, "멍멍이");
		
		t1.start();
		t2.start();
	}

}
