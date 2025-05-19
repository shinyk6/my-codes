package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec01.*;


public class GreetMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1-02.xml");
		
		//선조인 인터페이스로 리턴
		Greet greet = context.getBean("eveningGreet", Greet.class);
		System.out.println(greet.greeting());
		
		if(context.containsBean("eveningGreet")) {
			//인터페이스가 아닌 본인 것으로 찾아와야함 (doJob이 서브클래스에 존재)
			EveningGreet greet02 = context.getBean("eveningGreet", EveningGreet.class); 
			greet02.doJob();
		}
		
		//close를 해줘야 destroy메소드 실행됨
		((AbstractApplicationContext) context).close();
		
	}

}
